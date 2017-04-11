//package test;
//
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//
///**
// * Created by November on 28.03.2017.
// */
//public class getExcelData {
//    /**
//     * @param File Name
//     * @param Sheet Name
//     * @return
//     */
//    public String[][] getExcelData(String fileName, String sheetName) {
//        String[][] arrayExcelData = null;
//        try {
//            FileInputStream fs = new FileInputStream(fileName);
//            Workbook wb;
//            wb = new XSSFWorkbook(fs);
//            Sheet sh = wb.getSheet(sheetName);
//
////            int totalNoOfCols = sh.get();
//            int totalNoOfRows = sh.getLastRowNum();
//
//            arrayExcelData = new String[totalNoOfRows-1][totalNoOfCols];
//
//            for (int i= 1 ; i < totalNoOfRows; i++) {
//
//                for (int j=0; j < totalNoOfCols; j++) {
//                    arrayExcelData[i-1][j] = sh.getCell(j, i).getContents();
//                }
//
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//            e.printStackTrace();
//        } catch (BiffException e) {
//            e.printStackTrace();
//        }
//        return arrayExcelData;
//    }
//}
