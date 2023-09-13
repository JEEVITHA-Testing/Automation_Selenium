package vtiger.ObjectRepository1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.genericutility.WebDriverUtility;

public class CreatenewOrganisationPage extends WebDriverUtility {
	//declaration
@FindBy(name="accountname")
private WebElement orgnameedt;
@FindBy(name="industry")
private WebElement industryedt;
@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement savebtn;
//initialization
public CreatenewOrganisationPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
//utilization
public WebElement getOrgnameedt() {
	return orgnameedt;
}


public WebElement getIndustryedt() {
	return industryedt;
}

public WebElement getSavebtn() {
	return savebtn;
}


//Businesslibrary
public void industryapp(String orgName)
{
	orgnameedt.sendKeys(orgName);
	savebtn.click();
}


public void getIndustryedt(String oRGNAME, String iNDUSTRYTYPE) 
	{orgnameedt.sendKeys(oRGNAME);
	handleDropdown(iNDUSTRYTYPE, industryedt);
	savebtn.click();
}
}

