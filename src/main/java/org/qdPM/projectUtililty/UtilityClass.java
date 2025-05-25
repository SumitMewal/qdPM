package org.qdPM.projectutililty;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.qdPM.driver.DriverManager;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public final class UtilityClass {

	private UtilityClass()
	{

	}

	// Method to get property value on basis of key using HashTable
	// Hashtable is fast and thread safe
	private static Properties prop = new Properties(); 
	private static final HashMap<String,String> MAP = new HashMap<String, String>();

	// static block is used to load properties file 
	static
	{
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream("C:\\Users\\sumit\\Education\\Web_Automation\\org.qdPM\\src\\main\\resources\\frameworkproperties\\Property.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(fileInputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Object key : prop.keySet())
		{
			MAP.put(String.valueOf(key), String.valueOf(prop.get(key)));
		}
	}

	// getting property values using Hashmap
	public static String getValue(String key) throws IOException
	{
		if(Objects.isNull(key) || Objects.isNull(MAP.get(key)))
		{
			System.out.println("Check key !! value or key is blank or incorrect....key =" +key+" value of key = "+MAP.get(key));
		}
		return MAP.get(key);
	}

	// Select dropdown handling
	private static List<WebElement> optionsList ;
	public static void selectDropDown(By by, String value)
	{
		WebElement element = DriverManager.getDriver().findElement(by);
		Select select = new Select(element);
		optionsList = select.getOptions();
		for (WebElement option : optionsList)
		{
			if(option.getText().equalsIgnoreCase(value))
			{
				select.selectByVisibleText(option.getText());
			}
		}
	}

	// Sendkeys to text box
	public static void enterTxtBox(By by, String enterTxt)
	{
		DriverManager.getDriver().findElement(by).clear();
		DriverManager.getDriver().findElement(by).sendKeys(enterTxt);
	}

	// Check checkbox is selected or not comparing with excel data
	public static void selectChkBox(By by, String cellValue) throws IOException
	{
		WebElement chkBox = DriverManager.getDriver().findElement(by);
		String bool = ExcelReader.getExcelData(cellValue);
		if(bool.equalsIgnoreCase("yes") && chkBox.isSelected()==false)
		{
			chkBox.click();
		}
		else if(bool.equalsIgnoreCase("no") && chkBox.isSelected()==true)
		{
			chkBox.click();
		}
	}

	//Read data from email 
	public void readEmail(String email)
	{
		DriverManager.getDriver().get("https://www.mailinator.com/");
	}
}
