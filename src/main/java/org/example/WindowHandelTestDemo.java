package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Set;

public class WindowHandelTestDemo {
    public static WebDriver driver;
    static String browser="chrome";
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
        driver.get("https://demo.automationtesting.in/Windows.html");
        driver.findElement(By.xpath("//button[contains(text(),'    click   ')]")).click();
        Set<String> s=driver.getWindowHandles();
        for(String i:s){
            System.out.println(s);
            String t=driver.switchTo().window(i).getTitle();
            System.out.println(t);
        }
        driver.findElement(By.xpath("/html/body/div/main/section[2]/div/div/div[1]/div/div[2]/div/a")).click();

    }
}
