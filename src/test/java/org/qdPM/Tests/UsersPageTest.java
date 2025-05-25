package org.qdPM.tests;

import java.io.IOException;
import java.util.ArrayList;
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
	UsersPage uSP = new UsersPage();
	AddUserPage aUP = new AddUserPage();
	ArrayList<String> arrList;

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
	{	
		arrList = new ArrayList<String>();
		String fullName = ExcelReader.getExcelData("Full Name");
		String beforePhone = ExcelReader.getExcelData("Phone");
		String newPhone = ExcelReader.getExcelData("Updated Phone");
		lP.enterUserEmail("sumitsmewal@gmail.com").enterUserPassword("sumita").clickLogin();
		clickOnSubmenu("Users","View All");
		arrList = 	uSP.getColumnsValue("Name");
		for (int i=0;i<arrList.size();i++)
		{
			if(arrList.get(i).equalsIgnoreCase(fullName))
			{
				System.out.println(arrList.get(i));
				uSP.editRow(i);
				Thread.sleep(5000);
				aUP.enterPhone(ExcelReader.getExcelData("Updated Phone")).saveUserDetails();
			}
		}
		// To validate updated data on the data table 
		for (int i=0;i<arrList.size();i++)
		{
			if(arrList.get(i).equalsIgnoreCase(fullName))
			{				
				if(uSP.getColumnsValue("Phone").getFirst().toString().equalsIgnoreCase(newPhone))
				{
					System.out.println("Data updated from: "+beforePhone+" to "+ newPhone);
				}
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
				uSP.deleteRow(i);
				//aUP.selectGroup("Manager").saveUserDetails();
			}
		}
		// Validate the deleted user on the data table

		for (int i=0;i<arrList.size();i++)
		{
			if(!arrList.get(i).equalsIgnoreCase(fullName))
			{				
				System.out.println(fullName+ "not found !! Deleted from the system !!");
			}
		}
	}
}
