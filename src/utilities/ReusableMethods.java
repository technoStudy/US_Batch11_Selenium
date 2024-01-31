package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReusableMethods {

    public static void myWait(int sec){
        try{
           Thread.sleep(sec * 1000);
        }catch (InterruptedException e){
            throw new RuntimeException();
        }
    }

    public void screenShot(WebDriver driver)  {
        // Create ScreenShot object casting
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        // we need to implement date time
        LocalDateTime timeOfBug = LocalDateTime.now();
        // let define the time format
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("MMddyyyyhhmmss");
        // month/day/year/hour/minutes/seconds
        String date = timeOfBug.format(timeFormat);
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
       try {
           // implement original file
           FileUtils.copyFile(tempFile,fullPage);
       }catch (IOException e){
           System.out.println(e.getMessage());
       }
    }






}
