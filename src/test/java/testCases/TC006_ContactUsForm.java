package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ContactUsPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC006_ContactUsForm extends BaseClass {
	String name;

	@Test
	public void verifyContactUsFormSubmission() {
		HomePage hp = new HomePage(driver);
		Assert.assertTrue(hp.img_logo(), "Home page logo not visible");
		hp.clickContactUs();

		ContactUsPage cup = new ContactUsPage(driver);
		Assert.assertTrue(cup.isContactPageVisible(), "Contact us page not Visible..");

		name = generateRandomString();
		cup.setName(name);
		cup.setEmail(name + "@gmail.com");
		cup.setMessage(name + " please call me.");
		cup.setSubject(name + "  resolve this issue..");
		cup.uploadFile("E:\\Selenium Projects\\AutomationExercise\\src\\test\\java\\testCases\\TC004_LoginAndLogOut.java");
		cup.clickSubmit();

		driver.switchTo().alert().accept();

		String expectedMsg = "Success! Your details have been submitted successfully.";
		String actualMsg = cup.getSuccessMessageText();
		Assert.assertEquals(expectedMsg, actualMsg, "Form submission filed..");
		cup.clickHome();
		Assert.assertTrue(hp.img_logo(), "Home page logo not visible");

	}

}
