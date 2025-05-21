package org.qdPM.projectutililty;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public final class ExcelReader {

	private ExcelReader()
	{

	}
	private static FileInputStream fis;
	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	private static XSSFRow row;

	private static void loadExcelFile()throws IOException
	{
		fis = new FileInputStream("C:\\Users\\sumit\\Education\\Web_Automation\\org.qdPM\\src\\main\\resources\\testData\\qdPM_dataSheet.xlsx");
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("Client Data");
		fis.close();
	}

	private static HashMap<Object, Object> excelMap ;
	public static String getExcelData(String columnkey) throws IOException
	{
		excelMap =  new HashMap<Object, Object>();
		if (sheet == null)
		{
			loadExcelFile();
		}
		int rowCount = sheet.getLastRowNum();
		int lastCellCount = sheet.getRow(0).getLastCellNum();
		for (int i = 1 ; i<=rowCount;i++)
		{
			String key = sheet.getRow(i).getCell(0).getStringCellValue().toString();
			for (int j = 1; j<lastCellCount;j++)
			{
				String value = sheet.getRow(i).getCell(j).toString();
				excelMap.put(key, value);
			}
		}
		String cellValue = " ";
		for(Object key: excelMap.keySet())
		{
			System.out.println(excelMap.get(key));
			
			if (key.toString().equalsIgnoreCase(columnkey))
			{
				cellValue =  excelMap.get(key).toString();
			}
		}
		return cellValue;

	}



}
