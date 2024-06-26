package com.thetestingacademy.ex25062024;

import org.testng.annotations.Test;

// TestNG Same Priority then and  then ALLBHABETS  according priority
public class Lab279 {
    @Test(priority = 0)
    public void testMethodA() {
        System.out.println("testMethodA");
    }

    @Test (priority = 0)
    public void testMethodB() {
        System.out.println("testMethodB");
    }

    @Test (priority = 0)
    public void testMethodC() {
        System.out.println("testMethodC ");
    }
    @Test (priority = 0)
    public void testMethodD() {
        System.out.println(" testMethodD  ");
    }
}
