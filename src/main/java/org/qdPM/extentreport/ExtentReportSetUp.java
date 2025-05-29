package org.qdPM.extentreport;

import java.io.IOException;

import org.qdPM.projectutililty.UtilityClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import javaUtilities.JavaUtilities;

public final class ExtentReportSetUp {

	private ExtentReportSetUp()
	{

	}
	
	// This is a setup file for extent report
	static String fileName = "report"+JavaUtilities.formatedDate()+".html";
	static ExtentReports extentReports;
	private static final String REPORTFILEPATH = "C:\\Users\\sumit\\Education\\Web_Automation\\org.qdPM\\Extent-Reports\\"+fileName; 
			//System.getProperty("User.dir"+"/Extent-Reports.report.html");
	
	public static ExtentReports reportSetUp() throws IOException
	{
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(REPORTFILEPATH);
		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReport);

		// Report Configuration		
		sparkReport.config().setDocumentTitle("qdPM");
		sparkReport.config().setReportName(System.getProperty("user.name"));
		sparkReport.config().setTheme(Theme.DARK);
		
		// System information
		extentReports.setSystemInfo("Executed on URL", UtilityClass.getPropertyValue("url"));
		extentReports.setSystemInfo("Executed on Browser", "Chrome");
		extentReports.setSystemInfo("Executed on O/S", System.getProperty("os.name"));
		extentReports.setSystemInfo("Executed by User", System.getProperty("user.name"));
		return extentReports;
	}


}
