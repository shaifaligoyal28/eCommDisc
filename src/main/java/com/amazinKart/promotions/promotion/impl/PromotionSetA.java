package com.amazinKart.promotions.promotion.impl;

import com.amazinKart.promotions.dto.CurrencyExchange;
import com.amazinKart.promotions.dto.Discount;
import com.amazinKart.promotions.dto.Product;
import com.amazinKart.promotions.promotion.PromotionSet;
import com.amazinKart.promotions.utils.DefaultPromotion;
import com.amazinKart.promotions.utils.Utility;

import java.util.List;

public class PromotionSetA implements PromotionSet {

    double max = 0;
    double discount = 0;
    String tag = null;
    Discount disc;

    public List<Product> getDiscount(List<Product> products, CurrencyExchange currencyExchange) {
        System.out.println("Running Get Discount");
        String base = currencyExchange.getBase();
        for (Product product : products) {
            max = 0;
            tag = null;
            if(!product.getCurrency().equalsIgnoreCase("inr"))
            {
                System.out.println(product.getPrice());
                double price = Utility.convertToINR(product.getPrice(),product.getCurrency(),base,currencyExchange.getRates());
                System.out.println(price);
                product.setPrice(price);
                product.setCurrency("INR");
            }

            if (product.getOrigin().equalsIgnoreCase("africa")) {
                discount = (7 * product.getPrice()) / 100;
                if (max < discount) {
                    max = discount;
                    tag = "7% discount if the origin of the products is Africa ";
                }
            }
            if (product.getRating() == 2) {
                discount = (4 * product.getPrice()) / 100;
                if (max < discount) {
                    max = discount;
                    tag = "4% discount if the rating equals 2";
                }
            }
            if (product.getRating() < 2) {
                discount = (8 * product.getPrice()) / 100;
                if (max < discount) {
                    max = discount;
                    tag = "4% discount if the rating below 2";
                }
            }
            if (product.getRating() < 2) {
                discount = (8 * product.getPrice()) / 100;
                if (max < discount) {
                    max = discount;
                    tag = "4% discount if the rating below 2";
                }
            }
            if ((product.getCategory().equalsIgnoreCase("electronics") ||
                    product.getCategory().equalsIgnoreCase("furnishing")) &&
                    product.getPrice() >= 500) {
                discount = 100;
                if (max < discount) {
                    max = discount;
                    tag = "Rs100 discount if category electronics or furnishing and price equal to or above 500";
                }
            }
            if (max == 0 && tag == null) {
                disc = DefaultPromotion.getDefaultDiscount(product);
            } else
                disc = new Discount(discount, tag);
            product.setDiscount(disc);
        }
        return products;
    }
}
