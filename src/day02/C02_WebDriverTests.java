package day02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class C02_WebDriverTests {

    public static void main(String[] args) {
        // driver.get("") method Takes the driver to the desired URL.
        // 1st step Navigate to Ebay
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://www.facebook.com");

        // navigate to with edge, internet explorer, firefox
        WebDriver edgeDriver = new EdgeDriver() ;
        edgeDriver.get("https://www.ebay.com");

        WebDriver internetExplorerDriver = new InternetExplorerDriver();
        internetExplorerDriver.get("https://www.ebay.com");

        // Returns the URL information of the visited web page.
        System.out.println(chromeDriver.getCurrentUrl());
        //Returns the title information of the visited web page.
        System.out.println(chromeDriver.getTitle());
        //Closes the opened driver.
       // chromeDriver.close();
        //If multiple windows have been opened during the test, it closes all of them.
        chromeDriver.quit();

    }


}
