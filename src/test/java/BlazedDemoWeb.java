import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;

public class BlazedDemoWeb {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get(" https://blazedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement element=driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select select=new Select(element);
        select.selectByValue("Paris");
        WebElement element1=driver.findElement(By.xpath("//select[@name='toPort']"));
        Select select1=new Select(element1);
        select1.selectByValue("Rome");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        int rows=driver.findElements(By.xpath("//tbody//tr")).size();
        int column=driver.findElements(By.xpath("//tbody//tr[1]//td")).size();

        for(int i=1;i<=rows;i++){
            String text=driver.findElement(By.xpath("//tbody//tr["+i+"]//td[6]")).getText();
           String str=text.substring(1);
                int price = Integer.parseInt(str);
               System.out.println(price);
            ArrayList<Integer> array=new ArrayList<Integer>();

        }

    }
}
