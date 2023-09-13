package vtiger.ObjectRepository1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.genericutility.WebDriverUtility;

public class CreatenewContactPage extends WebDriverUtility {
@FindBy(name="lastname")
private WebElement lastnameedt;
@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement savebtn;
@FindBy(xpath = "//input[@name='account_name']/following-sibling::img[@title='Select']")
private WebElement OrgLookUpImg;
@FindBy(name = "search_text") 
private WebElement OrgSearchEdt;
@FindBy(name = "search")
private WebElement OrgSearchBtn;
//initialize
public CreatenewContactPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
//utilize
public WebElement getLastnameedt() {
	return lastnameedt;
}
public WebElement getSavebtn() {
	return savebtn;
}
public WebElement getOrgLookUpImg() {
	return OrgLookUpImg;
}
public WebElement getOrgSearchEdt() {
	return OrgSearchEdt;
}
public WebElement getOrgSearchBtn() {
	return OrgSearchBtn;
}
//bussiness library
/**
 * This method will create contact with Mandatory fields
 * @param LASTNAME
 */
public void createNewContact(String LASTNAME)
{
	lastnameedt.sendKeys(LASTNAME);
	savebtn.click();		
}

/**
 * This method will create Contact using Organization
 * @param LASTNAME
 * @param ORGNAME
 * @param driver
 */
public void createNewContact(String LASTNAME, String ORGNAME, WebDriver driver)
{
	lastnameedt.sendKeys(LASTNAME);
	OrgLookUpImg.click();
	switchToWindow(driver, "Accounts");
	OrgSearchEdt.sendKeys(ORGNAME);
	OrgSearchBtn.click();
	driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click(); //dynamic xpath
	//a[text()='ch399'] - regular xpath for reference
	//a[text()='"+ORGNAME+"'] -> Dynamic Xpath
	//driver.findElement(By.linkText(ORGNAME));
	switchToWindow(driver, "Contacts");
	savebtn.click();
}
}
