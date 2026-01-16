package org.practice.src.test.java.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.practice.src.test.java.utils.ExtentManager;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@name='username']")
    WebElement inputElement;

    @FindBy(xpath = "//input[@type='password']")
    WebElement inputPassword;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement btnSubmit;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void performLogin(String userName, String password) {
        ExtentManager.logStep("Performing Login");
        addTextInfield(inputElement,userName);
        addTextInfield(inputPassword,password);
        ExtentManager.logStep("Clicking Login");
        clickElement(btnSubmit);
    }
}
