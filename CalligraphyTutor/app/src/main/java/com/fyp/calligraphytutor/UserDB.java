package com.fyp.calligraphytutor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Fawad on 3/24/2019.
 */

public class UserDB extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "ctutor.db";
    public static final String TABLE_NAME = "users";
    public static final String USERID = "id";
    public static final String USERNAME = "username";
    public static final String NAME = "name";
    public static final String EMAIL = "email";
    public static final String PHONE = "phone";
    public static final String PASSWORD = "password";
    //private HashMap hp;

    public UserDB(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(
                "CREATE TABLE IF NOT EXISTS users " +
                        "(id integer primary key, username text, name text, email text, phone text, password text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        //db.execSQL("DROP TABLE IF EXISTS contacts");
        onCreate(db);
    }

    public boolean insertUser (String username, String name, String email, String phone, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("name", name);
        contentValues.put("phone", phone);
        contentValues.put("email", email);
        contentValues.put("password", password);
        db.insert("users", null, contentValues);
        return true;
    }

    public boolean validate(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        boolean result = false;
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME, "username=? AND password=?", new String[] { username, password });
        if (numRows > 0) {
            result = true;
        }
        return result;
    }

    public boolean checkusername(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        boolean result = false;
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME, "username=?", new String[] { username });
        if (numRows > 0) {
            result = true;
        }
        return result;
    }

    public boolean checkemail(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        boolean result = false;
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME, "email=?", new String[] { email });
        if (numRows > 0) {
            result = true;
        }
        return result;
    }

    public Cursor getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from users where id="+id+"", null );
        return res;
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        return numRows;
    }

    public boolean updateUser (Integer id, String username, String name, String email, String phone, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("name", name);
        contentValues.put("phone", phone);
        contentValues.put("email", email);
        contentValues.put("password", password);
        db.update("users", contentValues, "id = ? ", new String[] { Integer.toString(id) } );
        return true;
    }

    public Integer deleteUser (Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("users",
                "id = ? ",
                new String[] { Integer.toString(id) });
    }

    public ArrayList<String> getAllUsers() {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from users", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(NAME)));
            res.moveToNext();
        }
        return array_list;
    }
}