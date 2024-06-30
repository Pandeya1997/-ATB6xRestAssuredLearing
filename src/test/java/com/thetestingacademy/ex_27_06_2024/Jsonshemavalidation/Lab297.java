package com.thetestingacademy.ex_27_06_2024.Jsonshemavalidation;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import java.io.File;

public class Lab297 {

    @Test
    public void JSValidation(){
        RestAssured.given()
                .baseUri("https://jsonplaceholder.typicode.com/posts/2")
                .when().get().then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/resources/schema.json")));
    }
}
