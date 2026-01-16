package org.practice.src.test.java.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.practice.src.test.java.utils.ExtentManager;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected static final Logger logger = LogManager.getLogger(BasePage.class);

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void waitForVisibility(WebElement element) {
    WebDriverWait webDriverWait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public boolean clickElement(WebElement element) {

       try {
           waitForVisibility(element);
           element.click();
           return true;
       } catch (Exception e) {
           return false;
       }
     }

    public void addTextInfield(WebElement element, String text) {
        waitForVisibility(element);
        element.sendKeys(text);
    }
}
