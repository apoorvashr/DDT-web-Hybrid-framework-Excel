package org.practice.src.test.java.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import org.apache.commons.io.FileUtils;

public class ScreenshotUtil {

    public static String capture(WebDriver driver, String testName) {

        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            String path = "reports/screenshots/" + testName + "_" + System.currentTimeMillis() + ".png";
            FileUtils.copyFile(src, new File(path));

            return path;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}