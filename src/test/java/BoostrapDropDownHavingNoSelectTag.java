import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class BoostrapDropDownHavingNoSelectTag {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
            driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[@type='button']")).click();
        List<WebElement> text = driver.findElements(By.xpath("//ul[contains(@class,'multiselect')]//label"));
        System.out.println(text.size());
//        for(int i=0;i<text.size();i++){
//            System.out.println(text.get(i).getText());
//        }
//        for(int i=0;i<text.size();i++){
//           if(text.get(i).getText().equals("Java")){
//               text.get(i).click();
//               break;
//            }
//        }
//        for(int i=0;i<text.size();i++){
//            if(text.get(i).getText().equals("Java")||text.get(i).getText().equals("Python")){
//                text.get(i).click();
//            }
        //or we can modified the above line
//        for(int i=0;i<text.size();i++){
//            String option=text.get(i).getText();
//            if(option.equals("Java")||option.equals("Python")){
//                text.get(i).click();
//            }
//        }
        //using enhance for lop
//        for (WebElement option : text) {
//            if (option.getText().equals("Java")) {
//                option.click();
//                break;
//            }
//        }
//        for (WebElement option : text) {
//            if (option.getText().equals("Java") || option.getText().equals("Python")) {
//                option.click();
//            }
//        }
    }
}
