package day07;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C03_Alerts extends TestBase {

    /*





     */

    @Before
    public void setUp(){
        // Navigate to the URL: https://the-internet.herokuapp.com/javascript_alerts
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    public void clickForJSAlert(){
        //Click on the Click for JS Alert
        WebElement clickforJSAlertButton =
                driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        ReusableMethods.myWait(2);
        clickforJSAlertButton.click();
        ReusableMethods.myWait(2);
        // Click the "OK" button to close the alert.
        driver.switchTo().alert().accept();

        // Verify that the text inside the alert says "I am a JS Alert.
        WebElement message = driver.findElement(By.xpath("//p[@id='result']"));
        String actualMessage = message.getText();
        String expectedMessage = "You successfully clicked an alert";//This expected message from BA
        Assert.assertEquals(expectedMessage,actualMessage);// first one should be expected, second one actual

    }

    /*
    Navigate to the URL: https://the-internet.herokuapp.com/javascript_alerts
    Click on the Click for JS Confirm
    Press the “Cancel” button on the alert
    Verify that the text inside the alert says " You clicked: Cancel

     */

    /*
    Navigate to the URL: https://the-internet.herokuapp.com/javascript_alerts
    Click on the Click for JS Prompt alert
    Write ‘Selenium’ on JS Alert
    Click ok on the alert
    Verify that the text inside the alert says “You entered: Selenium”

     */

}
