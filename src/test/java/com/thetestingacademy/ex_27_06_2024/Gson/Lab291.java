package com.thetestingacademy.ex_27_06_2024.Gson;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab291 {
    // Payload - String , Map
    // Most Used - class & Objects,
    // Swagger API - Document, File , IO, Binary File Payload
// Non BDD - API Automation -
// Cucumber BDD  - suite - Framework -. Cucumber BDD (Feature Files, Glue Other)

// Payload --> RA --> class or object --> JSONString (who help , Library --serialization
    // Response --> Json String --> class or object (Deserialization)
    //{
    //            "firstname" : "Jim",
    //    //                "lastname" : "Brown",
    //                "totalprice" : 111,
    //                "depositpaid" : true,
    //                "bookingdates" : {
    //            "checkin" : "2018-01-01",
    //                    "checkout" : "2019-01-01"
    //        },
    //            "additionalneeds" : "Breakfast"
    //        }


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

}
