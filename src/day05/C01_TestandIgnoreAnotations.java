package day05;


import org.junit.Ignore;
import org.junit.Test;


public class C01_TestandIgnoreAnotations {
    // We are not using anymore MAIN METHOD
    // we added JUnit library in the framework
    // when we create a test method we should define it ( this is a test method )
    // 1st annotation is @Test to define a test method
    // each @Test method represents a test case
    // generally The name of class should be same with the user story
    // when we run all tests at once, we should run class and
    // tests will run alphabetic order
    @Test
    public void afirstTest() {
        System.out.println("First Test Run");
    }

    // if you want to ignore a test we are using @Ignore annotation
    @Test @Ignore
    public void bsecondTest(){
        System.out.println("Second Test Run");

    }

    @Test
    public void cthirdTest(){
        System.out.println("Third Test Run");
    }



}
