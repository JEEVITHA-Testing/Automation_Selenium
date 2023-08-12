package Vtiger.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.genericutility.JavaUtility;
import vtiger.genericutility.WebDriverUtility;
import vtiger.genericutility.excelfileutility;
import vtiger.genericutility.propertyfileutility;

public class createOrgwithindustryusingGU {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
JavaUtility jUtility=new JavaUtility();
propertyfileutility pUtility=new propertyfileutility();
excelfileutility eUtility=new excelfileutility();
WebDriverUtility wUtility=new WebDriverUtility();
WebDriver driver=null;
//step1:Read All Data Required
/*read Data from Property file*/
String BROWSER = pUtility.readdatafrompropertyfile("browser");
String URL = pUtility.readdatafrompropertyfile("url");
String USERNAME = pUtility.readdatafrompropertyfile("username");
String PASSWORD = pUtility.readdatafrompropertyfile("password");
/*read data from ExcelFile */
String ORGNAME = eUtility.readdatafromexcelsheet("Organization", 4, 2)+jUtility.getRandomNumber();
String INDUSTRYTYPE = eUtility.readdatafromexcelsheet("Organization", 4, 3);
//step2:launch the browser//Run Time Polymorphism-driver
if(BROWSER.equalsIgnoreCase("chrome"))
{
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
}
else if(BROWSER.equalsIgnoreCase("firefox"))
{
	WebDriverManager.firefoxdriver().setup();
	driver = new FirefoxDriver();
}
else if(BROWSER.equalsIgnoreCase("edge"))
{
	WebDriverManager.edgedriver().setup();
	driver = new EdgeDriver();
}
else
{
	System.out.println("Invalid Browser name");
}
wUtility.maximiseWindow(driver);
wUtility.waitForpageLoad(driver);
driver.get(URL);
//Step2:Login to application
driver.findElement(By.name("user_name")).sendKeys(USERNAME);
driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
driver.findElement(By.id("submitButton")).click();
//Step 3: Navigate to Organizations Link
driver.findElement(By.linkText("Organizations")).click();

//Step 4: Click On create Organization Look Up Image
driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

//Step 5: Create Organization with mandatory Information
driver.findElement(By.name("accountname")).sendKeys(ORGNAME);

//Step 6: Select 'Chemicals' in industry Drop down
WebElement dropDown = driver.findElement(By.name("industry"));
Select sel = new Select(dropDown);
sel.selectByValue(INDUSTRYTYPE);

//Step 7: Save 
driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

//Step 8: Validate
String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
if(orgHeader.contains(ORGNAME))
{
	System.out.println("PASS");
	System.out.println(orgHeader);
}
else
{
	System.out.println("FAIL");
}
WebElement mouseHover = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
wUtility.mouseHoverAction(driver, mouseHover);
Thread.sleep(1000);
driver.findElement(By.linkText("Sign Out")).click();

//Step 10: Close the browser
driver.quit();
	}

}
