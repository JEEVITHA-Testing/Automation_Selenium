package Vtiger.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class writedataintoexcelsheet {

	public static void main(String[] args) throws Throwable, IOException {
		// TODO Auto-generated method stub
		//Step 1: Open the document in Java readable format
		FileInputStream fis =new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");

		//Step 2: Create a workbook

		Workbook wb = WorkbookFactory.create(fis); 
		//Step 3: navigate to Sheet

		Sheet sh=wb.createSheet("trial");
		//Sheet sh=wb.getSheet("trial");
		//Step 4: navigate to Row Row 
		Row rw =sh.createRow(2);

		//Step 5: create a cell Cell 
		Cell cl=rw.createCell(3);

		//Step 6: provide Data to be written

		cl.setCellValue("SELENIUM"); 
		//Step 7: open document in java write format

		FileOutputStream fos =new FileOutputStream(".\\src\\\\test\\\\resources\\\\TestData.xlsx");

		//Step 8: write the data

		wb.write(fos); 
		System.out.println("Data added successfully");
		//step 9:close
		wb.close();
	}

}
