package links;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo3 
{
	static
	{
		WebDriverManager.firefoxdriver().setup();
	}
	WebDriver driver;
	@Test
	public void testA() throws IOException 
	{
		 driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://selenium.dev/downloads/");
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println("No of links are :"+allLinks.size());
		for (WebElement link : allLinks) {
			String href = link.getAttribute("href");
			LinkUtlity.verifyLink(href);
			
		}

}
}