package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected static final Logger logger = LogManager.getLogger(BasePage.class);
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
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

    protected WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected String getPageTitle() {
        /*   String pagetitle = driver.getTitle();*/
        wait.until(ExpectedConditions.titleContains(driver.getTitle()));
        String pagetitle = driver.getTitle();

        return pagetitle;
    }

}
