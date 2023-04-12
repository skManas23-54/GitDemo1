package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test_Case5 {
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
        boolean isNewUserSignUpDisplayed=driver.findElement(By.xpath("//div[@class='signup-form']//child::h2")).isDisplayed();
        System.out.println(isNewUserSignUpDisplayed);
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("sjj");
        driver.findElement(By.xpath("//section[@id=\"form\"]/div/div/div[3]/div/form/input[3]\n")).sendKeys("Manas@gmail.com");
        driver.findElement(By.xpath("//button[contains(text(),'Signup')]")).click();
        //p[contains(text(),'Email Address already exist!')]
        boolean isShowEmailIdAlreadyExist=driver.findElement(By.xpath("//div[@class='signup-form']//child::h2")).isDisplayed();
        System.out.println(isShowEmailIdAlreadyExist);

    }
}
