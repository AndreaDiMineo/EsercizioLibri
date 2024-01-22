package com.example.eserciziolibri.models;

import java.io.Serializable;

public class RetailPrice implements Serializable {

    private double amount;
    private String currencyCode;

    public RetailPrice(double amount, String currencyCode) {
        this.amount = amount;
        this.currencyCode = currencyCode;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}
