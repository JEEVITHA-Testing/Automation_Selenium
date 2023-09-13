package Vtiger.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class testngAssert {
	@Test

	public void CreateCustomer()//fail
	{
		Assert.fail();
	System.out.println("create");
	}
@Test(dependsOnMethods="CreateCustomer")

	public void ModifyCustomer()
	{
	System.out.println("modify");
}

@Test(dependsOnMethods={"CreateCustomer","ModifyCustomer"})

	public void deleteCustomer()
	{
	System.out.println("delete");
}
}
