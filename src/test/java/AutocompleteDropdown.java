import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AutocompleteDropdown {
    public static void main(String[] args) {
         ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.twoplugs.com");
        driver.findElement(By.xpath("//a[text()='Live Posting']")).click();
        WebElement searchBox=driver.findElement(By.xpath("//input[@id='autocomplete']"));
        searchBox.clear();
        searchBox.sendKeys("Toronto");
        String text;
//        do{
//            searchBox.sendKeys(Keys.ARROW_DOWN);
//            text=searchBox.getAttribute("value");
//            if(text.equals("Toronto"))
//        }

    }
}
