package vtiger.ObjectRepository1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	 //Rule - Create a seperate pom class for every web page
	
		//Rule 2: Identify the web Elements using @FindBy, @FindAll, @FindBys
		//Declaration
		@FindBy(name = "user_name")
		private WebElement userNameEdt;
		
		@FindBy(name = "user_password")
		private WebElement passwordEdt;
		
		@FindBy(id = "submitButton")
		private WebElement loginBtn;
		
		//Rule 3: Create a constructor to initialize the web elements
		//Initialization
		public LoginPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		//Rule 4: provide getters for accessing the web elements
		//Utilization
		public WebElement getUserNameEdt() {
			return userNameEdt;
		}

		public WebElement getPasswordEdt() {
			return passwordEdt;
		}

		public WebElement getLoginBtn() {
			return loginBtn;
		}

		//Rule 5: Provide business library - Framework developers idea
		          //- is a generic method created using web elements present only in current page 
		
		/**
		 * This method will Login to application
		 * @param USERNAME
		 * @param PASSWORD
		 */
		public void loginToApp(String USERNAME, String PASSWORD)
		{
			userNameEdt.sendKeys(USERNAME);
			passwordEdt.sendKeys(PASSWORD);
			loginBtn.click();
		}
		
}
