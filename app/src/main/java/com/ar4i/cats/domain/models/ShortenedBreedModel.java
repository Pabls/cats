package com.ar4i.cats.domain.models;

public class ShortenedBreedModel {
    private int id;
    private String name;

    public ShortenedBreedModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
