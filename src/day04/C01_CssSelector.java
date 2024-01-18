package day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_CssSelector {

    public static void main(String[] args) throws InterruptedException {
        /*
        Automation Exercise Category Test
        1- Create a test class and set the relevant settings
        2- Go to https://www.automationexercise.com/
        3- Locate the elements in the category section
        4- Test that there are 3 elements in the Category section
        5- Print the category names
        6- Close the page
        */

        // 1st Step WebDriver setup
        WebDriver driver = new ChromeDriver();
        // Navigate to https://www.automationexercise.com/
        driver.get("https://www.automationexercise.com/");
        // waiting to loading web page in 15 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        Thread.sleep(5000);
        // Locate the elements in the category section
        // we are using findeElements because there are class group it means there are more than one locators
        List<WebElement> categoryElements = driver.findElements(By.className("panel-title"));

        // Test that there are 3 elements in the Category section
        if (categoryElements.size()==3){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }
        Thread.sleep(5000);
       // Print the category names
        for (int i=0 ; i<categoryElements.size(); i++){
            System.out.println(categoryElements.get(i).getText());
        }
       // Close the page
        driver.close();
    }



}
