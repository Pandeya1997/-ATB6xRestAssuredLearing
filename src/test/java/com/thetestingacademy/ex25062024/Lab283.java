package com.thetestingacademy.ex25062024;

import org.testng.annotations.Test;

public class Lab283 {
    @Test (groups = {"init"} , priority = 1)
    public void getToken(){
        System.out.println("ServerStartedok");
    }
    @Test (groups = {"init"}, priority = 2)
    public void getBookingID(){
        System.out.println("intiEnviroment");
    }
    @Test (groups = {"init.*"})
    public void testPUTRequest (){
        System.out.println("Now i will run ");
    }
}
