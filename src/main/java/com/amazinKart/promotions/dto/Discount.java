package com.amazinKart.promotions.dto;

public class Discount {
    double amount;
    String discountTag;

    public Discount(double amount, String discountTag) {
        this.amount = amount;
        this.discountTag = discountTag;
    }

    public double getAmount() {
        return amount;
    }

    public String getDiscountTag() {
        return discountTag;
    }
}
