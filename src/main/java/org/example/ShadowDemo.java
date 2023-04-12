package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDemo {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://watir.com/examples/shadow_dom.html");
        driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("skManas");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("behera@002");
    }
}
