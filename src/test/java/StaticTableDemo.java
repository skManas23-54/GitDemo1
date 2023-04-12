import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class StaticTableDemo {
    public static void main(String[] args) {
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://testautomationpractice.blogspot.com/");

//        List<WebElement>r=driver.findElements(By.xpath("//table[@name='BookTable']//tr"));
//        System.out.println(r.size());
        //above line we can modify below
        // 1 find total number of rows
        //this is preferable
        int rows=driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
        System.out.println(rows);

        //we can write this but the problem is it is applicable when the page contain only one table
//        int rows1=driver.findElements(By.tagName("tr")).size();
//        System.out.println(rows1);

        // 2 find total number of column
        int column=driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
//        int column=driver.findElements(By.tagName("th")).size();//this is preferable if there is one table
        System.out.println(column);

        // 3 read specific row & column
        WebElement element=driver.findElement(By.xpath("//table[@name='BookTable']//tr[7]//td[1]"));
        System.out.println(element.getText());

        //4 read data from all the rows & column
        for(int i=2;i<=rows;i++){
            for(int j=1;j<=column;j++){
                WebElement element1=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td["+j+"]"));
                System.out.print(element1.getText()+"\t");
            }
            System.out.println();

        }
        // 4 print book name whose author name is amit
//        for(int i=2;i<=rows;i++){
//            for(int j=1;j<=column;j++){
//                WebElement element1=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td["+j+"]"));
//                String text=element1.getText();
//                if(text.equals("Amit")){
//                    WebElement element2=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td["+(j-1)+"]"));
//                    System.out.println(element2.getText());
//                }
//            }
//            System.out.println();
//
//        }
        //or we can write this way
        for(int i=2;i<=rows;i++){
            String author=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td[2]")).getText();
            if(author.equals("Amit")){
                String bookName=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td[1]")).getText();
                System.out.println(bookName);

            }
        }
        //find sum of all books
        int sum=0;
        for(int i=2;i<=rows;i++){
            String bookPrice=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td[4]")).getText();
            int price=Integer.parseInt(bookPrice);
            sum+=price;
            System.out.println(bookPrice);
        }
        System.out.println(sum);
    }
}
