package com.thetestingacademy.ex25062024.listeners;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListener.class)
public class Lab288 {

    @Test(groups = "Sanity")
    public void test1 (){
        System.out.println("test1");
        Assert.assertTrue(false);
    }
    @Test(groups = "Sanity")
    public void test2 (){
        System.out.println("test2");
        Assert.assertTrue(true);
    }
@AfterSuite
    public void emailToQALead(){
    System.out.println("After suite Executing....");
        System.out.println("Sending Email\n");

    }

}
