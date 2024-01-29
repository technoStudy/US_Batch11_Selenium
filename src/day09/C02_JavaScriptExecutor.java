package day09;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_JavaScriptExecutor extends TestBase {
    // Explain this approach why you created
    // what does it mean  JavascriptExecutor jsExecutor = (JavascriptExecutor) driver; ??
    // Why do we need to use it? to handle complex locators
    // Creating the JavaScriptExecutor interface object by type casting
    // we said to driver, act like a JavaScriptExecutor interface
    JavascriptExecutor jsExecutor = (JavascriptExecutor) driver; // casting
    // We have many options but we will not use all of them because they are Java Script language
    @Test
    public void navigateUrlJsExecutor() {
        // Navigate to URL
        jsExecutor.executeScript("window.location = 'https://the-internet.herokuapp.com'");
    }

    @Test
    public void getCurrentPageUrlJsExecutor(){
        jsExecutor.executeScript("window.location = 'https://the-internet.herokuapp.com'");

        // Get Current Page Url
        String currentUrl = (String) jsExecutor.executeScript("return document.URL");
        System.out.println("Current Url :"+currentUrl);
    }
    @Test
    public void getDomainCurrentPageJsExecutor(){
        jsExecutor.executeScript("window.location = 'https://the-internet.herokuapp.com'");
        // Get Domain of Current Page
        String domain = (String) jsExecutor.executeScript("return document.domain");
        System.out.println(domain);
    }



}
