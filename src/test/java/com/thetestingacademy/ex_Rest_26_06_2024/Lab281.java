package com.thetestingacademy.ex_Rest_26_06_2024;

import org.testng.annotations.Test;

public class Lab281 {
   @Test
    public void serverStartedok(){
       System.out.println("I Will run first");
    }
    @Test(dependsOnMethods = "serverStartedok")
    public void method1(){
        System.out.println("method");
    }
}
