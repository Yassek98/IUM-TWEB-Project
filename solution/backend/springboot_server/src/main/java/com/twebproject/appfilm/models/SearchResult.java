package com.twebproject.appfilm.models;

public class SearchResult {
    private String type;
    private Integer id; // can be null for actors
    private String name;

    public SearchResult(String type, Integer id, String name) {
        this.type = type;
        this.id = id;
        this.name = name;
    }

    // Getters and Setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
