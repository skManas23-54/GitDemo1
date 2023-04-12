import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class AutoSuggestionDropDown {
    public static void main(String[] args)throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("selenium");
        Thread.sleep(2000);
        List<WebElement> list=driver.findElements(By.xpath("//div[contains(@class,'wM6W7d')]//span"));
        System.out.println(list.size());
//        for(WebElement element:list){
//            System.out.println(element.getText());
//        }
        for(WebElement element:list){
            if(element.getText().equals("selenium interview questions")){
                element.click();
                break;
            }
        }

    }
}
