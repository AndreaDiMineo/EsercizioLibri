package com.example.eserciziolibri.models;

import java.io.Serializable;

public class Offers implements Serializable {

    private int finskyOfferType;
    private ListPrice listPrice;
    private RetailPrice retailPrice;

    public Offers(int finskyOfferType, ListPrice listPrice, RetailPrice retailPrice) {
        this.finskyOfferType = finskyOfferType;
        this.listPrice = listPrice;
        this.retailPrice = retailPrice;
    }

    public int getFinskyOfferType() {
        return finskyOfferType;
    }

    public void setFinskyOfferType(int finskyOfferType) {
        this.finskyOfferType = finskyOfferType;
    }

    public ListPrice getListPrice() {
        return listPrice;
    }

    public void setListPrice(ListPrice listPrice) {
        this.listPrice = listPrice;
    }

    public RetailPrice getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(RetailPrice retailPrice) {
        this.retailPrice = retailPrice;
    }
}
