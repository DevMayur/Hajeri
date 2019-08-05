package com.example.hajeri;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.hajeri.database.ClassesDBHelper;
import com.example.hajeri.database.StudentContract;
import com.example.hajeri.database.StudentDBHelper;

public class CreateStudent extends Activity implements AdapterView.OnItemSelectedListener {

    private Spinner sp_category;
    private Button bt_male,bt_female;
    private RadioGroup radioGroup_gender;
    private Button bt_ok,bt_cancel;
    private EditText student_name, previous_attendance,previous_attendance_out_off,gr_number,birthdate,caste,fathers_name,
            mothers_name,address,contact_1,contact_2,admit_date,bank_account_number,bank_branch,bank_ifsc,adhar_number,
            ration_card,child_uid,saral_id,standard;
    private String category  ,gender ="null";
    private int category_status = 0;
    private String class_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_student);

        Intent intent = getIntent();
        class_name = intent.getStringExtra("class_name");

        sp_category = findViewById(R.id.sp_category_create_student);
        bt_male = findViewById(R.id.bt_male_create_student);
        bt_female = findViewById(R.id.bt_female_create_student);
        bt_ok = findViewById(R.id.bt_ok_create_student);
        bt_cancel = findViewById(R.id.bt_cancel_create_student);
        student_name = findViewById(R.id.et_student_name_create_student);
        previous_attendance = findViewById(R.id.et_previous_attendance_create_student);
        previous_attendance_out_off = findViewById(R.id.et_out_of_previous_attendance_create_student);
        gr_number = findViewById(R.id.et_gr_number_create_student);
        birthdate = findViewById(R.id.et_birthday_create_student);
        caste = findViewById(R.id.et_caste_create_student);
        fathers_name = findViewById(R.id.et_fathers_name_create_student);
        mothers_name = findViewById(R.id.et_mothers_name_create_student);
        address = findViewById(R.id.et_address_create_student);
        contact_1 = findViewById(R.id.et_contact_1_create_student);
        contact_2 = findViewById(R.id.et_contact_2_create_student);
        admit_date = findViewById(R.id.et_admission_date_create_student);
        bank_account_number = findViewById(R.id.et_bank_account_number_create_student);
        bank_branch = findViewById(R.id.et_bank_branch_create_student);
        bank_ifsc = findViewById(R.id.et_bank_IFSC_create_student);
        adhar_number = findViewById(R.id.et_adhar_create_student);
        ration_card = findViewById(R.id.et_ration_card_create_student);
        child_uid = findViewById(R.id.et_child_uid_create_student);
        saral_id = findViewById(R.id.et_saral_id_create_student);
        standard = findViewById(R.id.et_standard_create_student);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.categories,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_category.setAdapter(adapter);

        sp_category.setOnItemSelectedListener(this);

        bt_male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gender = "male";
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    bt_male.setBackgroundColor(Color.parseColor("#6D6D6D"));
                    bt_female.setBackgroundColor(Color.parseColor("#75918282"));
                }else{
                    bt_male.setBackgroundColor(getResources().getColor(R.color.colorDarkGrey));
                    bt_female.setBackgroundColor(getResources().getColor(R.color.colorLightGrey));
                }
            }
        });

        bt_female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gender = "female";
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    bt_female.setBackgroundColor(Color.parseColor("#6D6D6D"));
                    bt_male.setBackgroundColor(Color.parseColor("#75918282"));
                }else{
                    bt_female.setBackgroundColor(getResources().getColor(R.color.colorDarkGrey));
                    bt_male.setBackgroundColor(getResources().getColor(R.color.colorLightGrey));
                }
            }
        });

        bt_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                checkFields();
            }

            private void checkFields() {
                //get data from spinner and radio buttons
                if (category_status == 1){
                    if (!gender.equals("null")){
                        if(!TextUtils.isEmpty(student_name.getText()) || !TextUtils.isEmpty(gr_number.getText()) ||
                                !TextUtils.isEmpty(birthdate.getText()) ||!TextUtils.isEmpty(caste.getText()) ||
                                !TextUtils.isEmpty(fathers_name.getText()) ||!TextUtils.isEmpty(mothers_name.getText())){
                            saveFields();
                        }
                    }else{
                        Toast.makeText(CreateStudent.this, "Please select gender", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(CreateStudent.this, "Please Select Category!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bt_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }


    private void saveFields() {

        int no_of_students = 0;

        StudentContract.ContactEntry.TABLE_NAME = class_name;
        SharedPreferences sharedPreferences = getSharedPreferences("class_name",MODE_PRIVATE);

        StudentDBHelper studentDBHelper = new StudentDBHelper(this);
        SQLiteDatabase db = studentDBHelper.getWritableDatabase();


        studentDBHelper.addStudent(Long.parseLong(contact_1.getText().toString()),Long.parseLong(contact_2.getText().toString()),student_name.getText().toString()
        ,Integer.parseInt(standard.getText().toString()),Long.parseLong(saral_id.getText().toString()),gender,category,fathers_name.getText().toString()
        ,mothers_name.getText().toString(),Integer.parseInt(gr_number.getText().toString()),birthdate.getText().toString(),admit_date.getText().toString()
        ,caste.getText().toString(),Long.parseLong(bank_account_number.getText().toString()),bank_branch.getText().toString(),
                Long.parseLong(adhar_number.getText().toString()),ration_card.getText().toString(),child_uid.getText().toString()
                ,address.getText().toString(),db);
        studentDBHelper.close();

        ClassesDBHelper classesDBHelper = new ClassesDBHelper(this);
        SQLiteDatabase read_db = classesDBHelper.getReadableDatabase();
        SQLiteDatabase write_db = classesDBHelper.getWritableDatabase();

        Cursor cursor = classesDBHelper.readClasses(read_db);
        while (cursor.moveToNext()) {
            no_of_students = cursor.getInt(cursor.getColumnIndex(StudentContract.ClassEntry.NUMBER_OF_STUDENTS));
        }


        class_name = sharedPreferences.getString("class_name","class_name_error");
        Toast.makeText(this, "classname : " + class_name, Toast.LENGTH_SHORT).show();

        classesDBHelper.updateStudentsCount(class_name,(no_of_students+1),write_db);
        Toast.makeText(this, "Student" + no_of_students + "created", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i){
            case 0:
                category_status = 0;
                break;

            case 1:
                category_status = 1;
                category = "SC";
                break;

            case 2:
                category_status = 1;
                category = "ST";
                break;

            case 3:
                category_status = 1;
                category = "OBC";
                break;

            case 4:
                category_status = 1;
                category = "NT";
                break;

            case 5:
                category_status = 1;
                category = "VJ";
                break;

            case 6:
                category_status = 1;
                category = "SBC";
                break;

            case 7:
                category_status = 1;
                category = "MINO";
                break;

            case 8:
                category_status = 1;
                category = "OTHER";
                break;

            default:
                category_status = 0;
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        category_status = 0;
    }

}
