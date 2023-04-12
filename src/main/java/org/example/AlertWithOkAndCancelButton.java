package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class AlertWithOkAndCancelButton {
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
        driver.get("https://demo.automationtesting.in/Alerts.html");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"CancelTab\"]/button")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String expectedOk="You pressed Ok";
        String expectedCancel="You Pressed Cancel";
        driver.switchTo().alert().accept();
        String actualOk=driver.findElement(By.xpath("//p[contains(text(),'You pressed Ok')]")).getText();
        if(expectedOk.equals(actualOk)==true){
            System.out.println("test case is passed");
        }
        else{
            System.out.println("text case is fail");
        }
//        driver.switchTo().alert().dismiss();
//
//        String actualCancel=driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[2]/a")).getText();
//        if(expectedCancel.equals(actualCancel)){
//            System.out.println("test case is passed");
//        }
//        else{
//            System.out.println("text case is fail");
//        }


    }
}
