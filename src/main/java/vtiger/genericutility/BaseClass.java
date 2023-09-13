package vtiger.genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository1.HomePage;
import vtiger.ObjectRepository1.LoginPage;

/**
 * this generic class consisting of all basic configuration
 * annotation of TestNG
 * @author Lenovo
 *
 */
public class BaseClass {
	public JavaUtility jUtil = new JavaUtility();
	public propertyfileutility pUtil = new propertyfileutility();
	public excelfileutility eUtil = new excelfileutility();
	public WebDriverUtility wUtil =new  WebDriverUtility();		
public WebDriver driver = null;
public static WebDriver sdriver;
	@BeforeSuite(alwaysRun = true)
public void bsconfig()
{
	System.out.println("======database connected====");
}
	//@Parameters("browser")
	//@BeforeTest
@BeforeClass(alwaysRun = true)
public void bcConfig(/*String BROWSER*/) throws Throwable
{
	String BROWSER = pUtil.readdatafrompropertyfile("browser");
	String URL = pUtil.readdatafrompropertyfile("url");
	if (BROWSER.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	} else if (BROWSER.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	} else if (BROWSER.equalsIgnoreCase("edge")) {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	} else {
		System.out.println("Invalid Browser name");
	}

	wUtil.maximiseWindow(driver);
	wUtil.waitForpageLoad(driver);
	driver.get(URL);
	sdriver=driver;
	System.out.println(BROWSER+"======Browser Launched======");
}
@BeforeMethod(alwaysRun = true)
public void bmConfig() throws Throwable
{
	String USERNAME = pUtil.readdatafrompropertyfile("username");
	String PASSWORD = pUtil.readdatafrompropertyfile("password");
	LoginPage lp=new LoginPage(driver);
	lp.loginToApp(USERNAME, PASSWORD);
	System.out.println("======Login Sucessfully====");
}
@AfterMethod(alwaysRun = true)
public void amConfig() throws Throwable
{
	HomePage hp=new HomePage(driver);
	hp.logoutapp(driver);
	System.out.println("======LogOut Sucessfully====");
}
//@AfterTest
@AfterClass(alwaysRun = true)
public void acconfig()
{
driver.quit();
System.out.println("======Browser Closed===");
}
@AfterSuite(alwaysRun = true)
public void asconfig()
{
	System.out.println("======database connected closed====");	

}

}



