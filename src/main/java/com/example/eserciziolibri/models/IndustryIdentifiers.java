package com.example.eserciziolibri.models;

import java.io.Serializable;

public class IndustryIdentifiers implements Serializable {

    private String type;
    private String identifier;

    public IndustryIdentifiers(String type, String identifier) {
        this.type = type;
        this.identifier = identifier;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}
