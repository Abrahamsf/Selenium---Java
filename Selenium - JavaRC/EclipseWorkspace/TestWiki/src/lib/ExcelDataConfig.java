package lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelDataConfig {
	
	XSSFWorkbook wb;
	XSSFSheet sheet1;
	XSSFRow columnNumber;
	
	public ExcelDataConfig(String excelPath){
		
		try 
		{
				File src = new File(excelPath);
				FileInputStream fis = new FileInputStream(src);
				
				wb = new XSSFWorkbook(fis);
						
		} 
		catch (Exception e)
		{
			System.out.println(e.getMessage());
				
		}
		
	}

	
	public String getData(int sheetNumber,int row, int column){
		
		sheet1 = wb.getSheetAt(sheetNumber);
		String data = sheet1.getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	
	public int getRowCount(int sheetIndex){
		
		int row = wb.getSheetAt(sheetIndex).getLastRowNum();
		row = row+1;
		
		return row;
	}
	
	public int getColumnCount(int sheetIndex){
		
		sheet1 = wb.getSheetAt(sheetIndex);
		int col = sheet1.getRow(0).getLastCellNum();
		
		return col;
	}
	
}
