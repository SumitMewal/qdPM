package org.qdPM.base;
import java.io.IOException;
import java.sql.Driver;
import java.sql.Time;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.qdPM.driver.DriverManager;
import org.qdPM.frameworkactions.ActionBuilderClass;
import org.qdPM.pageobject.SidebarMenuPage;
import org.qdPM.projectutililty.UtilityClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class AbstractClass extends ActionBuilderClass {

	// protected used instead of private as it's the parent class for all my test classes
	protected AbstractClass()
	{

	}
	private final static By userTitle = By.xpath("//span[@class='username']");
	private final static By logOut = By.xpath("//ul[class='dropdown-menu']");

	@BeforeMethod
	public static void initDriver() throws IOException 
	{
		DriverManager.setDriver();
		DriverManager.getDriver().get(UtilityClass.getPropertyValue("url"));
		DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
		DriverManager.getDriver().manage().window().maximize();
	}

	@AfterMethod
	public static void tearDown()
	{
		//logOut();
		DriverManager.getDriver().quit();
	}

	// Methods are here because menu and submenu are common for all the pages
	// Dynamic xpath for the side bar menus
	// Menu  -- //ul[@class='page-sidebar-menu']/li/a/span[text()='Discussions']
	// Submenu -- //ul[@class='page-sidebar-menu']/li/a/span[text()='Discussions']/parent::a/parent::li//ul[@class='sub-menu']/li/a/span[text()='View All']
	public void clickOnMenu(String nameOfMenu)
	{
		// final By menu = By.xpath("//ul[@class='page-sidebar-menu']/li/a/span[text()='"+nameOfMenu+"']");

		final By menu = By.xpath("//i[contains(@class,'fa-user')]/following-sibling::span[contains(text(),'"+nameOfMenu+"')]");

		DriverManager.getDriver().findElement(menu).click();

	}
	public void clickOnSubmenu(String nameOfMenu, String nameOfSubMenu) throws InterruptedException
	{
		clickOnMenu(nameOfMenu);
		final By subMenu = By.xpath("//ul[@class='page-sidebar-menu']/li/a/span[text()='"+nameOfMenu+"']"
				+ "/parent::a/parent::li//ul[@class='sub-menu']/li/a/span[text()='"+nameOfSubMenu+"']"); 
		DriverManager.getDriver().findElement(subMenu).click();
	}
	public static void logOut()
	{
		DriverManager.getDriver().findElement(userTitle).click();
		DriverManager.getDriver().findElement(logOut).click();
	}

}
