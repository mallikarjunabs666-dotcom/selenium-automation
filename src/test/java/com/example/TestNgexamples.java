package com.example;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNgexamples {

    @Test ( priority = -2)
    public void Demo1()
    {
        System.out.println("For console output");

        Reporter.log("Messgae", true);

        Reporter.log("MEssage1, false");

    }

    @Test(enabled = false)
    public void demo2()
    {
        System.out.println("Console output from 2nd method");

        Reporter.log("Only message");
    }
}
