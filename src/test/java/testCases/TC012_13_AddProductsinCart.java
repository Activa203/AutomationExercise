package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductsPage;
import pageObjects.RegisterLoginPage;
import testBase.BaseClass;

public class TC012_13_AddProductsinCart extends BaseClass {

//	@Test(priority = 1)
	public void AddProductsinCart() {
		HomePage hp = new HomePage(getDriver());

		Assert.assertTrue(hp.img_logo(), "Homepage logo not visible");
		hp.clickProducts();
		
		ProductsPage pp=new ProductsPage(getDriver());
		pp.hoverToFirstProduct();
		pp.clickAddToCart();	
		pp.clickContinueShopping();
		
		hp.clickCart();
		
		Assert.assertTrue(pp.isCartEmpty(),"cart is empty..");
		
		Assert.assertTrue(pp.tagVisible(),"tags are missing..");
		

	}
	
	
	@Test(priority = 2)
	public void AddMoreProductsinCart() throws InterruptedException {
		
		  HomePage hp = new HomePage(getDriver());
		  
		  Assert.assertTrue(hp.img_logo(), "Homepage logo not visible");
		  hp.clickProducts();
		  
		  ProductsPage pp=new ProductsPage(getDriver()); pp.hoverToFirstProduct();
		  for(int i=1;i<=3;i++) { Thread.sleep(2000); pp.clickAddToCart();
		  pp.clickContinueShopping(); }
		  
		  hp.clickCart();
		  
		  Assert.assertTrue(pp.isCartEmpty(),"cart is empty..");
		  
		  Assert.assertTrue(pp.tagVisible(),"tags are missing..");
		  System.out.println(pp.getProductCount());
		  Assert.assertEquals(pp.getProductCount(),"4","product count dosent match..."
		  );
		 

		

	}
}
