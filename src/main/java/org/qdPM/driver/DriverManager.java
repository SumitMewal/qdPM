package org.qdPM.driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

	// Private constructor to prevent the creation of new instances of Driver
	private static ThreadLocal<WebDriver> driverL= new ThreadLocal<WebDriver>();

	// Public method to access the driver instance (uses lazy instantiation)
	public static WebDriver getDriver()
	{
		return driverL.get();
	}

	public static void setDriver()
	{
		driverL.set(new ChromeDriver());	
	}

	/*
	Public method to quit the driver and 
	remove the current thread's value for this thread-local variable
	 */
	public void closeDriver()
	{
		driverL.get().quit();
		driverL.remove();
	}


}
