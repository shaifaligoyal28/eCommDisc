package com.amazinKart.promotions.dto;

import java.util.HashMap;

public class CurrencyExchange {
    HashMap<String,Double> rates;
    String base;
    String date;

    public CurrencyExchange(){}

    public CurrencyExchange(HashMap<String, Double> rates, String base, String date) {
        this.rates = rates;
        this.base = base;
        this.date = date;
    }

    public HashMap<String, Double> getRates() {
        return rates;
    }

    public void setRates(HashMap<String, Double> rates) {
        this.rates = rates;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
