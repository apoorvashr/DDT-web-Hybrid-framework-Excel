package org.practice.src.test.java.utils;

import com.aventstack.extentreports.ExtentTest;
import org.practice.src.test.java.test.BaseTest;
import org.testng.*;

import static java.sql.DriverManager.getDriver;

public class ExtentListener extends BaseTest  implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = ExtentManager.getExtent().createTest(result.getMethod().getMethodName());
        ExtentManager.setTest(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentManager.getTest().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        String path = ScreenshotUtil.capture(
               getDriver(),
                result.getMethod().getMethodName()
        );

        ExtentManager.getTest()
                .fail(result.getThrowable())
                .addScreenCaptureFromPath(path);
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentManager.getExtent().flush();
    }
}