package com.example.eserciziolibri.models;

import java.io.Serializable;

public class ReadingModes implements Serializable {

    private boolean text;
    private boolean image;

    public ReadingModes(boolean text, boolean image) {
        this.text = text;
        this.image = image;
    }

    public boolean isText() {
        return text;
    }

    public void setText(boolean text) {
        this.text = text;
    }

    public boolean isImage() {
        return image;
    }

    public void setImage(boolean image) {
        this.image = image;
    }
}
