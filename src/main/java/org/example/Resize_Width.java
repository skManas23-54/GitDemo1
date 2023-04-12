package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Resize_Width {
    static String browser = "chrome";
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException{
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
        driver.get("https://jqueryui.com/");
        driver.findElement(By.xpath("//*[@id=\"global-nav\"]/nav/div/ul[1]/li[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[1]/ul/li[3]/a")).click();
        WebElement frame= driver.findElement(By.xpath("//*[@id=\"content\"]/iframe"));
        driver.switchTo().frame(frame);
        WebElement reSize=driver.findElement(By.xpath("//*[@id='resizable']/div[3]"));
        Actions action=new Actions(driver);
        Thread.sleep(4000);
        action.dragAndDropBy(reSize, 500,230).perform();
}
}
