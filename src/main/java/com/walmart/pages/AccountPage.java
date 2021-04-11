package com.walmart.pages;

import com.walmart.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends BasePage {

    public AccountPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,AccountPage.class);
    }

}
