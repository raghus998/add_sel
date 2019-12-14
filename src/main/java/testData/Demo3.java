package testData;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import testData.DataUtiliry;

public class Demo3
{
	
	static
	{
		WebDriverManager.firefoxdriver().setup();
	}
	@Test
	public void testA() throws InterruptedException
	{
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String url = DataUtiliry.getPropertyData("url");
		String un = DataUtiliry.getPropertyData("un");
		String pw = DataUtiliry.getPropertyData("pw");
		driver.get(url);
		driver.findElement(By.id("username")).sendKeys(un);
		Thread.sleep(2000);
		driver.findElement(By.name("pwd")).sendKeys(pw);
		Thread.sleep(2000);
		driver.findElement(By.id("loginButton")).click();
	}

}
