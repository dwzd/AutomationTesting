package com.ecvictor.api.rest.assured.o2o;

/**
 * Created by caoc on 3/24/2017.
 */

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Properties;

import static io.restassured.RestAssured.expect;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by caoc on 2/22/16.
 * Copyright (c) 2015 Service ECVictor Inc. All rights reserved.
 */
public class BtcTest {
    private String token;

    /**
     * Should not be able to access.
     */
    @Test
    public void testGetMyIp() {
        expect().statusCode(200)
                .body("USD", equalTo("971.41"))
                .contentType("application/json; charset=utf-8")
                .given()
                .when().get("https://min-api.cryptocompare.com/data/price?fsym=ETH&tsyms=USD&e=Bitfinex");
    }



}