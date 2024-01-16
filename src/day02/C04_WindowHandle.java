package day02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_WindowHandle {
    static WebDriver driver;

    public static void main(String[] args) {
        /*
        Retrieve the title and current URL of the website https://the-internet.herokuapp.com/
        using its WebDriver objects.
        Find the window handle value of the website https://the-internet.herokuapp.com/.
        Find the source codes of the website https://the-internet.herokuapp.com/.
        Find other driver.get..() objects and research their properties.
       */
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com");
        System.out.println(driver.getWindowHandle());
        System.out.println(driver.getPageSource());
        System.out.println(driver.getTitle());

        //Expected Result ==>> the expectation of the user
        //Actual Result   ==> the result that application has now
    }
}
