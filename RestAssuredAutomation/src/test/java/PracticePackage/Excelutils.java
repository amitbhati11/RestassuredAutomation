package PracticePackage;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Excelutils {
	static XSSFWorkbook workbook;
	
	
	public static void getexcelred() {
		
		try {
		
			String xclpath="./exceldata/Datadriven.xlsx";
		workbook = new XSSFWorkbook (xclpath);
			XSSFSheet sheet=workbook.getSheet("Sheet1");
		int rowcount=sheet.getPhysicalNumberOfRows();
		
		System.out.println(rowcount);
			
		} catch (Exception exp) {
			// TODO Auto-generated catch block
			exp.printStackTrace();
		//	System.out.println(exp.getMessage());
		//	System.out.println(exp.getCause());
			
			
		}
	
		
	}
	public static void getreaddata() {
		try {
		String xclpath="./exceldata/Datadriven.xlsx";
		
		
			workbook = new XSSFWorkbook (xclpath);
			XSSFSheet sheet=workbook.getSheet("Sheet1");
			//String data=sheet.getRow(1).getCell(1).getStringCellValue();
			
	//	String data=sheet.getRow(1).getCell(2).getStringCellValue();
			
			// to avoid tycasting  we use data formatter n Object value
			
			DataFormatter fomater= new DataFormatter();
			
			Object value =fomater.formatCellValue(sheet.getRow(0).getCell(1));
			
			System.out.println(value);
		
		
		
		
		
		//System.out.println(data);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public static void main(String [] xyz) {
		getexcelred();
		getreaddata();
	}
	

}

