package headless;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo
{
	static
	{
		WebDriverManager.chromedriver().setup();
	}
	@Test
	public void testA() throws IOException, InterruptedException
	{
		ChromeOptions co = new ChromeOptions();
		co.setHeadless(false);
		
		WebDriver driver = new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.get("https://selenium.dev/");
		Thread.sleep(2000);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./screenshot/abc.png"));
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		Reporter.log("Title is :"+title,true);
		Reporter.log("Url is :"+url,true);
		driver.close();
		
		
	}

}
