package org.qdPM.tests;
import java.io.IOException;

import org.qdPM.base.AbstractClass;
import org.qdPM.pageobject.LoginPage;
import org.qdPM.pageobject.UserPage;
import org.testng.annotations.Test;

public final class LoginPageTest extends AbstractClass  {

	private LoginPageTest()
	{

	}
	UserPage uP;
	LoginPage lP = new LoginPage();
	@Test (priority = 1)
	public void validateUserName ()
	{
		lP.enterUserEmail("sumitsmewal@gmail.com").enterUserPassword("sumita").clickLogin();
	}
	@Test (priority = 2)
	public void createClientUser() throws IOException
	{
		uP = lP.enterUserEmail("sumitsmewal@gmail.com").enterUserPassword("sumita").clickLogin();
		clickOnSubmenu("Users","Add User");
		uP.selectGroup().enterName().enterPass().enterEmail().enterPhone().selectLanguage();
	}



}

