package com.ar4i.cats.data.models;

public class CategoryModel {

    // region========================================Fileds=========================================

    private int id;
    private String name;

    // endregion-------------------------------------Fileds-----------------------------------------

    public CategoryModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // region========================================SET/GET========================================

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
