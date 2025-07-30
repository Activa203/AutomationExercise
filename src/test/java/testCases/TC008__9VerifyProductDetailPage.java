package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ContactUsPage;
import pageObjects.HomePage;
import pageObjects.ProductDetailPage;
import pageObjects.ProductsPage;
import pageObjects.TestCasePage;
import testBase.BaseClass;
import utilities.DataProviderTestCase8;

public class TC008__9VerifyProductDetailPage extends BaseClass {
	String name;

	//@Test(priority = 1,description = "Verify product detail page..")
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
	
	@Test(priority = 2,description = "Test Case 9: Search Product",dataProvider = "SearchKeywords",dataProviderClass = DataProviderTestCase8.class)
	public void verifySearchProduct(String keyward) throws InterruptedException
	{
		HomePage hp = new HomePage(getDriver());
		Assert.assertTrue(hp.img_logo(), "Home page logo not visible");
		hp.clickProducts();
		
		ProductsPage pp=new ProductsPage(getDriver());
		Assert.assertTrue(pp.pageVisible(),"Products Page not loaded...");
		
		pp.setSearchText(keyward);
		pp.clickSearch();
		
		Thread.sleep(2000);
		Assert.assertTrue(pp.isProductListVisible(),"Products List  not visible...");
		
		
	}
	


}
