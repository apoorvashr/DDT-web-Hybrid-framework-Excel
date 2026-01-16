package org.practice.src.test.java.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {

    private static Workbook workbook;
    private static Sheet sheet;
    protected static final Logger logger = LogManager.getLogger(ExcelUtils.class);

    //load excel
    public static void loadExcel(String filePath, String sheetName) {
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(fileInputStream);
            sheet = workbook.getSheet(sheetName);
        } catch (Exception e) {
            logger.error(e.getMessage() + "inside the error exception in reading data");
        }
    }

    //get cell data
    public static String getCellData(int row, int col) {
        Cell cell = sheet.getRow(row).getCell(col);

        if (cell.getCellType() == CellType.STRING) {
            return cell.getStringCellValue();
        } else if (cell.getCellType() == CellType.NUMERIC) {
            return String.valueOf((int) cell.getNumericCellValue());
        }
     return "";
    }

    //row count
    public static int getRowCount () {
        return sheet.getPhysicalNumberOfRows();
    }

    //close the workbook
    public static void closeExcel() throws IOException {
        workbook.close();
    }
}
