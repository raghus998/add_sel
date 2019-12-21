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

public class Demo6 
{
	static
	{
		WebDriverManager.firefoxdriver().setup(); 
	}
	@Test
	public void testA() throws IOException
	{
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("file:///E:/Raghus/add_sel/htmlfiles/images.html");
		List<WebElement> allImages = driver.findElements(By.tagName("img"));
		System.out.println("Total no of Images :"+allImages.size());
		for (WebElement image : allImages) {
			String src = image.getAttribute("src");
			URL url = new URL(src);
			HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
			httpUrlConnection.connect();
			int code = httpUrlConnection.getResponseCode();
			String msg = httpUrlConnection.getResponseMessage();
			String value = image.getAttribute("value");
			if (code == 200) 
			{
				System.out.println(value+"image is working fine"+"Response Code is :"+code);
				
			} else 
			{
				System.out.println(value+"image is broken "+"Response Code is :"+code);

			}
			
			
		}

}
}