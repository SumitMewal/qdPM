package org.qdPM;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.qdPM.base.AbstractClass;
import org.qdPM.driver.DriverManager;
import org.testng.annotations.Test;

public class HomePageTest extends AbstractClass  {

	WebDriver driver;
	@Test
	public void loginUser1()
	{
		DriverManager.getDriver().manage().window().maximize();
		//driver.get("http://localhost:8091/");
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
		//driver.get("http://localhost:8091/");
		DriverManager.getDriver().findElement(By.name("login[email]")).sendKeys("sumitdesigner@mailinator.com");
		DriverManager.getDriver().findElement(By.name("login[password]")).sendKeys("sumitd");
		DriverManager.getDriver().findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		DriverManager.getDriver().findElement(By.xpath("//span[@class='username']")).getText();
		String userName = DriverManager.getDriver().findElement(By.xpath("//span[@class='username']")).getText();
		System.out.println(userName);
	}
}
