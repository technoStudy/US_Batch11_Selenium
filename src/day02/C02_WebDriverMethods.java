package day02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_WebDriverMethods {

    static WebDriver driver ;

    public static void main(String[] args) {

        driver = new ChromeDriver();
        driver.get("https://www.ebay.com");

       //driver = new EdgeDriver() ;
       //driver.get("https://www.ebay.com");

       //driver = new InternetExplorerDriver();
       //driver.get("https://www.ebay.com");

       // driver.close();

       // driver.quit();
       // System.out.println(driver.getPageSource());
        // Returns the window handle value, a unique
        // identifier assigned by the operating system to the opened window.
        System.out.println(driver.getWindowHandle());
    }
}
