package org.qdPM;
import org.qdPM.driver.DriverManager;
import org.openqa.selenium.By;
import org.qdPM.base.AbstractClass;
import org.testng.annotations.Test;

public class LoginPageTest extends AbstractClass  {
	//public WebDriver driver;
	@Test 
	public void loginAdmin ()
	{
		//driver = new ChromeDriver(); // we are giving the life to the object
		
		DriverManager.getDriver().manage().window().maximize();
		//driver.get("http://localhost:8091/");
		DriverManager.getDriver().findElement(By.name("login[email]")).sendKeys("sumitclient@mailinator.com");
		DriverManager.getDriver().findElement(By.name("login[password]")).sendKeys("sumitc");
		DriverManager.getDriver().findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		DriverManager.getDriver().findElement(By.xpath("//span[@class='username']")).getText();
		String userName = DriverManager.getDriver().findElement(By.xpath("//span[@class='username']")).getText();
		System.out.println(userName);
	}
}
