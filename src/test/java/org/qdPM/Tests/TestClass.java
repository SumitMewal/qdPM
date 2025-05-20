package org.qdPM.tests;

import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.collections4.map.HashedMap;
import org.qdPM.base.AbstractClass;
import org.qdPM.pageobject.UserPage;
import org.qdPM.projectutililty.ExcelReader;
import org.qdPM.projectutililty.UtilityClass;
import org.testng.annotations.Test;

public final class TestClass extends AbstractClass {

	@Test (enabled = true)
	public void test1() throws IOException
	{
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map  = ExcelReader.getCellValue();
		for (Object key : map.keySet())
		{
			System.out.println(key.toString()+ " Value "+map.get(key).toString());
		}


	}
	@Test
	public void test2()
	{


	}
}
