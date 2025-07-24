package pageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage {

	public ProductsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='All Products']") WebElement pageLogo;
	
	@FindBy(xpath="//div[@class='col-sm-4']") public List<WebElement> productList;
	
	@FindBy(css = "a[href='/product_details/1']")
	WebElement firstViewProduct;

	
	public boolean pageVisible() {
		return pageLogo.isDisplayed();
	}
	
	public boolean isProductListVisible() {
		System.out.println(productList.size());
	    return productList.size() > 0;
	}
	
	public void clickViewProduct()
	{
		
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("arguments[0].scrollIntoView(true);", firstViewProduct);
		  js.executeScript("arguments[0].click();", firstViewProduct);
		 
		
		/*
		 * Actions actions = new Actions(driver);
		 * actions.moveToElement(firstViewProduct).click().perform();
		 */
	}
}
