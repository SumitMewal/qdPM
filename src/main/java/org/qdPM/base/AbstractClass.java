package org.qdPM.base;

import org.qdPM.driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class AbstractClass {

	@BeforeMethod
	public static void initDriver()
	{
		DriverManager.setDriver();
		DriverManager.getDriver().get("http://localhost:8091/");
	}

	@AfterMethod
	public static void tearDown()
	{
		DriverManager.getDriver().quit();
	}
}
