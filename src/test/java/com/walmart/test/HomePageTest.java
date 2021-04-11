package com.walmart.test;

import com.walmart.base.BaseTest;
import com.walmart.pages.HomePage;
import com.walmart.pages.SearchResultsPage;
import com.walmart.utils.ExcelHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    private static Logger log = (Logger) LogManager.getLogger(HomePageTest.class);
    HomePage hm;

    @DataProvider(name="searchData")
    public Object[][] testData(){
        log.info("calling getexceldata");
        return ExcelHelper.getExcelData("Book2.xlsx","Sheet1");
    }

    @Test(dataProvider = "searchData")
    public void searchTest(String searchKeyword,String expected) throws InterruptedException {
        hm = new HomePage(driver);

        //SearchResultsPage sp = hm.search(searchKeyword);
       // log.info(sp.getTitle());

        log.info("Search Page Title retrieved");

        //Assert.assertEquals(sp.getTitle(),expected);
    }

    @Test
    public void imagesTest(){
        hm = new HomePage(driver);
        Assert.assertEquals(hm.images(),5);
        log.info("Home Page images got asserted:");
    }
}
