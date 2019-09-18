package com.amazinKart.promotions;

import com.amazinKart.promotions.exception.PromotionException;
import com.amazinKart.promotions.manager.PromotionManager;
import org.testng.annotations.Test;

public class PromotionManagerTest {
    PromotionManager promotionManager = new PromotionManager();

    @Test
    public void promotionTest() {
        promotionManager.promotion("promotionseta");
    }

    @Test(expectedExceptions = PromotionException.class)
    public void promotionTestwhenPromotionnotExist() {
        promotionManager.promotion("prom0");
    }
}
