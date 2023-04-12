import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class LocationOfElement {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.orangehrm.com/");
        WebElement element=driver.findElement(By.xpath("/html/body/nav/div/a/img"));
        driver.manage().window().maximize();
        System.out.println(element.getLocation());//(47, 29)
        driver.manage().window().minimize();
        System.out.println(element.getLocation());
        driver.manage().window().fullscreen();
        System.out.println(element.getLocation());

        Point p=new Point(100,100);
        driver.manage().window().setPosition(p);
        System.out.println(element.getLocation());
    }
}
