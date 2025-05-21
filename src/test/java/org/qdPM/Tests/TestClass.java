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
		System.out.println(ExcelReader.getExcelData("Full Name"));
	}
	@Test
	public void test2()
	{


	}
}
