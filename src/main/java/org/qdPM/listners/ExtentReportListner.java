package org.qdPM.listners;

import java.io.IOException;

import org.qdPM.extentreport.ExtentReportManager;
import org.qdPM.extentreport.ExtentReportSetUp;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public final class ExtentReportListner implements ITestListener{


	static ExtentReports extentReport;
	ExtentTest extentTest;

	@Override
	public void onTestStart(ITestResult result) {

		extentTest = extentReport.createTest(result.getMethod().getMethodName());
		ExtentReportManager.setExtentTest(extentTest);
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		ExtentReportManager.getExtentTest().log(Status.PASS, "Test Case : "+ result.getMethod().getMethodName()+ " is passed. ");
		ExtentReportManager.closeExtentTest();
	}


	@Override
	public void onTestFailure(ITestResult result) {

		ExtentReportManager.getExtentTest().log(Status.FAIL, "Test Case : "+ result.getMethod().getMethodName()+ " is Failed. ");
		ExtentReportManager.closeExtentTest();
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		ExtentReportManager.getExtentTest().log(Status.PASS, "Test Case : "+ result.getMethod().getMethodName()+ " is Skipped. ");
		ExtentReportManager.closeExtentTest();
	}

	@Override
	public void onStart(ITestContext context) {

		try {
			extentReport = ExtentReportSetUp.reportSetUp();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onFinish(ITestContext context) {

		extentReport.flush();

	}



}
