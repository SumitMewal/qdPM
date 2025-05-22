package org.qdPM.tests;
import java.io.IOException;

import org.qdPM.base.AbstractClass;
import org.qdPM.pageobject.LoginPage;
import org.qdPM.pageobject.AddUserPage;
import org.testng.annotations.Test;

public final class LoginPageTest extends AbstractClass  {

	private LoginPageTest()
	{

	}
	AddUserPage aUP;
	LoginPage lP = new LoginPage();
	@Test (enabled = false)
	public void validateUserName ()
	{
		lP.enterUserEmail("sumitsmewal@gmail.com").enterUserPassword("sumita").clickLogin();
	}
	
	@Test 
	public void createUser() throws IOException, InterruptedException
	{
		aUP = lP.enterUserEmail("sumitsmewal@gmail.com").enterUserPassword("sumita").clickLogin();
		clickOnSubmenu("Users","Add User");
		aUP.chkActiveChkBox().enterName().enterPass().enterEmail().enterPhone().selectLanguage().selectGroup().chkUserNotify().saveUserDetails();
	}
	



}

