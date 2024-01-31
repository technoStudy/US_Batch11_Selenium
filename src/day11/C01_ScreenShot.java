package day11;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.ReusableMethods;
import utilities.TestBase;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class C01_ScreenShot extends TestBase {
    JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;


    @Test
    public void sreenShotMethod() throws IOException {
        driver.get("https://www.ebay.com");

        // Create ScreenShot object casting
        TakesScreenshot screenshot = (TakesScreenshot) driver;

        // we need to implement date time
        LocalDateTime timeOfBug = LocalDateTime.now();
        System.out.println("Current Time :"+timeOfBug);
        // let define the time format
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("MMddyyyyhhmmss");
                                                            // month/day/year/hour/minutes/seconds
        String date = timeOfBug.format(timeFormat);
        System.out.println("After the time format :"+date);
        // What is related to take screenshot and time?
        // When we run the test we can find many bugs then we need to order them
        // we can order automatically via date time
        // we will assign date time for the name of screenshots

        // we should create a file to keep screenshots
        // path of file == > src/screenshots/image_
        String filePath = "src/screenshots/image_"+date+".jpeg";

        File fullPage = new File(filePath);
        // creating temporary file to save as Screen shot
        File tempFile =  screenshot.getScreenshotAs(OutputType.FILE);

        // implement original file
        FileUtils.copyFile(tempFile,fullPage);
    }

    @Test
    public void footerTest(){
        driver.get("https://www.selenium.dev/");
        WebElement seleniumHeaderText =
                driver.findElement(By.xpath("(//*[name()='svg'][@id='Layer_1'])[1]"));
        assertTrue(seleniumHeaderText.isDisplayed());
        WebElement githubIcon =
                driver.findElement(By.xpath("//i[@class='fab fa-github']"));
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", githubIcon);
        ReusableMethods.myWait(2);
        githubIcon.click();
        ArrayList<String> windowHandleValues = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandleValues.get(1));
        String githubActualTitle = driver.getTitle();
        String githubExpectedTitle =
                "GitHub - SeleniumHQ/selenium: A browser automation framework and ecosystem.";
        assertEquals(githubExpectedTitle, githubActualTitle);
        driver.switchTo().window(windowHandleValues.get(0));// jump to selenium
        WebElement youtubeIcon =
                driver.findElement(By.xpath("//i[@class='fab fa-youtube']"));
        ReusableMethods.myWait(2);
        youtubeIcon.click();
        driver.switchTo().window(windowHandleValues.get(0));// jump to selenium
        WebElement emailIcon =
                driver.findElement(By.xpath("//i[@class='fas fa-mail-bulk']"));
        assertTrue(emailIcon.isDisplayed());
        WebElement facebookIcon =
                driver.findElement(By.xpath("(//i[@class='fab fa-facebook'])[1]"));
        assertTrue(facebookIcon.isDisplayed());
        WebElement slackIcon =
                driver.findElement(By.xpath("(//i[@class='fab fa-slack'])[1]"));
        assertTrue(slackIcon.isDisplayed());

    }

}
