package vtiger.ObjectRepository1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	//declaration
@FindBy(xpath="//img[@title='Create Organization...']")
private WebElement lookupimg;
//initilization
public OrganizationPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
//utilization
public WebElement getLookupimg() {
	return lookupimg;
}


//businesslibrary
/**
 * this method will click on create organization lookup image
 */
public void clickonOrgapp()
{
	lookupimg.click();
}
}
