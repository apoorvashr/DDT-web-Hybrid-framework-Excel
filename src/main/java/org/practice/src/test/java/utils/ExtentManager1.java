/*
package org.practice.src.test.java.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.practice.src.test.java.page.BasePage;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class ExtentManager extends BasePage {

   private static ExtentReports extentReports;
   private static ThreadLocal<ExtentTest> testThreadLocal= new ThreadLocal<>();
   // private static ExtentTest testThreadLocal;
    private  static  Map<Long, WebDriver> driverMap = new HashMap<>();

    public ExtentManager(WebDriver driver) {
        super(driver);
    }

    //Initialise extent report
    public static  ExtentReports getReports() {
        if (extentReports==null) {
          String reportPath = System.getProperty("user.dir")+"src/main/java/org/practice/src/test/resources/ExtentReport/ExtentReport.html";
           ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
           sparkReporter.config().setReportName("Banking automation Report");
           sparkReporter.config().setDocumentTitle("parabank");
           sparkReporter.config().setTheme(Theme.DARK);

           extentReports =  new ExtentReports();
           //adding system information
           extentReports.setSystemInfo("Operating System",System.getProperty("os.name"));
           extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
           extentReports.setSystemInfo("User name", System.getProperty("user.name"));
       }
       return extentReports;
    }

    //start the test
    public static  ExtentTest startTest(String testName) {

        ExtentTest extentTest =  getReports().createTest(testName);
        //testThreadLocal.set(extentTest);

    return extentTest;
    }

    //End the test
    public static  void endTest(){
        getReports().flush();
    }

    //get current thread's test
    public static  ExtentTest getTest(){
        return testThreadLocal.get();
       // return testThreadLocal.getExtent().getTestSubject().test();
    }

    //Method to get the name of the current test
    public static String getTestName() {
        ExtentTest currentTest = getTest();
          if (currentTest!=null) {
             return  currentTest.getModel().getName();
          } else {
              return "no test is currently active for this thread";
          }
    }

    //log the steps
    public static void logStep(String logMessage) {
        getTest().info("logMessage");
    }

    //log a step validation with screenshot
    public static void logStepWithScreenShot(WebDriver driver,String logmessage, String screenshotMessage) {
        getTest().pass(logmessage);
        //screenshot method
    }

    //log a step validation with screenshot
    public static void logfail(WebDriver driver,String logmessage, String screenshotMessage) {
        getTest().fail(logmessage);
        //screenshot method
        attachScreenShot(driver,screenshotMessage);
    }

    //log a step validation with screenshot
    public static void logSkip(WebDriver driver,String logmessage, String screenshotMessage) {
        getTest().skip(logmessage);
        //screenshot method
        attachScreenShot(driver,screenshotMessage);
    }

    //take screenshot with date and time in the system
    public static  String  takeScreenShot(WebDriver driver, String screenShotName) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
        //format date and time for File Name
        String timestamp = String.valueOf(new SimpleDateFormat(("dd-mm-yyyy").format(String.valueOf(new Date()))));
        //saving the screenshot to a file
        String destfilePath = System.getProperty("user.dir") + "src/main/java/org/practice/src/test/resources/ExtentReport/Screenshots" + "ScreenshotName" + "_" + "timeStamp" + ".png";
        File finalPath = new File(destfilePath);
        FileUtils.copyFile(src.toPath().toFile(),finalPath);
         //convert screenshot to base64 to embed in to the report
        String base64Format = convertToBase64(src);
        return base64Format;
    }

    //Convert screenshot to Base64 format
    public static String convertToBase64(File screenshotFile) throws IOException {
     String baseFormat ="";
        //Read the file content into a byte array
    byte[] fileContent = org.apache.commons.io.FileUtils.readFileToByteArray(screenshotFile);
    //convert the byte to base64 string
        return  baseFormat  = Base64.encodeBase64String(fileContent);
    }

   //register webDriver for current Thread
    public static void registerDriver(WebDriver driver) {
         driverMap.put(Thread.currentThread().getId(), driver);
    }

    //Attach screenshot to report using base 64
    public static synchronized void attachScreenShot(WebDriver driver,String message)  {
      try{
      String screenShotBase64 = takeScreenShot(driver, getTestName());
       getTest().info(message, MediaEntityBuilder.createScreenCaptureFromBase64String(screenShotBase64).build());
      } catch (Exception e) {
          getTest().fail("Failed to attach screenshot");
          e.printStackTrace();
        }
    }
}*/
