package com.ecvictor.api.rest.assured.o2o;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Properties;

import static com.ecvictor.api.rest.assured.o2o.RestAssuredUtil.getProperties;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.core.IsEqual.equalTo;

public class JtechTest {
    private String apptoken;
    private String token;

    @BeforeClass
    public static void  setup(){
//        RestAssuredUtil.setup();
//        {
//            RestAssuredUtil.setup();
//
//        }
        Properties prop = getProperties();
        //RestAssured.baseURI ="http://192.168.88.187:8080/ectd/";
    }
    @Test
    public void a_get_token_when_login(){
        ValidatableResponse response =
                 given()
                        .header("authorization", "Basic cm9vdDoxMjM0NTY=")
                        .header("Content-Type", "application/x-www-form-urlencoded")
                        .body("grant_type=password&username=root&password=Basic cm9vdDoxMjM0NTY=&code=1")
                        .when().post("http://192.168.88.187:8080/ectd/f/login")
                .then().statusCode(200).log().body();

        //Response response = given().get("/ectd/f/login");
        token = response.extract().body().jsonPath().get("access_token");
       // response.print();
      //  token = response.getHeader("access_token");
        System.out.println(token);

    }

    @Test
    public void b_getApplicationType(){
        given()
                .header("apptoken", token)
                .header("uid", "bad94a71544d4146b8a9f4ad04d5e19b")
                .header("roles", "Administrator")
                .header("expires_in", "1525100162614")
                .header("user", "root")
                .when()
                .get("http://192.168.88.187:8080/ectd/a/getSubTypeListByAppType/New Drug application(NDA)")
                .then()
                .statusCode(200).log().body()
                .body("id", hasItem(10));



    }
    @Test
    public void c_getSubTypeApplication(){
        given()
                .header("apptoken", token)
                .header("uid", "bad94a71544d4146b8a9f4ad04d5e19b")
                .header("roles", "Administrator")
                .header("expires_in", "1525100162614")
                .header("user", "root")
                .when()
                .get("http://192.168.88.187:8080/ectd/a/getSubSubTypeListBySubType/Original Application")
                .then()
                .log().body()
                .body("type", hasItem("Application"))
                .contentType("application/json");
    }

}
