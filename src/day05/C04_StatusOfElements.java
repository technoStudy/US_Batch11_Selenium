package day05;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;


import java.time.Duration;

public class C04_StatusOfElements {

    /*
    TC ID: TC_PRODUCTS_PAGE_001
    TC Title: Verify Home Page Elements
    TC Description: This test case focuses on verifying the visibility of
    essential elements on the home page of the 'http://automationexercise.com' website.
    It includes steps to launch the website and verify the presence of the following elements:
    Products, Cart, Signup/Login, Video Tutorials, Testcases, API Testing, and Contact Us.
    Test Steps:
    Navigate to URL https://automationexercise.com/
   1- Verify the presence of the 'Products' link or button on the home page.
   2- Verify the presence of the 'Cart' link or button on the home page.
   3- Verify the presence of the 'Signup/Login' link or button on the home page.
   4- Verify the presence of the 'Video Tutorials' link or section on the home page.
   5- Verify the presence of the 'Testcases' link or section on the home page.
   6- Verify the presence of the 'API Testing' link or section on the home page.
   7- Verify the presence of the 'Contact Us' link or section on the home page.
    Expected Result:
    The 'Products' link or button should be visible on the home page
    The 'Cart' link or button should be visible on the home page
    The 'Signup/Login' link or button should be visible on the home
    The 'Video Tutorials' link or section should be visible on the home
    The 'Testcases' link or section should be visible on the home
    The 'API Testing' link or section should be visible on the home
    The 'Contact Us' link or section should be visible on the home

     */

    WebDriver driver;
    ReusableMethods reusableMethods = new ReusableMethods();

    @Before
    public void setUp(){
        // Navigate to URL https://automationexercise.com/
        driver = new ChromeDriver();
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void productButtonIsDisplayed() throws InterruptedException {
        // Verify the presence of the 'Products' link or button on the home page.
        WebElement productButton = driver.findElement(By.xpath("//a[@href='/products']"));
        // Before we used if-else to test but in the JUnit we do not need to use if-else
        // instead of if-else we will use Assertion method
        // we can type a message, the message will be appearing when the test is fail
        // We will see the message, only if it's failed
        Thread.sleep(3000);
        Assert.assertTrue("Product Button is not visible",productButton.isDisplayed());
        driver.close();
    }

    @Test
    public void CartButtonIsDisplayed() throws InterruptedException {
        // Verify the presence of the 'Cart' link or button on the home page.
        WebElement cartButton = driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]"));
        Thread.sleep(3000);
        Assert.assertTrue("Cart Button is not visible",cartButton.isDisplayed());
        driver.close();
    }

    @Test
    public void signLoginButtonIsDisplayed() throws InterruptedException {
        // Verify the presence of the 'Signup/Login' link or button on the home page
        WebElement signLoginButton = driver.findElement(By.xpath("//a[@href='/login']"));
        Thread.sleep(3000);
        Assert.assertTrue("Signup/Login Button is not visible",signLoginButton.isDisplayed());
        driver.close();
    }


    /*


    6- Verify the presence of the 'API Testing' link or section on the home page.
    7- Verify the presence of the 'Contact Us' link or section on the home page.
     */
    @Test
    public void videoTutorialsButtonIsDisplayed() {
        //4- Verify the presence of the 'Video Tutorials' link or section on the home page.
        WebElement videoTutorialButton =
                driver.findElement(By.xpath("//a[@href='https://www.youtube.com/c/AutomationExercise']"));
        reusableMethods.myWait(2);
        Assert.assertTrue(videoTutorialButton.isDisplayed());
    }

    @Test
    public void testCasesIsDisplayed() {
        //5- Verify the presence of the 'Testcase' link or button on the home page.
        WebElement testCasesButton = driver.findElement(By.xpath("(//a[@href='/test_cases'])[1]"));
        Assert.assertTrue("testcases Button is not visible", testCasesButton.isDisplayed());
    }



    @After
    public void tearDown(){
        driver.quit();
    }

}
