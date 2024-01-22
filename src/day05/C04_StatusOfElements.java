package day05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
    Verify the presence of the 'Products' link or button on the home page.
    Verify the presence of the 'Cart' link or button on the home page.
    Verify the presence of the 'Signup/Login' link or button on the home page.
    Verify the presence of the 'Video Tutorials' link or section on the home page.
    Verify the presence of the 'Testcases' link or section on the home page.
    Verify the presence of the 'API Testing' link or section on the home page.
    Verify the presence of the 'Contact Us' link or section on the home page.
    Expected Result: The gender radio button selected
    should be visually checked, indicating successful selection.
     */

    @Test
    public void productButtonIsDisplayed(){
       // Navigate to URL https://automationexercise.com/
        WebDriver driver = new ChromeDriver();
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // Verify the presence of the 'Products' link or button on the home page.
        WebElement productButton = driver.findElement(By.xpath("//a[@href='/products']"));
        // Before we used if-else to test but in the JUnit we do not need to use if-else
        // instead of if-else we will use Assertion method
        // we can type a message, the message will be appearing when the test is fail
        // We will see the message, only if it's failed
        Assert.assertTrue("Product Button is not visible",productButton.isDisplayed());
        driver.close();
    }

    @Test
    public void CartButtonIsDisplayed() throws InterruptedException {
        // Navigate to URL https://automationexercise.com/
        WebDriver driver = new ChromeDriver();
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // Verify the presence of the 'Cart' link or button on the home page.
        WebElement cartButton = driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]"));

        Thread.sleep(3000);
        Assert.assertTrue("Cart Button is not visible",cartButton.isDisplayed());
        driver.close();
    }

    @Test
    public void signLoginButtonIsDisplayed() throws InterruptedException {
        // Navigate to URL https://automationexercise.com/
        WebDriver driver = new ChromeDriver();
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // Verify the presence of the 'Signup/Login' link or button on the home page
        WebElement signLoginButton = driver.findElement(By.xpath("//a[@href='/login']"));
        Thread.sleep(3000);
        Assert.assertTrue("Signup/Login Button is not visible",signLoginButton.isDisplayed());
        driver.close();
    }



}
