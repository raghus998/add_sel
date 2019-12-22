package headless;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo1 
{
	static
	{
		WebDriverManager.firefoxdriver().setup();
	}
	@Test
	public void testA() throws IOException
	{
		FirefoxOptions fo = new FirefoxOptions();
		fo.setHeadless(true);
		WebDriver driver = new FirefoxDriver(fo);
		driver.manage().window().maximize();
		driver.get("https://selenium.dev/");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./screenshot/abc1.png"));
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		Reporter.log("Title is :"+title,true);
		Reporter.log("Url is :"+url,true);
		driver.close();
	}

}
