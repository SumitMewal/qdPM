package org.qdPM.pageobject;

import java.io.IOException;
import org.openqa.selenium.By;
import org.qdPM.driver.DriverManager;
import org.qdPM.projectutililty.ExcelReader;
import org.qdPM.projectutililty.UtilityClass;

public final class AddUserPage  {

	private static By activeChkBox = By.id("users_active");
	private static By groupDrpDwn = By.id("users_users_group_id");
	private static By nameTxtBox = By.id("users_name");
	private static By passTxtBox = By.id("users_password");
	private static By emailTxtBox = By.id("users_email");
	private static By phoneTxtBox = By.id("extra_fields_9");
	private static By photoTxtBox = By.id("users_photo");
	private static By languageDrpDwn = By.id("users_culture");
	private static By SubmitBtn = By.id("submit_button");
	
	private static By closeBtn = By.xpath("//button[contains(text(),'Close')]");
	private static By userNotify = By.id("users_notify");

	public void addUser()
	{
		
		
	}
	
	public AddUserPage chkActiveChkBox() throws IOException
	{
		UtilityClass.selectChkBox(activeChkBox, "Active");
		return this;
	}
	public AddUserPage chkUserNotify() throws IOException
	{
		UtilityClass.selectChkBox(userNotify, "Notify");
		return this;
	}

	public AddUserPage selectGroup() throws IOException
	{
		UtilityClass.selectDropDown(groupDrpDwn, ExcelReader.getExcelData("Group"));
		return this;
	}
	
	public AddUserPage enterName() throws IOException
	{
		UtilityClass.enterTxtBox(nameTxtBox, ExcelReader.getExcelData("Full Name"));
		return this;
	}
	public AddUserPage enterPass() throws IOException
	{	
		UtilityClass.enterTxtBox(passTxtBox, ExcelReader.getExcelData("Password"));
		return this;
	}
	public AddUserPage enterEmail() throws IOException
	{
		UtilityClass.enterTxtBox(emailTxtBox, ExcelReader.getExcelData("Email"));
		return this;
	}
	public AddUserPage enterPhone(String phone) throws IOException
	{
		UtilityClass.enterTxtBox(phoneTxtBox, phone);
		return this;
	}
	public void uploadPhoto()
	{
		// Need to find the way to upload photo from excel sheet.....
	}
	public AddUserPage selectLanguage() throws IOException
	{
		UtilityClass.selectDropDown(languageDrpDwn, ExcelReader.getExcelData("Language"));
		return this;
	}
	public UsersPage saveUserDetails()
	{
		DriverManager.getDriver().findElement(SubmitBtn).click();
		return new UsersPage();
	}
	public void resetData()
	{
		DriverManager.getDriver().findElement(closeBtn).click();
	}

}