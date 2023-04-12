import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HandelMultiplyDropDownByGenericMethod {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.orangehrm.com/contact-sales/");
        WebElement noOfEmployee=driver.findElement(By.xpath("//*[@id=\"Form_getForm_NoOfEmployees\"]"));
        selectOptionsFromDropdown(noOfEmployee,"11 - 15");
        WebElement country=driver.findElement(By.xpath("//*[@id=\"Form_getForm_Country\"]"));
        selectOptionsFromDropdown(country,"Aruba");

    }
    public static void selectOptionsFromDropdown(WebElement element,String value){

        Select select=new Select(element);
        List<WebElement>allOptions=select.getOptions();
        for(WebElement option:allOptions){
            if(option.getText().equals(value)){
                option.click();
                break;
            }
        }
    }

}
