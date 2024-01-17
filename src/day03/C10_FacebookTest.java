package day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C10_FacebookTest {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        //to handle all cookies button
        WebElement cookiesButton = driver.findElement(By.xpath("(//button[@value='1'])[3]"));
        cookiesButton.click();

        // Click on the create new account button
        WebElement createNewButton = driver.findElement(By.xpath("(//a[@role='button'])[2]"));
        createNewButton.click();
        // Find the locator of First Name text box and send a name

        // Find the locator of Last Name text box and send a surname

        // Find the locator of Mobile number or email text box  and send an email

        // Find the locator of New Password text box and send a password


    }
}
