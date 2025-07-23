package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SignupPage extends BasePage{

	public SignupPage(WebDriver driver) {
		super(driver);
	}
		

	
	@FindBy(xpath="//b[normalize-space()='Enter Account Information']") WebElement page_Logo;
	@FindBy(xpath="//input[@id='id_gender1']") WebElement btn_gender;
	@FindBy(xpath="//select[@id='days']") WebElement dob_date;
	@FindBy(xpath="//select[@id='months']") WebElement dob_month;
	@FindBy(xpath="//select[@id='years']") WebElement dob_year;
	@FindBy(xpath="//input[@id='newsletter']") WebElement btn_newsLetter;
	@FindBy(xpath="//input[@id='password']") WebElement txt_pass;
	
	@FindBy(xpath="//input[@id='first_name']") WebElement txt_firstName;
	@FindBy(xpath="//input[@id='last_name']") WebElement txt_lastName;
	@FindBy(xpath="//input[@id='company']") WebElement txt_company;
	@FindBy(xpath="//input[@id='address1']") WebElement txt_Address1;
	@FindBy(xpath="//input[@id='address2']") WebElement  txt_Address2;
	@FindBy(xpath="//input[@id='state']") WebElement txt_state;
	@FindBy(xpath="//input[@id='city']") WebElement txt_city;
	@FindBy(xpath="//input[@id='zipcode']") WebElement txt_zipcode;
	@FindBy(xpath="//input[@id='mobile_number']") WebElement txt_mbNum;
	@FindBy(xpath="//button[normalize-space()='Create Account']") public WebElement btn_createAcc;
	@FindBy(xpath="//b[normalize-space()='Account Created!']") WebElement check_AccCreated;
	@FindBy(xpath="//a[normalize-space()='Continue']")public WebElement btn_continue;
	
	
	
	
	public boolean pageVisible() {
		return	page_Logo.isDisplayed();
	}
	
	public void clickGender() {
		btn_gender.click();
	}
	public void setPassword(String pass)
	{
		txt_pass.sendKeys(pass);
	}
	
	public void setDate(String date) {
		   select = new Select(dob_date);
		    select.selectByVisibleText(date);
		//dob_date.sendKeys(date);
	}
	
	public void setMonth(String month) {
		select=new Select(dob_month);
		select.selectByVisibleText(month);
		//dob_month.sendKeys(month);
	}
	
	public void setYear(String year)
	{
		select =new Select(dob_year);
		select.selectByVisibleText(year);
		//dob_year.sendKeys(year);
	}
	public void clickNewsLetter()
	{
		btn_newsLetter.click();
	}
	
	public void setName(String name)
	{
		txt_firstName.sendKeys(name);
	}
	
	public void setLname(String lname)
	{
		txt_lastName.sendKeys(lname);
	}
	
	public void setCompany(String cmpny)
	{
		txt_company.sendKeys(cmpny);
	}
	
	public void setAdd1(String Add1)
	{
		txt_Address1.sendKeys(Add1);
	}
	public void setAdd2(String Add2)
	{
		txt_Address2.sendKeys(Add2);
	}
	public void setCity(String City)
	{
		txt_city.sendKeys(City);
	}
	public void setState(String State)
	{
		txt_state.sendKeys(State);
	}
	
	public void clickCreate()
	{
		btn_createAcc.click();
	}
	public void setZipCode(String zip) {
		txt_zipcode.sendKeys(zip);
	}
	public void setMobNo(String mobNo)
	{
		txt_mbNum.sendKeys(mobNo);
	}
	
	public boolean accountStatus() {
		return check_AccCreated.isDisplayed();
	}
	
	public void clickContinue() {
		btn_continue.click();
	}
}
