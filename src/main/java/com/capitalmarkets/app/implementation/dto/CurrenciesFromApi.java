package com.capitalmarkets.app.implementation.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = false)
public class CurrenciesFromApi implements Serializable {

    private String EUR;
    private String GBP;
    private String USD;
    private String JPY;

    public String getEUR() {
        return EUR;
    }

    public String getGBP() {
        return GBP;
    }

    public String getUSD() {
        return USD;
    }

    public String getJPY() {
        return JPY;
    }

    public void setEUR(String EUR) {
        this.EUR = EUR;
    }

    public void setGBP(String GBP) {
        this.GBP = GBP;
    }

    public void setUSD(String USD) {
        this.USD = USD;
    }

    public void setJPY(String JPY) {
        this.JPY = JPY;
    }

    public CurrenciesFromApi() {
    }

    public CurrenciesFromApi(String EUR, String GBP, String USD, String JPY) {
        this.EUR = EUR;
        this.GBP = GBP;
        this.USD = USD;
        this.JPY = JPY;
    }

    @Override
    public String toString() {
        return "CurrenciesFromApi{" +
                "EUR='" + EUR + '\'' +
                ", GBP='" + GBP + '\'' +
                ", USD='" + USD + '\'' +
                ", JPY='" + JPY + '\'' +
                '}';
    }
}
