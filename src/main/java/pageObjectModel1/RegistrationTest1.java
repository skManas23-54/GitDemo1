package pageObjectModel1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RegistrationTest1 {
    public static WebDriver driver;
    static String browser="chrome";
@Test
    public void verifyFlightReg(){
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
    RegistrationPage1 pg=new RegistrationPage1(driver);
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





    }


}
