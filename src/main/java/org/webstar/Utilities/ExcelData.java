package org.webstar.Utilities;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;


public class ExcelData {

    public static Object[][] getSheetData(String filePath,String sheetname){
        Object[][] data = new Object[0][];
        try {
            FileInputStream file = new FileInputStream(filePath);

            //Treat this as your typical workbook for Excel that has data in it
            XSSFWorkbook  workbook = new XSSFWorkbook(file );

            //This is the sheet inside your Excel workbook that needs to be read
            XSSFSheet sheet = workbook.getSheet(sheetname);
            int numOfRows = sheet.getPhysicalNumberOfRows();

            // TODO: 2023/01/07 Implement for loop logic to populate our data object with the data from the sheet 


        }catch (Exception ex){
            ex.printStackTrace();
        }
        return data;
    }
}
