package Vtiger.practice;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class ReadDataFromPropertyFile {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Step 1: Open the document in Java readable format 
		FileInputStream fis= new FileInputStream(".src\\test\\resources\\CommonData.properties");

		//Step 2: Create object of properties class java.util 
		Properties p= new Properties();
		//step 3: load the document into properties class
		 p.load(fis);
		//Step 4: provide the key and read the value
		 String BROWSER= p.getProperty("browser"); 
		 System.out.println(BROWSER);
		String USERNAME =p.getProperty("username"); 
		System.out.println(USERNAME);
	}

}
