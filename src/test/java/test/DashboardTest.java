package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.DashboardPage;
import utils.ExcelUtils;

import java.io.IOException;
import java.util.List;

public class DashboardTest extends BaseTest {

    DashboardPage dashboardPage;


    @DataProvider(name = "dashboardData")
    public Object[][] getDashboardData() throws IOException {

        String filePath = System.getProperty("user.dir") + "/testdata/TestData.xlsx";
        ExcelUtils.loadExcel(filePath, "Sheet2");
        int rowCount = ExcelUtils.getRowCount();
        String ExpectedTitle = ExcelUtils.getCellData(1, 1);
        String ExpectedUrl = ExcelUtils.getCellData(2, 1);

        Object[][] data = new Object[rowCount - 1][0];

        data[rowCount - 1][0] = ExcelUtils.getCellData(1, 0);
        data[rowCount - 1][0] = ExcelUtils.getCellData(2, 0);

        logger.info("---------------------------------8888----" + data);

        ExcelUtils.closeExcel();
        return data;
    }


   /* @Test(dataProvider = "dashboardData")
    public void verifyBalanceTotal() {

    }

    @Test
    public void verifyAllAccounts(){

    }*/

    //String expectedUrl

    @Test(dataProvider = "getDashboardData")
    public void verifyTheDahshboardMenu(String expectedTitle) {

        dashboardPage = new DashboardPage(getDriver());
        List<String> menuFound = dashboardPage.verifyTheMenu();

        Assert.assertEquals(expectedTitle, menuFound);
        //Assert.assertEquals(expectedUrl,);

    }

}
