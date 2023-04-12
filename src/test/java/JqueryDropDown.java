import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class JqueryDropDown {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
        WebElement element=driver.findElement(By.xpath("//*[@id=\"justAnInputBox\"]"));
        element.click();

//        selectChoiceValue(driver,"choice 1");
        selectChoiceValue(driver,"all");

    }
    public static void selectChoiceValue(WebDriver driver,String... value){
        List<WebElement> element=driver.findElements(By.xpath("//span[@class=\"comboTreeItemTitle\"]"));
            if(!value[0].equalsIgnoreCase("all")) {
                for (WebElement option : element) {
                    String text=option.getText();
                    for(String val:value){
                        if(text.equals(val)){
                            option.click();
                        }
                    }
                }
            }
            else{
                for(WebElement item:element){
                    item.click();
                }
            }
    }
}
