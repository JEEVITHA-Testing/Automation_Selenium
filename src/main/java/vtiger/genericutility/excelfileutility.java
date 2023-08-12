package vtiger.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
  * this class contain reusable method used for excel file
  * @author Lenovo
  *
  */
public class excelfileutility {
	/**
	 * this method will read data from property file and return the value of caller
	 * @param key 
	 * @return
	 * @throws Throwable
	 */
public String readdatafromexcelsheet(String sheetname,int rownum,int celno) throws Throwable
{
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
 String data = wb.getSheet(sheetname).getRow(rownum).getCell(celno).getStringCellValue();
wb.close();
return data;
}
public void writedatafromexcelsheet(String sheet,int rownum,int celNum ,String value) throws Throwable
{

FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
Workbook wb = WorkbookFactory.create(fis);
wb.createSheet(sheet).createRow(rownum).createCell(celNum).setCellValue(value);
FileOutputStream fos= new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
wb.write(fos);
wb.close();
}
}
