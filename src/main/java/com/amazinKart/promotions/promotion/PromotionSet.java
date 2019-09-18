package com.amazinKart.promotions.promotion;

import com.amazinKart.promotions.dto.CurrencyExchange;
import com.amazinKart.promotions.dto.Product;

import java.util.List;

public interface PromotionSet {
    List<Product> getDiscount(List<Product> products, CurrencyExchange currencyExchange);
}
