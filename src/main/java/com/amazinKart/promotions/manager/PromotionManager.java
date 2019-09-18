package com.amazinKart.promotions.manager;

import com.amazinKart.promotions.dto.CurrencyExchange;
import com.amazinKart.promotions.dto.Product;
import com.amazinKart.promotions.factory.PromotionSetFactory;
import com.amazinKart.promotions.utils.Utility;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import static com.amazinKart.promotions.constants.PromotionConstant.PATH;

public class PromotionManager {

    Utility utility = new Utility();

    public void promotion(String promotionStrtegy) {
        System.out.println("Inside promotion");
        List<Product> products = utility.getProductList();
        CurrencyExchange currencyExchange = utility.getCurrencyExchange();
        PromotionSetFactory.getInstance(promotionStrtegy).getDiscount(products,
                currencyExchange);

        saveToFile(products);
    }

    private void saveToFile(List<Product> products){
        System.out.println("INside save to file"+PATH);
       // String path = "target/output.json";
        try{
            File file = new File(PATH);
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            ObjectMapper objectMapper = new ObjectMapper();
            fileWriter.write(objectMapper.writeValueAsString(products));
            fileWriter.flush();
            fileWriter.close();
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }

}
