package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;


public class BaseTest {

    protected static final Logger logger = LogManager.getLogger(BaseTest.class);
    protected static WebDriver driver;

    static {
        System.out.println("Logger class = " + logger.getClass());
        logger.error("❌ ERROR LOG TEST");
        logger.warn("⚠ WARN LOG TEST");
        logger.info("✅ INFO LOG TEST");
    }

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeSuite(alwaysRun = true)
    public void setup() {
        // ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver();

        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        getDriver().manage().window().maximize();
        //ExtentManager.logStep("Launching ParaBank");

        logger.error("Launching ParaBank");

        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        if (getDriver() != null) {
            driver.quit();
        }
    }


}
