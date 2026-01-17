package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.BasePage;

import java.util.List;


public class DashboardPage extends BasePage {

    @FindBy(xpath = "//ul[@class='leftmenu']//li")
    List<WebElement> dashboardMenulist;

    public DashboardPage(WebDriver driver) {
        super(driver);
    }


    public List<String> verifyTheMenu() {

        return dashboardMenulist.stream()
                .map(e -> e.getText().trim())
                .filter(t -> !t.isEmpty())
                .toList();
    }


}
