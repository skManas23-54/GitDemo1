package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Keybord_Input {
    static String browser = "chrome";
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
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
        driver.get("https://extendsclass.com/mysql-online.html\n");
       WebElement keyboard= driver.findElement(By.xpath("//*[@id=\"container-SQL\"]/div[1]/div/div[6]/div[1]/div/div/div/div[5]/div[3]/pre/span"));
        Actions action=new Actions(driver);
       Thread.sleep(3000);
        action.keyDown(keyboard, Keys.CONTROL).sendKeys("a").sendKeys("c").build().perform();
        WebElement distination=driver.findElement(By.xpath("//*[@id=\"container-SQL\"]/div[1]/div/div[6]/div[1]/div/div/div/div[5]/div[5]\n"));
        Thread.sleep(3000);
        action.keyDown(keyboard, Keys.CONTROL).sendKeys("a").sendKeys("V").build().perform();
    }
}
