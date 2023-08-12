package Vtiger.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class createOrganisation {

	public static void main(String[] args) throws Throwable {
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
				driver.findElement(By.linkText("Organizations")).click();
				driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
				driver.findElement(By.name("accountname")).sendKeys("spiderMan1");
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				Thread.sleep(1000);
				String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(contactHeader.contains("spiderMan1"))
		{
			System.out.println("PASS");
			System.out.println(contactHeader);
		}
		else
		{
			System.out.println("FAIL");
		}
				
				//Step 9: Logout of App
				WebElement mouseHover = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				Actions act = new Actions(driver);
				act.moveToElement(mouseHover).perform();
				Thread.sleep(1000);
				driver.findElement(By.linkText("Sign Out")).click();	
				//Step 10: Close the browser
				driver.quit();
	}

}
