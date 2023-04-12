package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropCustomDemo {
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
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        WebElement source=driver.findElement(By.xpath("//*[@id=\"box1\"]"));
        WebElement target=driver.findElement(By.xpath("//*[@id=\"box106\"]"));
       Actions action=new Actions(driver);
       action.clickAndHold(source).moveToElement(target).release().build().perform();
    }
}
