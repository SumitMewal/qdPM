package org.qdPM.tests;

import org.qdPM.base.AbstractClass;
import org.qdPM.frameworkactions.ActionClass;
import org.qdPM.pageobject.AddUserPage;
import org.qdPM.pageobject.LoginPage;
import org.testng.annotations.Test;

public final class UsersPageTest extends AbstractClass {
	
	
	private UsersPageTest()
	{
		
	}
	LoginPage lP = new LoginPage();
	AddUserPage aUP;
	@Test
	public void searchUser()
	{
		aUP = lP.enterUserEmail("sumitsmewal@gmail.com").enterUserPassword("sumita").clickLogin();
		clickOnSubmenu("Users","View All");
		
		
	}

}
