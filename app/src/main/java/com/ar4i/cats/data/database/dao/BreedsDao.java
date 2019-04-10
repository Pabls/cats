package com.ar4i.cats.data.database.dao;

import com.ar4i.cats.data.database.entity.BreedEntity;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface BreedsDao {

    @Query("SELECT * FROM breeds")
    List<BreedEntity> getAllBreeds();

    @Query("SELECT * FROM breeds WHERE id LIKE :id")
    List<BreedEntity> getBreedById(String id);

    @Query("SELECT * FROM breeds WHERE name LIKE :name")
    List<BreedEntity> getBreedByName(String name);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMany(List<BreedEntity> breeds);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(BreedEntity breed);

    @Update
    void update(BreedEntity breed);

    @Delete
    void delete(BreedEntity breed);
}
