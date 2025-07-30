package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage extends BasePage {

	public ProductsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h2[normalize-space()='All Products']")
	WebElement pageLogo;

	@FindBy(xpath = "//div[@class='col-sm-4']")
	public List<WebElement> productList;

	@FindBy(css = "a[href='/product_details/1']")
	WebElement firstViewProduct;
	@FindBy(xpath = "//input[@id='search_product']")
	WebElement txt_serach;
	@FindBy(xpath = "//button[@id='submit_search']")
	WebElement btn_search;

	@FindBy(xpath = "(//div[@class='productinfo text-center'])[1]")
	public WebElement firstProduct;

	@FindBy(xpath = "//body/section/div[@class='container']/div[@class='row']/div[@class='col-sm-9 padding-right']/div[@class='features_items']/div[2]/div[1]/div[1]/div[1]/a[1]")
	public WebElement btn_AddToCart;
	
	@FindBy(xpath="//button[normalize-space()='Continue Shopping']")WebElement btn_continueShopping;
	
	@FindBy(xpath = "//div[@id='cart_info']//tr")
	public List<WebElement> cartSelectedProdCount;
	
	@FindBy(xpath="//td[@class='cart_price']")WebElement price_tag;

	
	@FindBy(xpath="//p[@class='cart_total_price']")WebElement ttl_price_tag;
	
	@FindBy(xpath="//button[normalize-space()='4']") WebElement product_Count;
	
	
	
	public boolean pageVisible() {
		return pageLogo.isDisplayed();
	}

	public boolean isProductListVisible() {

		return productList.size() > 1;
	}

	public void clickViewProduct() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", firstViewProduct);
		js.executeScript("arguments[0].click();", firstViewProduct);

		/*
		 * Actions actions = new Actions(driver);
		 * actions.moveToElement(firstViewProduct).click().perform();
		 */
	}

	public void setSearchText(String item) {
		txt_serach.sendKeys(item);
	}

	public void clickSearch() {
		btn_search.click();
	}

	public void hoverToFirstProduct() {
	    Actions act = new Actions(driver);
	    act.moveToElement(firstProduct).perform();
	}


	public void clickAddToCart() {
		
		  ((JavascriptExecutor)
		  driver).executeScript("arguments[0].scrollIntoView(true);", btn_AddToCart);

		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  wait.until(ExpectedConditions.elementToBeClickable(btn_AddToCart));
		 

	    Actions act = new Actions(driver);
	    act.moveToElement(btn_AddToCart).click().build().perform();
	}
	
	public String ContinueShoppingVisible() {
		return btn_continueShopping.getText();
	}
	
	public void clickContinueShopping() {
		btn_continueShopping.click();
	}
	
	public boolean isCartEmpty() {
		return cartSelectedProdCount.size()>1;
	}
	
	public boolean tagVisible() {
		return price_tag.isDisplayed() && ttl_price_tag.isDisplayed();
	}
	
	public String getProductCount() {
		return product_Count.getText();
	}
}
