package testCases;

import java.time.Duration;

import org.apache.poi.ss.usermodel.Footer;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegisterLoginPage;
import pageObjects.SignupPage;
import testBase.BaseClass;

public class TC010_11_VerifySubscriptionInHomePage extends BaseClass {
	String name;
	WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));

	@Test(priority = 1, description = "Should register a new user successfully with valid details")
	public void verify_account_registration() {
		try {
			HomePage hp = new HomePage(getDriver());
			Assert.assertTrue(hp.img_logo(), "Homepage logo not visible");

			// test case 11
			hp.clickCart();
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

			Assert.assertTrue(hp.checkSubscription(), "Subscription not visible");

			hp.setSubEmail("sag@sdaj");
			hp.clickSubscription();

			Assert.assertEquals(hp.subMsg(), "You have been successfully subscribed!");

		} catch (Exception e) {
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}
	}

}
