package org.qdPM.tests;
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
	@Test 
	public void validateUserName ()
	{
		lP.enterUserEmail("sumitsmewal@gmail.com").enterUserPassword("sumita").clickLogin();
	}
	public void createClientUser()
	{
		uP = lP.enterUserEmail("sumitsmewal@gmail.com").enterUserPassword("sumita").clickLogin();
		clickOnSubmenu("Users","Add User");
		
	}



}

