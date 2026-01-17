package test;


import model.LoginTestData;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.LoginPage;
import utils.ExcelUtils;

public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() throws Exception {

        String filePath = System.getProperty("user.dir") + "/testdata/TestData.xlsx";
        ExcelUtils.loadExcel(filePath, "Sheet1");

        int rowCount = ExcelUtils.getRowCount();
        Object[][] data = new Object[rowCount - 1][1];

        for (int i = 1; i < rowCount; i++) {

            String title = ExcelUtils.getCellData(i, 0);
            String userName = ExcelUtils.getCellData(i, 1);
            String password = ExcelUtils.getCellData(i, 2);

            data[i - 1][0] = new LoginTestData(title, userName, password);
        }

        ExcelUtils.closeExcel();
        return data;
    }


    @Test(dataProvider = "loginData")
    public void loginTobankAccount(LoginTestData data) {

        loginPage = new LoginPage(getDriver());

        String actualTitle = loginPage.performLogin(
                data.getUsername(),
                data.getPassword());

        Assert.assertEquals(
                actualTitle,
                data.getPageTitle(),
                "Page title mismatch after login"
        );

    }

}



/*
@DataProvider(name = "loginData")
public Object[][] getLoginData() throws IOException {
    String filePath = System.getProperty("user.dir")+"/testdata/TestData.xlsx";
    ExcelUtils.loadExcel(filePath,"Sheet1");
    int rowCount = ExcelUtils.getRowCount();
    Object[][] data = new Object[rowCount -1][2];

    for (int i = 1; i<rowCount;i++){
        data[i-1][0] =ExcelUtils.getCellData(i,0);
        data[i-1][1] = ExcelUtils.getCellData(i,1);
    }

    ExcelUtils.closeExcel();
    return data;
}

@Test(dataProvider = "loginData")
public void loginTobankAccount(String username, String password) {
    loginPage = new LoginPage(getDriver());
    loginPage.performLogin(username,password);

    logger.info("The page title is" + driver.getTitle());
    //"ParaBank | Accounts Overview"
    // Assert.assertEquals(driver.getTitle(),);
}*/


//"ParaBank | Accounts Overview"
// Assert.assertEquals(driver.getTitle(),);