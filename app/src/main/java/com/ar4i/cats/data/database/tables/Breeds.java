package com.ar4i.cats.data.database.tables;

import android.content.ContentValues;

public final class Breeds {
    private Breeds() {
    }

    // region========================================FIELDS=========================================

    private static final String TABLE_NAME = "breeds";

    private static final String ID = "id";
    private static final String NAME = "name";

    private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS %s " +
            "( %s TEXT PRIMARY KEY, %s TEXT);";

    private static String GET_ALL_BREEDS = "SELECT * FROM %s";

    private static String INSERT_BREED = "INSERT INTO %s (%s, %s) VALUES (%s, %s);";

    // endregion-------------------------------------FIELDS-----------------------------------------

    // region========================================PUBLIC METHODS=================================


    public static String getTableName() { return TABLE_NAME; }

    public static String getID() { return ID; }

    public static String getNAME() { return NAME; }

    public static String getTableCreationCommand() {
        return String.format(CREATE_TABLE, TABLE_NAME, ID, NAME);
    }

    public static String getBreedsSelectionCommand() {
        return String.format(GET_ALL_BREEDS, TABLE_NAME);
    }

    public static ContentValues toContentValues(String id, String name) {
        ContentValues cv = new ContentValues();
        cv.put(ID, id);
        cv.put(NAME, name);
        return cv;
    }
    // endregion-------------------------------------PUBLIC METHODS---------------------------------
}
