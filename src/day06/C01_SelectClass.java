package day06;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import java.time.Duration;

public class C01_SelectClass {
  /*
  Select Class is a utility provided to make it easier to select
  options from a dropdownlist
   */
    /*
    TC ID: TC_FACEBOOK_SIGNUP_001
    TC Title: Verify Facebook Sign-Up Functionality Including Email
    Verification and Gender Selection
    TC Description: This test case aims to ensure that the user can
    navigate to the Facebook homepage, initiate the sign-up process,
    enter personal information, and verify the 'enter your email again'
    input field, along with the ability to select and verify gender.
    Test Steps:
    1-Navigate to the Facebook homepage at https://www.facebook.com/
    2-Click the ‘Accept Cookies' button if you have one.
    3-Click the 'Create New Account' button.
    4-Fill in the first name and last name fields with the given names.
    5-Enter a valid email address in the designated email input field.
    6-Create and enter a password in the password field
    7-Select the date of birth from the given dropdown options.
    8-Select the gender by clicking the appropriate radio button.
    9-Verify that the selected gender radio button is checked.
    Expected Result:
    The homepage should load successfully.
    Upon clicking the 'Products' button, the user should be redirected
    to the ALL PRODUCTS page.
    The ALL PRODUCTS page should display a list of products.
    When clicking 'View Product' for a product, the user should be
    taken to that product's detail page.
    The product detail page should accurately display all relevant
    product information, including product name, category, price, availability, condition, and brand.
     */

   static WebDriver driver;
   ReusableMethods reusableMethods = new ReusableMethods();
    @BeforeClass
    public static void setUpClass(){
        // 1-Navigate to the Facebook homepage at https://www.facebook.com/
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void loginFunctionalityTest(){
        // 2-Click the ‘Accept Cookies' button if you have one.
        WebElement cookiesButton = driver.findElement(By.xpath("(//button[@value='1'])[3]"));
        cookiesButton.click();

        // 3-Click the 'Create New Account' button.
        WebElement createNewButton = driver.findElement(By.xpath("(//a[@role='button'])[2]"));
        createNewButton.click();
        reusableMethods.myWait(2);
        // 4- Fill in the first name and last name fields with the given names.
        WebElement firstNameTextBox = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstNameTextBox.sendKeys("Mehmet");
        WebElement lastNameTextBox = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastNameTextBox.sendKeys("Sezgin");
        reusableMethods.myWait(2);
        // 5-Enter a valid email address in the designated email input field.
        WebElement mobilePhoneTextBox = driver.findElement(By.xpath("//input[@name='reg_email__']"));
        mobilePhoneTextBox.sendKeys("+38630335147");
        // 6-Create and enter a password in the password field
        WebElement passwordTextBox = driver.findElement(By.xpath("//input[@autocomplete='new-password']")) ;
        passwordTextBox.sendKeys("xxxxxx");
        reusableMethods.myWait(2);
        //7-Select the date of birth from the given dropdown options.
        // for month
        WebElement monthList = driver.findElement(By.xpath("//select[@id='month']"));
        Select select = new Select(monthList);
        select.selectByVisibleText("Apr");
        // for day

        //8-Select the gender by clicking the appropriate radio button.
        //9-Verify that the selected gender radio button is checked.


    }



}
