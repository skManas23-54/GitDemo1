import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HandelBrowserWidow {
    public static void main(String[] args) {
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath("//a[contains(text(),'OrangeHRM, Inc')]")).click();


        Set<String> windowId=driver.getWindowHandles();

        //approach 3
//        Iterator<String>it=data.iterator();
//        String parentWindow=it.next();
//        String childWindow=it.next();
//        System.out.println(parentWindow);
//        String window=driver.switchTo().window(childWindow).getTitle();
//        System.out.println(window);

        //approach 1 using list collection
//        List<String> windowIdList=new ArrayList(windowId);
//        String parentWindow=windowIdList.get(0);
//        String childWindow=windowIdList.get(1);

        //switch to childWindow
//        driver.switchTo().window(childWindow);
//        System.out.println(driver.getTitle());
//        driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/div[2]/ul/li[2]/a/button")).click();

        //switch to parent window
//        driver.switchTo().window(parentWindow);
//        System.out.println(driver.getTitle());
//        WebElement image=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[1]/img"));
//        System.out.println(image.isDisplayed());

        //approach 2
        for(String wind:windowId){
            String title=driver.switchTo().window(wind).getTitle();
            if(title.equals("OrangeHRM HR Software | Free & Open Source HR Software | HRMS | HRIS | OrangeHRM")){
                driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/div[2]/ul/li[2]/a/button")).click();
            }
        }

        //closing specific window
        //if have 5 window title as 1windowTitle=x,2wt=y,3wt=z,4wt=r,4wt=t
        //suppose i want to close 2nd and 3rd window
        for(String wind:windowId){
            String title=driver.switchTo().window(wind).getTitle();
            if(title.equals("y")||title.equals("z")){
                driver.close();
            }
        }
    }
}
