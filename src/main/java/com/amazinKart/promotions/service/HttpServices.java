package com.amazinKart.promotions.service;

import com.amazinKart.promotions.exception.PromotionException;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.*;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Map;

import static com.amazinKart.promotions.constants.PromotionConstant.*;
import static org.apache.http.HttpHeaders.ACCEPT;

public class HttpServices {
    public String getData(String url, Map<String, String> headers) throws PromotionException {
        String response = null;
        try {

            HttpMethod method = new GetMethod(url);
            this.setGetHeaders(method, headers);
            HttpClient httpClient = new HttpClient();

            httpClient.executeMethod(method);

            response = IOUtils.toString(method.getResponseBodyAsStream(), "UTF-8");
            System.out.println(response);
            if (SUCCESS_STATUS_CODES.contains(method.getStatusCode())) {

                return response;

            } else if (method.getStatusCode() == BAD_REQUEST) {

                throw new PromotionException("Bad request call for URL " + url);

            } else if (method.getStatusCode() == URL_NOT_FOUND) {

                throw new PromotionException("Called URL not found URL " + url);
            }

        } catch (IOException e) {
            throw new PromotionException("Failed POST request call for URL " + url);

        }
        return response;
    }

    public static String doGet(String url) {
        String resp=null;

        HttpResponse response = null;
        try {

            org.apache.http.client.HttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet getRequest = new HttpGet(url);
            getRequest.addHeader(ACCEPT, "application/json");
            response = httpClient.execute(getRequest);
            resp =  EntityUtils.toString(response.getEntity());
            System.out.println(resp);
            // validateResponse(response);
        } catch (IOException exception) {
            //  logger.logErrorMessage(exception);
            System.out.println(exception);

        }
        return resp;
    }

    private void setGetHeaders(HttpMethod method, Map<String, String> headers) {
        method.addRequestHeader("Content-Type", "application/json");
        method.addRequestHeader("Accept", "application/json");

    }





}
