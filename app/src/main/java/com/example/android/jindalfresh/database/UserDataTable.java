package com.example.android.jindalfresh.database;

import android.provider.BaseColumns;

public class UserDataTable implements BaseColumns {

    public final static String TABLE_NAME = "usertoken";
    public final static String COLUMN_TOKEN_NO = "token_number";
    public final static String COLUMN_ID = BaseColumns._ID;
    public final static String COLUMN_USER_EMAIL = "email";

    public UserDataTable() {
    }
}
