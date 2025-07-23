package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegisterLoginPage;
import testBase.BaseClass;

public class TC004_LoginAndLogOut extends BaseClass {

	@Test(description = "Login user with valid data..")
	public void verify_loginAndLogOut() {
		HomePage hp = new HomePage(driver);

		Assert.assertTrue(hp.img_logo(), "Homepage logo not visible");
		hp.click_Signup_login();
		RegisterLoginPage rlp = new RegisterLoginPage(driver);
		Assert.assertTrue(rlp.checkPageVisible(), "Register/Login page not loaded");
		
		//shubhamabcd@gmail.com
		//abcd@123
		rlp.setLoginEmail("shubhamabcd@gmail.com");
		rlp.setPassword("abcd@123");
		rlp.clickLogin();
		
		String user=hp.checkUser();
		boolean validUser=user.equalsIgnoreCase("Logged in as "+"shubham");
		Assert.assertTrue(validUser,"test failed invalid user login..");
		
		hp.clickLogOut();
		Assert.assertTrue(rlp.checkPageVisible(), "Logout Failed..");


		

	}
}
