package org.qdPM.extentreport;
import com.aventstack.extentreports.ExtentTest;

public final class ExtentReportManager {

	private ExtentReportManager()
	{

	}

	private static ThreadLocal<ExtentTest> extentTestL= new ThreadLocal<ExtentTest>();

	public static ExtentTest getExtentTest()
	{
		return extentTestL.get();
	}

	public static void setExtentTest(ExtentTest extentTest)
	{
		extentTestL.set(extentTest);	
	}

	public static void closeExtentTest()
	{
		extentTestL.remove();
	}
}
