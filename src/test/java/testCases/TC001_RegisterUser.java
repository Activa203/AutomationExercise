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

public class TC001_RegisterUser extends BaseClass {
	String name;
	WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
	@Test(priority = 1,description = "Should register a new user successfully with valid details")
	public void verify_account_registration() {
		try {
			HomePage hp = new HomePage(getDriver());
			Assert.assertTrue(hp.img_logo(), "Homepage logo not visible");

			hp.click_Signup_login();

			RegisterLoginPage rlp = new RegisterLoginPage(getDriver());

			Assert.assertTrue(rlp.checkPageVisible(), "Register/Login page not loaded");

			name = generateRandomString();
			System.out.println("name: "+name);
			rlp.setName(name);
			rlp.setEmail(name + "@gmail.com");
			rlp.clickSignUp();
			Thread.sleep(3000);
			boolean allOk = signUpForm();
			
			Assert.assertTrue(allOk,"Account creation failed...");
			
			Thread.sleep(5000);
			String user=hp.checkUser();
			
			boolean validUser=user.equalsIgnoreCase("Logged in as "+name);
			Assert.assertTrue(validUser,"test failed invalid user login..");
			hp.clickLogOut();
			
			
			/*
			 * hp.clickDelete();
			 * Assert.assertTrue(hp.accDltStatus(),"Account deletion failed..");
			 * hp.clickContinue();
			 */
			 

		} catch (Exception e) {
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}
	}
	
	
	@Test(priority = 2, dependsOnMethods = "verify_account_registration")
	public void verify_login_with_same_credentials() {
		try {
			HomePage hp = new HomePage(getDriver());
			Assert.assertTrue(hp.img_logo(), "Homepage logo not visible");

			hp.click_Signup_login();
			RegisterLoginPage rlp = new RegisterLoginPage(getDriver());
			Assert.assertTrue(rlp.checkPageVisible(), "Register/Login page not loaded");

			rlp.setLoginEmail(name + "@gmail.com");
			rlp.setPassword(name + "@123");
			rlp.clickLogin();
			
			String user=hp.checkUser();
			boolean validUser=user.equalsIgnoreCase("Logged in as "+name);
			Assert.assertTrue(validUser,"test failed invalid user login..");
			
			
			
			  hp.clickDelete();
			  Assert.assertTrue(hp.accDltStatus(),"Account deletion failed..");
			  hp.clickContinue();

			 
		 
			
		} catch (Exception e) {
			Assert.fail("Login test failed: " + e.getMessage());
		}
	}
	 

	public boolean signUpForm() {
		try {

			SignupPage sp = new SignupPage(getDriver());
			if (!sp.pageVisible()) {
				return false;
			}
			sp.clickGender();
			sp.setDate("10");
			sp.setMonth("June");
			sp.setYear("1999");
			sp.clickNewsLetter();
			sp.setPassword(name + "@123");
			sp.setName(name);
			sp.setLname(name);
			sp.setCompany(name);
			sp.setAdd1(name);
			sp.setAdd2(name);
			sp.setCity(name);
			sp.setState(name);
			sp.setZipCode("123456");
			sp.setMobNo("1234567890");

			
			wait.until(ExpectedConditions.elementToBeClickable(sp.btn_createAcc));
			sp.clickCreate();
			
			if(!sp.accountStatus())
			{
				return false;
			}
			
			wait.until(ExpectedConditions.elementToBeClickable(sp.btn_continue));
			sp.clickContinue();
			return true;
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

}
