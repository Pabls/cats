package com.ar4i.cats.data.models;

public class PartialBreedModel {
    private String id;
    private String name;

    public PartialBreedModel(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
