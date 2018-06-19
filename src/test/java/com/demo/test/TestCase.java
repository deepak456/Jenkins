package com.demo.test;


import org.testng.Assert;
import org.testng.annotations.Test;

public  class TestCase {

    @Test(priority = 10, alwaysRun = true, enabled = true)
  public void testMethod()
    {
        System.out.println("success 1");
    }

    @Test(priority = 10, alwaysRun = true, enabled = true)
    public void testMethod1()
    {
        System.out.println("success 2");
    }

    @Test(priority = 10, alwaysRun = true, enabled = true)
    public void testMethod2()
    {
        System.out.println("success 3");
    }
    @Test(priority = 10, alwaysRun = true, enabled = true)
    public void testMethod3()
    {
        System.out.println("success 4");
    }
    @Test(priority = 10, alwaysRun = true, enabled = true)
    public void testMethod4()
    {
        System.out.println("success 5");
    }
    @Test(priority = 10, alwaysRun = true, enabled = true)
    public void testMethod5()
    {
        System.out.println("success 5");
    }
    @Test(priority = 10, alwaysRun = true, enabled = true)
    public void testMethod6()
    {
        if(5<8){
            System.out.println ("Test case Fail 6");
           
        }else {
            System.out.println ("success 6");
        }
    }
    @Test(priority = 10, alwaysRun = true, enabled = true)
    public void testMethod7()
    {
        System.out.println("success  7");
    }
    @Test(priority = 10, alwaysRun = true, enabled = true)
    public void testMethod8()
    {
        System.out.println("success   8");
      
    }
@Test(priority = 10, alwaysRun = true, enabled = true)
    public void testMethod9()
    {
        System.out.println("success   9");
         System.out.println("  aaaa.............");
      
    }


}
