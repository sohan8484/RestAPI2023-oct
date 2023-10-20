package api.utilities;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtility {
    public String readExcel(String sheetName,int row, int column) throws IOException {
        FileInputStream fis = new FileInputStream("paht");
        Workbook wb = WorkbookFactory.create(fis);
        return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
    }
    public void writeExcel(String sheetName, int row, int column, String data) throws IOException {
        FileInputStream fis = new FileInputStream("pat");
        Workbook wb = WorkbookFactory.create(fis);
        wb.createSheet(sheetName).createRow(row).createCell(column).setCellValue(data);
        FileOutputStream fos = new FileOutputStream("path");
        wb.write(fos);
    }
}
