package com.example.android.jindalfresh.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.jindalfresh.database.UserDataTable;

public class DBCreator extends SQLiteOpenHelper {

    public static final String LOG_TAG = DBCreator.class.getSimpleName();

    /**
     * Name of the database file
     */
    public static final String DATABASE_NAME = "jindalfresh.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.
     */
    public static final int DATABASE_VERSION = 1;

    public DBCreator(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_JF_TABLE = "CREATE TABLE " + UserDataTable.TABLE_NAME + " ("
                + UserDataTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + UserDataTable.COLUMN_USER_EMAIL + " TEXT NOT NULL, "
                + UserDataTable.COLUMN_TOKEN_NO + " TEXT NOT NULL );";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_JF_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
