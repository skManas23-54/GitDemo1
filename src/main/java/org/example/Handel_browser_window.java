package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Set;


public class Handel_browser_window {
        static String browser = "chrome";
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
            driver.get("https://demo.automationtesting.in/Windows.html");
            driver.findElement(By.xpath("//a[contains(text(),'Open New Tabbed Windows ')]")).click();
            driver.findElement(By.xpath("//div[@id='Tabbed']/child::a/button")).click();
            System.out.println(driver.getTitle());
           Set<String> s=driver.getWindowHandles();
           for(String i:s){
//               System.out.println(i);
               String title=driver.switchTo().window(i).getTitle();
//               System.out.println(title);
               if(title.contains("Selenium")){
                   driver.close();
               }
           }

    }
}
