package com.example.hajeri;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hajeri.database.ClassesDBHelper;
import com.example.hajeri.database.StudentContract;
import com.example.hajeri.database.StudentDBHelper;

public class CreateClass extends AppCompatActivity implements View.OnClickListener {

    private EditText et_classname,et_teachersname,et_division,et_start_date,et_end_date,et_organization;
    private Button bt_create;
    private String classId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_class);

        et_classname = findViewById(R.id.et_classname_create_class);
        et_teachersname = findViewById(R.id.et_teachers_name_create_class);
        et_division = findViewById(R.id.et_division_create_class);
        et_start_date = findViewById(R.id.et_starting_date_create_class);
        et_end_date = findViewById(R.id.et_ending_date_create_class);
        et_organization = findViewById(R.id.et_organization_create_class);
        bt_create = findViewById(R.id.bt_create_create_class);
        bt_create.setOnClickListener(this);
        classId = et_classname.getText().toString();
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bt_create_create_class){
            ClassesDBHelper classesDBHelper = new ClassesDBHelper(CreateClass.this);
            SQLiteDatabase db = classesDBHelper.getWritableDatabase();
            classesDBHelper.addClass(et_classname.getText().toString(),
                    et_start_date.getText().toString(),
                    et_end_date.getText().toString(),
                    et_teachersname.getText().toString(),
                    et_organization.getText().toString(),
                    et_division.getText().toString(),
                    0,db);

            classesDBHelper.close();
            et_classname.setText("");
            et_teachersname.setText("");
            et_division.setText("");
            et_start_date .setText("");
            et_end_date.setText("");
            et_organization.setText("");

            Toast.makeText(CreateClass.this, "Class Created Successfully !", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(CreateClass.this,MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);

        }
    }

}
