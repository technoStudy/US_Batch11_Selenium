package day02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05_FirstTest {

    public static void main(String[] args) {
        /*
        User Story: Verify the Title of the Amazon Website.
        As a Quality Assurance Engineer, I want to automate
        a test that verifies the title of the Amazon website,
        So that I can ensure the website's title correctly
        contains the word "Amazon".
         */

        // 1st step: WebDriver
        WebDriver driver = new ChromeDriver();
        // Navigate to url ==> https://www.amazon.com
        driver.get("https://www.amazon.com");

        // Create expected result
        String expectedResultTitle = "Amazon";

        // Actual result is coming from the url
        String actualResultTitle = driver.getTitle();
        System.out.println(actualResultTitle);
        if (actualResultTitle.contains(expectedResultTitle)){
            System.out.println("Url Title Test PASSED");
        }else {
            System.out.println("Url Title Test FAILED");
        }

        driver.close();
    }
}
