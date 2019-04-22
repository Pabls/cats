package com.ar4i.cats.data.database.dto;

public class BreedDto {
    // region========================================FIELDS=========================================

    private String id;
    private String name;

    // endregion-------------------------------------FIELDS-----------------------------------------

    public BreedDto(String id, String name) {
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
