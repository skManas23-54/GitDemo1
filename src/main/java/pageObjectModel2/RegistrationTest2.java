package pageObjectModel2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import pageObjectModel1.RegistrationPage1;

public class RegistrationTest2 {
    public static WebDriver driver;
    static String browser = "chrome";

    @Test
    public void verifyFlightReg() {
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
        RegistrationPage2 pg = new RegistrationPage2(driver);
        driver.get("https://demo.guru99.com/test/newtours/");
        pg.clickRegButton();
        pg.setFirstName("Manas");
        pg.setLastName("Behera");
        pg.setPhoneNo("9040320799");
        pg.setEmail("sk@gmail.com");
        pg.setAddressName("Hyderabad");
        pg.setCityName("Kondapur");
        pg.setStateName("Telangana");
        pg.setPostalCde("SriramNagar");
        pg.clickCountryBox("AMERICAN SAMOA");
        pg.setUserName("skManas");
        pg.setPassword("Behera@2002");
        pg.setConfirmPassword("Behera@2002");
        pg.clickSubmitButton();
        String expRegPageTitle="Register: Mercury Tours";
        if(driver.getPageSource().contains("Register: Mercury Tours")){
            System.out.println("Registered Successfully");
        }
        else{
            System.out.println("There is some issue");
        }
    }
}
