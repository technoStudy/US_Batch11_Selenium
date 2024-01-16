package day01;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_WebDriver {

    public static void main(String[] args) {

        // A WebDriver is an interface used to in web automation
        // We can create browsers object from the WebDriver
        WebDriver chromeDriver = new ChromeDriver() ;
        // The firs approach : Navigate to url
        chromeDriver.get("https://www.ebay.com");

    }





}
