//https://www.youtube.com/watch?v=NtW4TLgKFHY&t=2s - Creating the Utility
//https://www.youtube.com/watch?v=FteLT8uiVbI&t=4s - Using the Utility with DataProvider


//THIS IS GOT FROM MY DATA DRIVEN TESTING PROJECT TO SEE IF THIS WORKS WITH TUTORIALNINJA




package com.tutorialsninja.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ReadXLSdata {

	//Just used for Testing Purpose
/*	public static void main(String[] args) throws EncryptedDocumentException, IOException {
	
		ReadXLSdata red = new ReadXLSdata();
		red.getData("login");

	}
	
*/
	
	
	@DataProvider(name="bvtdata")
	public String[][] getData(Method m) throws EncryptedDocumentException, IOException {
		
		String excelSheetName = m.getName();
		//Excel File Locations and SheetName
		File f = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\testdata\\TutorialNinjaTestdata.xlsx");  
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheetName = wb.getSheet(excelSheetName);
		
		//Dynamically Read Rows and Columns
		int totalRows = sheetName.getLastRowNum();
		System.out.println(totalRows);
		Row rowCells = sheetName.getRow(0);
		int totalCols = rowCells.getLastCellNum();
		System.out.println(totalCols);
		
		DataFormatter format = new DataFormatter();
		
		//Define Rows and Columns using 2 For Loops
		String testData[][] = new String[totalRows][totalCols];
		for(int i=1;i<=totalRows;i++) {
			for(int j=0;j<totalCols;j++) {
				testData[i-1][j]=format.formatCellValue(sheetName.getRow(i).getCell(j));
				System.out.println(testData[i-1][j]);
					
						
			}
				
		}
		
		
		return testData;
		
		
	}
		
}
