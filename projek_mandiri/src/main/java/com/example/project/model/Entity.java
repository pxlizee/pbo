package com.example.project.model;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Entity {

    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
