package Testng1;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lab267 {
    //curd
    // Create Booking  --> id
    // put --> id, token
    // Delete --> id
    // Get ---> ID -- Verify it should not exist
    String token ;
    Integer bookingId;
    public String getToken() {
        token = "123";
        return token;
    }
    @BeforeTest
   public void getTokenAndBookingId() {
        token = getToken();
      //  post Req -
        // Post code
        bookingId = 123;
    }
    @Test
    public void testPUTReq() {
        System.out.println(token);
        System.out.println(bookingId);
        // PUT Req
    }
    @Test
    public void testPUTR() {
        System.out.println(token);
        System.out.println(bookingId);
        // Delete  Req
    }




}
