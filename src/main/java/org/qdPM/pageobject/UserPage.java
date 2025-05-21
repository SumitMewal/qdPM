package org.qdPM.pageobject;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.qdPM.driver.DriverManager;
import org.qdPM.projectutililty.ExcelReader;
import org.qdPM.projectutililty.UtilityClass;

public final class UserPage  {

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


	public UserPage selectGroup()
	{
		UtilityClass.selectDropDown(groupDrpDwn, "Client");
		return this;
	}
	public UserPage enterName() throws IOException
	{
		UtilityClass.enterTxtBox(nameTxtBox, ExcelReader.getExcelData("Full Name"));
		return this;
	}
	public UserPage enterPass() throws IOException
	{	
		UtilityClass.enterTxtBox(passTxtBox, ExcelReader.getExcelData("Password"));
		return this;
	}
	public UserPage enterEmail() throws IOException
	{
		UtilityClass.enterTxtBox(emailTxtBox, ExcelReader.getExcelData("Email"));
		return this;
	}
	public UserPage enterPhone() throws IOException
	{
		UtilityClass.enterTxtBox(phoneTxtBox, ExcelReader.getExcelData("Phone"));
		return this;
	}
	public void uploadPhoto()
	{

	}
	public UserPage selectLanguage()
	{
		UtilityClass.selectDropDown(languageDrpDwn, "Hindi");
		return this;
	}

	public void saveUserDetails()
	{

	}

	public void resetData()
	{

	}

	/*
	private final static By labels = By.xpath("//div[@class='form-group']/label/label");
	private static List<String> nameOfLabels;
	public static  List<String> getLabelsText()
	{
		List<WebElement> listLables = DriverManager.getDriver().findElements(labels);
		for (WebElement label : listLables)
		{
			nameOfLabels.add(label.getText());
		}
		System.out.println(nameOfLabels.get(2));
		return nameOfLabels;
	}
	public static void fillData() {

		List<String> listLabel = getLabelsText();
		for (String label: listLabel)
		{
			System.out.println(label);
		}

	}

	 */








}