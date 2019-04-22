package com.ar4i.cats.data.database.dto;

public class CategoryDto {
    // region========================================FIELDS=========================================

    private int id;
    private String name;

    // endregion-------------------------------------FIELDS-----------------------------------------

    public CategoryDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // region========================================SET/GET========================================

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // endregion-------------------------------------SET/GET----------------------------------------
}
