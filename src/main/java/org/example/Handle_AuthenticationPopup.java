package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Handle_AuthenticationPopup {
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
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        String text=driver.findElement(By.xpath("//div[@class='example']/p")).getText();
        System.out.println(text);
    }
}
