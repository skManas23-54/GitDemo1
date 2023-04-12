import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaginationTable {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();
        WebElement userBox = driver.findElement(By.xpath("//*[@id=\"input-username\"]"));
        userBox.clear();
        userBox.sendKeys("demo");
        WebElement passBox = driver.findElement(By.xpath("//*[@id=\"input-password\"]"));
        passBox.clear();
        passBox.sendKeys("demo");
//        driver.switchTo().alert().accept();
        driver.findElement(By.xpath(" //*[@id=\"form-login\"]/div[3]/button")).click();
        if (driver.findElement(By.xpath("//button[@type='button' and @class='btn-close']")).isDisplayed()) {
            driver.findElement(By.xpath("//button[@type='button' and @class='btn-close']")).click();
        }
        driver.findElement(By.xpath("//a[contains(@href,'#collapse-5')]")).click();
        driver.findElement(By.xpath("//ul[@id='collapse-5']//li[1]//a")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
//        String text=driver.findElement(By.xpath("//div[contains(text(),'Showing 71 to 80 of 11385 (1139 Pages)')]")).getText();
        //        String text=driver.findElement(By.xpath("//div[contains(text(),'Showing 71 to 80 of 11385 (1139 Pages)')]")).getText();
        WebElement element = driver.findElement(By.xpath("//div[@class='col-sm-6 text-end']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String text = wait.until(ExpectedConditions.visibilityOf(element)).getText();
        //this for static
        //this is not preferable because  instead od Showing 71 to 80 of 11385 (1139 Pages)')] this if any change the method
        //is not work text.substring(26,31)) because if 71 chang into 791 then ihe index of 1 is change
        System.out.println(text.substring(26, 31));//1139

        //this for dynamic
        /*
        it is preferable because if  (1139 Pages) is change to (113909 Pages) so there is no problem because we take the index
        of "(" and index of "Pages" which is not changes
         */
//        System.out.println(text.substring(text.indexOf("(")+1,text.indexOf("Pages")-1 ));//find from (1139 Pages) to 1139
        int totalPages = Integer.parseInt(text.substring(text.indexOf("(") + 1, text.indexOf("Pages") - 1));
        System.out.println("total number of page = " + totalPages);
        //instead of total number of page we write 5
        for (int p = 1; p <= 5; p++) {
            if (totalPages > 1) {
                WebElement activePage = driver.findElement(By.xpath("//ul[@class='pagination']//li//*[text()=" + p + "]"));
                System.out.println("Active page:" + activePage.getText());
                JavascriptExecutor js1=(JavascriptExecutor)driver;
                js1.executeScript("arguments[0].click();",activePage);
//                activePage.click();
                Thread.sleep(2000);
            }
            int noOfRows=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size();
            System.out.println(noOfRows);

            for(int r=1;r<=noOfRows;r++){
                String customerName=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr[1]//td[2]")).getText();
                String email=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr[1]//td[3]")).getText();
                String customerGroup=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr[1]//td[4]")).getText();

                System.out.println(customerName+"     "+email+"    "+customerGroup);

            }
        }
            driver.quit();
        }
    }

