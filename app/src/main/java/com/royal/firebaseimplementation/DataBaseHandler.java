package com.royal.firebaseimplementation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DataBaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    public  static final String DATABASE_NAME = "SQLiteDatabase.db";
    public  static final String TABLE_NAME = "PEOPLE";
    public  static  final String COLUMN_ID = "ID";
    public  static final  String COLUMN_FIRST_NAME = "FIRST_NAME";
    public  static final  String COLUMN_LAST_NAME = "LAST_NAME";

    SQLiteDatabase database;

    public DataBaseHandler(@Nullable Context context) {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }


    public void onCreate(SQLiteDatabase db ) {
        db.execSQL(" create table " + TABLE_NAME +
                " ( " + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_FIRST_NAME + " VARCHAR , "
                + COLUMN_LAST_NAME + " VARCHAR );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void insertRecord(ContactModel contact) {
        database = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();// use of Data add
        contentValues.put(COLUMN_FIRST_NAME, contact.getFname());
        contentValues.put(COLUMN_LAST_NAME, contact.getLname());
        database.insert(TABLE_NAME, null, contentValues);
        database.close();
    }
    public ArrayList<ContactModel> getAllRecords() {
        database = this.getReadableDatabase();
        Cursor cursor = database.query(TABLE_NAME, null, null, null, null
                , null, null);
        ArrayList<ContactModel> contactModelsArrayList = new ArrayList<ContactModel>();
        if (((Cursor) cursor).getCount() > 0) {

            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                ContactModel contactModel = new ContactModel();
                contactModel.setId(cursor.getString(0));
                contactModel.setFname(cursor.getString(1));
                contactModel.setLname(cursor.getString(2));
                contactModelsArrayList.add(contactModel);
            }
        }
        cursor.close();
        database.close();
        return  contactModelsArrayList;

    }
    public void updateRecord(ContactModel contact) {

        database = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();// use of Data add
        contentValues.put(COLUMN_FIRST_NAME, contact.getFname());
        contentValues.put(COLUMN_LAST_NAME, contact.getLname());
        database.update(TABLE_NAME,contentValues,COLUMN_ID + "= ?",new String[]{contact.getId()});
        database.close();
    }
    public void deleteRecord(ContactModel contact) {

        database = this.getReadableDatabase();
        database.delete(TABLE_NAME, COLUMN_ID + " = ?", new String[]{contact.getId()});
        database.close();

    }
}
