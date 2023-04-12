package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCaseDemo {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.saucedemo.com");

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id=\"login-button\"]")).click();
        boolean isAddToCartDisplayed=driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).isDisplayed();
        if(isAddToCartDisplayed==true){
            System.out.println("Test is passed");
        }
        else{
            System.out.println("Test is failed");
        }
        driver.close();


    }
}
