package com.example.edu.a0817moacn01c_3.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ma on 13/11/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASENAME="pachoDB";
    private static final Integer DATABASEVERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASENAME, null, DATABASEVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
