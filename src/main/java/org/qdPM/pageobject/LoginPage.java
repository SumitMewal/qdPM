package org.qdPM.pageobject;
import org.openqa.selenium.By;
import org.qdPM.base.AbstractClass;
import org.qdPM.driver.DriverManager;

public final class LoginPage extends AbstractClass {

	// Page Elements
	private final By emailTxtBox = By.name("login[email]");
	private final By passTxtBox = By.xpath("//input[@type='password']");
	private final By loginBtn = By.xpath("//button[contains(text(),'Login')]");
	private final By forgotPassLinkTxt = By.linkText("Password forgotten?");
	private final By userTitle = By.xpath("//span[@class='username']");

	// Methods for implementation
	public LoginPage enterUserEmail(String email)
	{
		sendkeys(emailTxtBox, email);
		// for chaining method need to return the same class object or can return this.
		return this;
	}
	public LoginPage enterUserPassword(String password)
	{
		sendkeys(passTxtBox, password);
		return this;
	}
	public AddUserPage clickLogin()
	{
		click(loginBtn);
		return new AddUserPage();
	}
	public ForgotPasswordPage clickForgotPassword()
	{
		click(forgotPassLinkTxt);
		return new ForgotPasswordPage();
	}
	public String getUserTitle()
	{
		return DriverManager.getDriver().findElement(userTitle).getText();

	}
}
