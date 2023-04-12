import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class UdemySeleniumPractice {
    public static void main(String[] args) throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        String url = "https://itera-qa.azurewebsites.net/home/automation";
        driver.get(url);
//       WebElement element=driver.findElement(By.xpath("//input[@name='username']"));
//        Set<String>s1= driver.getWindowHandles();
//       Iterator<String>it=s1.iterator();
//       String parentWindow=it.next();
//       String childWindow=it.next();
//        System.out.println(childWindow);
//       driver.switchTo().window(childWindow);
//
//
//       driver.findElement(By.xpath("//section[contains(@class,'row td-box td-box--100')]/descendant::div[7]/descendant::a")).click();

//        String str=driver.getPageSource();
//        System.out.println(str);
//        System.out.println(element.isSelected());
//        By nameBox=By.xpath("//input[@name='username']");
//        WebDriverWait mywait=new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement element=mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
//        element.sendKeys("Admin");
//        element.click();
//        System.out.println(element.isSelected());
//        element.sendKeys("Admin");
//        URL url1=new URL("https://www.flipkart.com/");
//        driver.navigate().to(url1);
//        driver.navigate().back();
//        driver.navigate().forward();
//        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")).sendKeys("6382377445");
//        driver.navigate().refresh();
        driver.findElement(By.xpath("//input[@id='tuesday']")).click();
        List<WebElement> checkBox = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
        System.out.println(checkBox.size());

        for(WebElement element:checkBox){
            element.click();
        }
//        for(int i=0;i< checkBox.size();i++){
//            if(checkBox.get(i).isSelected()){
//                checkBox.get(i).clear();
//            }
//        }
            for(WebElement element:checkBox){
                if(element.isSelected()){
                    element.click();
                }
            }
//        for (int i = 5; i < checkBox.size(); i++) {
//            checkBox.get(i).click();
//            }
          }

        }


