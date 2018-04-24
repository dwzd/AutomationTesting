package com.ecvictor.api.rest.assured.o2o;

import io.restassured.RestAssured;
import org.apache.http.HttpResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Properties;

import static com.ecvictor.api.rest.assured.o2o.RestAssuredUtil.getProperties;
import static io.restassured.RestAssured.expect;
import static org.hamcrest.core.IsEqual.equalTo;

public class Jtech2Test {
    private String apptoken;
    private String token;

    @BeforeClass
    public static void  setup(){
        RestAssuredUtil.setup();
        {
            RestAssuredUtil.setup();

        }
        Properties prop = getProperties();
        RestAssured.baseURI ="http://192.168.88.187:8080/ectd/";
    }
    @Test
    public void get_token_when_login(){
        String grant_type = "password";
        String username = "root";
        String password = "Basic cm9vdDoxMjM0NTY=";
        String code = "1";

        expect().statusCode(200)
                .header("authorization", "Basic cm9vdDoxMjM0NTY=")
                .header("Content-Type", "application/x-www-form-urlencoded");

               // .body("grant_type=password&username=root&password=Basic%20cm9vdDoxMjM0NTY%3D&code=1")
                //.asString();
    }
}
