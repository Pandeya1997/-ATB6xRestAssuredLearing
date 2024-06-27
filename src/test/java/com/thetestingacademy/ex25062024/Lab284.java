package com.thetestingacademy.ex25062024;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Lab284 {


    @Parameters("browser")
    @Test(priority = 1)
    public void testDemo1(String value ){
        System.out.println("browser is " + value );
        switch (value){
            case "firefox":
                // firefox code
                System.out.println("firfox starting and Running TC");
            case "chrome":
                // chrome code
                System.out.println("chrome starting and Running TC ");
                break;
            default:
                System.out.println("No idea,WHAT TO START");


        }

    }

}