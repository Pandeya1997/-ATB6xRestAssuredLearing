package com.thetestingacademy.ex22062024.CRUD.PUT.NonBDDStyle;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class Lab274 {

    RequestSpecification r = RestAssured.given();
    Response response;
    ValidatableResponse vr;
    String token = "49e01375461a3ca";
    String bookingid = "1065";

    String BASE_URL = "https://restful-booker.herokuapp.com";
    String BASE_PATH = "/booking";

    @Test
    public void testPutREQUESTNonBDD() {
        String BASE_PATH_UPDATED = BASE_PATH + "/" + bookingid;
        System.out.println(BASE_PATH_UPDATED);

        String payload = "{\n" +
                "        \"firstname\": \"abhishek\",\n" +
                "        \"lastname\": \"pandey\",\n" +
                "        \"totalprice\": 10000,\n" +
                "        \"depositpaid\": true,\n" +
                "        \"bookingdates\": {\n" +
                "            \"checkin\": \"2024-06-12\",\n" +
                "            \"checkout\": \"2024-06-12\"\n" +
                "        },\n" +
                "        \"additionalneeds\": \"Party time booking\"\n" +
                "    }";

        r.baseUri(BASE_URL);
        r.basePath(BASE_PATH_UPDATED);
        r.contentType(ContentType.JSON);
        r.cookie("token", token);
        r.body(payload).log().all();

        response = r.when().log().all().put();

        vr = response.then().log().all();
        vr.statusCode(200);
        vr.body("firstname", Matchers.equalTo("abhishek"));
        vr.body("lastname", Matchers.equalTo("pandey"));


    }
}