package day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class C08_Locators {

    public static void main(String[] args)  {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        // locator with id gh-btn ==> all locators should be unique

        // we should assing the locators on WebElement class
        WebElement searchButton = driver.findElement(By.id("gh-btn"));
        // we created locator for the search button on the main page
        // now we can click on the button via this WebElement
        // we can test is this button visible or not
        // If the driver cannot find the object with findElement(), it throws a NoSuchElementException


        // Search Text box on the ebay main page
        WebElement searchTextBox = driver.findElement(By.name("_nkw"));
        // we can send test data (text) with locator
        searchTextBox.sendKeys("Galaxy AI");

        // click on the search button with click() method
        searchButton.click();


        }
}
