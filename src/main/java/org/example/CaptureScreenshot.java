package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;

public class CaptureScreenshot {
    public static WebDriver driver;
    static String browser = "chrome";
    public static void main(String[] args) throws IOException {
        switch (browser) {
            case "chrome" -> {
                driver = new ChromeDriver();
                WebDriverManager.chromedriver().setup();
            }
            case "firefox" -> {
                driver = new FirefoxDriver();
                WebDriverManager.firefoxdriver().setup();
            }
        }
        driver.get("https://www.ebay.com/");
        takeScreenshot("ebay_login");
    }
    public static void takeScreenshot(String fileName) throws IOException {
        File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("D:/Selenium/Selenium_Demo/src/main/java/org/example"+fileName+".jpg"));
//        FileUtils.copyFile(file,new File(".//screenshot1/screen.jpg"));
    }
}
