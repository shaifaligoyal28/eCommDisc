package com.amazinKart.promotions.utils;

import com.amazinKart.promotions.dto.CurrencyExchange;
import com.amazinKart.promotions.dto.Product;
import com.amazinKart.promotions.service.HttpServices;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Utility {
    //can be sent through properties file file
    private final String productUrl = "https://api.jsonbin.io/b/5d31a1c4536bb970455172ca/latest";
    private final String currencyExchangeUrl = "https://api.exchangeratesapi.io/latest";

    private ObjectMapper objectMapper = new ObjectMapper();

    public List<Product> getProductList(){
        System.out.println("Fetch Product list");
        String resp = getHttpResp(productUrl);
        Product[] productList = null;
        try {
            productList = objectMapper.readValue(resp, Product[].class);
        }
        catch(Exception e){
            System.out.println(e);
        }
        return Arrays.asList(productList);
    }

    public CurrencyExchange getCurrencyExchange()
    {
        System.out.println("Fetch Currency Exchange");
        String resp = getHttpResp(currencyExchangeUrl);
        CurrencyExchange currencyExchange=null;
        try {
            currencyExchange = objectMapper.readValue(resp, CurrencyExchange.class);
        }
        catch(Exception e){
            System.out.println(e);
        }
        return currencyExchange;
    }

    public static double convertToINR(double prodPrice,String prodCurrency,String base,HashMap<String,Double> rates){
        double price = 0;
        if(rates.containsKey("INR") && rates.containsKey(prodCurrency)){
            double inrValue = rates.get("INR");
            double prodCurrValue = rates.get(prodCurrency);
            price = inrValue * prodPrice / prodCurrValue;

        }
        return price;
    }

    private String getHttpResp(String url){
        HttpServices httpServices = new HttpServices();
        String resp = httpServices.doGet(url);
        return resp;
    }
}



