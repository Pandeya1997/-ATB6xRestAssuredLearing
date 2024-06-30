package com.thetestingacademy.ex_27_06_2024.Gson.deserialization;

import com.google.gson.Gson;
import com.thetestingacademy.ex_27_06_2024.Gson.Serialization.Booking;
import org.testng.annotations.Test;

public class Lab295 {
    @Test
    public void DeSerializationTest(){
    String jsonString   = "{\n" +
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
    Gson gson = new Gson();
    Booking booking = gson.fromJson(jsonString,Booking.class);
    System.out.println(booking.getFirstname());
    System.out.println(booking.getLastname());
    }
}
