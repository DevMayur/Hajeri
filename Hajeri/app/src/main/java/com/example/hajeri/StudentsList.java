package com.example.hajeri;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.hajeri.R;
import com.example.hajeri.adapters.StudentAdapter;
import com.example.hajeri.database.StudentContract;
import com.example.hajeri.database.StudentDBHelper;
import com.example.hajeri.models.StudentModel;

import java.util.ArrayList;
import java.util.List;

public class StudentsList extends AppCompatActivity {

    private FloatingActionButton fab_add_student;
    private String class_name;
    private RecyclerView recyclerView;
    private StudentAdapter studentAdapter;
    private List<StudentModel> sList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_list);

        Intent intent = getIntent();
        class_name = intent.getStringExtra("class_name");
        final String table_name = class_name.replaceAll("\\s","");

        recyclerView = findViewById(R.id.students_list_recycler_view);
        sList = new ArrayList<>();
        studentAdapter = new StudentAdapter(this,sList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(studentAdapter);



        fetchData();

        fab_add_student = findViewById(R.id.fab_add_student);

        fab_add_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentsList.this,CreateStudent.class);
                Toast.makeText(StudentsList.this, "table name : " + table_name, Toast.LENGTH_SHORT).show();
                intent.putExtra("class_name",table_name);
                startActivity(intent);
            }
        });

    }

    private void fetchData() {

        StudentContract.ContactEntry.TABLE_NAME = class_name.replaceAll("\\s","");

        StudentDBHelper studentDBHelper = new StudentDBHelper(this);
        SQLiteDatabase db = studentDBHelper.getReadableDatabase();
        db.execSQL("CREATE TABLE IF NOT EXISTS " +class_name.replaceAll("\\s","") +  " ( " + StudentContract.ContactEntry.PHONE_NUMBER + " number , " +
                        StudentContract.ContactEntry.PHONE_NUMBER_2 + " number , " +
                        StudentContract.ContactEntry.NAME + " text , " +
                        StudentContract.ContactEntry.STANDARD + " number , " +
                        StudentContract.ContactEntry.SARAL_ID + " number , " +
                        StudentContract.ContactEntry.GENDER + " text , " +
                        StudentContract.ContactEntry.CATEGORY + " text , " +
                        StudentContract.ContactEntry.FATHERS_NAME + " text , " +
                        StudentContract.ContactEntry.MOTHERS_NAME + " text , " +
                        StudentContract.ContactEntry.REGISTER_NUMBER + " number , " +
                        StudentContract.ContactEntry.BIRTH_DATE + " text , " +
                        StudentContract.ContactEntry.ADMISSION_DATE + " text , " +
                        StudentContract.ContactEntry.CASTE + " text , " +
                        StudentContract.ContactEntry.BANK_ACCOUNT_NUMBER + " number , " +
                        StudentContract.ContactEntry.BANK_BRANCH + " text , " +
                        StudentContract.ContactEntry.ADHAR_NUMBER + " number , " +
                        StudentContract.ContactEntry.RATION_CARD + " text , " +
                        StudentContract.ContactEntry.STUDENT_UID + " number , " +
                        StudentContract.ContactEntry.ADDRESS + " text );");

        Cursor cursor = studentDBHelper.readStudents(db);

        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex(StudentContract.ContactEntry.NAME));
            String reg_no = String.valueOf(cursor.getInt(cursor.getColumnIndex(StudentContract.ContactEntry.REGISTER_NUMBER)));
            String gender = cursor.getString(cursor.getColumnIndex(StudentContract.ContactEntry.GENDER));
            String category = cursor.getString(cursor.getColumnIndex(StudentContract.ContactEntry.CATEGORY));

            StudentModel model = new StudentModel();

            model.setNAME(name);
            model.setREGISTER_NUMBER(reg_no);
            model.setGENDER(gender);
            model.setCATEGORY(category);
            sList.add(model);
        }

        studentAdapter.notifyDataSetChanged();

    }
}
