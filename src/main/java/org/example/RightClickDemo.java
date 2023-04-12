package org.example;

import com.beust.ah.A;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickDemo {
    public static WebDriver driver;
    static String browser = "chrome";

    public static void main(String[] args) {
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
        driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
        Actions action=new Actions(driver);
        WebElement source=driver.findElement(By.xpath("/html/body/div/section/div/div/div/p/span"));
        action.contextClick(source).build().perform();
        driver.findElement(By.xpath("/html/body/ul/li[3]")).click();
       driver.switchTo().alert().accept();
    }
}
