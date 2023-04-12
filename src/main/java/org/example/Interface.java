package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Set;

public class Interface {
    public static  String browser="chrome";
    public static WebDriver driver;
    public static void main(String[] args) {
        if(browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
        }
        else if(browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }
        driver.get("https://www.facebook.com/");
        driver.findElement(By.id("email")).sendKeys("6382377445");
        driver.findElement(By.id("pass")).sendKeys("Behera@2002");
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div[1]/form/div[2]/button")).click();
//        driver.findElement(By.id("email")).sendKeys("6382377445");
//        driver.findElement(By.id("pass")).sendKeys("Behera@2002");
//        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div[1]/form/div[2]/button")).click();
//        driver.navigate().to("http://automationexercise.com");

       driver.navigate().to("https://omayo.blogspot.com/2013/05/page-one.html");
       driver.findElement(By.xpath("//a[@id='link1']")).click();
       String windowHandel=driver.getWindowHandle();
        System.out.println(windowHandel);

        Set<String>windowHandels=driver.getWindowHandles();
        System.out.println(windowHandels);
    }
}
