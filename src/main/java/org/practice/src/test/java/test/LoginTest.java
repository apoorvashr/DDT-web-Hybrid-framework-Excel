package org.practice.src.test.java.test;

import org.practice.src.test.java.page.LoginPage;
import org.practice.src.test.java.test.BaseTest;
import org.practice.src.test.java.utils.ExcelUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends BaseTest {

     LoginPage loginPage;

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
         Assert.assertEquals(driver.getTitle(),"ParaBank | Accounts Overview");
       }
    }
