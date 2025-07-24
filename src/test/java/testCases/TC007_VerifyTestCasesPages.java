package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ContactUsPage;
import pageObjects.HomePage;
import pageObjects.TestCasePage;
import testBase.BaseClass;

public class TC007_VerifyTestCasesPages extends BaseClass {
	String name;

	@Test
	public void verifyContactUsFormSubmission() {
		HomePage hp = new HomePage(getDriver());
		Assert.assertTrue(hp.img_logo(), "Home page logo not visible");
		hp.clickTestCase();
		TestCasePage tcp=new TestCasePage(getDriver());
		Assert.assertTrue(tcp.pageLogoVisible(),"Test case page not visible..");
	

	}

}
