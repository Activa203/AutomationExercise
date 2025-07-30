package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[normalize-space()='Signup / Login']")
	WebElement btn_lgn;
	@FindBy(xpath = "//img[@alt='Website for automation practice']")
	WebElement img_logo;
	@FindBy(xpath = "//li[10]//a[1]")
	WebElement lbl_logedIn;
	@FindBy(xpath = "//a[normalize-space()='Delete Account']")
	public WebElement btn_delete;
	@FindBy(xpath = "//b[normalize-space()='Account Deleted!']")
	WebElement check_AccDeleted;
	@FindBy(xpath = "//a[normalize-space()='Contact us']")
	WebElement btn_continue;

	@FindBy(xpath = "//a[normalize-space()='Logout']")
	WebElement btn_logout;
	
	@FindBy(xpath = "//a[normalize-space()='Contact us']")
	WebElement btn_ContactUs;
	
	@FindBy(xpath = "//div[@class='item active']//button[@type='button'][normalize-space()='Test Cases']")
	WebElement btn_TestCases;
	
	@FindBy(xpath = "//a[@href='/products']")
	WebElement btn_Products;
	
	@FindBy(xpath = "//h2[normalize-space()='Subscription']")
	WebElement logo_subscription;
	
	@FindBy(xpath = "//input[@id='susbscribe_email']")
	WebElement txt_email_subscription;
	
	@FindBy(xpath = "//button[@id='subscribe']")
	WebElement btn_subscribe;
	
	@FindBy(xpath = "//div[@class='alert-success alert']")
	WebElement msg_sub;
	
	@FindBy(xpath = "//a[normalize-space()='Cart']")
	WebElement btn_cart;
	
	
	
	
	
	

	public boolean img_logo() {
		return img_logo.isDisplayed();
	}

	public void click_Signup_login() {
		btn_lgn.click();
	}

	public String checkUser() {
		return lbl_logedIn.getText();
	}

	public void clickDelete() {
		btn_delete.click();
	}

	public boolean accDltStatus() {
		return check_AccDeleted.isDisplayed();
	}

	public void clickContinue() {
		btn_continue.click();
	}

	public void clickLogOut() {
		btn_logout.click();
	}
	
	public void clickContactUs() {
		btn_continue.click();
	}
	
	public void clickTestCase() {
		btn_TestCases.click();
	}
	
	public void clickProducts() {
		btn_Products.click();
	}
	
	public boolean checkSubscription() {
		return logo_subscription.isDisplayed();
	}
	
	public void setSubEmail(String email)
	{
		txt_email_subscription.sendKeys(email);
	}
	
	public void clickSubscription() {
		btn_subscribe.click();
	}
	
	public String subMsg() {
		return msg_sub.getText();
	} 
	
	
	public void clickCart() {
		btn_cart.click();
	}
}
