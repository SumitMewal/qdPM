package org.qdPM.tests;
import org.qdPM.base.AbstractClass;
import org.qdPM.pageobject.LoginPage;
import org.testng.annotations.Test;

public final class LoginPageTest extends AbstractClass  {

	private LoginPageTest()
	{

	}
	@Test 
	public void getUserName ()
	{
		LoginPage lP = new LoginPage();
		lP.enterUserEmail("sumitsmewal@gmail.com").enterUserPassword("sumita").clickLogin();
		
	}
		
		






		/*
		DriverManager.getDriver().findElement(By.name("login[email]")).sendKeys("sumitclient@mailinator.com");
		DriverManager.getDriver().findElement(By.name("login[password]")).sendKeys("sumitc");
		DriverManager.getDriver().findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		DriverManager.getDriver().findElement(By.xpath("//span[@class='username']")).getText();
		String userName = DriverManager.getDriver().findElement(By.xpath("//span[@class='username']")).getText();
		System.out.println(userName);
		 */
	}

