package basic;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo2 
{
	static
	{
		WebDriverManager.chromedriver().setup();
	}
	@Test
	public void testA() throws IOException, AWTException, InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.actitime.com/login.do");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager"); 
		driver.findElement(By.id("loginButton")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("(//div[@class='menu_icon'])[3]")).click();
		driver.findElement(By.linkText("Contact actiTIME Support")).click();
		driver.findElement(By.xpath("//div[@class='icon dz-clickable']")).click();
		Thread.sleep(3000);
		/*TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./screenshot/popup.png"));*/
		//create object of Robot class
		Robot r = new Robot();
		//Get the Size of Screen
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		//Crate RectAngle class
		Rectangle rect = new Rectangle(d);
		//Take the screenshot
		BufferedImage img = r.createScreenCapture(rect);
		//store in loc
		ImageIO.write(img, "png", new File("./screenshot/popup1.png"));
		
		driver.close();
	}

}
