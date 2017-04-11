package com.dataprovider;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by November on 29.03.2017.
 */
public class POI {

    static FileInputStream fileInputStream;
    static XSSFWorkbook wb;
    static int i;
    static int j;
    static Object array[][];


//    public static void main(String[] args) throws IOException {
//        Object[][] testObjArray = TableUtil.getTableArray();
//
//        for (i = 0; i < testObjArray.length; i++) {
//            for (j = 0; j < testObjArray[i].length; j++) {
//                System.out.print(testObjArray[i][j].toString());
//            }
//            System.out.println();
//        }
//    }

    @DataProvider
    public static Object[][] getData() throws IOException {
        return TableUtil.getTableArray();
    }

    static class TableUtil {


        public static Object[][] getTableArray() throws IOException {

            fileInputStream = new FileInputStream("/b1.xlsx");

            wb = new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet0 = wb.getSheetAt(0);
            int maxRows = sheet0.getLastRowNum() + 1;
            array = new Object[sheet0.getLastRowNum() + 1][sheet0.getRow(0).getLastCellNum()];
            Cell cell;
            System.out.println(sheet0.getLastRowNum() + "_" + sheet0.getRow(0).getLastCellNum());


            for (i = 0; i < maxRows; i++) {
                for (j = 0; j < sheet0.getRow(i).getLastCellNum(); j++) {
                    // Alternatively, get the value and format it yourself
                    cell = sheet0.getRow(i).getCell(j);
                    switch (cell.getCellTypeEnum()) {
                        case STRING:
                            array[i][j] = (cell.getRichStringCellValue().getString());
                            break;
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                array[i][j] = (cell.getDateCellValue());
                            } else {
                                array[i][j] = (Object) (cell.getNumericCellValue());
                            }
                            break;
                        case BOOLEAN:
                            array[i][j] =(Object) (cell.getBooleanCellValue());
                            break;
                        case FORMULA:
                            array[i][j] =(Object) (cell.getCellFormula());
                            break;
                        case BLANK:
                            System.out.println();
                            break;
                        default:
                            System.out.println();
                    }
                }
            }

            fileInputStream.close();
            return (array);
        }
    }
}