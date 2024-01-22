package day05;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C02_BeforeAfterAnotation {

    // @Before method is executed before each test method
    // if we have common method for each @Test it is better to put in the @Before method
    @Before
    public void setUp(){
        System.out.println("Before Method Run");
    }

    @Test
    public void test01(){
        System.out.println("Test1 Run");
    }

    @Test
    public void test02(){
        System.out.println("Test2 Run");
    }

    @Test
    public void test03(){
        System.out.println("Test3 Run");
    }
    // @After method is executed after each @Test method
    // when we want to clean or close a website after each @Test method
    // we are using @After method
    @After
    public void tearDown(){
        System.out.println("After Method Run");
    }



}
