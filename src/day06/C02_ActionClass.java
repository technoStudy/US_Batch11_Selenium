package day06;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;

import java.time.Duration;

public class C02_ActionClass {
    /*
    TC ID: TC_DEMOQA_001
    TC Title: Click on 'Elements' then 'Buttons' and finally 'Click Me' button on demoqa.com
    TC Description: Verify that a user can navigate to the 'Buttons'
    section under 'Elements' on demoqa.com and successfully click the
    'Click Me' button using the Actions class.
    Test Steps:
    1-Launch the Chrome browser and navigate to https://demoqa.com
    2-On the home page, locate the 'Elements' section and click on it.
    3-Once the 'Elements' section is loaded, locate the 'Buttons' option and click on it.
    4-In the 'Buttons' section, use the Actions class to move to the 'Click Me' button and perform a click action.
    5-Verify that the button has been clicked successfully.
    Expected Result: The 'Click Me' button click is successfully recognized
    and the corresponding action or message is displayed on the website.

     */
    WebDriver driver;
    ReusableMethods reusableMethods = new ReusableMethods();

    @Before
    public void setUp() {
        // 1-Launch the Chrome browser and navigate to https://demoqa.com
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void clickMeButtonFunctionality() {
        // 2-On the home page, locate the 'Elements' section and click on it.
        WebElement elementsButtonHomePage =
                driver.findElement(By.xpath("(//div[@class='avatar mx-auto white'])[1]"));
        elementsButtonHomePage.click();
        reusableMethods.myWait(2);
        // 3-Once the 'Elements' section is loaded, locate the 'Buttons' option and click on it.
        WebElement buttonsElement = driver.findElement(By.xpath("(//li[@id='item-4'])[1]"));
        buttonsElement.click();
        reusableMethods.myWait(2);
        //4-In the 'Buttons' section, use the Actions class to move to the 'Click Me' button and perform a click action.
        WebElement clickMeButton = driver.findElement(By.xpath("(//button[@type='button'])[4]"));
        reusableMethods.myWait(2);

        Actions actions = new Actions(driver);
        actions.click(clickMeButton).build().perform();
        // 5-Verify that the button has been clicked successfully.
        WebElement dynamicClickMessage = driver.findElement(By.xpath("//p[@id='dynamicClickMessage']"));
        Assert.assertTrue(dynamicClickMessage.isDisplayed());
    }

    /*
    TC ID: TC_DEMOQA_002
    TC Title: Verify Double Click Action on Button in DemoQA Website
    TC Description: This test case aims to validate that a user
    can navigate to the 'Buttons' section under 'Elements' on demoqa.com
    and successfully perform a double-click action on the 'Double Click Me'
    button using the Actions class.
    Test Steps:
    1-Launch the Chrome browser and navigate to https://demoqa.com
    2-On the home page, locate the 'Elements' section and click on it.
    3-Once the 'Elements' section is loaded, locate the 'Buttons' option and click on it.
    4-In the 'Buttons' section, use the Actions class to move to the
    ‘Double Click Me' button and perform a click action.
    5-Confirm that the double-click action triggers the expected response on the page.
    Expected Result: The 'Double Click Me' button responds to the
    double-click action as intended, typically by displaying a success
    message or changing its state to indicate that it has been double-clicked.

     */

    @Test
    public void doubleClickFunctionality() {
        // 2-On the home page, locate the 'Elements' section and click on it.
        WebElement elementsButtonHomePage =
                driver.findElement(By.xpath("(//div[@class='avatar mx-auto white'])[1]"));
        elementsButtonHomePage.click();
        // 3-Once the 'Elements' section is loaded, locate the 'Buttons' option and click on it.
        WebElement buttonsElement = driver.findElement(By.xpath("(//li[@id='item-4'])[1]"));
        buttonsElement.click();
        reusableMethods.myWait(2);

        // 4-In the 'Buttons' section, use the Actions class to move to the
        // ‘Double Click Me' button and perform a click action.

        WebElement doubleClickButton =
                driver.findElement(By.xpath("(//button[@type='button'])[2]"));
        reusableMethods.myWait(2);

        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickButton).build().perform();
        reusableMethods.myWait(2);
        // 5-Confirm that the double-click action triggers the expected response on the page.
        WebElement doubleClickMessage = driver.findElement(By.xpath("//p[@id='doubleClickMessage']"));
        Assert.assertTrue(doubleClickMessage.isDisplayed());

    }

}
