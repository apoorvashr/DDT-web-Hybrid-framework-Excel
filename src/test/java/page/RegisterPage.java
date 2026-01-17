package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.BasePage;

public class RegisterPage extends BasePage {

    @FindBy(xpath = "//p/a[text()='Register']")
    WebElement registerLi;

    @FindBy(xpath = "//input[@id='customer.firstName']")
    WebElement firstNameField;

    @FindBy(xpath = "//input[@id='customer.lastName']")
    WebElement lastNameField;

    @FindBy(xpath = "//input[@id='customer.address.street']")
    WebElement address;

    @FindBy(xpath = "//input[@id='customer.address.city']")
    WebElement city;

    @FindBy(xpath = "//input[@id='customer.address.state']")
    WebElement state;

    @FindBy(xpath = "//input[@id='customer.address.zipCode']")
    WebElement zipCode;

    @FindBy(xpath = "//input[@id='customer.phoneNumber']")
    WebElement phoneNumber;

    @FindBy(xpath = "//input[@id='customer.ssn']")
    WebElement customerSsn;

    @FindBy(xpath = "//input[@id='customer.username']")
    WebElement customerUsername;

    @FindBy(xpath = "//input[@id='customer.password']")
    WebElement customerPassword;

    @FindBy(xpath = "//input[@id='repeatedPassword']")
    WebElement repeatedPassword;

    @FindBy(xpath = "//input[@type='submit' and @value='Register']")
    WebElement btnRegister;

    @FindBy(xpath = "//h1[contains(text(),'Signing up')]")
    WebElement titlePage;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }


    public String verifyPageTitle() {
        return getPageTitle();
    }

    public String performRegistration() {
        clickElement(registerLi);
        return getPageTitle();
    }


}
