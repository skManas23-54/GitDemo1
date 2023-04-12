import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownDemo {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
        WebElement element=driver.findElement(By.xpath("//*[@id=\"post-2646\"]/div[2]/div/div/div/p/select"));
        Select select=new Select(element);
//        select.selectByValue("BHS");
//        for(WebElement element1:element){
//            System.out.println(element1);
        List<WebElement>e=select.getOptions();
        for(WebElement d:e){
//            System.out.println(d);
            if(d.getText().equals("Chad")){
                d.click();
            }
        }
//
//        }
        //or


    }
}
