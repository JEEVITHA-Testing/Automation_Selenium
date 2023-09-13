package Vtiger.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyzerPractice {
	@Test(retryAnalyzer=vtiger.genericutility.RetryAnaliyserImplementation.class)
public void sample()

{	
		Assert.fail();
		System.out.println("jeevi");
}
}
