package test.day7;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AnotationTest
{
    @BeforeClass
    //runs only once before all test methods
    public void beforeClass()
    {
        System.out.println("Before class!");
    }

    @BeforeMethod
    public void setup()
        //some code that will be running before every test, like:test1,test2,test3
        //We can use method with @BeforeMethod annotation
    {
        System.out.println("Before Method!");
    }
    //runs automatically after every test
    @AfterMethod
    public void Teardown()
    {
        System.out.println("After Method!");
    }
    @Test
    public void test1()
    {
        System.out.println("test 1");
    }

    @Test
    public void test2()
    {
        System.out.println("test 2");
    }

    @Test
    public void test3()
    {
        System.out.println("test 3");
    }
}
