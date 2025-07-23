package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegisterLoginPage;
import testBase.BaseClass;

public class TC002_LoginUserWithCorrectEmailandPassword extends BaseClass {

	@Test(description = "Login user with valid data..")
	public void verify_login() {
		HomePage hp = new HomePage(driver);

		Assert.assertTrue(hp.img_logo(), "Homepage logo not visible");
		hp.click_Signup_login();
		RegisterLoginPage rlp = new RegisterLoginPage(driver);
		Assert.assertTrue(rlp.checkPageVisible(), "Register/Login page not loaded");
		
		// fill user correct data here
		String name = "asga";
		rlp.setLoginEmail(name + "@gmail.com");
		rlp.setPassword(name + "@123");
		rlp.clickLogin();

		String user = hp.checkUser();
		boolean validUser = user.equalsIgnoreCase("Logged in as " + name);
		Assert.assertTrue(validUser, "test failed invalid user login..");

		hp.clickDelete();
		Assert.assertTrue(hp.accDltStatus(), "Account deletion failed..");
		hp.clickContinue();

	}
}
