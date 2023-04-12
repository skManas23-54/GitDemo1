import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Slider {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get(" https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
        driver.manage().window().maximize();
        Actions actions=new Actions(driver);
//        WebElement min_slider=driver.findElement(By.xpath("//*[@id=\"slider-range\"]/span[1]"));
//        System.out.println(min_slider.getLocation());
//        actions.dragAndDropBy(min_slider,100,250).perform();
//        System.out.println("after moving"+min_slider.getLocation());

        WebElement max_slider=driver.findElement(By.xpath("//*[@id=\"slider-range\"]/span[2]"));
        System.out.println(max_slider.getLocation());
        actions.dragAndDropBy(max_slider,-96,250).perform();
        System.out.println("after moving"+max_slider.getLocation());
    }
}
