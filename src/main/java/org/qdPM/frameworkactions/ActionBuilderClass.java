package org.qdPM.frameworkactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.qdPM.driver.DriverManager;
import org.qdPM.extentreport.ExtentReportManager;

import com.aventstack.extentreports.Status;
public class ActionBuilderClass {

	protected ActionBuilderClass()
	{

	}

	/* Sendkeys 
	 * Click
	 * MouseHover
	 * Select DropDown
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	public static void sendkeys(WebElement element, String sendKeys, String elementName)
	{
		element.sendKeys(sendKeys);
		ExtentReportManager.getExtentTest().log(Status.INFO,"Value : "+sendKeys+" passed in element"+elementName);
	}
	
	public static void click(WebElement element, String elementName)
	{
		element.click();
		ExtentReportManager.getExtentTest().log(Status.INFO,"Element : "+elementName+" clicked !!");
	}





}
