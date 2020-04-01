package seleniumpackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeTest;

public class ClassMain extends Selenium_Operations{
	
	@BeforeTest
	public void MainMethod() throws IOException, InterruptedException {
		int Column_Count = 0;
		LinkedList<String> Key = new LinkedList<String>();
		LinkedList<String> Value = new LinkedList<String>();
		
		File Excel = new File("C:\\Users\\Satish\\eclipse-workspace\\7am_to_8am_Batch\\TestDataFolder\\TestDataWorkbook.xlsx");
		FileInputStream Read_Write = new FileInputStream(Excel);
		
		XSSFWorkbook Wb = new XSSFWorkbook(Read_Write);
		XSSFSheet DataSheet = Wb.getSheet("TestDataSheet");
		
		DataFormatter formatter = new DataFormatter();
		
		int Row_Count = DataSheet.getLastRowNum()-DataSheet.getFirstRowNum();
		System.out.println(Row_Count);
		
		for(int i=0;i<Row_Count;i++) {
			Column_Count = DataSheet.getRow(i).getLastCellNum();
			for(int j=0;j<Column_Count;j++) {
				String value = formatter.formatCellValue(DataSheet.getRow(i).getCell(j));
				Key.add(value);
			}
		}
		System.out.println(Key);
		
		for(int i=1;i<=Row_Count;i++) {
			for(int j=0;j<Column_Count;j++) {
				String value = formatter.formatCellValue(DataSheet.getRow(i).getCell(j));
				Value.add(value);
			}
		}
		System.out.println(Value);
		
		for(int i=0;i<Key.size();i++) {
			Data.put(Key.get(i), Value.get(i));
		}
		System.out.println(Data);
	//	MethodMain();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
