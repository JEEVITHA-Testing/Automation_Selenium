package Vtiger.practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class baseclasspractice {
	@Test
public void test()
{
	System.out.println("Test");
}
	@BeforeSuite
	public void bs()
	{
		System.out.println("BEFORE SUITE");
	}
	@AfterSuite
	public void as()
	{
		System.out.println("AFTER SUITE");
	}
	@BeforeClass
	public void bc()
	{
		System.out.println("BEFORE CLASS");
	}
	@AfterClass
	public void ac()
	{
		System.out.println("AFTER CLASS");
	}
	@BeforeMethod
	public void bm()
	{
		System.out.println("BEFORE METHOD");
	}
	@AfterMethod
	public void am()
	{
		System.out.println("AFTER METHOD");
	}
}
