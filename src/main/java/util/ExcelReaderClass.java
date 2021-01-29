package util;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReaderClass {
	
	// Global Variables
		public String path;
		public FileInputStream fis = null;
		private XSSFWorkbook workbook = null;
		private XSSFSheet sheet = null;
		private XSSFRow row = null;
		private XSSFCell cell = null;

		// XSSF is used for 2010 or later versions
		// HSSF is used for 2007 or earlier versions

		// Constructor to initialize variables
		public ExcelReaderClass(String path) {
			this.path = path;
			try {
				fis = new FileInputStream(path);
				workbook = new XSSFWorkbook(fis);
				sheet = workbook.getSheetAt(0);
				fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// Method to call the value
		public String getCellData(String sheetName, String colName, int rowNum) {
			// For Sheet
			int index = workbook.getSheetIndex(sheetName);
			int col_Num = 0;
			sheet = workbook.getSheetAt(index);

			// For Row
			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equals(colName.trim())) {
					col_Num = i;
				}
			}

			// For Column
			row = sheet.getRow(rowNum - 1);
			cell = row.getCell(col_Num);
			return cell.getStringCellValue();
		}

}
