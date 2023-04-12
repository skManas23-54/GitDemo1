package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class AutoSuggestionDropDown {
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
        driver.get("https://www.makemytrip.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//span[contains(text(),'From')]")).click();
        WebElement form=driver.findElement(By.xpath("//input[@placeholder='From']"));
        form.sendKeys("mumbai");
        Thread.sleep(2000);
        form.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        form.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

    }
}
