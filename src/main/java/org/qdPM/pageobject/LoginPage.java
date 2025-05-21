package org.qdPM.pageobject;
import org.openqa.selenium.By;
import org.qdPM.driver.DriverManager;

public final class LoginPage {


	// Page Elements
	private final By emailtxtbox = By.name("login[email]");
	private final By Passtxtbox = By.xpath("//input[@type='password']");
	private final By lobinBtn = By.xpath("//button[contains(text(),'Login')]");
	private final By forgotPassLinkTxt = By.linkText("Password forgotten?");

	// Methods for implementation
	public LoginPage enterUserEmail(String email)
	{
		DriverManager.getDriver().findElement(emailtxtbox).sendKeys(email);
		// for chaining method need to return the same class object or can return this.
		return this;
	}
	public LoginPage enterUserPassword(String password)
	{
		DriverManager.getDriver().findElement(Passtxtbox).sendKeys(password);
		return this;
	}
	public UserPage clickLogin()
	{
		DriverManager.getDriver().findElement(lobinBtn).click();
		return new UserPage();
	}
	public ForgotPasswordPage clickForgotPassword()
	{
		DriverManager.getDriver().findElement(forgotPassLinkTxt).click();
		return new ForgotPasswordPage();
	}

}
