package Vtiger.practice;

import org.openqa.selenium.WebElement;
import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class createorgwithcontact {
	public static void main(String[] args) throws InterruptedException  {
		// TODO Auto-generated method stub

		// Step 1: Launch The Browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888");

		// Step 2: Login To Application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//Step 3: click on contacts LInk
		driver.findElement(By.linkText("Contacts")).click();
		
		//Step 4: click on create contact look up Image
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		//step 5: create contact using mandatory fields
		driver.findElement(By.name("lastname")).sendKeys("spiderMan");
		
		
		//Step 10 : save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step 11: Validate
		String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(contactHeader.contains("spiderMan"))
		{
			System.out.println("PASS");
			System.out.println(contactHeader);
		}
		else
		{
			System.out.println("FAIL");
		}
		
		//step 12: logout
		WebElement mouseHover = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(mouseHover).perform();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Logout successfull");
		
		
		//Step 13: Close the browser
		driver.quit();
		
		
	}

}
