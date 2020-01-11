package headless;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
	public void testA() throws IOException
	{
		WebDriver driver = new PhantomJSDriver();
		driver.manage().window().maximize();
		driver.get("https://selenium.dev/");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./screenshot/abc2.png"));
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		Reporter.log("Title is :"+title,true);
		Reporter.log("Url is :"+url,true);
		driver.close();
	}

}
