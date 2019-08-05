package com.example.hajeri.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class AttendanceDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Attendance";
    public static final int DATABASE_VERSION= 3;

    public static final String DROP_TABLE = "drop table if exists " + StudentContract.AttendanceEntry.TABLE_NAME;

    public static final String CREATE_TABLE = "CREATE TABLE " + StudentContract.AttendanceEntry.TABLE_NAME +
            " ( " + StudentContract.AttendanceEntry.STUDENT_NAME + " text ," +
            StudentContract.AttendanceEntry.STUDENT_ID + " number ," +
            StudentContract.AttendanceEntry.DATE + " text ," +
            StudentContract.AttendanceEntry.PRESENT_STATUS + " text );";

    public AttendanceDBHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        Log.d("database_operations","attendance_database_created");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
        Log.d("database_operations","attendacen table created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROP_TABLE);
        onCreate(sqLiteDatabase);
    }

    public void addAttendance(String student_name,int student_id,String date, String status,SQLiteDatabase db){
        String statement = "INSERT INTO " + StudentContract.AttendanceEntry.TABLE_NAME + " VALUES ( " +
                student_name + " , " + student_id + " , " + date+" , " + status+ " );";
        db.execSQL(statement);
        Log.d("database_operations","student " + student_name + " is " + status);
    }
}
