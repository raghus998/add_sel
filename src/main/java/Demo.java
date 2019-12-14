import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {
	static {
		WebDriverManager.firefoxdriver().setup();
	}
	@Test
	public void testA() throws InterruptedException
	{
		int count = 0;
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://selenium.dev/");
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		Reporter.log("Total links Are :"+allLinks.size(),true);
		WebElement fotter = driver.findElement(By.tagName("footer"));
		List<WebElement> fotterLinks = fotter.findElements(By.tagName("a"));
		Reporter.log("Fotter links Are :"+fotterLinks.size(),true);
		driver.close();
		
		
		

}
}