package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Set;

public class CookiesHandle {
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
        driver.get("https://automationexercise.com/login");
        Set<Cookie>cookiesList=driver.manage().getCookies();
        System.out.println(cookiesList.size());
//        for(Cookie getCookies:cookiesList){
//            System.out.println(getCookies.getName()+":"+getCookies.getValue());
//        }
//        System.out.println(driver.manage().getCookieNamed("__gpi"));//print cookie by name
        //add cookies
        Cookie c=new Cookie("mycookie","12334");

        driver.manage().addCookie(c);
//        cookiesList=driver.manage().getCookies();
//        System.out.println(cookiesList.size());
//
//        for(Cookie getCookies:cookiesList){
//            System.out.println(getCookies.getName()+":"+getCookies.getValue());
//        }
        Cookie d=new Cookie("csrftoken","C0tL1vkBPUKv2zoMShBzTlhAU7QMaitUtUAFONjO4dV3W9doW819DgNu9F0CZRiR");
        driver.manage().deleteCookie(d);
cookiesList=driver.manage().getCookies();
        for(Cookie getCookies:cookiesList){
            System.out.println(getCookies.getName()+":"+getCookies.getValue());
        }
    }
}
