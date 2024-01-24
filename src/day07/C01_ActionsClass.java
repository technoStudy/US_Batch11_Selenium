package day07;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C01_ActionsClass extends TestBase {

    /*
    TC ID: TC_DEMOQA_003
    TC Title: Verify Right Click Action on 'Right Click Me'
    Button in DemoQA Website

    TC Description: This test case verifies that the user can
    perform a right-click action on the 'Right Click Me' button
    located within the 'Buttons' section under 'Elements'
    on demoqa.com using the Actions class provided by Selenium WebDriver.

    Test Steps:
    1-Launch the Chrome browser and navigate to https://demoqa.com
    On the home page, locate the 'Elements' section and click on it.
    2-Once the 'Elements' section is loaded, locate the 'Buttons' option and click on it.
    3-In the 'Buttons' section, use the Actions class to move to the ‘Right Click Me'
    button and perform a click action.
    4-Confirm that the right-click action is successful by verifying the expected outcome,
    such as a context menu appearance or a message display.

    Expected Result: The 'Right Click Me' button should correctly respond to
    the right-click action, demonstrating that the button is interactive and the action is
    recognized by the web application.

     */

    /*
    From this class we will create a new class in the utilities package
    with name TestBase.
    We will create some methods in the TestBase class
    -Setup
    -Teardown or Cleanup
    -Common (method for testing) utilities
    We will inherit the TestBase class with Test classes
    */

    @Before
    public void setUp() {
        //  1-Launch the Chrome browser and navigate to https://demoqa.com
        driver.get("https://demoqa.com");
    }

    @Test
    public void rightClickMe() {
        // 2-Once the 'Elements' section is loaded, locate the 'Buttons' option and click on it.
        WebElement elementsButtonHomePage =
                driver.findElement(By.xpath("(//div[@class='avatar mx-auto white'])[1]"));
        elementsButtonHomePage.click();
        // 3-In the 'Buttons' section, use the Actions class to move to the ‘Right Click Me'
        //    button and perform a click action.
        ReusableMethods.myWait(2);
        WebElement buttonsElement = driver.findElement(By.xpath("(//li[@id='item-4'])[1]"));
        buttonsElement.click();
        WebElement rightClickButton = driver.findElement(By.xpath("//button[@id='rightClickBtn']"));
        ReusableMethods.myWait(2);
        Actions actions = new Actions(driver);
        actions.contextClick(rightClickButton).perform();
        // 4-Confirm that the message
        WebElement rihtClickMessage = driver.findElement(By.xpath("//p[@id='rightClickMessage']"));
        Assert.assertTrue(rihtClickMessage.isDisplayed());
    }

    @After
    public void tearDown() {
        quiteDriver();
    }


}
