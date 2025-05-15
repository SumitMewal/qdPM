package org.qdPM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginPageTest {
	public WebDriver driver;
	@Test 
	public void loginAdmin ()
	{
		driver = new ChromeDriver(); // we are giving the life to the object
		driver.manage().window().maximize();
		driver.get("http://localhost:8091/");
		driver.findElement(By.name("login[email]")).sendKeys("sumitsmewal@gmail.com");
		driver.findElement(By.name("login[password]")).sendKeys("sumita");
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		driver.quit();  
	}
}
