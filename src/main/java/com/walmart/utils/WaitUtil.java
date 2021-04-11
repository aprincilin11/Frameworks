package com.walmart.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WaitUtil {
    static Logger log = LogManager.getLogger(WaitUtil.class);

    /* public static List<WebElement> explicitElementVisible(WebDriver driver, long timeInSecs, List<WebElement> elements) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeInSecs);
            elements = wait.until(ExpectedConditions.visibilityOfAllElements(elements));
        } catch (Exception e){
            log.error("Exception occurred while waiting for the element explicitly");
            log.error(e.getMessage());
        }
        return elements;
    }
     */

    //implicit wait
    public static void implicitWait(WebDriver driver, long timeInSecs){
        driver.manage().timeouts().implicitlyWait(timeInSecs, TimeUnit.SECONDS);
    }
}
