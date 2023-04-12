import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SortedDropdown {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.twoplugs.com");
        driver.findElement(By.xpath("//a[text()='Live Posting']")).click();
        WebElement option=driver.findElement(By.xpath("//select[@name='category_id']"));
        Select select=new Select(option);
        List<WebElement> optionList=select.getOptions();
        ArrayList originalList=new ArrayList();
        ArrayList tempList=new ArrayList<>();
        for(WebElement op:optionList){
            originalList.add(op.getText());
            tempList.add(op.getText());
        }
        System.out.println("original list:"+originalList);
        System.out.println("temp list:"+tempList);
        Collections.sort(tempList);
        }

    }

