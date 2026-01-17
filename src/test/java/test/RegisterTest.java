package test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.RegisterPage;
import utils.ExcelUtils;

import java.io.IOException;


public class RegisterTest extends BaseTest {

    RegisterPage registerPage;

    @DataProvider(name = "expectedTitles")

    public Object[][] expectedTitles() throws IOException {

        String filePath = System.getProperty("user.dir") + "/testdata/TestData.xlsx";

        ExcelUtils.loadExcel(filePath, "Sheet2");

        int rowCount = ExcelUtils.getRowCount();

        Object[][] data = new Object[rowCount - 1][1];

        for (int i = 1; i < rowCount; i++) {
            data[i - 1][0] = ExcelUtils.getCellData(i, 0);
        }

        logger.info("Elements in excel are" + data);

        ExcelUtils.closeExcel();

        return data;
    }

    //String expectedTitleHeading,
    @Test(dataProvider = "expectedTitles")
    public void VerifyRegistration(String expectedTitleName) {
        registerPage = new RegisterPage(getDriver());
        String actualTitle = registerPage.verifyPageTitle();

        logger.info("actual title is 1st time" + actualTitle + "expected title is" + expectedTitleName);

        SoftAssert softAssert = new SoftAssert();
        logger.info("🔥 THIS LOG MUST APPEAR IN CONSOLE");

        softAssert.assertEquals(actualTitle, expectedTitleName, "Title mismatch");
        registerPage.verifyPageTitle();

        registerPage.performRegistration();
        actualTitle = registerPage.verifyPageTitle();

        logger.info("actual title is" + actualTitle + "expected title is" + expectedTitleName);
        softAssert.assertEquals(actualTitle, expectedTitleName, "Title mismatch");

    }
}
