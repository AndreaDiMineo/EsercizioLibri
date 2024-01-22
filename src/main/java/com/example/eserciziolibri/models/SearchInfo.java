package com.example.eserciziolibri.models;

import java.io.Serializable;

public class SearchInfo implements Serializable {

    private String textSnippet;

    public SearchInfo() {}

    public SearchInfo(String textSnippet) {
        this.textSnippet = textSnippet;
    }

    public String getTextSnippet() {
        return textSnippet;
    }

    public void setTextSnippet(String textSnippet) {
        this.textSnippet = textSnippet;
    }
}
