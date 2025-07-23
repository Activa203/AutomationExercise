package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import freemarker.template.SimpleDate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseClass {
	public static WebDriver driver;
	public Logger logger;
	public Properties prop;

	@BeforeClass()
	@Parameters({ "os", "browser" })
	public void setup(String os, String br) throws IOException {

		// loading config.prop file
		FileReader file = new FileReader(
				"E:\\Selenium Projects\\AutomationExercise\\src\\test\\resources\\config.properties");
		prop = new Properties();
		prop.load(file);
		logger = LogManager.getLogger(this.getClass());

		
		if (prop.getProperty("execution_env").equalsIgnoreCase("local")) {
			switch (br.toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			default:
				System.out.println("please provide valid browser..");
				return;
			}

		} 
		else {
			System.out.println("please select browser...");
			return;
		}
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// driver.get("http://localhost/opencart/upload/");
		driver.get(prop.getProperty("appURL"));
		driver.manage().window().maximize();
	}

	@AfterClass(groups = { "DataDriven", "Santiy", "Master", "Regression" })
	public void tearDown() {
		driver.quit();
	}
	
	 public void waitForElementToBeClickable(WebElement element, int timeoutSeconds) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
	        wait.until(ExpectedConditions.elementToBeClickable(element));
	    }

	public String generateRandomString() {
		String randomString = RandomStringUtils.randomAlphabetic(5);
		return randomString;
	}

	public String captureScreen(String tname) throws IOException {
		String timeStamp = new SimpleDateFormat("yyyyMMddhhss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile = new File(targetFilePath);
		sourceFile.renameTo(targetFile);

		return targetFilePath;
	}
}
