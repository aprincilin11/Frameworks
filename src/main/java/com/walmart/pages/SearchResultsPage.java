package com.walmart.pages;

import com.walmart.base.BasePage;
import com.walmart.utils.WaitUtil;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class SearchResultsPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//div[@id='header-bubble-links']/descendant::span[contains(text(),'Account')]")
    WebElement accountTag;

    @FindBy(how = How.XPATH, using = "//a[@id='hf-home-link']")
    WebElement logo;
    private Object AccountPage;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, SearchResultsPage.class);
    }

    public String getTitle() {
        return driver.getTitle();
    }

//    public boolean accountElement() {
//        accountTag.click();
//        boolean b = accountTag.isDisplayed();
//        System.out.println("Grid view of search results is enabled: " + b);
//        return b;
//    }

    public String setAccountTagClickable() {
        accountTag.click();
        //return PageFactory.initElements(driver,AccountPage);
        return getTitle();
    }


    public boolean logoDisplayed() {

        WaitUtil.implicitWait(driver, 2000);
        logo.click();
        boolean walmartLogo = logo.isDisplayed();
        //System.out.println("The logo of Walmart is displayed: " + walmartLogo);
        return walmartLogo;
    }
}
