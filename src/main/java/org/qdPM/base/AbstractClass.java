package org.qdPM.base;
import java.io.IOException;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

import org.qdPM.driver.DriverManager;
import org.qdPM.projectutililty.UtilityClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class AbstractClass {

	// protected used instead of private as it's the parent class for all my test classes
	protected AbstractClass()
	{

	}

	@BeforeMethod
	public static void initDriver() throws IOException 
	{
		DriverManager.setDriver();
		DriverManager.getDriver().get(UtilityClass.getValue("url"));
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

	@AfterMethod
	public static void tearDown()
	{
		DriverManager.getDriver().quit();
	}


}
