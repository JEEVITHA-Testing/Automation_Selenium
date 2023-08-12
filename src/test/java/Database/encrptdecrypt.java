package Database;

import java.util.Base64;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class encrptdecrypt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String encryptedUsername= new String(Base64.getEncoder().encode("admin".getBytes()));
		String encryptedpassword=new String(Base64.getEncoder().encode("admin" .getBytes()));

		System.out.println(encryptedUsername);
		System.out.println(encryptedpassword);
		String decryptedUsername= new String(Base64.getDecoder().decode(encryptedUsername.getBytes()));
		String decryptedpassword=new String(Base64.getDecoder().decode(encryptedpassword.getBytes()));
		WebDriverManager.chromedriver().setup();

		WebDriver driver=new ChromeDriver();
				driver.get("http:localhost:8888/"); 
				driver.findElement(By.name("user_name")).sendKeys(decryptedUsername);
				driver.findElement(By.name("user_password")).sendKeys(decryptedpassword); 
				driver.findElement(By.id("submitButton")).click();
	}

}
