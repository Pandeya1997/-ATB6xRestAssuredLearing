package com.thetestingacademy.ex22062024.CRUD.Full;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.testng.Assert;

import static org.assertj.core.api.Assertions.*;


public class Lab277 {
    String token;
    Integer bookingId;
    RequestSpecification requestSpecification = RestAssured.given();
    ValidatableResponse validatableResponse;
    Response response;

    @BeforeTest
    public void getAToken() {
        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("auth");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload);
        response = requestSpecification.post();
        validatableResponse = response.then();
        validatableResponse.statusCode(200);

        // Extract the token from this
        token = response.then().log().all().extract().path("token");
        Assert.assertNotNull(token);

    }

    @BeforeTest
    public void getBookingID() {

        String Payload = "{\n" +
                "        \"firstname\": \"Abhishek\",\n" +
                "        \"lastname\": \"Pandey\",\n" +
                "        \"totalprice\": 111,\n" +
                "        \"depositpaid\": true,\n" +
                "        \"bookingdates\": {\n" +
                "            \"checkin\": \"2024-06-12\",\n" +
                "            \"checkout\": \"2024-06-12\"\n" +
                "        },\n" +
                "        \"additionalneeds\": \"Party time booking\"\n" +
                "    }";

        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON).log().all();
        requestSpecification.body(Payload);

        response = requestSpecification.when().post();

        ValidatableResponse validatableResponse = response.then();
        String responseString = response.asString();
        System.out.println(responseString);

        validatableResponse.statusCode(200);

        bookingId = response.then().log().all().extract().path("bookingid");
        String firstName = response.then().log().all().extract().path("booking.firstName");
        System.out.println(firstName);
        System.out.println(bookingId);
        Assert.assertNotNull(bookingId);

    }

    @Test
    public void testPUTRequestPositive() {
        // token and bookingID
        String payload = "{\n" +
                "        \"firstname\": \"Abhishek \",\n" +
                "        \"lastname\": \"Pandey\",\n" +
                "        \"totalprice\": 111,\n" +
                "        \"depositpaid\": true,\n" +
                "        \"bookingdates\": {\n" +
                "            \"checkin\": \"2024-06-12\",\n" +
                "            \"checkout\": \"2024-06-12\"\n" +
                "        },\n" +
                "        \"additionalneeds\": \"Party time booking\"\n" +
                "    }";

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("booking/" + bookingId);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);


        // put Request
        requestSpecification.body(payload).log().all();
        response = requestSpecification.when().put();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);




        String fullResponesJSONString = response.asString();
        System.out.println(fullResponesJSONString);


        // Verify all the keys and value pairs in the response
        // firstname, lastname, deposit, totla,. checkin

        // 3 Ways You can verify the response

        // 1. RA - Matchers
        validatableResponse.body("firstname", Matchers.equalTo("Abhishek"));
        validatableResponse.body("lastname", Matchers.equalTo("Pandey"));


        //  2. TestNG Asserts -
        //  Assert.assertEquals(firstNameResponse,"Pramod");

        String firstNameResponse = response.then().log().all().extract().path("firstname");
        Assert.assertEquals(firstNameResponse, "Abhishek");
        //String firstNameResponse = response.then().log().all().extract().path("firstname");
       // Assert.assertEquals(firstNameResponse,"Pramod");

//3. TestNG Assertion with JSON Path Lib

        JsonPath jsonpath = new JsonPath(fullResponesJSONString);
        String firstNameJSONPathExtracted = jsonpath.getString("firstname");
        String lastNameJSONPathExtracted = jsonpath.getString("lastname");
        Integer totalpriceJSONPathExtracted = jsonpath.getInt("totalprice");
        String checkinDate = jsonpath.getString("bookingdates.checkin");

        Assert.assertEquals(firstNameJSONPathExtracted,"Abhishek");
       Assert.assertEquals(lastNameJSONPathExtracted,"Pandey");
        Assert.assertEquals(totalpriceJSONPathExtracted,111);
        Assert.assertEquals(checkinDate,"2024-06-12");




//        // JSON Array Response
//        String checkin = jsonPath.getString("[0][\"bookingdates\"][\"checkin\"]");
//        System.out.println(checkin);


        // 4. Assertj Matching

        assertThat(firstNameJSONPathExtracted)
                .isEqualTo("Abhishek")
                .isNotBlank().isNotEmpty();

        assertThat(totalpriceJSONPathExtracted).isPositive().isNotZero();







    }
}
