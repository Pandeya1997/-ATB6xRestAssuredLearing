package com.thetestingacademy.ex_27_06_2024.jacksonapi.ser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thetestingacademy.ex_27_06_2024.Gson.Serialization.Booking;
import com.thetestingacademy.ex_27_06_2024.Gson.Serialization.BookingDates;
import org.testng.annotations.Test;

public class Lab295 {
    @Test
    public  void seraJackson()  throws JsonProcessingException {
        String BASE_URL = "https://restful-booker.herokuapp.com";
        String BASE_PATH = "/booking";


        Booking booking = new Booking();
        booking.setFirstname("Pramod");
        booking.setLastname("Dutta");
        booking.setTotalprice(112);
        booking.setDepositpaid(true);

        BookingDates bookingdates = new BookingDates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-01");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

        System.out.println(booking);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
        System.out.println(jsonString);
    }
}
