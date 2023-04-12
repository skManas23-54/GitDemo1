import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TabAndWindow {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.orangehrm.com/");
//        driver.switchTo().newWindow(WindowType.TAB); //open new TAB
        driver.switchTo().newWindow(WindowType.WINDOW);  //opens two different browser window
        driver.get("https://automationexercise.com/test_cases");
        Set<String> windowId=driver.getWindowHandles();
       List<String> windowHandle=new ArrayList<>(windowId);
       String parentWindow=windowHandle.get(0);
        String childWindow=windowHandle.get(1);
        driver.switchTo().window(childWindow);
//        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a")).click();
        driver.navigate().to("https://www.orangehrm.com/");
//        driver.switchTo().window(parentWindow);
        driver.navigate().back();
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a")).click();

    }
}
