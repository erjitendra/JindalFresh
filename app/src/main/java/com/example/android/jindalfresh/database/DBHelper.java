package com.example.android.jindalfresh.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.android.jindalfresh.app_activities.auth.UserTokenModel;

public class DBHelper {

    private DBCreator dbCreator;

    public DBHelper(Context context) {
        dbCreator = new DBCreator(context);
    }


    public String getLatestToken() {
        String token = null;
        try {
            SQLiteDatabase db = dbCreator.getReadableDatabase();
            String selectQuerySQLCommand = "SELECT * FROM " + UserDataTable.TABLE_NAME + " ORDER BY _id DESC LIMIT 1";
            Cursor cursor = db.rawQuery(selectQuerySQLCommand, null);
            if (cursor.moveToFirst()) {

                token = cursor.getString(cursor.getColumnIndex(UserDataTable.COLUMN_TOKEN_NO));

            }
            cursor.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return token;
    }

    public boolean deleteTokens() {
        boolean logoutStatus = true;

        try {
            SQLiteDatabase database = dbCreator.getWritableDatabase();
            database.execSQL("DELETE FROM " + UserDataTable.TABLE_NAME);
            database.close();

        } catch (Exception e) {
            logoutStatus = false;
        }
        return logoutStatus;
    }

    public String getEmail() {
        //Open the database

        String email = null;
        try {
            SQLiteDatabase db = dbCreator.getReadableDatabase();
            String selectQuerySQLCommand = "SELECT * FROM " + UserDataTable.TABLE_NAME + " ORDER BY _id DESC LIMIT 1";
            Cursor cursor = db.rawQuery(selectQuerySQLCommand, null);
            if (cursor.moveToFirst()) {

                email = cursor.getString(cursor.getColumnIndex(UserDataTable.COLUMN_USER_EMAIL));

            }
            cursor.close();

            db.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        //Close the database


        return email;


    }


    public void insertTokenInDb(UserTokenModel userTokenModel, String email) {
        SQLiteDatabase db = dbCreator.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(UserDataTable.COLUMN_TOKEN_NO, userTokenModel.getAccessToken());
        values.put(UserDataTable.COLUMN_USER_EMAIL, email);

        db.insert(UserDataTable.TABLE_NAME, null, values);
    }
}
