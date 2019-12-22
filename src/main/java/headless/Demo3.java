package headless;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo3
{
	static
	{
		WebDriverManager.phantomjs().setup();
	}
	
	@Test
	public void testA()
	{
		WebDriver driver = new PhantomJSDriver();
		driver.manage().window().maximize();
		driver.get("https://selenium.dev/");
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		Reporter.log("Title is :"+title,true);
		Reporter.log("Url is :"+url,true);
		driver.close();
	}
}
