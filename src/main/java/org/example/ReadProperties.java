package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    public static void main(String[] args) throws IOException,NullPointerException {
        WebDriver driver = null;
        Properties prop = new Properties();

            FileInputStream ip = new FileInputStream("D:/Selenium/Selenium_Demo/src/main/java/org/example/Config.properties");
            prop.load(ip);

            System.out.println(prop.getProperty("browser"));
            String browser=prop.getProperty("browser");
            if(browser.equals("chrome")){
               WebDriverManager.chromedriver().setup();
                driver= new ChromeDriver();
            }
            else if(browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver= new ChromeDriver();
        }
            else if(browser.equals("edge")){
                WebDriverManager.edgedriver().setup();
                driver= new ChromeDriver();
            }
            else{
                System.out.println("now browser");
        }
            driver.get(prop.getProperty("url"));
            driver.manage().deleteAllCookies();
            driver.findElement(By.xpath(prop.getProperty("automationDemo_xpath"))).isDisplayed();
            driver.findElement(By.xpath(prop.getProperty("mailAddress_xpath"))).sendKeys(prop.getProperty("userName"));
            driver.findElement(By.xpath(prop.getProperty("password_xpath"))).sendKeys(prop.getProperty("password"));
            driver.findElement(By.xpath(prop.getProperty("loginBtn_xpath"))).click();



    }
}
