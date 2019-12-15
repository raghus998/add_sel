package links;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.Test;

public class Demo1 
{
		@Test
		public void testA() throws IOException
		{
			try
			{
				URL url = new URL("https://selenium.dev/dbhgjhjnownloads/");
				HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
				httpUrlConnection.setConnectTimeout(2000);
				httpUrlConnection.connect();
				if (httpUrlConnection.getResponseCode() == 200) {
					System.out.println(httpUrlConnection.getURL()+"is working Fine.Response Code is :"+httpUrlConnection.getResponseCode()+"Response Msg is :"+httpUrlConnection.getResponseMessage());
					
				} else {
					System.out.println(httpUrlConnection.getURL()+"is broken.Response Code is :"+httpUrlConnection.getResponseCode()+"Response Msg is :"+httpUrlConnection.getResponseMessage());
				}
			} 
			catch (MalformedURLException e)
			{
				e.printStackTrace();
			}
			
		}

}
