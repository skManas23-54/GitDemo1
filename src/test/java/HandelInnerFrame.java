import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandelInnerFrame {
    public static void main(String[] args) {
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.get("https://ui.vision/demo/webtest/frames/");
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='frame_1.html']")));
        driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("123456");
        driver.switchTo().defaultContent();

        WebElement frame3=driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
        driver.switchTo().frame(frame3);
        driver.findElement(By.xpath("//*[@id=\"id3\"]/div/input")).sendKeys("187655");
        WebElement iframe=driver.findElement(By.xpath("//iframe[contains(@src,'https://docs.')]"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//*[@id=\"i5\"]/div[3]/div")).click();
        driver.switchTo().defaultContent();
        WebElement frame2=driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
        driver.switchTo().frame(frame2);
        driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("23456789");
    }
}
