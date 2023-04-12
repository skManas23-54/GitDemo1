package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Drag_Droped {
    static String browser = "chrome";
    public static WebDriver driver;

    public static void main(String[] args) {
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
        driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[1]/ul/li[2]/a")).click();
       WebElement frame= driver.findElement(By.xpath("//*[@id=\"content\"]/iframe"));
       driver.switchTo().frame(frame);
        WebElement drag=driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
        WebElement drop=driver.findElement(By.xpath("//*[@id=\"droppable\"]"));
        Actions action=new Actions(driver);
        action.dragAndDrop(drag,drop).perform();


    }
}

