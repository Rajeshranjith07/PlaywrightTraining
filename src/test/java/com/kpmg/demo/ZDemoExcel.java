package com.kpmg.demo;

import java.io.FileInputStream;
import java.io.IOException;

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
		for(int i=0;i<2;i++)
		{
			for(int j=0;j<2;j++)
			{
				String demoValue= sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.println(demoValue);
				
			}	
		}
		
		book.close();
		file.close();
	}

}
