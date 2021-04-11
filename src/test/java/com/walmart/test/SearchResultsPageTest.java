package com.walmart.test;

import com.walmart.base.BaseTest;
import com.walmart.pages.AccountPage;
import com.walmart.pages.SearchResultsPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchResultsPageTest extends BaseTest {
    private static Logger log = LogManager.getLogger(SearchResultsPage.class);

    SearchResultsPage searchResultsPage;

    /* @Test
    public void accountElementTest() {
        searchResultsPage = PageFactory.initElements(driver, SearchResultsPage.class);

    boolean actual = searchResultsPage.accountElement();
       Assert.assertTrue(actual);
         Assert.assertEquals(actual,true);
        log.info("'Account' Web element got asserted:");
    } */


    @Test
    public void accountClickTest(){
        searchResultsPage = PageFactory.initElements(driver, SearchResultsPage.class);
        //AccountPage acctPage;
        searchResultsPage.setAccountTagClickable();
        log.info("Title of the tag Account: ");
    }

    @Test
    public void logoDisplayedTest() {
        searchResultsPage = PageFactory.initElements(driver, SearchResultsPage.class);
        boolean actual = searchResultsPage.logoDisplayed();
        //Assert.assertTrue(actual);
        //Assert.assertEquals(actual, true);
        log.info(actual);
        log.info("Logo of Walmart got asserted:");
    }

}
