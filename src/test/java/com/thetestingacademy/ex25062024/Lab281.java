package com.thetestingacademy.ex25062024;

import org.testng.annotations.Test;

public class Lab281 {
@Test
    public void serverStartedok(){
    System.out.println(" I Will run first");
}
@Test(dependsOnMethods = "serverStartedok")
public void method (){
    System.out.println("methos");
}
}
