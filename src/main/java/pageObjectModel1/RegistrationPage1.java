package pageObjectModel1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage1 {
    WebDriver driver;
    By regLin = By.xpath("//a[contains(text(),'REGISTER')]");
    By firstName = By.name("firstName");
    By lastName = By.name("lastName");
    By phone = By.name("phone");
    By email = By.name("userName");
    By addressName = By.name("address1");
    By city = By.name("city");
    By state = By.name("state");
    By postalCode = By.name("postalCode");
    By country = By.name("country");
    By userName = By.name("email");
    By password = By.name("password");
    By confirmPassword = By.name("confirmPassword");
    By submitB = By.name("submit");

    RegistrationPage1(WebDriver d) {
        driver = d;
    }

    public void clickRegButton() {
        driver.findElement(regLin).click();
    }

    public void setFirstName(String FirstName) {
        driver.findElement(firstName).sendKeys(FirstName);
    }

    public void setLastName(String LastName) {
        driver.findElement(lastName).sendKeys(LastName);
    }

    public void setPhoneNo(String MobileNumber) {
        driver.findElement(phone).sendKeys(MobileNumber);
    }

    public void setEmail(String EmailId) {
        driver.findElement(email).sendKeys(EmailId);
    }

    public void setAddressName(String Address) {
        driver.findElement(addressName).sendKeys(Address);
    }

    public void setCityName(String City) {
        driver.findElement(city).sendKeys(City);
    }

    public void setStateName(String State) {
        driver.findElement(state).sendKeys(State);
    }

    public void setPostalCde(String Post) {
        driver.findElement(postalCode).sendKeys(Post);
    }

    public void clickCountryBox(String text) {
        WebElement element = driver.findElement(country);
        element.click();
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public void setUserName(String UserName) {
        driver.findElement(userName).sendKeys(UserName);
    }

    public void setPassword(String Password) {
        WebElement element=driver.findElement(password);
        element.clear();
        element.sendKeys(Password);
    }

    public void setConfirmPassword(String ConfirmPassword) {
        driver.findElement(confirmPassword).sendKeys(ConfirmPassword);
    }

    public void clickSubmitButton() {
        driver.findElement(submitB).click();
    }


}
