package test;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by November on 28.03.2017.
 */
public class ExcelDP {
//    @DataProvider
//    public Object[][] getDataFromXlsxFile() throws Exception {
//
//        Object[][] testObjArray = ExcelUtils.getTableArray("/b1.xlsx");
//
//        return (testObjArray);
//
//    }

    public static void main(String[] args) throws Exception {
        Object[][] testObjArray = ExcelUtils.getTableArray("/b1.xlsx");
    }

    static class ExcelUtils {

        public static XSSFSheet ExcelWSheet;
        public static XSSFWorkbook ExcelWBook;
        public static XSSFCell Cell;
        public static Object[][] getTableArray(String name) throws Exception {

            String[][] tabArray = null;

            try {

                FileInputStream ExcelFile = new FileInputStream("C:\\Users\\November\\TestNGSample2\\1\\src\\test\\resources\\b1.xlsx");

                // Access the required test data sheet

                ExcelWBook = new XSSFWorkbook(ExcelFile);
                ExcelWSheet = ExcelWBook.getSheet("sheet1");

                int startRow = 1;
                int startCol = 1;

                int ci = 0;
                int cj = 0;

                int totalRows = ExcelWSheet.getLastRowNum();
                System.out.println("total rows - " + totalRows);

                int totalCols = 2;

                // you can write a function as well to get Column count
                for (int i = 0; i < ExcelWSheet.getLastRowNum(); i++) {
                    if (ExcelWSheet.getRow(i).getLastCellNum() < totalCols) {
                        totalCols = ExcelWSheet.getRow(i).getLastCellNum();
                    }
                }

                System.out.println("total cols = " + totalCols);

                tabArray = new String[totalRows][totalCols];

                for (int i = 1; i <= totalRows; i++) {

                    for (int j = 1; j <= totalCols; j++) {

                        tabArray[i - 1][j - 1] = getCellData(i, j);

                        System.out.println(tabArray[i][j]);

                    }

                }

            } catch (FileNotFoundException e) {

                System.out.println("Could not find the Excel sheet");

                e.printStackTrace();

            } catch (IOException e) {

                System.out.println("Could not read the Excel sheet");

                e.printStackTrace();

            }

            return (tabArray);

        }

        public static String getCellData(int RowNum, int ColNum) throws Exception {


            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
            String CellData = null;

            int cellType = Cell.getCellType();

            switch (cellType) {
                case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING:
                    CellData = (Cell.getStringCellValue());
                    break;
                case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC:
                    CellData = (String.valueOf(Cell.getNumericCellValue()));
                    break;
                case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_FORMULA:
                    CellData = (String.valueOf(Cell.getNumericCellValue()));
                    break;
            }
            return CellData;
        }

    }

}

