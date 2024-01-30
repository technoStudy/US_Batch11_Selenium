package day09;

import org.checkerframework.checker.index.qual.PolyUpperBound;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.awt.*;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
    public void getCurrentPageUrlJsExecutor() {
        jsExecutor.executeScript("window.location = 'https://the-internet.herokuapp.com'");

        // Get Current Page Url
        String currentUrl = (String) jsExecutor.executeScript("return document.URL");
        System.out.println("Current Url :" + currentUrl);
    }

    @Test
    public void getDomainCurrentPageJsExecutor() {
        jsExecutor.executeScript("window.location = 'https://the-internet.herokuapp.com'");
        // Get Domain of Current Page
        String domain = (String) jsExecutor.executeScript("return document.domain");
        System.out.println(domain);
    }

    // ********************* IMPORTANT *************************************************************
    @Test
    public void scrollToElementJsExecutor() {
        jsExecutor.executeScript("window.location = 'https://the-internet.herokuapp.com'");
        // Scroll to an Element
        WebElement editorButton = driver.findElement(By.xpath("//a[@href='/tinymce']"));
        ReusableMethods.myWait(2);
        // we implemented locators to say scroll to this element
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", editorButton);
    }

    //*************************************************************************************************
    @Test
    public void scrollWithCoordinatesPointJsExecutor() {
        jsExecutor.executeScript("window.location = 'https://the-internet.herokuapp.com'");
        // Scroll down with x,y coordinates
        ReusableMethods.myWait(2);
        jsExecutor.executeScript("window.scrollTo(0,500)");// scroll down to 500th pixel
    }

    @Test
    public void clickOnElementJsExecutor() {
        driver.get("https://the-internet.herokuapp.com");
        WebElement editorButton = driver.findElement(By.xpath("//a[@href='/tinymce']"));
        // for example this code is not running (working)==> editorButton.click();
        // then we can use javascriptexecutor to click on the WebElement
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", editorButton);
        ReusableMethods.myWait(2);
        // Click on an Element
        jsExecutor.executeScript("arguments[0].click();", editorButton);

    }

    @Test
    public void sendTextValueJsExecutor() {
        driver.get("https://demo.guru99.com/V4/");
        // please find how to send a text in a web element with JavaScriptExecutor
        // userId:mngr550587 , password = rUveqUn
        WebElement userIdTextBox = driver.findElement(By.xpath("//input[@type='text']"));

        jsExecutor.executeScript("arguments[0].value = 'mngr550587'",userIdTextBox);

        WebElement passWordTextBox = driver.findElement(By.xpath("//input[@type='password']"));

        jsExecutor.executeScript("arguments[0].value = 'rUveqUn'",passWordTextBox);
                                                           // Text from the user
    }

    @Test
    public void refreshThePageJsExecutor(){
        driver.get("https://demo.guru99.com/V4/");
        // Refresh the Current Page
        jsExecutor.executeScript("history.go(0)");

    }
    @Test
    public void highlightedElementJsExecutor(){
        driver.get("https://demo.guru99.com/V4/");
        WebElement userIdTextBox = driver.findElement(By.xpath("//input[@type='text']"));
        jsExecutor.executeScript("arguments[0].style.border = '3px solid red'",userIdTextBox);
        WebElement passWordTextBox = driver.findElement(By.xpath("//input[@type='password']"));
        jsExecutor.executeScript("arguments[0].style.border = '3px solid red'",passWordTextBox);
        WebElement guru99HeaderText = driver.findElement(By.xpath("//h2[@class='barone']"));
        jsExecutor.executeScript("arguments[0].style.border = '5px solid green'",guru99HeaderText);
    }




    }


