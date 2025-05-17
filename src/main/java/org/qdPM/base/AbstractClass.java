package org.qdPM.base;
import java.io.IOException;
import org.qdPM.driver.DriverManager;
import org.qdPM.projectUtililty.UtilityClass;
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
	}

	@AfterMethod
	public static void tearDown()
	{
		DriverManager.getDriver().quit();
	}


}
