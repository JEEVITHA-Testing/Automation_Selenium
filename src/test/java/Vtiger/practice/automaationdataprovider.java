package Vtiger.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class automaationdataprovider {
	 @Test(dataProvider = "getInfo")
	 public void addProductToCart(String name, String model)  
	 {
System.out.println(name+" "+model/*+" - "+price*/);
	 }
	 @Test(dataProvider = "getData")
	 public void addProductToCart1(String name, String model,int price)  
	 {
System.out.println(name+" "+model+" - "+price);
	 }
	@DataProvider 
	public Object[][] getData()
	{
	//row //column
	Object[][] data = new Object[3][3]; // 4 sets of Data with 3 fields/info
	data[0][0] = "Samsung";
	data[0][1] ="A80";
	data[0][2]= 15000;
	
	data[1][0] ="Vivo";
	data[1][1]= "21";
	data[1][2] = 8000;
	
	data[2][0] ="Iphone";
	data[2][1] ="S13";
	data[2][2] =12000;
	return data;
}
	@DataProvider 
	public Object[][] getInfo()
	{
	//row //column
	Object[][] data = new Object[2][2]; // 4 sets of Data with 3 fields/info
	data[0][0] = "Samsung";
	data[0][1] ="A80";
	
	
	data[1][0] ="Vivo";
	data[1][1]= "21";
	return data;
	 }
}
