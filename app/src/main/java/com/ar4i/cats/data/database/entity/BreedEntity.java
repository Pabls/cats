package com.ar4i.cats.data.database.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "breeds")
public class BreedEntity {

    public BreedEntity(String id, String name) {
        this.id = id;
        this.name = name;
    }

// region========================================FIELDS=========================================

    @PrimaryKey()
    private String id;

    private String name;

    // endregion-------------------------------------FIELDS-----------------------------------------



    // region========================================SET/GET========================================

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // endregion-------------------------------------SET/GET----------------------------------------
}
