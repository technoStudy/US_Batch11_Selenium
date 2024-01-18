package day02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C06_NavigateQuestion {

    public static void main(String[] args) {
        /*
        Let's create a new Class named C07_NavigateQuestion.
        - Go to the YouTube homepage. https://www.youtube.com/
        - Go to the Amazon page. https://www.amazon.com/
        - Return to the YouTube page.
        - Go back to the Amazon page again.
        - Refresh the page.
        - Close all pages.
         */

        WebDriver driver = new ChromeDriver();
        // - Go to the YouTube homepage. https://www.youtube.com/
        driver.navigate().to("https://www.youtube.com");
        // Go to the Amazon page. https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com");

        // - Return to the YouTube page.
        driver.navigate().back();
        // - Go back to the Amazon page again.
        driver.navigate().forward();
        // Refresh the page.
        driver.navigate().refresh();
        // - Close all pages.
        driver.close();

       // do group work with max number of people and day


    }
}
