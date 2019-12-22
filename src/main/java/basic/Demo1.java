package basic;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo1 
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
		driver.get(" ");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("div[id='start'] button")).click();
		
		//Create a object of Fluent Class
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(50))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		
		
		WebElement eEle = wait.until(new Function<WebDriver, WebElement>() {

			//Implemation for apply method to check the element is displayed or not
			public WebElement apply(WebDriver driver) 
			{
				if (driver.findElement(By.cssSelector("div[id='finish'] h4")).isDisplayed()) {
					return driver.findElement(By.cssSelector("div[id='finish'] h4"));
				}
				else
				{
					return null;
				}
				
				
			}
		});
		 	
		System.out.println("Element is Displayed and text is :"+eEle.getText()+" "+eEle.isDisplayed());
		driver.close();
	}

}
 