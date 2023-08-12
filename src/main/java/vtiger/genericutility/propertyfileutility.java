package vtiger.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * this class consists of generic/resuable methods related to property file
 * @author Lenovo
 *
 */
public class propertyfileutility {
/**
 * this method will read data from property file and return the value of caller
 * @param key
 * @return
 * @throws Throwable
 */
	public String readdatafrompropertyfile(String key) throws Throwable {
		// TODO Auto-generated method stub
FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
Properties p=new Properties();
p.load(fis);
 String value = p.getProperty(key);
 return value;
	}

}
