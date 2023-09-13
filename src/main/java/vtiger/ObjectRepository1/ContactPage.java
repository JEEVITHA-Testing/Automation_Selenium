package vtiger.ObjectRepository1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement Contactlookupimg;
	//initilization
	public ContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization
	public WebElement getLookupimg() {
		return Contactlookupimg;
	}


	//businesslibrary
	public void Orgapp()
	{
		Contactlookupimg.click();
	}
}
