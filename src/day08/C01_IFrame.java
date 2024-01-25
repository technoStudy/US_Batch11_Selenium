package day08;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C01_IFrame extends TestBase {

/*
1-Navigate to the URL https://the –internet.hrekuapp.com/iframe
2-Create a method iframeTest
3-‘An Iframe containing…’ test that the text is accessible and print it
4-Write ‘Test Automation Engineer’ to the text box
5-Verify that the text of the ‘Elemental Selenium’ link at the bottom of the text box is visible.
 */

    @Before
    public void setUp() {
        // 1-Navigate to the URL https://the –internet.hrekuapp.com/iframe
        driver.get("https://the-internet.herokuapp.com/iframe");
    }
    @After
    public void tearDown(){
        quiteDriver();
    }

    @Test
    public void iframeTest() {


        // 3-‘An Iframe containing…’ test that the text is accessible and print it
        WebElement headerText = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(headerText.isEnabled());// for accessible isEnabled is better option
        System.out.println(headerText.getText());
        ReusableMethods.myWait(2);
        // 4-Write ‘Test Automation Engineer’ to the text box
        WebElement iFrameElement = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iFrameElement);// we implemented iFrame locator into driver iframe method
        ReusableMethods.myWait(2);
        WebElement textBox = driver.findElement(By.xpath("//body[@id='tinymce']"));

        textBox.clear();
        ReusableMethods.myWait(2);
        textBox.sendKeys("Test Automation Engineer");
        ReusableMethods.myWait(1);
        // 5-Verify that the text of the ‘Elemental Selenium’ link at the bottom of the text box is visible.
        WebElement elementalText = driver.findElement(By.xpath("//div[@id='page-footer']/div/div/a"));
        Assert.assertTrue(elementalText.isDisplayed());
    }


}
