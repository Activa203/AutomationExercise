package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegisterLoginPage;
import testBase.BaseClass;

public class TC003_LoginUserWithInCorrectEmailandPassword extends BaseClass {

	@Test(description = "Login user with valid data..")
	public void verify_login() {
		HomePage hp = new HomePage(getDriver());

		Assert.assertTrue(hp.img_logo(), "Homepage logo not visible");
		hp.click_Signup_login();
		RegisterLoginPage rlp = new RegisterLoginPage(getDriver());
		Assert.assertTrue(rlp.checkPageVisible(), "Register/Login page not loaded");
		
		// fill user data here
		String name = "asga";
		rlp.setLoginEmail(name + "@gmail.com");
		rlp.setPassword(name + "@123");
		rlp.clickLogin();
		
		String actualMsg = rlp.getInvalidUserMsg();
		String expectedMsg = "Your email or password is incorrect!";
		Assert.assertEquals(actualMsg, expectedMsg, "Invalid login message does not match!");


		

	}
}
