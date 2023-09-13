package Vtiger.Organizationteast;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import vtiger.ObjectRepository1.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository1.CreatenewOrganisationPage;
import vtiger.ObjectRepository1.HomePage;
import vtiger.ObjectRepository1.LoginPage;
import vtiger.ObjectRepository1.OrganizationPage;
import vtiger.genericutility.BaseClass;
import vtiger.genericutility.JavaUtility;
import vtiger.genericutility.WebDriverUtility;
import vtiger.genericutility.excelfileutility;
import vtiger.genericutility.propertyfileutility;

public class createorgwithindustryusingguwithPomclassTest extends BaseClass{
@Test
	public void createorgwithindustry() throws Throwable
	{
		
		
		
		 /*read Data from ExcelFile*/
		String ORGNAME = eUtil.readdatafromexcelsheet("Organization", 4, 2)+jUtil.getRandomNumber();
		String INDUSTRYTYPE = eUtil.readdatafromexcelsheet("Organization", 4, 3);
				
		
		
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
		Assert.assertTrue(orgHeader.contains(ORGNAME));
		System.out.println(orgHeader);
	
	}
	}

