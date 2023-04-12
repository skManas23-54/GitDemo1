package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test_Case3 {
    public static String browser = "chrome";
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
        driver.get("http://automationexercise.com");
        driver.manage().window().maximize();
        boolean isSignButtonDisplayed = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']//li[4]")).isDisplayed();
        System.out.println(isSignButtonDisplayed);
        driver.findElement(By.xpath("//ul[@class='nav navbar-nav']//li[4]")).click();
        boolean loginDisplayed = driver.findElement(By.xpath("//h2[contains(text(),'Login to your account')]")).isDisplayed();
        System.out.println(loginDisplayed);
        driver.findElement(By.xpath("//div[@class='login-form']/child::form/input[2]\n")).sendKeys("Manass@gmail.com");
        driver.findElement(By.xpath("//div[@class='login-form']/child::form/input[3]\n")).sendKeys("Beheraa@2002");
        driver.findElement(By.xpath("//div[@class='login-form']/child::form/button\n")).click();
        boolean isMailOrPasswordIncorrect = driver.findElement(By.xpath("        //p[contains(text(),'Your email or password is incorrect!')]\n")).isDisplayed();
        System.out.println(isMailOrPasswordIncorrect);
    }
}
