package testCases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import testBase.BaseClass;

public class FindAllBrokenLinks extends BaseClass {
	
	@Test
	public void findBrokenLinks() throws MalformedURLException, IOException {
		List<WebElement> allLinks=getDriver().findElements(By.tagName("a"));
		
		System.out.println(allLinks.size());
		int count=1;
		for(WebElement ele:allLinks)
		{
			String url=ele.getAttribute("href");
						
			System.out.println(count +".url :  "+url);
			HttpURLConnection conn = (HttpURLConnection)(new URL(url).openConnection());
			conn.setRequestMethod("HEAD");
			conn.connect();
			int resCOde=conn.getResponseCode();
			if(resCOde >= 400){
			      System.out.println(url + " is broken.");
			   }
		}
	}
}
