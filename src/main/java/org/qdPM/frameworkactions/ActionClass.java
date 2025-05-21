package org.qdPM.frameworkactions;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.qdPM.driver.DriverManager;

public final class ActionClass {

	private ActionClass()
	{
		
	}
	
	static Actions actionObj = new Actions(DriverManager.getDriver());;
	public static void hoverToElement(By by)
	{
		actionObj.moveToElement(DriverManager.getDriver().findElement(by));
	
	}
	
	
	
	
	
	
	
	
	
	
}
