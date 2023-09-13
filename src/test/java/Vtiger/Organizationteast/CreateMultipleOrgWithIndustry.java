package Vtiger.Organizationteast;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository1.CreatenewOrganisationPage;
import vtiger.ObjectRepository1.HomePage;
import vtiger.ObjectRepository1.LoginPage;
import vtiger.ObjectRepository1.OrganizationPage;
import vtiger.ObjectRepository1.OrgnaizationinfoPage;
import vtiger.genericutility.BaseClass;
import vtiger.genericutility.JavaUtility;
import vtiger.genericutility.WebDriverUtility;
import vtiger.genericutility.excelfileutility;
import vtiger.genericutility.propertyfileutility;

public class CreateMultipleOrgWithIndustry extends BaseClass{


	@Test(dataProvider = "getData")
	public void createMultipleOrg(String ORG, String INDUSTRYTYPE) throws Throwable {

		
		String ORGNAME = ORG+jUtil.getRandomNumber();

		// Step 3: Navigate to Organizations Link
		HomePage hp=new HomePage(driver);
		Thread.sleep(1000);
		hp.clickonOrganizationlnk();
		// Step 4: Click On create Organization Look Up Image
		OrganizationPage op=new OrganizationPage(driver);
		op.clickonOrgapp();

		// Step 5: Create Organization with mandatory Information
		CreatenewOrganisationPage cnop=new CreatenewOrganisationPage(driver);
		cnop.getIndustryedt(ORGNAME, INDUSTRYTYPE);
		
		// Step 8: Validate
		OrgnaizationinfoPage oip=new OrgnaizationinfoPage(driver);
		String orgHeader=oip.getHeader();
		Assert.assertTrue(orgHeader.contains(ORGNAME));
		System.out.println(orgHeader);
		
	
	}

	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException {
		Object[][] data = eUtil.readMultipleDataFromExcel("MultipleOrg");
		return data;
	}
}
