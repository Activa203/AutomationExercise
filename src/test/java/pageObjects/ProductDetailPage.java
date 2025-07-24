package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage extends BasePage {

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[normalize-space()='Blue Top']")
    WebElement productName;

    @FindBy(xpath = "//p[normalize-space()='Category: Women > Tops']")
    WebElement productCategory;

    @FindBy(xpath = "//span/span[contains(text(),'Rs.')]")
    WebElement productPrice;

    @FindBy(xpath = "//p[b[text()='Availability:']]")
    WebElement productAvailability;

    @FindBy(xpath = "//p[b[text()='Condition:']]")
    WebElement productCondition;

    @FindBy(xpath = "//p[b[text()='Brand:']]")
    WebElement productBrand;

    public boolean isProductDetailVisible() {
        return productName.isDisplayed() &&
               productCategory.isDisplayed() &&
               productPrice.isDisplayed() &&
               productAvailability.isDisplayed() &&
               productCondition.isDisplayed() &&
               productBrand.isDisplayed();
    }
}
