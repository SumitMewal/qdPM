package org.qdPM.Tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RunnerTestNG {
	
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("This is Before Suite annotation");
	}
	@AfterClass
	public void afterSuite()
	{
		System.out.println("This is After Suite annotation");
	}
	
	
	
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("This is Before Class annotation");
	}
	@AfterClass
	public void afterClass()
	{
		System.out.println("This is After Class annotation");
	}
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("This is BeforeMethod annotation");
	}
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("This is AfterMethod annotation");
	}
	
	@Test
	public void Test1()
	{
		System.out.println("This is test1 annotation");
	}
	@Test
	public void Test2()
	{
		System.out.println("This is test2 annotation");
	}
	@BeforeTest	
	public void startBeforeTest()
	{
		System.out.println("This is Before test annotation");
	}

	@AfterTest	
	public void startAfterTest()
	{
		System.out.println("This is After test annotation");
	}
}
