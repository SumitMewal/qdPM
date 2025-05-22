package org.qdPM.tests;

import java.io.IOException;
import org.qdPM.base.AbstractClass;
import org.qdPM.pageobject.AddUserPage;
import org.qdPM.pageobject.LoginPage;
import org.qdPM.pageobject.UsersPage;
import org.qdPM.projectutililty.ExcelReader;
import org.testng.annotations.Test;

public final class UsersPageTest extends AbstractClass {

	private UsersPageTest()
	{

	}
	LoginPage lP = new LoginPage();
	AddUserPage aUP = new AddUserPage();
	UsersPage uSP = new UsersPage();

	@Test
	public void searchUser() throws IOException
	{
		String userName = ExcelReader.getExcelData("Full Name");
		aUP = lP.enterUserEmail("sumitsmewal@gmail.com").enterUserPassword("sumita").clickLogin();
		clickOnSubmenu("Users","View All");
		uSP.Hover().enterSearchTxt(userName).clickSearch();
		System.out.println(userName);
		System.out.println(uSP.getColumnValue("Name"));
		if(uSP.getColumnValue("Name").equalsIgnoreCase(userName))
		{
			System.out.println(userName+ " User successfully found !!");
		}
		else
		{
			System.out.println(userName+ " User not found !!");
		}
		uSP.resetDataTable();
	}

	@Test (enabled =false)
	public void verifyFromEmail()
	{
		String email = uSP.getColumnValue("Email");
	}

	@Test
	public void updateUserDetails() throws IOException
	{	
		String userName = ExcelReader.getExcelData("Full Name");
		uSP.getColumnValue("Name").equalsIgnoreCase(userName);
		
	}

}
