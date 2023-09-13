package Vtiger.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import vtiger.ObjectRepository1.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository1.CreatenewOrganisationPage;
import vtiger.ObjectRepository1.HomePage;
import vtiger.ObjectRepository1.LoginPage;
import vtiger.ObjectRepository1.OrganizationPage;
import vtiger.genericutility.JavaUtility;
import vtiger.genericutility.WebDriverUtility;
import vtiger.genericutility.excelfileutility;
import vtiger.genericutility.propertyfileutility;

public class createorgwithindustryusingguwithPomclass {

	public static void main(String[] args)  throws Throwable{
	
		//Create Objects of all Utility Classes
		JavaUtility jUtil = new JavaUtility();
		propertyfileutility pUtil = new propertyfileutility();
		excelfileutility eUtil = new excelfileutility();
		WebDriverUtility wUtil =new  WebDriverUtility();		
		WebDriver driver = null;
		
		//Step 1: Read All the Data required QCO-SOEAJD-M2 - sh0bha 10am to 12pm -JDBC
		
		 /*read Data from Property file*/
		String BROWSER = pUtil.readdatafrompropertyfile("browser");
		String URL = pUtil.readdatafrompropertyfile("url");
		String USERNAME = pUtil.readdatafrompropertyfile("username");
		String PASSWORD = pUtil.readdatafrompropertyfile("password");
		
		 /*read Data from ExcelFile*/
		String ORGNAME = eUtil.readdatafromexcelsheet("Organization", 4, 2)+jUtil.getRandomNumber();
		String INDUSTRYTYPE = eUtil.readdatafromexcelsheet("Organization", 4, 3);
				
		//Step 2: Launch the browser - //Run Time Polymorphism - driver
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
	    
	    
	    wUtil.maximiseWindow(driver);
		wUtil.waitForpageLoad(driver);
		driver.get(URL);
		
		//Step 2: Login To Application
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		 //login operation
		
		
//		lp.getUserNameEdt().sendKeys(USERNAME);
//		lp.getPasswordEdt().sendKeys(PASSWORD);
//		lp.getLoginBtn().click();
		
			
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
		
		//Step 3: Navigate to Organizations Link
	//	driver.findElement(By.linkText("Organizations")).click();
		HomePage hp=new HomePage(driver);
		Thread.sleep(1000);
		hp.clickonOrganizationlnk();
		//Step 4: Click On create Organization Look Up Image
	//	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		OrganizationPage op=new OrganizationPage(driver);
		op.clickonOrgapp();
		
		//Step 5: Create Organization with mandatory Information
	//	driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		CreatenewOrganisationPage cnop=new CreatenewOrganisationPage(driver);
		cnop.getIndustryedt(ORGNAME, INDUSTRYTYPE);
		
		
		//Step 8: Validate
		//String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		OrgnaizationinfoPage oip=new OrgnaizationinfoPage(driver);
		String orgHeader=oip.getHeader();
		if(orgHeader.contains(ORGNAME))
		{
			System.out.println("PASS");
			System.out.println(orgHeader);
		}
		else
		{
			System.out.println("FAIL");
		}
		
		//Step 9: Logout of App
		hp.logoutapp(driver);
		
		//Step 10: Close the browser
		driver.quit();
		
	}
	}

