package Vtiger.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class demo {
	public static void main(String[] args) throws InterruptedException  {
		// TODO Auto-generated method stub

		// Step 1: Launch The Browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
}
}