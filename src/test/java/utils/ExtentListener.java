package utils;

import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = utils.ExtentManager.getExtent()
                .createTest(result.getMethod().getMethodName());

        utils.ExtentManager.setTest(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        if (ExtentManager.getTest() != null) {
            ExtentManager.getTest().pass("Test Passed");
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {

        if (utils.ExtentManager.getTest() != null) {
            utils.ExtentManager.getTest().fail(result.getThrowable());
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        utils.ExtentManager.getExtent().flush();
    }
}