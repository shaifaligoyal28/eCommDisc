package com.amazinKart.promotions.exception;

public class PromotionException extends RuntimeException {

    String body;

    public PromotionException(String body) {
        this.body = body;
    }



    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "BadRequestException [body=" + body + "]";
    }
}
