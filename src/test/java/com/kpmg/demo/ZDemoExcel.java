package com.kpmg.demo;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ZDemoExcel {
	public static void main(String[] args) throws IOException  {
		
		FileInputStream file=new FileInputStream("test-data/orange-hrm-data.xlsx");
		
		XSSFWorkbook book=new XSSFWorkbook(file);
		XSSFSheet sheet= book.getSheet("invalidLoginTest");
		String value= sheet.getRow(0).getCell(0).getStringCellValue();
		System.out.println(value);
		
		//write logic to print all cell values
		for(int i=1;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				String demoValue= sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.println(demoValue);
				
			}	
		}
		
		book.close();
		file.close();
		
		GetExcelData excelData=new GetExcelData();	
		excelData.getExcelData();
	}
}
	
class GetExcelData{
	public void getExcelData() throws IOException {

		FileInputStream file = new FileInputStream("C:\\AutomationSession\\automation_workspace\\HybridFramework\\Test-Data\\orange-hrm-data.xlsx");

		XSSFWorkbook book = new XSSFWorkbook(file);

		XSSFSheet sheet = book.getSheet("invalidLoginTest");

		int rowCount = sheet.getPhysicalNumberOfRows();
		int cellCount = sheet.getRow(0).getPhysicalNumberOfCells();

		Object[][] data = new Object[rowCount - 1][cellCount];

		DataFormatter format=new DataFormatter();
		
		for (int r = 1; r < rowCount; r++) {
			for (int c = 0; c < cellCount; c++) {
				data[r - 1][c] = format.formatCellValue(sheet.getRow(r).getCell(c));
				
			}
		}
		System.out.println(Arrays.deepToString(data));

		book.close();
		file.close();
	}

}

