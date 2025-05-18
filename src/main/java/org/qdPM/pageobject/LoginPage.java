package org.qdPM.pageobject;
import org.openqa.selenium.By;
import org.qdPM.driver.DriverManager;

public final class LoginPage {
	
		
	// Page Elements
	private final By txtEmail = By.name("login[email]");
	private final  By txtPass = By.name("login[email]");
	private final By btnLogin = By.xpath("//button[contains(text(),'Login')]");
	private final By linkPassForgotten = By.linkText("Password forgotten?");
	
	// Objects of the pages where the user will land after clicking on the buttons.
	HomePage hP = new HomePage();
	ForgotPasswordPage fPP = new ForgotPasswordPage();
	
	// Methods for implementation
	public LoginPage enterUserEmail(String email)
	{
		DriverManager.getDriver().findElement(txtEmail).sendKeys(email);
		// for chaining method need to return the same class object or can return this.
		return this;
	}
	public LoginPage enterUserPassword(String password)
	{
		DriverManager.getDriver().findElement(txtPass).sendKeys(password);
		return this;
	}
	public HomePage clickLogin()
	{
		DriverManager.getDriver().findElement(btnLogin).click();
		return hP;
	}
	public ForgotPasswordPage clickForgotPassword()
	{
		DriverManager.getDriver().findElement(linkPassForgotten).click();
		return fPP;
	}

}
