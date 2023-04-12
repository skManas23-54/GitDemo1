package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.qatools.ashot.Screenshot;

public class CompareImage {
    public static WebDriver driver;
    static String browser = "chrome";

    public static void main(String[] args) throws InterruptedException {
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
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement logo = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[2]/img"));
//        Screenshot logoScreenshot=new Ashok().
        logo.sendKeys("C:\\Users\\kabishu\\Downloads\\Aim.pdf");
    }
}
