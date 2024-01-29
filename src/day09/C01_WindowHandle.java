package day09;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C01_WindowHandle extends TestBase {
 /*
    Navigate to the Facebook website.
    Store the page's window handle value in a String variable.
    Test that the page title contains "Facebook."
    Open a new tab and navigate to the eBay website.
    Test that the page title contains "Ebay."


    Return to the initially opened page and test that you have returned to the Facebook page.
     */

    @Before
    public void setUp(){
        // Navigate to the Facebook website.
        driver.get("https://www.facebook.com/");
        // if facebook have a cookies on your device use the following method
        // We will not click on the cookies accept button, we will handle with a new method
        driver.manage().deleteAllCookies();

    }
     @Test
    public void windowHandleTest(){
         // Store (assign a variable) the page's window handle value in a String variable.
         String facebookWindowHandle = driver.getWindowHandle();// driver.getWindowHandle() returns string


         // Test that the page title contains "Facebook."
         String expectedTitle = "Facebook - log in or sign up" ;
         String actualTitle = driver.getTitle();
         Assert.assertEquals(expectedTitle,actualTitle);
         ReusableMethods.myWait(1);
         // Open a new tab and navigate to the eBay website.
         driver.switchTo().newWindow(WindowType.TAB);
         driver.get("https://www.ebay.com");
         ReusableMethods.myWait(1);
         // Test that the page title contains "Ebay."
         String expectedTitleEbay = "Electronics, Cars, Fashion, Collectibles & More | eBay" ;
         String actualTitleEbay= driver.getTitle();
         Assert.assertEquals(expectedTitleEbay,actualTitleEbay);
         // Return to the initially opened page and test that you have returned to the Facebook page.
         ReusableMethods.myWait(1);
         driver.switchTo().window(facebookWindowHandle) ;

     }


}
