package org.practice.src.test.java.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public static ExtentReports getExtent() {
        if (extent == null) {
            ExtentSparkReporter spark =
                    new ExtentSparkReporter("reports/ExtentReport.html");

            spark.config().setReportName("Banking Automation Execution");
            spark.config().setDocumentTitle("ParaBank Test Report");

            extent = new ExtentReports();
            extent.attachReporter(spark);

            extent.setSystemInfo("Project", "Digital Banking");
            extent.setSystemInfo("Tester", "Apoorva");
            extent.setSystemInfo("Environment", "QA");

        }
        return extent;
    }

    public static void setTest(ExtentTest extentTest) {
        test.set(extentTest);
    }

    public static ExtentTest getTest() {
        return test.get();
    }

    public static void logStep(String message) {
        getTest().info(message);
    }
}