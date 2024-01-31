package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class C02_RobotClass extends TestBase {


    /*
    Using the Robot class in automated testing, especially in a
    testing framework like Selenium, allows the testers to simulate
    native keyboard and mouse actions that are otherwise difficult
    or impossible tp perform with standard Selenium commands

    The Robot class is a part of Java AWT (Abstract Window Toolkit)
    to handle
    - pop-ups
    - alerts and pop-ups
    - form filling
    - Testing keyboard shortcuts
    - Uploading files
    - Downloading files
     */
    ReusableMethods reusableMethods = new ReusableMethods();
    @Test
    public void robotTest() throws AWTException {
        // navigate to the upload page of the guru99
        driver.get("http://demo.guru99.com/test/upload/");
        reusableMethods.myWait(1);

        //There is a iframe on the cookies page, we should handle it
        WebElement iframeCookies = driver.findElement(By.id("gdpr-consent-notice"));
        driver.switchTo().frame(iframeCookies);

        WebElement element =
                driver.findElement(By.xpath("(//div[@class='action-wrapper'])[3]"));
        element.click();
        reusableMethods.screenShot(driver);
        reusableMethods.myWait(1);
        // Locate the "Choose File" button
        WebElement chooseFile =
                driver.findElement(By.xpath("(//input[@id='uploadfile_0'])[1]"));
        Actions actions = new Actions(driver);
        actions.click(chooseFile).build().perform();

        // Create file path for the uploaded file
         String filePath = "\"C:\\Users\\msezgin\\OneDrive - ENDAVA\\Desktop\\QuickStart\\promptTest\\AlterDomus\\AlterDomusPrompt.docx\"";

        // Create a StringSelection object with the file path intended for upload
        StringSelection pathOfFile = new StringSelection(filePath);

        // Copy the file path to clipboard to use for pasting
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(pathOfFile,null);
        reusableMethods.myWait(1);

        // Initialize Robot Class to perform native keyboard and mouse actions
        Robot robot = new Robot();

        // Press the CTRL key to prepare for paste operation
        robot.keyPress(KeyEvent.VK_CONTROL);

        // Press the V key
        robot.keyPress(KeyEvent.VK_V);

        // Release the CTR key
        robot.keyRelease(KeyEvent.VK_CONTROL);

        // Release the V key
        robot.keyRelease(KeyEvent.VK_V);

        reusableMethods.myWait(1);

        // press and relase the enter t close file window and upload the file
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_ENTER);



    }


}
