package Vtiger.ContactTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository1.ContactPage;
import vtiger.ObjectRepository1.ContactinfoPage;
import vtiger.ObjectRepository1.CreatenewContactPage;
import vtiger.ObjectRepository1.CreatenewOrganisationPage;
import vtiger.ObjectRepository1.HomePage;
import vtiger.ObjectRepository1.LoginPage;
import vtiger.ObjectRepository1.OrganizationPage;
import vtiger.ObjectRepository1.OrgnaizationinfoPage;
import vtiger.genericutility.BaseClass;

@Listeners(vtiger.genericutility.ListenersImplementation.class)
public class createcontactwithOrganizationTest extends BaseClass {
@Test(groups="ReggressionSuite")//(groups="SmokeSuite")
public void createcontactwithOrgTest() throws Throwable
{
			
				/* read Data from ExcelFile */
				String ORGNAME = eUtil.readdatafromexcelsheet("Contacts", 4, 2) + jUtil.getRandomNumber();
				String LASTNAME = eUtil.readdatafromexcelsheet("Contacts", 4, 3);

		
//Step 3: Navigate to Organizations Link
				HomePage hp = new HomePage(driver);
			hp.clickonOrganizationlnk();
Reporter.log("clicked on Organisation link");
				// Step 4: Click On create Organization Look Up Image
			OrganizationPage op = new OrganizationPage(driver);
				op.clickonOrgapp();
				Reporter.log("clicked on Organisation lookup image");
				// Step 5: Create Organization with mandatory Information
				CreatenewOrganisationPage cnop = new CreatenewOrganisationPage(driver);
				cnop.industryapp(ORGNAME);
				Reporter.log(" Organisation created");
				// Step 8: Validate
				OrgnaizationinfoPage oip = new OrgnaizationinfoPage(driver);
				String orgHeader = oip.getHeader();
Assert.assertTrue(orgHeader.contains(ORGNAME));
System.out.println(orgHeader);

				//Step 9: Click on Contacts Link
				hp.clickonContactlnk();
				Reporter.log("clicked on contacts link");
				//Step 10: Click on Create Contact Look Up image
				ContactPage cp = new ContactPage(driver);
				cp.getLookupimg();
				Reporter.log("clicked on contacts lookup image");
				//Step 11: create Contact using the organization
				CreatenewContactPage cncp = new CreatenewContactPage(driver);
				cncp.createNewContact(LASTNAME, ORGNAME, driver);
				Reporter.log("create contact");
				//Step 12: Validate for Contacts
				ContactinfoPage cip = new ContactinfoPage(driver);
				String ContactHeader = cip.getContactHeader();
				Assert.assertTrue(ContactHeader.contains(LASTNAME));
				System.out.println(ContactHeader);
				
			}
@Test
public void demo1()
{
	System.out.println("demo");
}

	}


