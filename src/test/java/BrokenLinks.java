import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class BrokenLinks {
    public static void main(String[] args) throws IOException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://www.deadlinkcity.com/");
        List<WebElement> elements=driver.findElements(By.tagName("a"));
        System.out.println(elements.size());
        int brokenLinks=0;
        for(WebElement e:elements){
            String hrefAttributeValue=e.getAttribute("href");
            System.out.println(hrefAttributeValue);
            if(hrefAttributeValue==null||hrefAttributeValue.isEmpty()){
                System.out.println("href attribute value is null");
                continue;
            }
            URL urlLinks=new URL(hrefAttributeValue);//convert String url format
            //send request to server-open connect
            HttpURLConnection connection=(HttpURLConnection) urlLinks.openConnection();
            connection.connect();
           if(connection.getResponseCode()>=400){
               System.out.println(hrefAttributeValue+"       "+"======>Broken links"    );
               brokenLinks++;
           }
           else{
               System.out.println(hrefAttributeValue+"       "+"======> Not Broken links");
           }
        }
        System.out.println("total number of broken links"+brokenLinks);
    }
}
