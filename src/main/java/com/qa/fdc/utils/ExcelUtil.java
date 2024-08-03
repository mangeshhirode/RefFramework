package com.qa.fdc.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	public static String TEST_DATA_SHEET_PATH = ".src.test.resources\\testdata\\automationProductSheet.xlsx";

	private static Workbook book;
    private static Sheet sheet;
	public static Object[][]  getTestData(String sheetName) {
		System.out.println("debug  :  2");

		Object[][] data=null;
		try {
			System.out.println("debug  :  3");

			FileInputStream ip = new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\Automation_22062024\\FDCFramework\\src.test.resources\\testdata\\automationProductSheet.xlsx");
			System.out.println("debug  :  4");

			book = WorkbookFactory.create(ip);
			System.out.println("debug  :  5");

		  sheet=book.getSheet(sheetName);
		   data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		  for(int i=0;i<sheet.getLastRowNum();i++) {
			  for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
				  data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			  }
		  }
		   
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (EncryptedDocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
return data;
	}
}
