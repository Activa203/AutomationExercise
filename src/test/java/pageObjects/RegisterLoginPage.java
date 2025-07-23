package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterLoginPage extends BasePage{

	public RegisterLoginPage(WebDriver driver) {
		super(driver);
	}
	

	@FindBy(xpath="//input[@data-qa='login-email']") WebElement txt_login_email;
	@FindBy(xpath="//input[@placeholder='Password']") WebElement txt_pass;
	@FindBy(xpath="//button[normalize-space()='Login']") WebElement btn_login;
	@FindBy(xpath="//input[@placeholder='Name']") WebElement txt_signup_name;
	@FindBy(xpath="//input[@data-qa='signup-email']") WebElement txt_signup_email;
	@FindBy(xpath="//button[normalize-space()='Signup']") WebElement btn_singup;
	@FindBy(xpath="//h2[normalize-space()='Login to your account']") WebElement page_logo;
	@FindBy(xpath="//p[normalize-space()='Your email or password is incorrect!']") WebElement invalid_user;
	@FindBy(xpath="//p[normalize-space()='Email Address already exist!']") WebElement invalid_email;
	
	
	
	public boolean checkPageVisible()
	{
		return page_logo.isDisplayed();
	}
	public void setName(String name)
	{
		txt_signup_name.sendKeys(name);
	}
	
	public void setEmail(String email)
	{
		txt_signup_email.sendKeys(email);
	}
	public void clickSignUp() {
		btn_singup.click();
	}
	
	public void setLoginEmail(String email)
	{
		txt_login_email.sendKeys(email);
	}
	public void setPassword(String pass)
	{
		txt_pass.sendKeys(pass);
	}
	public void clickLogin() {
		btn_login.click();
	}
	
	public String getInvalidUserMsg()
	{
		return invalid_user.getText();
	}
	
	public String getInvalidEmailMsg()
	{
		return invalid_email.getText();
	}
}
