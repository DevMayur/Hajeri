package com.example.hajeri.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ClassesDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "classes";
    public static final int DATABASE_VERSION = 1;

    public static final String CREATE_TABLE = "create table " + StudentContract.ClassEntry.TABLE_NAME +
            " ( " + StudentContract.ClassEntry.CLASS_NAME + " text ," +
            StudentContract.ClassEntry.START_DATE + " text , "+
            StudentContract.ClassEntry.END_DATE + " text ,"+
            StudentContract.ClassEntry.TEACHER_NAME + " text ,"+
            StudentContract.ClassEntry.DIVISION + " text ,"+
            StudentContract.ClassEntry.NUMBER_OF_STUDENTS + " number ,"+
            StudentContract.ClassEntry.ORGANIZATION + " text );";

    public static final String DROP_TABLE = "drop table if exists " + StudentContract.ClassEntry.TABLE_NAME;


    public ClassesDBHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        Log.d("database_operations","database_created");
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        Log.d("database_operation" , "class created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }

    public void addClass(String classname,String start_date,String end_date,String teacher,String organization,String division,int number_of_students, SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(StudentContract.ClassEntry.CLASS_NAME,classname);
        contentValues.put(StudentContract.ClassEntry.START_DATE,start_date);
        contentValues.put(StudentContract.ClassEntry.END_DATE,end_date);
        contentValues.put(StudentContract.ClassEntry.TEACHER_NAME,teacher);
        contentValues.put(StudentContract.ClassEntry.ORGANIZATION,organization);
        contentValues.put(StudentContract.ClassEntry.NUMBER_OF_STUDENTS,number_of_students);
        contentValues.put(StudentContract.ClassEntry.DIVISION,division);

        db.insert(StudentContract.ClassEntry.TABLE_NAME,null,contentValues);
        Log.d("database_operations" , "class created");
    }

    public Cursor readClasses(SQLiteDatabase db){
        String[] projections = {
                StudentContract.ClassEntry.CLASS_NAME ,
                StudentContract.ClassEntry.START_DATE ,
                StudentContract.ClassEntry.END_DATE ,
                StudentContract.ClassEntry.TEACHER_NAME,
                StudentContract.ClassEntry.DIVISION ,
                StudentContract.ClassEntry.NUMBER_OF_STUDENTS,
                StudentContract.ClassEntry.ORGANIZATION
        };

        Cursor cursor =  db.query(StudentContract.ClassEntry.TABLE_NAME,
                projections ,null,null,null, null,null);

        return cursor;
    }

    public void updateStudentsCount(String class_name,int value,SQLiteDatabase db){
        ContentValues params = new ContentValues();
        params.put(StudentContract.ClassEntry.NUMBER_OF_STUDENTS,value);
        db.execSQL("UPDATE " + StudentContract.ClassEntry.TABLE_NAME + " SET " + StudentContract.ClassEntry.NUMBER_OF_STUDENTS + " = " +value + " WHERE " + StudentContract.ClassEntry.CLASS_NAME + " = " + "\"" +class_name  + "\"");
    }



}