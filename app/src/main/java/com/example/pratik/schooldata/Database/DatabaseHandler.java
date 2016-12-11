package com.example.pratik.schooldata.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.pratik.schooldata.Model.StudentData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pratik on 07-Nov-16.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "contactsManager";

    // Contacts table name
    private static final String TABLE_CONTACTS = "schooldata";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_FNAME = "fname";
    private static final String KEY_LNAME = "lname";
    private static final String KEY_STD = "std";
    private static final String KEY_DIV = "div";
    private static final String KEY_PERCENT = "percent";
    private static final String KEY_RESULT = "result";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_FNAME + " TEXT,"
                + KEY_LNAME + " TEXT,"
                + KEY_STD + " TEXT,"
                + KEY_DIV + " TEXT,"
                + KEY_RESULT + " TEXT,"
                + KEY_PERCENT + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        // Create tables again
        onCreate(db);
    }

    public void addContact(StudentData studentData) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_FNAME, studentData.getFname()); // Contact Name
        values.put(KEY_LNAME, studentData.getLname()); // Contact Phone Number
        values.put(KEY_STD, studentData.getStd()); // Contact Phone Number
        values.put(KEY_DIV, studentData.getDiv()); // Contact Phone Number
        values.put(KEY_RESULT, studentData.getResult()); // Contact Phone Number
        values.put(KEY_PERCENT, studentData.getPercent()); // Contact Phone Number


        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        db.close(); // Closing database connection
    }




    // Getting All Contacts
    public List<StudentData> getAllContacts() {
        List<StudentData> contactList = new ArrayList<StudentData>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                StudentData studentData = new StudentData();
                studentData.set_id(Integer.parseInt(cursor.getString(0)));
                studentData.setFname(cursor.getString(1));
                studentData.setLname(cursor.getString(2));
                studentData.setStd(cursor.getString(3));
                studentData.setDiv(cursor.getString(4));
                studentData.setResult(cursor.getString(5));
                studentData.setPercent(cursor.getString(6));

                // Adding contact to list
                contactList.add(studentData);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }








    // Getting All Contacts
    public List<StudentData> getDivAContacts() {
        List<StudentData> contactList = new ArrayList<StudentData>();
        // Select All Query
        //String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

        //String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS +" WHERE " + KEY_DIV + " = A";


        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM schooldata WHERE div = ? ", new String[] {"A"});

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                StudentData studentData = new StudentData();
                studentData.set_id(Integer.parseInt(cursor.getString(0)));
                studentData.setFname(cursor.getString(1));
                studentData.setLname(cursor.getString(2));
                studentData.setStd(cursor.getString(3));
                studentData.setDiv(cursor.getString(4));
                studentData.setResult(cursor.getString(5));
                studentData.setPercent(cursor.getString(6));

                // Adding contact to list
                contactList.add(studentData);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }





    public List<StudentData> getDivBContacts() {
        List<StudentData> contactList = new ArrayList<StudentData>();
        // Select All Query
        //String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

        //String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS +" WHERE " + KEY_DIV + " = A";


        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM schooldata WHERE div = ? ", new String[] {"B"});

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                StudentData studentData = new StudentData();
                studentData.set_id(Integer.parseInt(cursor.getString(0)));
                studentData.setFname(cursor.getString(1));
                studentData.setLname(cursor.getString(2));
                studentData.setStd(cursor.getString(3));
                studentData.setDiv(cursor.getString(4));
                studentData.setResult(cursor.getString(5));
                studentData.setPercent(cursor.getString(6));

                // Adding contact to list
                contactList.add(studentData);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }


    public List<StudentData> getDivCContacts() {
        List<StudentData> contactList = new ArrayList<StudentData>();
        // Select All Query
        //String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

        //String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS +" WHERE " + KEY_DIV + " = A";


        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM schooldata WHERE div = ? ", new String[] {"C"});

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                StudentData studentData = new StudentData();
                studentData.set_id(Integer.parseInt(cursor.getString(0)));
                studentData.setFname(cursor.getString(1));
                studentData.setLname(cursor.getString(2));
                studentData.setStd(cursor.getString(3));
                studentData.setDiv(cursor.getString(4));
                studentData.setResult(cursor.getString(5));
                studentData.setPercent(cursor.getString(6));

                // Adding contact to list
                contactList.add(studentData);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }


    public List<StudentData> getDivDContacts() {
        List<StudentData> contactList = new ArrayList<StudentData>();
        // Select All Query
        //String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

        //String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS +" WHERE " + KEY_DIV + " = A";


        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM schooldata WHERE div = ? ", new String[] {"D"});

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                StudentData studentData = new StudentData();
                studentData.set_id(Integer.parseInt(cursor.getString(0)));
                studentData.setFname(cursor.getString(1));
                studentData.setLname(cursor.getString(2));
                studentData.setStd(cursor.getString(3));
                studentData.setDiv(cursor.getString(4));
                studentData.setResult(cursor.getString(5));
                studentData.setPercent(cursor.getString(6));

                // Adding contact to list
                contactList.add(studentData);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }

    public List<StudentData> getDivEContacts() {
        List<StudentData> contactList = new ArrayList<StudentData>();
        // Select All Query
        //String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

        //String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS +" WHERE " + KEY_DIV + " = A";


        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM schooldata WHERE div = ? ", new String[] {"E"});

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                StudentData studentData = new StudentData();
                studentData.set_id(Integer.parseInt(cursor.getString(0)));
                studentData.setFname(cursor.getString(1));
                studentData.setLname(cursor.getString(2));
                studentData.setStd(cursor.getString(3));
                studentData.setDiv(cursor.getString(4));
                studentData.setResult(cursor.getString(5));
                studentData.setPercent(cursor.getString(6));

                // Adding contact to list
                contactList.add(studentData);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }

    public List<StudentData> getResultPassContacts() {
        List<StudentData> contactList = new ArrayList<StudentData>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM schooldata WHERE result = ? ", new String[] {"Pass"});

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                StudentData studentData = new StudentData();
                studentData.set_id(Integer.parseInt(cursor.getString(0)));
                studentData.setFname(cursor.getString(1));
                studentData.setLname(cursor.getString(2));
                studentData.setStd(cursor.getString(3));
                studentData.setDiv(cursor.getString(4));
                studentData.setResult(cursor.getString(5));
                studentData.setPercent(cursor.getString(6));
                // Adding contact to list
                contactList.add(studentData);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }


    public List<StudentData> getResultFailContacts() {
        List<StudentData> contactList = new ArrayList<StudentData>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM schooldata WHERE result = ? ", new String[] {"Fail"});

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                StudentData studentData = new StudentData();
                studentData.set_id(Integer.parseInt(cursor.getString(0)));
                studentData.setFname(cursor.getString(1));
                studentData.setLname(cursor.getString(2));
                studentData.setStd(cursor.getString(3));
                studentData.setDiv(cursor.getString(4));
                studentData.setResult(cursor.getString(5));
                studentData.setPercent(cursor.getString(6));
                // Adding contact to list
                contactList.add(studentData);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }


    public List<StudentData> getPercentOneContacts() {
        List<StudentData> contactList = new ArrayList<StudentData>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM schooldata WHERE percent < ? ", new String[] {"35"});

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                StudentData studentData = new StudentData();
                studentData.set_id(Integer.parseInt(cursor.getString(0)));
                studentData.setFname(cursor.getString(1));
                studentData.setLname(cursor.getString(2));
                studentData.setStd(cursor.getString(3));
                studentData.setDiv(cursor.getString(4));
                studentData.setResult(cursor.getString(5));
                studentData.setPercent(cursor.getString(6));
                // Adding contact to list
                contactList.add(studentData);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }


    public List<StudentData> getPercentTwoContacts() {
        List<StudentData> contactList = new ArrayList<StudentData>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM schooldata WHERE percent >= ? AND percent < ? ", new String[] {"35","50"});

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                StudentData studentData = new StudentData();
                studentData.set_id(Integer.parseInt(cursor.getString(0)));
                studentData.setFname(cursor.getString(1));
                studentData.setLname(cursor.getString(2));
                studentData.setStd(cursor.getString(3));
                studentData.setDiv(cursor.getString(4));
                studentData.setResult(cursor.getString(5));
                studentData.setPercent(cursor.getString(6));
                // Adding contact to list
                contactList.add(studentData);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }


    public List<StudentData> getPercentThreeContacts() {
        List<StudentData> contactList = new ArrayList<StudentData>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM schooldata WHERE percent >= ? AND percent < ? ", new String[] {"50","75"});

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                StudentData studentData = new StudentData();
                studentData.set_id(Integer.parseInt(cursor.getString(0)));
                studentData.setFname(cursor.getString(1));
                studentData.setLname(cursor.getString(2));
                studentData.setStd(cursor.getString(3));
                studentData.setDiv(cursor.getString(4));
                studentData.setResult(cursor.getString(5));
                studentData.setPercent(cursor.getString(6));
                // Adding contact to list
                contactList.add(studentData);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }


    public List<StudentData> getPercentFourContacts() {
        List<StudentData> contactList = new ArrayList<StudentData>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM schooldata WHERE percent >= ? ", new String[] {"75"});

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                StudentData studentData = new StudentData();
                studentData.set_id(Integer.parseInt(cursor.getString(0)));
                studentData.setFname(cursor.getString(1));
                studentData.setLname(cursor.getString(2));
                studentData.setStd(cursor.getString(3));
                studentData.setDiv(cursor.getString(4));
                studentData.setResult(cursor.getString(5));
                studentData.setPercent(cursor.getString(6));
                // Adding contact to list
                contactList.add(studentData);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }


    // Updating single contact
    public int updateContact(StudentData studentData, int i) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_FNAME, studentData.getFname());
        values.put(KEY_LNAME, studentData.getLname());
        values.put(KEY_STD, studentData.getStd());
        values.put(KEY_DIV, studentData.getDiv());
        values.put(KEY_RESULT, studentData.getResult());
        values.put(KEY_PERCENT, studentData.getPercent());

        // updating row
        return db.update(TABLE_CONTACTS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(i) });
    }



    // Deleting single contact
    public void deleteContact(int i) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS, KEY_ID + " = ?",
                new String[] { String.valueOf(i) });
        db.close();
    }

}
