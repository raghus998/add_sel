package links;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo4
{
	static
	{
		WebDriverManager.firefoxdriver().setup(); 
	}
	@Test
	public void testA()
	{
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("file:///E:/Raghus/add_sel/htmlfiles/linkes.html");
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println(allLinks.size());
		for (WebElement link : allLinks) {
			String href = link.getAttribute("href");
			LinkUtlity.responseForLink(href);
			System.out.println("....................");
			
		}
	}

}
