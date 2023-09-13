package Vtiger.practice;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertionpractice {
@Test
public void test()
{
	System.out.println("Hi Started");
//	Assert.assertEquals("a", "b");
	Assert.assertEquals("a", "a");
	System.out.println("Hello is here ");
}
@Test
public void test2()
{
	SoftAssert sa=new SoftAssert();
	System.out.println("step1");
	//pass-10 SA -8SA
	Assert.assertEquals(false, true);
	System.out.println("step2");
	sa.assertTrue(false);//fail
	System.out.println("step3");
	sa.assertEquals(1, 2);//fail
	System.out.println("step4");
	sa.assertAll();
	
}
}
