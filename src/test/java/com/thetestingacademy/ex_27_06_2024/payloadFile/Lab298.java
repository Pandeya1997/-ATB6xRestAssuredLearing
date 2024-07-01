package com.thetestingacademy.ex_27_06_2024.payloadFile;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.io.File;

public class  Lab298 {
    RequestSpecification r = RestAssured
            .given();
    Response response;
    ValidatableResponse validatableResponse;

    @Description("TC#1 Verify that create booking is working with valid payload ")
    @Test
    public void TestNonDDStylePostPositive() {
        String Base_URL = "https://restful-booker.herokuapp.com";
        String Base_PATH = "/booking";
       File file = new File("src\\test\\resources\\post Request.json");

        r.baseUri(Base_URL);
        r.basePath(Base_PATH);
        r.contentType(ContentType.JSON).log().all();
        r.body(file);

        response = r.when().log().all().post();
        String responseString = response.asString();
        System.out.println(responseString);

        validatableResponse = response.then();
        validatableResponse.statusCode(200);

    }
}
