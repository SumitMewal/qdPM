package org.qdPM.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qdPM.base.AbstractClass;
import org.qdPM.driver.DriverManager;
import org.qdPM.pageobject.LoginPage;
import org.testng.annotations.Test;

public class HomePageTest extends AbstractClass  {

	WebDriver driver;
	@Test
	public void loginUser1()
	{
		LoginPage lP = new LoginPage();
		lP.enterUserEmail("sumitclient@mailinator.com").enterUserPassword("sumitc").clickLogin();

	}

	@Test
	public void loginUser2()
	{
		LoginPage lP = new LoginPage();
		lP.enterUserEmail("sumitclient@mailinator.com").enterUserPassword("sumitc").clickLogin();

	}
}
