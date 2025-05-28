package org.qdPM.extentreport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentReportManager {
	
	private ExtentReportManager()
	{
		
	}

	private static ThreadLocal<ExtentTest> extentTestL= new ThreadLocal<ExtentTest>();

	// Public method to access the driver instance (uses lazy instantiation)
	public static ExtentTest getExtentTest()
	{
		return extentTestL.get();
	}

	public static void setDriver(ExtentTest extentTest)
	{
		extentTestL.set(extentTest);	
	}

}
