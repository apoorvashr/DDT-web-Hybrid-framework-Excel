package org.practice.src.test.java.test;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.practice.src.test.java.utils.ExtentManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;


public class BaseTest {

       protected static WebDriver driver;
       protected static final Logger logger = LogManager.getLogger(BaseTest.class);

       public WebDriver getDriver(){
           return driver;
       }

       @BeforeSuite(alwaysRun = true)
       public void setup() {
          // ChromeOptions options = new ChromeOptions();
           driver = new ChromeDriver();

           getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
           getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
           getDriver().manage().window().maximize();
           //ExtentManager.logStep("Launching ParaBank");
           driver.get("https://parabank.parasoft.com/parabank/index.htm");

       }

      @AfterSuite(alwaysRun = true)
      public void tearDown() {
           if (getDriver()!=null) {
               driver.quit();
           }
      }



    }
