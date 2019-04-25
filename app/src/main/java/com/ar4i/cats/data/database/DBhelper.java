package com.ar4i.cats.data.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.ar4i.cats.data.database.tables.Breeds;
import com.ar4i.cats.data.database.tables.Categories;

public class DBhelper extends SQLiteOpenHelper {

    // region========================================FIELDS=========================================

    public static final int VERSION = 1;
    public static final String DATABASE_NAME = "com.ar4i.catsApp.database";

    // endregion-------------------------------------FIELDS-----------------------------------------


    public DBhelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    // region========================================extends SQLiteOpenHelper=======================

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.beginTransaction();
        try {
            db.execSQL(Breeds.getTableCreationCommand());
            db.execSQL(Categories.getTableCreationCommand());

            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    // endregion-------------------------------------extends SQLiteOpenHelper-----------------------

}
