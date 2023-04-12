package pageObjectModel2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage2 {
    WebDriver driver;
    @FindBy(linkText = "REGISTER")
    WebElement RegLink;
    @FindBy(name = "firstName")
    WebElement FirstName;
    @FindBy(name = "lastName")
    WebElement LastName;
    @FindBy(name = "phone")
    WebElement PhoneNumber;
    @FindBy(name = "userName")
    WebElement UserName;
    @FindBy(name = "address1")
    WebElement Address;
    @FindBy(name = "city")
    WebElement City;
    @FindBy(name = "state")
    WebElement State;
    @FindBy(name = "postalCode")
    WebElement PostalCode;
    @FindBy(name = "country")
    WebElement Country;
    @FindBy(name = "email")
    WebElement EmailId;
    @FindBy(name = "password")
    WebElement Password;
    @FindBy(name = "confirmPassword")
    WebElement ConfirmPassword;
    @FindBy(name = "submit")
    WebElement Submit;

    RegistrationPage2(WebDriver d) {
       driver=d;
        PageFactory.initElements(d,this);
    }

    public void clickRegButton() {
        RegLink.click();
    }

    public void setFirstName(String firstName) {
        FirstName.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        LastName.sendKeys(lastName);
    }

    public void setPhoneNo(String MobileNumber) {
        PhoneNumber.sendKeys(MobileNumber);
    }

    public void setEmail(String emailId) {
        EmailId.sendKeys(emailId);
    }

    public void setAddressName(String address) {
        Address.sendKeys(address);
    }

    public void setCityName(String city) {
        City.sendKeys(city);
    }

    public void setStateName(String state) {
        State.sendKeys(state);
    }

    public void setPostalCde(String post) {
        PostalCode.sendKeys(post);
    }

    public void clickCountryBox(String text) {

        Country.click();
        Select select = new Select(Country);
        select.selectByVisibleText(text);
    }

    public void setUserName(String UserName) {
        EmailId.sendKeys(UserName);
    }

    public void setPassword(String password) {
        Password.sendKeys(password);
    }

    public void setConfirmPassword(String confirmPassword) {
        ConfirmPassword.sendKeys(confirmPassword);
    }

    public void clickSubmitButton() {
        Submit.click();
    }
}
