package com.ecvictor.api.rest.assured.o2o;

import io.restassured.RestAssured;
import org.hamcrest.core.IsNot;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.IsEqual.equalTo;

public class BitcoinPriceTest {


    private static String host;

    @BeforeClass
    static public  void setup(){
        Properties prop = getProperties();
        host = prop.getProperty("bitcoin.url.min");
    }

    @Test
    public void
    price_resource_returns_200_with_expected_price() {
        HashMap<String, String> currencyPair = new HashMap<>();
        currencyPair.put("BTC", "CAD");
        currencyPair.put("ETH", "USD");
        for (String key : currencyPair.keySet()) {

            given().log().uri().
                    when().
                    get(host + "/data/price?fsym={currency}&tsyms={unit}",
                            key, currencyPair.get(key)).
                    then().log().body().
                    statusCode(200).
//                    body("CAD", is(not(equalTo(7971.29)))); //term 4 price
                    body("CAD", is(not(equalTo(13833.68)))); ///term 5 price
        }

    }

    @Test
    public void
    price_resource_returns_200_with_expected_error() {

        HashMap<String, String> currencyPair = new HashMap<>();
        currencyPair.put("btc", "CAD");
        currencyPair.put("eth", "USD");

        for (String key : currencyPair.keySet()) {
            given().log().uri().
                    when().
                    get(host + "/data/price?fsym={currency}&tsyms={unit}",
                            key, currencyPair.get(key)).
                    then().log().body().
                    statusCode(200).
                    body("Response", equalTo("Error")).
                    body("Message", equalTo("There is no data for the symbol " + key + " ."));
        }
    }
    public static Properties getProperties() {
        //load properties from the config file
        String resourceName = "config.properties"; // could also be a constant
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Properties prop = new Properties();
        try {
            InputStream resourceStream = loader.getResourceAsStream(resourceName);
            prop.load(resourceStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}

