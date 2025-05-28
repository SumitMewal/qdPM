package org.qdPM.tests;

import java.io.IOException;
import java.sql.DriverManager;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.qdPM.base.AbstractClass;
import org.qdPM.pageobject.AddUserPage;
import org.qdPM.pageobject.LoginPage;
import org.qdPM.pageobject.UsersPage;
import org.qdPM.projectutililty.ExcelReader;
import org.qdPM.projectutililty.UtilityClass;
import org.testng.annotations.Test;

public final class UsersPageTest extends AbstractClass {

	private UsersPageTest()
	{

	}
	LoginPage lP = new LoginPage();
	UsersPage uSP = new UsersPage();
	AddUserPage aUP = new AddUserPage();
	ArrayList<String> arrList;
	ArrayList<String> arrListPhone;

	@Test(priority = 3)
	public void searchAndValidateUser() throws IOException, InterruptedException
	{
		arrList = new ArrayList<String>();
		String userName = ExcelReader.getExcelData("Full Name");
		lP.enterUserEmail("sumitsmewal@gmail.com").enterUserPassword("sumita").clickLogin();
		clickOnSubmenu("Users","View All");
		uSP.Hover().enterSearchTxt(userName).clickSearch();
		arrList = 	uSP.getColumnsValue("Name");
		// Need to update with assertion
		for (String fullName: arrList)
		{
			if(fullName.equalsIgnoreCase(userName))
			{
				System.out.println(userName+ " User found !!");
			}
		}
		uSP.resetDataTable();
	}

	@Test (enabled =false)
	public void verifyFromEmail()
	{
		// Email is not going from the local server!!
	}

	@Test(priority = 4)
	public void updateUserDetails() throws IOException, InterruptedException
	{	String updatedPhone;
	String phone;
	arrList = new ArrayList<String>();
	String fullName = ExcelReader.getExcelData("Full Name");
	lP.enterUserEmail("sumitsmewal@gmail.com").enterUserPassword("sumita").clickLogin();
	clickOnSubmenu("Users","View All");
	arrList = 	uSP.getColumnsValue("Name");
	for (int i=0;i<arrList.size();i++)
	{
		if(arrList.get(i).equalsIgnoreCase(fullName))
		{
			phone = uSP.getCellValue("Phone", i+1);
			uSP.editRow(i+1);
			aUP.enterPhone(ExcelReader.getExcelData("Updated Phone")).saveUserDetails();
			Thread.sleep(5000);
			updatedPhone = uSP.getCellValue("Phone", i+1);
			System.out.println("Phone "+phone+" is updated to "+updatedPhone );
		}
	}
	}

	@Test(priority = 5)
	public void deleteUser() throws IOException, InterruptedException
	{
		lP.enterUserEmail("sumitsmewal@gmail.com").enterUserPassword("sumita").clickLogin();
		clickOnSubmenu("Users","View All");
		String fullName = ExcelReader.getExcelData("Full Name");
		arrList = 	uSP.getColumnsValue("Name");
		for (int i=0;i<arrList.size();i++)
		{
			if(arrList.get(i).equalsIgnoreCase(fullName))
			{				
				uSP.deleteRow(i+1);
				UtilityClass.acceptDialogBox("yes");
				// Update with the assertion
				System.out.println("User deleted successfully !!");
				uSP.getCellValue("Name", i);
			}
		}
	}
}