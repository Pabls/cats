package com.ar4i.cats.data.database.entities;

public class BreedEntity {
    // region========================================FIELDS=========================================

    private String id;
    private String name;

    // endregion-------------------------------------FIELDS-----------------------------------------

    public BreedEntity(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // region========================================SET/GET========================================

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    // endregion-------------------------------------SET/GET----------------------------------------
}
