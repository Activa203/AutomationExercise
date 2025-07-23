package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends BasePage{

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='Get In Touch']") WebElement page_visible;
	@FindBy(xpath="//input[@placeholder='Name']") WebElement txt_Name;
	@FindBy(xpath="//input[@placeholder='Email']") WebElement txt_Email;
	@FindBy(xpath="//input[@placeholder='Subject']") WebElement txt_Subject;
	@FindBy(xpath="//textarea[@id='message']") WebElement txt_msg;
	@FindBy(xpath="//input[@name='submit']") WebElement btn_submit;
	@FindBy(xpath="//input[@name='upload_file']") WebElement file_upload;
	@FindBy(xpath="//div[@class='status alert alert-success']") WebElement alertSuccessMessage;
	@FindBy(xpath="//span[normalize-space()='Home']") WebElement btn_home;
	
	public boolean isContactPageVisible() {
	    return page_visible.isDisplayed();
	}

	public void setName(String name) {
	    txt_Name.sendKeys(name);
	}

	public void setEmail(String email) {
	    txt_Email.sendKeys(email);
	}

	public void setSubject(String subject) {
	    txt_Subject.sendKeys(subject);
	}

	public void setMessage(String message) {
	    txt_msg.sendKeys(message);
	}

	public void uploadFile(String filePath) {
	    file_upload.sendKeys(filePath);
	}

	public void clickSubmit() {
	    btn_submit.click();
	}
	
	public String getSuccessMessageText() {
		return alertSuccessMessage.getText();
	}
	
	public void clickHome() {
		btn_home.click();
	}

}
