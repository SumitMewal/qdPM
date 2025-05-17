package org.qdPM.Tests;
import org.qdPM.driver.DriverManager;
import org.openqa.selenium.By;
import org.qdPM.base.AbstractClass;
import org.testng.annotations.Test;

public class LoginPageTest extends AbstractClass  {
	//public WebDriver driver;
	@Test 
	public void loginAdmin ()
	{
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().findElement(By.name("login[email]")).sendKeys("sumitclient@mailinator.com");
		DriverManager.getDriver().findElement(By.name("login[password]")).sendKeys("sumitc");
		DriverManager.getDriver().findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		DriverManager.getDriver().findElement(By.xpath("//span[@class='username']")).getText();
		String userName = DriverManager.getDriver().findElement(By.xpath("//span[@class='username']")).getText();
		System.out.println(userName);
	}
}
