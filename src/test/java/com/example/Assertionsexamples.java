package com.example;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertionsexamples {


//    for Assert
//    Assert.assertequals(title, "1234")

//    for soft Assert
//    softAssert s = new softAssert();
//    s.asertequals(title, '1234')

    @Test
    public void test1()
    {
        String a = "1234";

        Assert.assertEquals(a, "1234");

        SoftAssert s = new SoftAssert();
        s.assertEquals(a, "12345");

        Reporter.log(a, true);




    }






}
