package Testng1;


import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab265 {
    @Description("TC#01")
    @Test
    public void testcase() {
        // Assertion --> Excepted Result == Actual Result
        // 200 == 200 --> True
        // 200 == 201 --> False
        // two type Assertion
        //soft Assertion
        //hard Assertion

//   SoftAssert s = new SoftAssert();
//   s.assertEquals("Abhishek", "abhishek","Not Equal");
//        System.out.println("End of Program ");
//        s.assertAll();
        //hard Assertion

        Assert.assertEquals("Abhishek", "abhishek");
        System.out.println("End of Program ");

    }
}
