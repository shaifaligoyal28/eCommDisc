package com.amazinKart.promotions.factory;

import com.amazinKart.promotions.exception.PromotionException;
import com.amazinKart.promotions.promotion.PromotionSet;
import com.amazinKart.promotions.promotion.impl.PromotionSetA;
import com.amazinKart.promotions.promotion.impl.PromotionSetB;

public class PromotionSetFactory {

    public static PromotionSet getInstance(String promotionSet){
        System.out.println("Creating instance "+promotionSet);
            if (promotionSet.equalsIgnoreCase("promotionseta"))
                return new PromotionSetA();
            if (promotionSet.equalsIgnoreCase("promotionsetb"))
                return new PromotionSetB();
            else
                throw new PromotionException("promotion Set "+promotionSet+" does not exist");
    }
}
