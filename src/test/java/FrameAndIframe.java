import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class FrameAndIframe {
    public static void main(String[] args) {
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
//        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/main/div/div[1]/div[1]/iframe")));
        //or we can write by using frame name
                driver.switchTo().frame("packageListFrame");

        WebElement element=driver.findElement(By.xpath("//a[text()='org.openqa.selenium' and @target='packageFrame']"));

        element.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.switchTo().defaultContent();
        driver.switchTo().frame("packageFrame");
        driver.findElement(By.xpath("//span[text()='Alert']")).click();
    }
}
