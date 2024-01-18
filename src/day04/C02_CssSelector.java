package day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_CssSelector {

    public static void main(String[] args) throws InterruptedException {
        /*
        Add/Remove Elements
        Navigate to https://the-internet.herokuapp.com/add_remove_elements/
        Click on the Add Element button.
        Test that the Delete button is Visible.
        Click on the Delete button.
        Test that the 'Add/Remove Elements' text is visible.
        Close the page.
        */

        // 1st Step WebDriver setup
        WebDriver driver = new ChromeDriver();
        //Navigate to https://the-internet.herokuapp.com/add_remove_elements/
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        // waiting to loading web page in 15 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        Thread.sleep(3000);
        // Click on the Add Element button.
        WebElement addElementButton = driver.findElement(By.cssSelector("button[onclick='addElement()']"));
        addElementButton.click();
        // Test that the Delete button is Visible.
        WebElement deleteButton = driver.findElement(By.cssSelector("button[onclick='deleteElement()']"));
        // isDisplayed() will return true or false; if the element is visible it returns true
        // if the element is not visible it returns false
       if (deleteButton.isDisplayed()==true) {
           System.out.println("Delete Button is Visible Test PASSED");
       }else {
           System.out.println("Delete Button is not Visible Test FAILED");
       }
        Thread.sleep(3000);
       //Click on the Delete button.
        deleteButton.click();

       //Test that the 'Add/Remove Elements' text is visible.
        if (addElementButton.isDisplayed()==true) {
            System.out.println("Add Element Button is Visible Test PASSED");
        }else {
            System.out.println("Add Element Button is not Visible Test FAILED");
        }
    }
}
