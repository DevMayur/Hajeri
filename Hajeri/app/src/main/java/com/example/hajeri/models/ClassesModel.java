package com.example.hajeri.models;

public class ClassesModel {

    public String TABLE_NAME;
    public String CLASS_NAME;
    public String START_DATE;
    public String END_DATE;
    public String TEACHER_NAME;
    public String ORGANIZATION;
    public String DIVISION;
    public String NUMBER_OF_STUDENTS;




    public String getTABLE_NAME() {
        return TABLE_NAME;
    }

    public void setTABLE_NAME(String TABLE_NAME) {
        this.TABLE_NAME = TABLE_NAME;
    }

    public String getCLASS_NAME() {
        return CLASS_NAME;
    }

    public void setCLASS_NAME(String CLASS_NAME) {
        this.CLASS_NAME = CLASS_NAME;
    }

    public String getSTART_DATE() {
        return START_DATE;
    }

    public void setSTART_DATE(String START_DATE) {
        this.START_DATE = START_DATE;
    }

    public String getEND_DATE() {
        return END_DATE;
    }

    public void setEND_DATE(String END_DATE) {
        this.END_DATE = END_DATE;
    }

    public String getTEACHER_NAME() {
        return TEACHER_NAME;
    }

    public void setTEACHER_NAME(String TEACHER_NAME) {
        this.TEACHER_NAME = TEACHER_NAME;
    }

    public String getORGANIZATION() {
        return ORGANIZATION;
    }

    public void setORGANIZATION(String ORGANIZATION) {
        this.ORGANIZATION = ORGANIZATION;
    }

    public String getDIVISION() {
        return DIVISION;
    }

    public void setDIVISION(String DIVISION) {
        this.DIVISION = DIVISION;
    }

    public ClassesModel() {
    }

    public String getNUMBER_OF_STUDENTS() {
        return NUMBER_OF_STUDENTS;
    }

    public void setNUMBER_OF_STUDENTS(String NUMBER_OF_STUDENTS) {
        this.NUMBER_OF_STUDENTS = NUMBER_OF_STUDENTS;
    }

    public ClassesModel(String TABLE_NAME, String CLASS_NAME, String START_DATE, String END_DATE, String TEACHER_NAME, String ORGANIZATION, String DIVISION, String NUMBER_OF_STUDENTS) {
        this.TABLE_NAME = TABLE_NAME;
        this.CLASS_NAME = CLASS_NAME;
        this.START_DATE = START_DATE;
        this.END_DATE = END_DATE;
        this.TEACHER_NAME = TEACHER_NAME;
        this.ORGANIZATION = ORGANIZATION;
        this.DIVISION = DIVISION;
        this.NUMBER_OF_STUDENTS = NUMBER_OF_STUDENTS;
    }
}
