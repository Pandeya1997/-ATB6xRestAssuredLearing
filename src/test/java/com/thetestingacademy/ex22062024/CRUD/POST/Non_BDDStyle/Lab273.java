package com.thetestingacademy.ex22062024.CRUD.POST.Non_BDDStyle;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;


public class Lab273 {
    RequestSpecification r = RestAssured
            .given();
    Response response;
    ValidatableResponse validatableResponse;

    @Description("TC#1 Verify that create booking is working with valid payload ")
    @Test
    public void TestNonDDStylePostPositive() {
        String Base_URL = "https://restful-booker.herokuapp.com";
        String Base_PATH = "/booking";
        String Payload = "{\n" +
                "    \"firstname\" : \"Abhishek\",\n" +
                "    \"lastname\" : \"Pandey\",\n" +
                "    \"totalprice\" : 10000,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-06-12\",\n" +
                "        \"checkout\" : \"2024-06-12\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Party time booking\"\n" +
                "}";

        r.baseUri(Base_URL);
        r.basePath(Base_PATH);
        r.contentType(ContentType.JSON).log().all();
        r.body(Payload);

        response = r.when().log().all().post();
        String responseString = response.asString();
        System.out.println(responseString);

        validatableResponse = response.then();
        validatableResponse.statusCode(200);

    }

    @Description("TC#2 - Verify that create booking not working, with 500 Error2")
    @Test
    public void testNonBDDStylePOSTNegative() {
        String BASE_URL = "https://restful-booker.herokuapp.com";
        String BASE_PATH = "/booking";
        String payload = "{}";
        r.baseUri(BASE_URL);
        r.basePath(BASE_PATH);
        r.contentType(ContentType.JSON).log().all();
        r.body(payload);

        response = r.when().log().all().post();
        String responseString = response.asString();
        System.out.println(responseString);


        validatableResponse = response.then();
        validatableResponse.statusCode(500);
    }
}
