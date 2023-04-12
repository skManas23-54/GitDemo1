package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.client5.http.utils.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EncodeString_Demo {
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
        driver.get("https://demo.nopcommerce.com/login");
        driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys("trew@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys("qewrty");
//        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button")).click();
    }
    static String decodeString(String password){
        byte[]decodedString= Base64.decodeBase64(password);
        return(new String (decodedString));
    }
}
