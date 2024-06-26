package com.thetestingacademy.ex25062024;

import org.testng.annotations.Test;

public class Lab278 {
    // TestNG Priority in java
    // TestNG also allows the use of negative priority values
    @Test (priority = 1)
    public void testMethodOne() {
        System.out.println("Test Method One ");
    }

    @Test (priority = 2)
    public void testMethodTwo() {
        System.out.println("Test Method two");
    }

    @Test (priority = 0)
    public void testMathodZero() {
        System.out.println("Test Method Zero ");
    }
    @Test (priority = -1)
    public void testMathodNegativeOne() {
        System.out.println(" Test Negative one  ");
    }


}
