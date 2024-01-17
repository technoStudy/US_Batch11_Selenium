package day03;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C09_WebElementMethods {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        // the xpath of the search text box
        WebElement searchTextBox = driver.findElement(By.xpath("//input[@type='text']"));
        // send a key in the search text box
        searchTextBox.sendKeys("Dell i11");

        // The xpath of the search button
        WebElement searchButton = driver.findElement(By.xpath("//input[@type='submit']"));
        // click the search button
        searchButton.click();


    }
}
