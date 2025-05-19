package org.qdPM.tests;

import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.collections4.map.HashedMap;
import org.qdPM.projectutililty.UtilityClass;
import org.testng.annotations.Test;

public class TestClass {

	
	@Test
	public void test1() throws IOException
	{
	HashMap<Object, Object> map = new HashMap<Object, Object>();
			
		map = UtilityClass.getCellValue("Client Data");
		for (Object key : map.keySet())
		{
			Object value = map.get(key);
			System.out.println("value is :"+value.toString());
		}
	
	}
	}
