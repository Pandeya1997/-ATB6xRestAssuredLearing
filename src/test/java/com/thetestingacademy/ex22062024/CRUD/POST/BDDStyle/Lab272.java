package com.thetestingacademy.ex22062024.CRUD.POST.BDDStyle;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class Lab272 {
    @Test
    public void TestBDDStylePostPositive() {
        // Post Request
        // URL
        // Body - Payload
        // Header - Content type
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
        RestAssured
                .given().baseUri(Base_URL).basePath(Base_PATH)
                .contentType(ContentType.JSON).log().all().body(Payload)
                .when().log().all().post()

                .then().log().all().statusCode(200);
    }
}
