package com.thetestingacademy.ex_RestAssured_ra01;

import io.restassured.RestAssured;

public class Lab260 {
    public static void main(String[] args) {
        // Rest Assured hello world Program
        //    RestAssured.basic().authenticate().();
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/ping")
                .when().get().then().statusCode( 201);

    }
}
