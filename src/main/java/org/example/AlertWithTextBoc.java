package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AlertWithTextBoc {
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
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[3]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"Textbox\"]/button")).click();
        driver.switchTo().alert().sendKeys(" Manas");
        driver.switchTo().alert().accept();
        String expectedText="Hello Manas How are you today";
        String actualText=driver.findElement(By.xpath("//div[@id='Textbox']/p")).getText();
        if(expectedText.equals(actualText)==true){
            System.out.println("text case is passed");
        }
        else{
            System.out.println("text case is fail");
        }


    }
}