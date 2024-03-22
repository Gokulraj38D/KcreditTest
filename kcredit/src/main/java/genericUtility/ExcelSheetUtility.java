package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheetUtility {
	
	public String toGetDataFromExcelSheet(String sheetname,int row,int cell) throws IOException {
		FileInputStream fis=new FileInputStream(IconstantUtility.excelfilepath);
		Workbook workbook=WorkbookFactory.create(fis);
		String cellValue = workbook.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
		return cellValue;
	}
}
