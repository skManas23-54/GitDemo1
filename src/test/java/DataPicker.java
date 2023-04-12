import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class DataPicker {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://jqueryui.com/datepicker/");
        driver.manage().window().maximize();
        WebElement frame = driver.findElement(By.xpath(" //iframe[@class='demo-frame']"));
        driver.switchTo().frame(frame);
        WebElement dataPicker = driver.findElement(By.xpath("//*[@id=\"datepicker\"]"));

        //Approach 1
        dataPicker.sendKeys("12/10/22");

        //Approach 2
        String year="2024";
        String month="March";
        String day="15";
        dataPicker.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        while(true){
            String Month=driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span[1]")).getText();
            String Year=driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span[2]")).getText();
            System.out.println(Month);
            System.out.println(Year);
            if(Month.equals(month)&&Year.equals(year)){
                break;
            }
            driver.findElement(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']")).click();
//            List<WebElement> allDates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
//            for(WebElement e:allDates){
//                if(e.getText().equals(day)){
//                    e.click();
//                    break;
//                }
//            }
            WebElement element1=driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[6]/a"));
            System.out.println(element1.getText());
        }
    }
}