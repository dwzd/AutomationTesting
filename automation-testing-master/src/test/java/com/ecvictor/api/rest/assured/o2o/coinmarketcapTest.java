package com.ecvictor.api.rest.assured.o2o;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.ecvictor.api.rest.assured.o2o.RestAssuredUtil.getProperties;
import static io.restassured.RestAssured.expect;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by caoc on 2/22/16.
 * Copyright (c) 2015 Service ECVictor Inc. All rights reserved.
 */
public class coinmarketcapTest {
    @BeforeClass
    public static void  setup(){
        Properties prop = getProperties();
        RestAssured.baseURI =prop.getProperty("coinmarketcap.url");
    }

    /**
     * Should not be able to access.
     */
    @Test
    public void coinmarket_top_10_coin_returns_200_with_expected_limit_and_unit() {
        expect().statusCode(200)
                .given().log().uri()
                .when().get("/ticker/?limit=10")
                .then().log().ifValidationFails()
                .body("size()", lessThan(11)).body("name", hasItem("Bitcoin"))
                .contentType("application/json");
    }
    @Test
    public void coinmarket_top_global_returns_200_with_expected_limit_and_unit() {
        expect().statusCode(200)
                .given().log().uri()
                .when().get("/global")
                .then().log().ifValidationFails()
                .body("bitcoin_percentage_of_market_cap", notNullValue())
                .contentType("application/json");
    }


}