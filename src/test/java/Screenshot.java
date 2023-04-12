import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;

public class Screenshot {
    public static void main(String[] args) throws IOException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");

        //capture screenshot full page -selenium 3,4
//        TakesScreenshot ts=(TakesScreenshot) driver;
//        File src=ts.getScreenshotAs(OutputType.FILE);
//        File target=new File("D:\\Selenium\\Selenium_Demo\\screenshot\\fullPage.png");

//        FileUtils.copyFile(src,target);

        //capture screenshot of specific area from a webPage selenium 3,4
        WebElement image=driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[1]/div/div[1]/a/img"));
        File src=image.getScreenshotAs(OutputType.FILE);
        File target= new File("D:\\Selenium\\Selenium_Demo\\screenshot\\sc.png");
        FileUtils.copyFile(src,target);

    }
}
