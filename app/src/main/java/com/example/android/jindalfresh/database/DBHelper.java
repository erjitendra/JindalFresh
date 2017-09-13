package com.example.android.jindalfresh.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;

import com.example.android.jindalfresh.app_activities.auth.UserTokenModel;

public class DBHelper {

    private DBCreator dbCreator;

    public DBHelper(Context context) {
        dbCreator = new DBCreator(context);
    }


    public String getLatestToken() {
        String token=null;
        SQLiteDatabase db = dbCreator.getReadableDatabase();
        String selectQuerySQLCommand = "SELECT * FROM " + UserDataTable.TABLE_NAME + " ORDER BY token_number DESC LIMIT 1";
        Cursor cursor = db.rawQuery(selectQuerySQLCommand, null);
        if(cursor.moveToFirst()) {

            token  =  cursor.getString(cursor.getColumnIndex(UserDataTable.COLUMN_TOKEN_NO));

        }
        cursor.close();
        return token;
    }

    public void insertTokenInDb(UserTokenModel userTokenModel, String email) {
        SQLiteDatabase db = dbCreator.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(UserDataTable.COLUMN_TOKEN_NO, userTokenModel.getAccessToken());
        values.put(UserDataTable.COLUMN_USER_EMAIL, email);

        db.insert(UserDataTable.TABLE_NAME, null, values);
    }
}
