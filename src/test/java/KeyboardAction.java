import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class KeyboardAction {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://text-compare.com/");
        driver.manage().window().maximize();
        WebElement element=driver.findElement(By.xpath("//*[@id=\"inputText1\"]"));
        element.sendKeys("welcome to automation testing");

        Actions act=new Actions(driver);

        //ctrl+a
        act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();

        //ctrl+c
        act.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
        //Tab
        act.keyDown(Keys.TAB).keyUp(Keys.CONTROL).perform();
        //or
//        act.sendKeys(Keys.TAB).perform();//only if want to press single key
        //ctrl+v
        act.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();

    }
}
