package com.example.eserciziolibri.models;

import java.io.Serializable;

public class LibroAPI implements Serializable {

    private String kind;
    private int totalItems;
    public Items[] items;

    public LibroAPI(String kind, int totalItems, Items[] items) {
        this.kind = kind;
        this.totalItems = totalItems;
        this.items = items;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public Items[] getItems() {
        return items;
    }

    public void setItems(Items[] items) {
        this.items = items;
    }
}
