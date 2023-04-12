package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

//import static com.sun.imageio.plugins.jpeg.JPEG.JPG;

public class Test_Case6 {
    public static String browser = "chrome";
    public static WebDriver driver;
    public static void main(String[] args)throws AWTException,InterruptedException {
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
        driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/child::li[8]\n")).click();
        boolean isGetInTouch = driver.findElement(By.xpath("//h2[contains(text(),'Get In Touch')]")).isDisplayed();
        System.out.println(isGetInTouch);
        driver.findElement(By.cssSelector("input[placeholder='Name']\n")).sendKeys("Rajesh");
        driver.findElement(By.cssSelector("input[type='email']\n")).sendKeys("Rajesh@gmail.com");
        driver.findElement(By.xpath("//input[@name='subject']\n")).sendKeys("Software Testing");
        driver.findElement(By.xpath("//textarea[@name='message']\n")).sendKeys("Test All case");
        WebElement button=driver.findElement(By.xpath("//input[@type='file']"));
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",button);
        Robot rb=new Robot();
        rb.delay(2000);
//        int jpg = JPG;
        StringSelection ss=new StringSelection("\"C:\\Users\\kabishu\\OneDrive\\Pictures\\Screenshots\\Screenshot_20230129_113235.png\"");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        driver.findElement(By.xpath("//input[@name='submit']")).click();
//        Thread.sleep(3000);
//        driver.findElement(By.xpath("https://automationexercise.com/contact_us"));
        driver.switchTo().alert().accept();
        boolean success=driver.findElement(By.xpath("//div[@id='form-section']/parent::div/child::div[2]")).isDisplayed();
        if(success){
            System.out.println("test is passed");
        }
        else{
            System.out.println("test is failed");
        }
        driver.findElement(By.xpath("//a[@class='btn btn-success']")).click();
        String title=driver.getTitle();
        System.out.println(title);

    }
}
