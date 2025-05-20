package org.qdPM.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.qdPM.driver.DriverManager;
import org.qdPM.projectutililty.UtilityClass;

public final class UserPage  {

//div[@class='form-group']/div
	
	private static By activeChkBox = By.id("uniform-users_active");
	private static By groupDrpDwn = By.id("uniform-users_active");
	private static By nameTxtBox = By.id("uniform-users_active");
	private static By passTxtBox = By.id("uniform-users_active");
	private static By emailTxtBox = By.id("uniform-users_active");
	private static By phoneTxtBox = By.id("uniform-users_active");
	private static By photoTxtBox = By.id("uniform-users_active");
	private static By languageDrpDwn = By.id("uniform-users_active");
	
	//private static By Admin
	
	
	public void selectGroup()
	{
		UtilityClass.selectDropDown(groupDrpDwn, "Client");
	}
	public void enterName()
	{
	//UtilityClass.enterTxtBox(nameTxtBox, );	
	}
	public void enterPass()
	{
		
	}
	public void enterEmail()
	{
		
	}
	public void enterPhone()
	{
		
	}
	public void uploadPhoto()
	{
		
	}
	public void selectLanguage()
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