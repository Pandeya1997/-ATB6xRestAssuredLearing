package com.thetestingacademy.ex22062024.CRUD.GET.NonBDDStyle;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;


public class Lab271 {
    @Description("TC#1 Positive testcase Verify that Get Single  Booking  ")
    @Test
    public void getRequestPostive() {
        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/2668").log().all();
        r.when().get();
        r.then().log().all().statusCode(200);
        // Header , Response , Data / Body
    }
    @Description("TC#1 negative testcase Verify that Get Booing and booking_id   ")
    @Test
    public void getRequestNegative() {
        RequestSpecification r1 = RestAssured.given();
        r1.baseUri("https://restful-booker.herokuapp.com");
        r1.basePath("/booking/-1").log().all();
        r1.when().get();
        r1.then().log().all().statusCode(404);
    }


}
