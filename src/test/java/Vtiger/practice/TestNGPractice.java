package Vtiger.practice;

import org.testng.annotations.Test;

public class TestNGPractice {
@Test(invocationCount=2, priority=1)

	public void CreateCustomer()
	{
	System.out.println("create");
}

@Test( priority=-2)

	public void ModifyCustomer()
	{
	System.out.println("modify");
}

@Test( priority=-6)

	public void deleteCustomer()
	{
	System.out.println("delete");
}
}


