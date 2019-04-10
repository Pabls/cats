package com.ar4i.cats.data.database;

import com.ar4i.cats.data.database.dao.BreedsDao;
import com.ar4i.cats.data.database.entity.BreedEntity;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = { BreedEntity.class},
        version = CatsDB.VERSION,
        exportSchema = false)
public abstract class CatsDB extends RoomDatabase {
    static final int VERSION = 1;
    public static String DATABASE_NAME = "com.ar4i.cats.database";
    public abstract BreedsDao breedsDao();
}
