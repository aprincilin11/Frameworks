package com.walmart.base;

import com.walmart.pages.SearchResultsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;
    @FindBy(how= How.ID,using="global-search-input")
    WebElement searchBox;

    @FindBy(how=How.ID,using="global-search-submit")
    WebElement searchButton;

    public BasePage(WebDriver driver){

        this.driver = driver;
    }

    public SearchResultsPage search(String searchData)  {
        searchBox.sendKeys(searchData);
        searchButton.click();
        return PageFactory.initElements(driver,SearchResultsPage.class);

    }
}
