package org.qdPM.base;
import java.io.IOException;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.qdPM.driver.DriverManager;
import org.qdPM.pageobject.SidebarMenuPage;
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

	// Methods are here because menu and submenu are common for all the pages
	// Dynamic xpath for the side bar menus
	// Menu  -- //ul[@class='page-sidebar-menu']/li/a/span[text()='Discussions']
	// Submenu -- //ul[@class='page-sidebar-menu']/li/a/span[text()='Discussions']/parent::a/parent::li//ul[@class='sub-menu']/li/a/span[text()='View All']
	public void clickOnMenu(String nameOfMenu)
	{
		final By menu = By.xpath("//ul[@class='page-sidebar-menu']/li/a/span[text()='"+nameOfMenu+"']");
		DriverManager.getDriver().findElement(menu).click();

	}
	public void clickOnSubmenu(String nameOfMenu,String nameOfSubMenu)
	{
		clickOnMenu(nameOfMenu);
		final By subMenu = By.xpath("//ul[@class='page-sidebar-menu']/li/a/span[text()='"+nameOfMenu+"']"
				+ "/parent::a/parent::li//ul[@class='sub-menu']/li/a/span[text()='"+nameOfSubMenu+"']");
		DriverManager.getDriver().findElement(subMenu).click();
	}

}
