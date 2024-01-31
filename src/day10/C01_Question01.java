package day10;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class C01_Question01 extends TestBase {

 /*
 TC ID: TC_SELENIUM_001
 TC Title: Validate Navigation and Footer Links on Selenium Homepage
 TC Description: This test case ensures that users can navigate
 from the Selenium homepage to the associated GitHub and YouTube
 pages via footer links, and verifies the visibility of Email,
 Facebook, and Slack icons in the footer.

Test Steps:
1-Navigate to https://www.selenium.dev/
2-Verify that the Selenium homepage is accessible and fully loaded.
3-Scroll to the footer and click on the "GitHub" link.
4-Verify that the GitHub page of Selenium is successfully accessed.
5-Return to the Selenium homepage.
6-Scroll to the footer and click on the "YouTube" link.
7-Return to the Selenium homepage.
8-Verify that the "Email" icon in the footer is visible.
9-Verify that the "Facebook" icon in the footer is visible.
10-Verify that the "Slack" icon in the footer is visible.

Expected Result:
The Selenium homepage loads successfully.
The browser navigates to the Selenium GitHub page, and the page loads successfully.
The browser navigates to the Selenium YouTube page, and the page loads successfully.
The "Email", "Facebook", and "Slack" icons in the footer are visible and identifiable.


  */
    JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
    @Before
    public void setUp(){
        // 1-Navigate to https://www.selenium.dev/
        driver.get("https://www.selenium.dev/");

    }

    @Test
    public void footerTest(){
        // 2-Verify that the Selenium homepage is accessible and fully loaded.
        WebElement seleniumHeaderText =
                driver.findElement(By.xpath("(//*[name()='svg'][@id='Layer_1'])[1]"));
        assertTrue(seleniumHeaderText.isDisplayed());

        // 3-Scroll to the footer and click on the "GitHub" link
        WebElement githubIcon =
                driver.findElement(By.xpath("//i[@class='fab fa-github']"));
        // scroll down with JavasScriptExecutor
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", githubIcon);
        ReusableMethods.myWait(2);
        githubIcon.click();

        // WebDriver driver stay Selenium home page, if we want to switch another page
        // we should use window handle value
        // in this case there are two window handle value
        //  we will put them in an arraylist
        ArrayList<String> windowHandleValues = new ArrayList<>(driver.getWindowHandles());
        // [windowhandleSelenium,windowhandleGithub] ==> index 0 is Selenium, index 1 is GitHub
        // 4-Verify that the GitHub page of Selenium is successfully accessed.
        driver.switchTo().window(windowHandleValues.get(1));// jump to github
        String githubActualTitle = driver.getTitle();
        String githubExpectedTitle =
                "GitHub - SeleniumHQ/selenium: A browser automation framework and ecosystem.";
        assertEquals(githubExpectedTitle, githubActualTitle);

        //5-Return to the Selenium homepage.
        driver.switchTo().window(windowHandleValues.get(0));// jump to selenium

        // 6-Scroll to the footer and click on the "YouTube" link.
        WebElement youtubeIcon =
                driver.findElement(By.xpath("//i[@class='fab fa-youtube']"));
        ReusableMethods.myWait(2);
        youtubeIcon.click();
      //  7-Return to the Selenium homepage.
        driver.switchTo().window(windowHandleValues.get(0));// jump to selenium
      //  8-Verify that the "Email" icon in the footer is visible.
        WebElement emailIcon =
                driver.findElement(By.xpath("//i[@class='fas fa-mail-bulk']"));
        assertTrue(emailIcon.isDisplayed());
      //  9-Verify that the "Facebook" icon in the footer is visible.
        WebElement facebookIcon =
                driver.findElement(By.xpath("(//i[@class='fab fa-facebook'])[1]"));
        assertTrue(facebookIcon.isDisplayed());
      //  10-Verify that the "Slack" icon in the footer is visible.
        WebElement slackIcon =
                driver.findElement(By.xpath("(//i[@class='fab fa-slack'])[1]"));
        assertTrue(slackIcon.isDisplayed());
        //  Assert class is called as a Hard assertion
        //  when we get a fail hard assertion stop the code

    }








}
