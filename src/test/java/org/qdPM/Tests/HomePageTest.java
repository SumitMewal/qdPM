package org.qdPM.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qdPM.base.AbstractClass;
import org.qdPM.driver.DriverManager;
import org.testng.annotations.Test;

public class HomePageTest extends AbstractClass  {

	WebDriver driver;
	@Test
	public void loginUser1()
	{
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().findElement(By.name("login[email]")).sendKeys("sumitsmewal@gmail.com");
		DriverManager.getDriver().findElement(By.name("login[password]")).sendKeys("sumita");
		DriverManager.getDriver().findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		String userName = DriverManager.getDriver().findElement(By.xpath("//span[@class='username']")).getText();
		System.out.println(userName);
	}

	@Test
	public void loginUser2()
	{
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().findElement(By.name("login[email]")).sendKeys("sumitdesigner@mailinator.com");
		DriverManager.getDriver().findElement(By.name("login[password]")).sendKeys("sumitd");
		DriverManager.getDriver().findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		String userName = DriverManager.getDriver().findElement(By.xpath("//span[@class='username']")).getText();
		System.out.println(userName);
	}
}
