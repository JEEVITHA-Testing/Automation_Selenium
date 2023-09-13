package vtiger.ObjectRepository1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactinfoPage {
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headertxt;
	//initilize
	public ContactinfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilize
	public WebElement getHeadertxt() {
		return headertxt;
	}
//business
public String getContactHeader()
{
	return headertxt.getText();
}

}
