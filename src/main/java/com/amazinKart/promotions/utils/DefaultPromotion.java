package com.amazinKart.promotions.utils;

import com.amazinKart.promotions.dto.Discount;
import com.amazinKart.promotions.dto.Product;

public class DefaultPromotion {
    public static Discount getDefaultDiscount(Product product) {
        if (product.getPrice() > 2000) {
            double discount = 2 * product.getPrice() / 100;
            String tag = "Default discount";
            return new Discount(discount, tag);
        }
        return null;
    }
}
