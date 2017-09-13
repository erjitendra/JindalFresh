package com.example.android.jindalfresh.Database;

import android.provider.BaseColumns;

/**
 * Created by Jindal on 9/13/2017.
 */

public class JFContract {
    private JFContract() {
    }

    public static final class JFEntry implements BaseColumns {

        /**
         * Name of database table for pets
         */
        public final static String TABLE_NAME = "usertoken";

        public final static String COLUMN_TOKEN_NO = "tokennumber";

    }
}
