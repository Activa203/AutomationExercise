package testCases;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegisterLoginPage;
import pageObjects.SignupPage;
import testBase.BaseClass;

public class TC005_RegisterUserWithExistingEmail extends BaseClass {
	
	WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
	@Test(priority = 1,description = "Should register a new user successfully with valid details")
	public void verify_account_registration() {
		try {
			HomePage hp = new HomePage(getDriver());
			Assert.assertTrue(hp.img_logo(), "Homepage logo not visible");

			hp.click_Signup_login();

			RegisterLoginPage rlp = new RegisterLoginPage(getDriver());

			Assert.assertTrue(rlp.checkPageVisible(), "Register/Login page not loaded");

		
			rlp.setName("sagh");
			rlp.setEmail("abcd@gmail.com");
			rlp.clickSignUp();
			String expectedMsg="Email Address already exist!";
			String actualMsg=rlp.getInvalidEmailMsg();
			Assert.assertEquals(expectedMsg,actualMsg,"Invalid SingUp message does not match!");
			 

		} catch (Exception e) {
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}
	}
	
	
	
}
