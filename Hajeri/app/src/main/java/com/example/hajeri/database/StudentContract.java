package com.example.hajeri.database;

public final class StudentContract {

    private StudentContract(){}

    public static class ContactEntry{
        public static String TABLE_NAME = "standard";
        public static final String PHONE_NUMBER= "phone_no_1";
        public static final String PHONE_NUMBER_2= "phone_no_2";
        public static final String NAME = "name";
        public static final String STANDARD= "standard";
        public static final String SARAL_ID = "saral_id";
        public static final String GENDER = "gender";
        public static final String CATEGORY = "category";
        public static final String FATHERS_NAME = "father_name";
        public static final String MOTHERS_NAME = "mother_name";
        public static final String REGISTER_NUMBER = "register_number";
        public static final String BIRTH_DATE = "birth_date";
        public static final String ADMISSION_DATE = "admission_date";
        public static final String CASTE= "caste";
        public static final String BANK_ACCOUNT_NUMBER = "bank_account_number";
        public static final String BANK_BRANCH = "bank_branch";
        public static final String ADHAR_NUMBER = "adhar_number";
        public static final String RATION_CARD = "ration_card";
        public static final String STUDENT_UID = "student_uid";
        public static final String ADDRESS = "address";
    }

    public static class ClassEntry{
        public static String TABLE_NAME = "std";
        public static final String CLASS_NAME = "class_name";
        public static final String START_DATE = "start_date";
        public static final String END_DATE = "end_date";
        public static final String TEACHER_NAME = "teacher_name";
        public static final String ORGANIZATION = "organization";
        public static final String DIVISION = "division";
        public static final String NUMBER_OF_STUDENTS = "numberofstudents";
    }

    public static class AttendanceEntry{
        public static String TABLE_NAME = "student_name";
        public static final String STUDENT_NAME = "student_name";
        public static final String STUDENT_ID = "student_id";
        public static final String DATE = "date";
        public static final String PRESENT_STATUS = "present_status";
    }


}
