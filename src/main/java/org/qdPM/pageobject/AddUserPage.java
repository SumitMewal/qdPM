package org.qdPM.pageobject;

import java.awt.Checkbox;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

	public AddUserPage selectGroup()
	{
		UtilityClass.selectDropDown(groupDrpDwn, "Developer");
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
	public AddUserPage enterPhone() throws IOException
	{
		UtilityClass.enterTxtBox(phoneTxtBox, ExcelReader.getExcelData("Phone"));
		return this;
	}
	public void uploadPhoto()
	{
		// Need to find the way to upload photo from excel sheet.....
	}
	public AddUserPage selectLanguage()
	{
		UtilityClass.selectDropDown(languageDrpDwn, "Hindi");
		return this;
	}
	public void saveUserDetails()
	{
		DriverManager.getDriver().findElement(SubmitBtn).click();
	}
	public void resetData()
	{
		DriverManager.getDriver().findElement(closeBtn).click();
	}

}