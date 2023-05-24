package com.tutorialsninja.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;






public class Utilities {
	
	//This is to remove hard coding for Implicit Wait Time and Page Load time from Base Class--**THIS DID NOT WORK FOR ME***
	public static int IMPLICIT_WAIT_TIME=10;
	public static int PAGE_LOAD_TIME=5;
	
	
	
	//Created Method to add timestamp to the incorrect test cases so it doesn't fail after 5 attempts
	public static String generateEmailWithTimeStamp() {
		//made static so it can be accesses by other classes
		
		Date date = new Date();
		String timestamp = date.toString().replace(" ","-").replace(":","-");
		return "amotoori"+timestamp+"@gmail.com";
		
	}
		
		
	
		
		// Method for accessing the Excel Sheet Name

	public static Object[][] getTestDataFromExcel(String sheetName) {
		File excelFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\testdata\\TutorialsNinjaTestData.xlsx");
		XSSFWorkbook workbook = null;
		try {
			FileInputStream fisExcel = new FileInputStream(excelFile);
			workbook = new XSSFWorkbook(fisExcel);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		XSSFSheet sheet = workbook.getSheet(sheetName);
		
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[rows][cols];
		
		for(int i=0;i<rows;i++) {
			
			XSSFRow row = sheet.getRow(i+1);
			
			for(int j=0;j<cols;j++) {
				
				XSSFCell cell = row.getCell(j);
				CellType cellType = cell.getCellType();
				
				switch(cellType) {
				
				case STRING:
					data[i][j] = cell.getStringCellValue();
					break;
				case NUMERIC:
					data[i][j] = Integer.toString((int)cell.getNumericCellValue());
					break;
				case BOOLEAN:
					data[i][j] = cell.getBooleanCellValue();
					break;	
		
				}
				
			}
			
			
		}
		
		return data;
		
	}
	
}



