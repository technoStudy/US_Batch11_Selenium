package day07;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C02_HoverOver extends TestBase {


    @Before
    public void setUp(){
        driver.get("https://demoqa.com/menu");
    }


    @Test
    public void hoverOverTest02(){
        Actions actions = new Actions(driver);
        // 4-Hover over the 'Main Item 2' to trigger the first popup.
        WebElement mainItem2Button = driver.findElement(By.xpath("(//a[@href='#'])[2]"));
        ReusableMethods.myWait(2);

        actions.moveToElement(mainItem2Button).build().perform();
        //5-Move the mouse to hover over the 'SUB List' to trigger the second popup.
        ReusableMethods.myWait(2);
    }


}
