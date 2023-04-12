package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.*;

public class TestCase_7 {
    public static String browser = "chrome";
    public static WebDriver driver;

    public static void main(String[] args) throws AWTException, InterruptedException {
        switch (browser) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
        }
        driver.get("http://automationexercise.com");
        driver.manage().window().maximize();
        boolean isSignButtonDisplayed = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']//li[4]")).isDisplayed();
        System.out.println(isSignButtonDisplayed);
        driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[5]/a")).click();

    }
}