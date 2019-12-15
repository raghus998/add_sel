package links;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo2
{
	static
	{
		WebDriverManager.firefoxdriver().setup();
	}
	@Test
	public void testA() throws IOException 
	{
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://selenium.dev/downloads/");
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		System.out.println("No of links are :"+allLinks.size());
		for (WebElement link : allLinks) {
			String href = link.getAttribute("href");
			
			try 
			{
				URL url = new URL(href);
				HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
				httpUrlConnection.connect();
				if (httpUrlConnection.getResponseCode() == 200) {
					System.out.println(httpUrlConnection.getURL()+" url is working Fine.Response Code is :"+httpUrlConnection.getResponseCode()+"Response Msg is :"+httpUrlConnection.getResponseMessage());
					
				} 
				else 
				{
					System.out.println(httpUrlConnection.getURL()+"url is broken.Response Code is :"+httpUrlConnection.getResponseCode()+"Response Msg is :"+httpUrlConnection.getResponseMessage());
				}
			} 
			catch (MalformedURLException e) 
			{
				
				e.printStackTrace();
			}
			
			System.out.println("**************************************************");
			
		}
	}

}
