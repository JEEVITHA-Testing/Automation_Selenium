package vtiger.genericutility;

import java.io.FileInputStream;
import java.util.Properties;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
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
/**
 * this method read multiple data from excel file for the sheet provider
 * @param sheetName
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
public Object[][]readMultipleDataFromExcel(String sheetName) throws EncryptedDocumentException, IOException
{
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	 Sheet sh = wb.getSheet(sheetName);
	 int lastRow=sh.getLastRowNum();
	int lastCel= sh.getRow(0).getLastCellNum();
	Object[][] data=new Object[lastRow][lastCel];
	for(int i=0;i<lastRow;i++)//navigate thru Rows3-0,1
	{
		for(int j=0;j<lastCel;j++)
		{                       //1-0,2-0
			data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
		}
	}
	return data;
}
}
