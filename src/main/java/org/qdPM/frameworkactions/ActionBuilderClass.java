package org.qdPM.frameworkactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
	static Actions actionObj = new Actions(DriverManager.getDriver());
	public static void sendkeys(By by, String sendKeys)
	{
		WebElement element = DriverManager.getDriver().findElement(by);
		element.clear();
		element.sendKeys(sendKeys);
		ExtentReportManager.getExtentTest().log(Status.INFO,"Value : "+sendKeys+" entered in text box");
	}

	public static void click(By by)
	{
		WebElement element = DriverManager.getDriver().findElement(by);
		element.click();
		ExtentReportManager.getExtentTest().log(Status.INFO,"Element clicked !!");
	}
	public static void hoverToElement(By by)
	{
		actionObj.moveToElement(DriverManager.getDriver().findElement(by)).build().perform();
		ExtentReportManager.getExtentTest().log(Status.INFO,"Hovered on Element");
	}
}
