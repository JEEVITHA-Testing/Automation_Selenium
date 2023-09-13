package vtiger.ObjectRepository1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgnaizationinfoPage {
@FindBy(xpath="//span[@class='dvHeaderText']")
private WebElement headertxt;
//initilize
public OrgnaizationinfoPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
public WebElement getHeadertxt() {
	return headertxt;
}
public String getHeader()
{
	return headertxt.getText();
}

}
