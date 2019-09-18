package com.amazinKart.promotions;

import com.amazinKart.promotions.manager.PromotionManager;


public class Main {
    public static void main(String args[]){
        PromotionManager promotionManager = new PromotionManager();
        System.out.println("running promotions for "+args[0]);
        try {
            promotionManager.promotion(args[0]);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

}
