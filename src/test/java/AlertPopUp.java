import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertPopUp {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();
//        driver.switchTo().alert().accept();
        Alert alert=wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).click();
        Alert alert2=wait.until(ExpectedConditions.alertIsPresent());
//        alert2.accept();
        System.out.println(alert2.getText());
        alert2.dismiss();
        driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]")).click();
        Alert alert3=wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(alert3.getText());
        alert3.sendKeys("I am manas");
        alert3.accept();
       boolean message= driver.findElement(By.xpath("//p[contains(text(),'You entered:')]")).isDisplayed();
        System.out.println(message);
    }
}
