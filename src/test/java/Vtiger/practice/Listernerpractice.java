package Vtiger.practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(vtiger.genericutility.ListenersImplementation.class)
public class Listernerpractice {
@Test
public void demo()
{
	Assert.fail();
	System.out.println("Hi");
}
@Test(dependsOnMethods="demo")
public void demo1()
{
	System.out.println("Hello");
}
}
