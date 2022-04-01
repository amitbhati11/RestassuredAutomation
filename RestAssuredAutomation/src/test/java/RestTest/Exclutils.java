package RestTest;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exclutils {
	
	public static void getExcelreaddata() {
		
		String xlpath="./exceldata/Datadriven.xlsx";
		
		try {
			XSSFWorkbook workbook=new XSSFWorkbook(xlpath);
			
			XSSFSheet sheet=workbook.getSheet("Sheet1");
			
		DataFormatter formater=new DataFormatter();
		
	Object data=sheet.getRow(0).getCell(0);
			
			System.out.println(data);
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			
			
		}
	}
		
		public static void main(String [] xyz) {
			
			getExcelreaddata();
		}
		
	}


