package com.walmart.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelHelper {
    private static Logger log = (Logger) LogManager.getLogger(ExcelHelper.class);

    public static Object[][] getExcelData(String fileName,String sheetName){
        log.info("test");
        Object[][] data = null;
        XSSFWorkbook wb = null;
        try{

            log.info(fileName);
            log.info(sheetName);
            wb = new XSSFWorkbook(Constants.RESOURCES_PATH + "/test-data/" + fileName);// we get access to workbook
            //wb = new XSSFWorkbook("C:\\Delina\\Frameworks\\Resources1\\test-data\\Book2.xlsx");
            System.out.println(wb);

            log.info(wb);
            //if we want to access sheet by index we have to use getSheetAt()
            XSSFSheet sheet = wb.getSheet(sheetName);// after getting access , we should access sheet

            int rowsIndex = sheet.getLastRowNum();//return the Last row index---index starts from 0

            log.info("total rows:" + rowsIndex);
            data = new Object[rowsIndex][];

            //We use for loop method to get row by row.
            for(int i = 1;i <= rowsIndex; i++){// we are not going to go from index 0 because index 0 always have headings.
                log.info("row index i is " + rowsIndex);
                log.info("value of i is" + i);
                XSSFRow row = sheet.getRow(i);// here we get access to first row of i

                int cols = row.getLastCellNum();// returns no.of columns-index starts from 0
                log.info("total cols:" +cols);
                Object[] colData = new Object[cols];

                for(int j = 0 ; j < cols;j++){
                    colData[j] = row.getCell(j).toString();// we are trying to get access to cell Data

                }
                data[i-1]=colData;

            }

        } catch (IOException e) {
            log.error(e);
        }
        finally{
            try{
                wb.close();
            }
            catch(IOException e){
                log.error("ExcelHelper exception"+e);
            }
        }
        return data;
    }
}
