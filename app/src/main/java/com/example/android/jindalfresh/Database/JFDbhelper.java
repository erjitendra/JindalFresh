package com.example.android.jindalfresh.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.jindalfresh.Database.JFContract.JFEntry;

/**
 * Created by Jindal on 9/13/2017.
 */

public class JFDbhelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = JFDbhelper.class.getSimpleName();

    /**
     * Name of the database file
     */
    private static final String DATABASE_NAME = "jindalfresh.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.
     */
    private static final int DATABASE_VERSION = 1;

    public JFDbhelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_JF_TABLE = "CREATE TABLE " + JFEntry.TABLE_NAME + " ("
                + JFEntry.COLUMN_TOKEN_NO + " TEXT NOT NULL );";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_JF_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
