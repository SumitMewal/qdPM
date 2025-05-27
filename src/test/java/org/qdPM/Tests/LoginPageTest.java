package org.qdPM.tests;
import java.io.IOException;

import org.qdPM.base.AbstractClass;
import org.qdPM.pageobject.LoginPage;
import org.qdPM.projectutililty.ExcelReader;
import org.qdPM.projectutililty.UtilityClass;
import org.qdPM.pageobject.AddUserPage;
import org.testng.annotations.Test;

public final class LoginPageTest extends AbstractClass  {

	private LoginPageTest()
	{

	}
	
	AddUserPage aUP;
	LoginPage lP = new LoginPage();
	@Test (enabled = true, priority = 1)
	public void validateUserName ()
	{
		lP.enterUserEmail("sumitsmewal@gmail.com").enterUserPassword("sumita").clickLogin();
		// Need to validate using assertion
		System.out.println(lP.getUserTitle());
	}

	@Test (priority = 2)
	public void createUser() throws IOException, InterruptedException
	{
		aUP = lP.enterUserEmail("sumitsmewal@gmail.com").enterUserPassword("sumita").clickLogin();
		clickOnSubmenu("Users","Add User");
		aUP.chkActiveChkBox().enterName().enterPass().enterEmail().enterPhone(ExcelReader.getExcelData("Phone")).selectLanguage().selectGroup().chkUserNotify().saveUserDetails();
		Thread.sleep(5000);
	}
}

