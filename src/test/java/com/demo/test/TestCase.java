package com.demo.test;


import org.testng.annotations.Test;

public  class TestCase {

    @Test(priority = 10, alwaysRun = true, enabled = true)
  public void testMethod()
    {
        System.out.println("success");
    }

}
