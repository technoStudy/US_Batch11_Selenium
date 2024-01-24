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

    /*
    TC ID: TC_DEMOQA_004
    TC Title: Verify Hover Over Functionality on 'Menu' Widget in DemoQA Website
    TC Description: This test case ensures that a user can navigate to the 'Menu'
    widget on demoqa.com, hover over 'Main Item 2', then 'SUB List', and finally
    verify if 'Sub Item 1' is visible.
    Test Steps:
    1-Launch the Chrome browser and navigate to https://demoqa.com
    2-On the homepage, click on the 'Widgets' button.
    3-On the Widgets page, click on the 'Menu' button.
    4-Hover over the 'Main Item 2' to trigger the first popup.
    5-Move the mouse to hover over the 'SUB List' to trigger the second popup.
    6-Verify that 'Sub Item 1' becomes visible.
    Expected Result: When the mouse is hovered over 'Main Item 2', a popup
    should appear. As the mouse moves over 'SUB List', a new popup should appear,
    and 'Sub Item 1' should be visible, indicating the hover functionality is working as expected.

     */

    @Test
    public void hoverOverTest() {
        Actions actions = new Actions(driver);
        // 2-On the homepage, click on the 'Widgets' button.
        WebElement widgetButton =
                driver.findElement(By.xpath("(//div[@class='avatar mx-auto white'])[4]"));
        ReusableMethods.myWait(2);
        widgetButton.click();
        // 3-On the Widgets page, click on the 'Menu' button.
        WebElement menuButton =
                driver.findElement(By.xpath("(//span[@class='text'])[23]"));
        actions.moveToElement(menuButton).click(menuButton).build().perform();
        ReusableMethods.myWait(1);

        // 4-Hover over the 'Main Item 2' to trigger the first popup.
        WebElement mainItem2Button = driver.findElement(By.xpath("(//a[@href='#'])[2]"));
        ReusableMethods.myWait(2);

        actions.moveToElement(mainItem2Button).build().perform();
        //5-Move the mouse to hover over the 'SUB List' to trigger the second popup.
        ReusableMethods.myWait(2);
        WebElement subListItem = driver.findElement(By.xpath("(//a[@href='#'])[5]"));
        actions.moveToElement(subListItem).build().perform();

        // 6-Verify that 'Sub Item 1' becomes visible.
        ReusableMethods.myWait(2);
        WebElement subItem1 = driver.findElement(By.xpath("(//a[@href='#'])[6]"));
        actions.moveToElement(subItem1).build().perform();
        Assert.assertTrue(subItem1.isDisplayed());

    }




    @After
    public void tearDown() {
        quiteDriver();
    }


}
