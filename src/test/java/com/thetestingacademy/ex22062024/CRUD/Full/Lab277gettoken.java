package com.thetestingacademy.ex22062024.CRUD.Full;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lab277gettoken {
    @BeforeTest
    public void getAToken() {
        System.out.println("2");
    }

    @BeforeTest
    public void getBookingID() {
        System.out.println("1");
    }

    @Test
    public void t3() {
        // token and BookingID
        System.out.println("3");
    }

}
