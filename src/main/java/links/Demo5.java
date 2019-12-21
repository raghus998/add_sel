package links;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo5
{
	static
	{
		WebDriverManager.firefoxdriver().setup();
	}
	WebDriver driver;
	@Test   
	public void testA() throws IOException 
	{
		 URL url = new URL("https://demo.actitime.com/favicon2.ico");
		 HttpURLConnection httpUrlConection = (HttpURLConnection) url.openConnection();
		 httpUrlConection.connect();
		int code = httpUrlConection.getResponseCode();
		System.out.println(code);

}
}