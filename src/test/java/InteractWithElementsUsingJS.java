import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class InteractWithElementsUsingJS {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        JavascriptExecutor js=(JavascriptExecutor) driver;
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='frame-one1434677811']")));
        //inputBox
        WebElement inbox=driver.findElement(By.xpath("//input[@id='RESULT_TextField-1']"));
        js.executeScript("arguments[0].setAttribute('value','manas')",inbox);

        //radiobutton
        WebElement radioButton=driver.findElement(By.xpath("//*[@id=\"q26\"]/table/tbody/tr[1]/td/label"));
        js.executeScript("arguments[0].click();",radioButton);
    }
}
