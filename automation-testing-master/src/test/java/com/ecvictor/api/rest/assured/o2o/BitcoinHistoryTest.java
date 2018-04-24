package com.ecvictor.api.rest.assured.o2o;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.IsEqual.equalTo;

public class BitcoinHistoryTest {


    private static String host;

    @BeforeClass
    static public  void setup(){
        Properties prop = getProperties();
        host = prop.getProperty("bitcoin.url");
    }

    @Test
    public void
    price_resource_returns_200_with_expected_price() {

            given().log().uri().
                    when().
                    get(host + "/api/data/coinsnapshot/?fsym={currency}&tsym={unit}",
                            "BTC", "USD").
                    then().log().body().
                    statusCode(200).
                    body("Data.Algorithm", (equalTo("SHA256")));

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

