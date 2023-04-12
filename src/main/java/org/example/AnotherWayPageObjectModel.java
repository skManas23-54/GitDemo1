package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AnotherWayPageObjectModel {
    WebDriver driver;
//    @FindBy (how= How.LINK_TEXT,using = "REGISTER")   //syntax 1
//    WebElement regLink;
      @FindBy(linkText = "REGISTER")
      WebElement regLink;
    @FindBy (how= How.NAME,using = "country")
    WebElement country;
    AnotherWayPageObjectModel(WebDriver d){
        driver=d;
        PageFactory.initElements(d,this);
    }
    public  void clickRegButton(){
        regLink.click();
    }
    public void clickCountryBox(String cn){
        Select select=new Select( country);
        select.selectByVisibleText(cn);
    }

}
