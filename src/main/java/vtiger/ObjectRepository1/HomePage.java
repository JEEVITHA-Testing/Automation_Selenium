package vtiger.ObjectRepository1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.genericutility.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	//declaration
@FindBy(linkText="Organizations")
private WebElement Organizationlnk;
@FindBy(linkText="Contacts")
private WebElement Contactslnk;
@FindBy(linkText="Products")
private WebElement Productslnk;
@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
private WebElement administrationlink;
@FindBy(linkText="Sign Out")
private WebElement signoutlnk;
//initilization
public HomePage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
//utilization
public WebElement getOrganizationlnk() {
	return Organizationlnk;
}
public WebElement getContactslnk() {
	return Contactslnk;
}

public WebElement getProductslnk() {
	return Productslnk;
}

public WebElement getAdministrationlink() {
	return administrationlink;
}

public WebElement getSignoutlnk() {
	return signoutlnk;

}
//Business Library
public void logoutapp(WebDriver driver)
{
	mouseHoverAction(driver,administrationlink);
	signoutlnk.click();
}
public void clickonOrganizationlnk()
{
	Organizationlnk.click();
}
public void clickonContactlnk()
{
	Contactslnk.click();
}
}
