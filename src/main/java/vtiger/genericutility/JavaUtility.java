package vtiger.genericutility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
/**
 * 
 * @author Lenovo
 *
 */
public class JavaUtility {
	/**
	 * 
	 * @return
	 */
public int getRandomNumber()
{
	Random r=new Random();
	return r.nextInt(1000);
}
/**
 * 
 * @return
 */
public String getSystemDate() {
	Date d=new Date();
	SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
	String date=formatter.format(d);
	return date;
}
}
