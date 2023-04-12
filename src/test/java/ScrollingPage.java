import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ScrollingPage {
    public static void main(String[] args) throws InterruptedException{
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");
        WebElement indFlag=driver.findElement(By.xpath("//img[contains(@src,'flag-of-India')]"));
        JavascriptExecutor js=(JavascriptExecutor) driver;

        //scroll down page by pixel
//        js.executeScript("window.scrollBy(0,3000)","");
//        System.out.println(js.executeScript("return window.pageYOffset;"));//3000

        //scroll down the page till the element is present
//        js.executeScript("arguments[0].scrollIntoView();",indFlag);
//        System.out.println(js.executeScript("return window.pageYOffset;"));//4946

        //scroll down the page till end
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        System.out.println(js.executeScript("return window.pageYOffset;"));//6008
        Thread.sleep(3000);

        //go to the initialPosition
        js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
        System.out.println(js.executeScript("return window.pageYOffset;"));//6008
    }
}
