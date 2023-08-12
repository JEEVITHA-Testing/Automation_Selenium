package Vtiger.practice;

import vtiger.genericutility.JavaUtility;
import vtiger.genericutility.excelfileutility;
import vtiger.genericutility.propertyfileutility;

public class Genericutilitypractice {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		propertyfileutility pUtil=new propertyfileutility();
		String value = pUtil.readdatafrompropertyfile("browser");
		System.out.println(value);
	String UN = pUtil.readdatafrompropertyfile("username");
		System.out.println(UN);
		
		excelfileutility eUtil=new excelfileutility();
		String data = eUtil.readdatafromexcelsheet("Organization",1,2);
		System.out.println(data);
	eUtil.writedatafromexcelsheet("trialnow",5,3,"automation");
	System.out.println("data added");
		  JavaUtility jUtil=new JavaUtility();
		  System.out.println(jUtil.getRandomNumber());
		  System.out.println(jUtil.getSystemDate());
	}

}
