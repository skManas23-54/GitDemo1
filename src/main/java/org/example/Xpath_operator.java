package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class Xpath_operator {
    public static String browser="chrome";
    public static WebDriver driver;
    public static  void main(String[] args) {
        switch (browser) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
        }
        driver.get("http://automationexercise.com");
        driver.manage().window().maximize();
        boolean isSignButtonDisplayed=driver.findElement(By.xpath("//ul[@class='nav navbar-nav']//li[4]")).isDisplayed();
        System.out.println(isSignButtonDisplayed);
        driver.findElement(By.xpath("//ul[@class='nav navbar-nav']//li[4]")).click();
        boolean isNewUserSignUpDisplayed=driver.findElement(By.xpath("//div[@class='signup-form']//child::h2")).isDisplayed();
        System.out.println(isNewUserSignUpDisplayed);
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Manas");
        driver.findElement(By.xpath("//section[@id=\"form\"]/div/div/div[3]/div/form/input[3]\n")).sendKeys("sk@gmail.com");
        driver.findElement(By.xpath("//button[contains(text(),'Signup')]")).click();
        boolean b=driver.findElement(By.xpath("//div[@class='login-form']/child::h2\n")).isDisplayed();
        System.out.println(b);
        driver.findElement(By.xpath("//input[@id=\"id_gender1\"]\n")).click();
        driver.findElement(By.xpath("//input[@id=\"name\"]\n")).sendKeys(" Behera");
        driver.findElement(By.xpath("//input[@id=\"password\"]\n")).sendKeys("Manas");
        WebElement day=driver.findElement(By.xpath("//*[@id=\"days\"]\n"));
        Select selectDay=new Select(day);
        selectDay.selectByValue("20");
        WebElement month=driver.findElement(By.xpath("//select[@id='months']"));
        Select selectMonth=new Select(month);
        selectMonth.selectByValue("1");
        WebElement year=driver.findElement(By.xpath("//select[@id='years']"));
        Select selectYear=new Select(year);
        selectYear.selectByValue("2002");
        driver.findElement(By.xpath("//input[@id=\"newsletter\"]\n")).click();
        driver.findElement(By.xpath("//input[@id=\"optin\"]")).click();
        driver.findElement(By.xpath("//input[@id=\"first_name\"]")).sendKeys("Manas");
        driver.findElement(By.xpath("//input[@id=\"last_name\"]")).sendKeys("Behera");
        driver.findElement(By.xpath("//input[@id=\"company\"]")).sendKeys("Qualcomm");
        driver.findElement(By.xpath("//input[@id=\"address1\"]")).sendKeys("At-kendrapara");
        driver.findElement(By.xpath("//input[@id='address2']")).sendKeys("po-Marsaghai");
        WebElement country=driver.findElement(By.xpath("//select[@id='country']\n"));
        Select selectCountry=new Select(country);
        selectCountry.selectByValue("India");
        driver.findElement(By.xpath("//input[@id=\"state\"]")).sendKeys("Odisha");
        driver.findElement(By.xpath("//input[@id=\"city\"]\n")).sendKeys("cuttack");
        driver.findElement(By.xpath("//input[@id=\"zipcode\"]\n")).sendKeys("435erw");
        driver.findElement(By.xpath("//input[@id=\"mobile_number\"]\n")).sendKeys("6382377445");
        driver.findElement(By.cssSelector("button[type='submit']\n")).click();

        boolean accountCreatedDisplayed=driver.findElement(By.xpath("//section[@id='form']/child::div[1]/div[1]/div[1]/h2/child::b")).isDisplayed();
        System.out.println(accountCreatedDisplayed);
        driver.findElement(By.cssSelector("a.btn-primary")).click();
        boolean logoutIsDisplayed=driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).isDisplayed();
        System.out.println(logoutIsDisplayed);
        driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/child::li[5]/child::a")).click();
        boolean accountDisplayedDisplayed=driver.findElement(By.xpath("//b[contains(text(),'Account Deleted!')]\n")).isDisplayed();
        System.out.println(accountDisplayedDisplayed);
        driver.findElement(By.xpath("//div[@class='pull-right']/child::a")).click();




    }

    }

