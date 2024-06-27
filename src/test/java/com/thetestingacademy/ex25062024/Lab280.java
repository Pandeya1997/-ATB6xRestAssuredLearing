package com.thetestingacademy.ex25062024;

import com.beust.ah.A;
import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab280 {
    // Grouping of Test Cases
    //  100 ->  20 P0, 30 - P1, 50 - P3
    // 40 - Smoke, 60 Sanity Testcase.
@AllureId("TC#1")
@Severity(SeverityLevel.NORMAL)
@Description("Sanity Test case")
@Test (groups = {"sanity"},priority = 1)
    public void  createBookingPostiveTestcase(){
        System.out.println("Sanity");
        System.out.println("QA");
    }
@Test (groups = {"sanity"},priority = 2)
    public void RegRun(){
        System.out.println("Rug");
    }
    @Test (groups = {"smoke"},priority = 3)
    public void smokeRun(){
        System.out.println("smoke");
        Assert.assertTrue(true);
    }
@Test (groups = {"qa","Prod"},priority = 3)
    public void QARun (){
        System.out.println("smoke");
        Assert.assertTrue(false);
    }
    @Test (groups = {"prod"},priority = 3)
    public void prodRun(){
        System.out.println("smoke");
        Assert.assertTrue(false);
    }
}
