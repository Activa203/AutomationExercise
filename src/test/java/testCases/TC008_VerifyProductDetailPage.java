package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ContactUsPage;
import pageObjects.HomePage;
import pageObjects.ProductDetailPage;
import pageObjects.ProductsPage;
import pageObjects.TestCasePage;
import testBase.BaseClass;

public class TC008_VerifyProductDetailPage extends BaseClass {
	String name;

	@Test
	public void verifyContactUsFormSubmission() {
		HomePage hp = new HomePage(getDriver());
		Assert.assertTrue(hp.img_logo(), "Home page logo not visible");
		hp.clickProducts();
		
		ProductsPage pp=new ProductsPage(getDriver());
		Assert.assertTrue(pp.pageVisible(),"Products Page not loaded...");
		
		Assert.assertTrue(pp.isProductListVisible(),"Products List  not visible...");
		
		pp.clickViewProduct();
		
		ProductDetailPage pdp=new ProductDetailPage(getDriver());
		Assert.assertTrue(pdp.isProductDetailVisible(),"Product Details not visible...");
		
	

	}

}
