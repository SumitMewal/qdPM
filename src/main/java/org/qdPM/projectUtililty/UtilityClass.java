package org.qdPM.projectutililty;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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



	// getting the data from excel sheet
	public static HashMap<Object, Object> getCellValue(String SheetName) throws IOException
	{
		HashMap<Object, Object> excelMap = new HashMap<Object, Object>();
		FileInputStream fileIO = new FileInputStream("C:\\Users\\sumit\\Education\\Web_Automation\\org.qdPM\\src\\main\\resources\\testData\\qdPM_dataSheet.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(fileIO);
		int noOfSheets =  workBook.getNumberOfSheets();
		for (int i = 0; i<noOfSheets;i++)
		{
			XSSFSheet activeSheet =  workBook.getSheetAt(i);
			if(activeSheet.getSheetName().equalsIgnoreCase(SheetName))
			{
				int rowCount = activeSheet.getPhysicalNumberOfRows();
				XSSFRow topRow= activeSheet.getRow(0);
				int cellCount = topRow.getPhysicalNumberOfCells();
				for (int row = 1;row<rowCount-1;row++)
				{
					XSSFRow activeRow = activeSheet.getRow(row);
					for (int cell = 0;cell < cellCount;cell++)
					{
						XSSFCell activeCell = activeRow.getCell(cell);
						excelMap.put(activeRow, activeCell);
					}
				}
			}
		}

		return excelMap;
	}




}
