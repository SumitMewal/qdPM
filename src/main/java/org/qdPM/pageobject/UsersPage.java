package org.qdPM.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.qdPM.frameworkactions.ActionClass;
import org.qdPM.projectutililty.UtilityClass;
import org.qdPM.driver.DriverManager;

public final class UsersPage {

	// search_keywords
	private static By searchIcon = By.id("yui-gen1");
	private static By searchTxt = By.id("search_keywords");
	private static By searhBtn = By.xpath("//input[@value='Search']");

	// Data Table
	private static By tableHeader = By.xpath("//th[@role='columnheader']/div");
	private static By tableRow = By.xpath("//tbody[@role='alert']/tr");
	private static By reset = By.xpath("//a[text()='Reset']");
	private static By actionButton = By.xpath("//tbody[@role='alert']/tr/td[6]/parent::tr/td/div[@class='checker']");
	
	public UsersPage Hover()
	{
		ActionClass.hoverToElement(searchIcon);
		return this;
	}

	public UsersPage enterSearchTxt(String searchValue)
	{
		UtilityClass.enterTxtBox(searchTxt, searchValue);
		return this;
	}

	public UsersPage clickSearch()
	{
		DriverManager.getDriver().findElement(searhBtn).click();
		return this;
	}

	private int getColumnIndex(String headerName) {
		List<WebElement> headers = DriverManager.getDriver().findElements(tableHeader);	
		for(int i =0;i<headers.size();i++)
		{
			if(headers.get(i).getText().equalsIgnoreCase(headerName))
			{
				return i+1;
			}
		}
		return 0;
	}

	public String getColumnValue(String headerName)
	{
		int columnIndex = getColumnIndex(headerName);
		System.out.println("column index"+columnIndex);
		By tableColumn = By.xpath("//tbody[@role='alert']/tr/td['"+columnIndex+"']/a");
		String value =  DriverManager.getDriver().findElement(tableColumn).getText();
		System.out.println("column value "+ value);
		return value;
	}

	public void resetDataTable()
	{
		DriverManager.getDriver().findElement(reset).click();
	}
	
	public void editRow()
	{
		//DriverManager.getDriver().findElement();
	}
	
}


