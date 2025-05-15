package org.qdPM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HomePageTest {

	WebDriver driver;
	@Test
	public void loginUser1()
	{
		driver = new ChromeDriver(); // we are giving the life to the object
		driver.manage().window().maximize();
		driver.get("http://localhost:8091/");
		driver.findElement(By.name("login[email]")).sendKeys("sumitsmewal@gmail.com");
		driver.findElement(By.name("login[password]")).sendKeys("sumita");
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		driver.quit();  
	}
	
	@Test

	public void loginUser2()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8091/");
		driver.findElement(By.name("login[email]")).sendKeys("sumitsmewal@gmail.com");
		driver.findElement(By.name("login[password]")).sendKeys("sumita");
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		driver.quit();
	}
	
	
	
	
	
	
	//WebDriver is a Interface and ChromeDriver is child of this.
	
	
}
