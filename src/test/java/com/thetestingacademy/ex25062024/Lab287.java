package com.thetestingacademy.ex25062024;

import org.testng.annotations.Test;
// Listeners - TestNG - Interface
// Listen to your Testcase - Failed, Passwed, Start, close, ....every State of the TC

// Types of TestNG Listeners

// ITestListener -  listen to events related to test methods.
// such as before and after a test method is executed.

// IInvokedMethodListener -  listen to events related to the invocation of
// any method, including configuration
// methods like @BeforeMethod and @AfterMethod


// ISuiteListener:
// listen to events related to the test suite,
// such as before and after the suite runs.


// IReporter - Test Results - Pass or Fail
// generate custom reports based on the test results.


// IAnnotationTransformer
// This listener is used to modify TestNG annotations at runtime.

public class Lab287 {
    @Test
    public void ABC(){
        System.out.println("abc");
    }
}
