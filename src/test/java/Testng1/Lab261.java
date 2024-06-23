package Testng1;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Lab261 {
    //100 -Group these test case
    //smoke sanity
    // Before , After we can do sometime
    @Description("TC#1 - Verify GET 261 Request 1 ")
    @Test
    public void getRequest() {
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/ping")
                .when().get().then().statusCode(201);
    }

    @Description("TC#1 - Verify GET 261 Request 2 ")
    @Test
    public void getRequest2() {
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/ping")
                .when().get()
                .then().statusCode(201);
    }
}
