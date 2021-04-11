package com.walmart.base;

import com.walmart.utils.ConfigUtil;
import com.walmart.utils.Constants;
import com.walmart.utils.ScreenshotUtil;
import com.walmart.utils.WebDriverUtil;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    protected WebDriver driver;
    protected static String url;
    protected static String browser;


    @BeforeSuite
    public void beforeSuite(){
        ConfigUtil configUtil = new ConfigUtil(Constants.RESOURCES_PATH +"/config.properties");
        url = configUtil.getProperty("stageUrl");
        browser = configUtil.getProperty("browser");
    }

    @BeforeMethod
    public void setUp(){

        driver = WebDriverUtil.getDriver(browser);
        driver.get(url);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown(ITestResult rs){
        if(ITestResult.FAILURE==rs.getStatus()){
            ScreenshotUtil.takescreenshot(rs.getName(),driver);
        }

        driver.quit();
    }
}
