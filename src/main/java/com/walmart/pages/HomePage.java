package com.walmart.pages;

import com.walmart.base.BasePage;
import com.walmart.utils.ExcelHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage {
    private static Logger log = (Logger) LogManager.getLogger(ExcelHelper.class);

    @FindBy(how = How.CSS, using = ".ClickThroughImage")
    List<WebElement> images;


    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);

    }

    public int images() {
        log.info("Testing for images displayed in HomePage");
        return images.size();
    }
}
