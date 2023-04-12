package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Alerts_pops {
    static String browser = "chrome";
    public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException{
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
        driver.get("https://demo.automationtesting.in/Alerts.html\n");
//        driver.findElement(By.xpath("//li[@class='active']/a")).click();
//        driver.findElement(By.xpath("//button[@class='btn btn-danger']\n")).click();
//        System.out.println(driver.switchTo().alert().getText());
//        driver.findElement(By.xpath("//a[contains(text(),'Alert with OK & Cancel ')]\n")).click();
//        driver.findElement(By.xpath("//*[@id=\"CancelTab\"]/button")).click();
//        String ExceptTestOk="You pressed Ok";
//        driver.switchTo().alert().accept();
//        String ActualTestOk=driver.findElement(By.xpath("//*[@id=\"demo\"]")).getText();
//        System.out.println(ActualTestOk);
//        if(ExceptTestOk.equals(ActualTestOk)==true){
//            System.out.println("Test is passed");
//        }
//        else{
//            System.out.println("test is failed");
//        }
//        String ExceptTestCancel="You Pressed Cancel";
//
//        driver.switchTo().alert().dismiss();
//        String ActualTestCancel=driver.findElement(By.xpath("//*[@id=\"demo\"]\n")).getText();
//        if(ExceptTestCancel.equals(ActualTestCancel)==true){
//            System.out.println("Test is passed");
//        }
//        else{
//            System.out.println("test is failed");
//        }
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[3]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"Textbox\"]/button")).click();
        driver.switchTo().alert().sendKeys("manas");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        String Act=driver.findElement(By.xpath("//p[contains(text(),'Hello manas How are you today')]\n")).getText();
        System.out.println(Act);
        String Exp="Hello manas How are you today";
        if(Exp.equals(Act)==true){
            System.out.println("Test is passed");
        }
        else{
            System.out.println("test is failed");
        }

    }
}
