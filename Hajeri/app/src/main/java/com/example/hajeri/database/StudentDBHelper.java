package com.example.hajeri.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class StudentDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "students_db";
    public static final int DATABASE_VERSION= 2;
    public static final String  CREATE_TABLE = "create table " + StudentContract.ContactEntry.TABLE_NAME +
              " ( " + StudentContract.ContactEntry.PHONE_NUMBER + " number , " +
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
              StudentContract.ContactEntry.ADDRESS + " text ); ";


    public static final String DROP_TABLE = "drop table if exists "+ StudentContract.ContactEntry.TABLE_NAME;

    public StudentDBHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        Log.d("database_operations","database_created_class_2");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        Log.d("database_operations", "table created class");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }

    public void addStudent( long phone, long phone2, String name, int std, long saral_id, String gender,
                            String category, String father,String mother, int register_number, String birth_date,
                            String admission_date, String caste, long bank_ac_no, String bank_branch,long adhar_number,
                            String ration_card, String student_uid, String address, SQLiteDatabase db ){

        ContentValues contentValues = new ContentValues();
        contentValues.put(StudentContract.ContactEntry.PHONE_NUMBER,phone);
        contentValues.put(StudentContract.ContactEntry.PHONE_NUMBER_2,phone2);
        contentValues.put(StudentContract.ContactEntry.NAME,name);
        contentValues.put(StudentContract.ContactEntry.STANDARD,std);
        contentValues.put(StudentContract.ContactEntry.SARAL_ID,saral_id);
        contentValues.put(StudentContract.ContactEntry.GENDER,gender);
        contentValues.put(StudentContract.ContactEntry.CATEGORY,category);
        contentValues.put(StudentContract.ContactEntry.FATHERS_NAME,father);
        contentValues.put(StudentContract.ContactEntry.MOTHERS_NAME,mother);
        contentValues.put(StudentContract.ContactEntry.REGISTER_NUMBER,register_number);
        contentValues.put(StudentContract.ContactEntry.BIRTH_DATE,birth_date);
        contentValues.put(StudentContract.ContactEntry.ADMISSION_DATE,admission_date);
        contentValues.put(StudentContract.ContactEntry.CASTE,caste);
        contentValues.put(StudentContract.ContactEntry.BANK_ACCOUNT_NUMBER,bank_ac_no);
        contentValues.put(StudentContract.ContactEntry.BANK_BRANCH,bank_branch);
        contentValues.put(StudentContract.ContactEntry.ADHAR_NUMBER,adhar_number);
        contentValues.put(StudentContract.ContactEntry.RATION_CARD,ration_card);
        contentValues.put(StudentContract.ContactEntry.STUDENT_UID,student_uid);
        contentValues.put(StudentContract.ContactEntry.ADDRESS,address);

        db.insert(StudentContract.ContactEntry.TABLE_NAME,null,contentValues);
        Log.d("database_operations","Student Added Successfully");
    }

    public Cursor readStudents(SQLiteDatabase db){
        String projections[] = {
                StudentContract.ContactEntry.PHONE_NUMBER,
                StudentContract.ContactEntry.PHONE_NUMBER_2,
                StudentContract.ContactEntry.NAME,
                StudentContract.ContactEntry.STANDARD,
                StudentContract.ContactEntry.SARAL_ID,
                StudentContract.ContactEntry.GENDER,
                StudentContract.ContactEntry.CATEGORY,
                StudentContract.ContactEntry.FATHERS_NAME,
                StudentContract.ContactEntry.MOTHERS_NAME,
                StudentContract.ContactEntry.REGISTER_NUMBER,
                StudentContract.ContactEntry.BIRTH_DATE,
                StudentContract.ContactEntry.ADMISSION_DATE,
                StudentContract.ContactEntry.CASTE,
                StudentContract.ContactEntry.BANK_ACCOUNT_NUMBER,
                StudentContract.ContactEntry.BANK_BRANCH,
                StudentContract.ContactEntry.ADHAR_NUMBER,
                StudentContract.ContactEntry.RATION_CARD,
                StudentContract.ContactEntry.STUDENT_UID,
                StudentContract.ContactEntry.ADDRESS
        };

        Cursor cursor =  db.query(StudentContract.ContactEntry.TABLE_NAME,
                projections ,null,null,null, null,null);

        return cursor;
    }
}
