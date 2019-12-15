package links;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.testng.annotations.Test;

public class Demo 
{
	@Test
	public void testA() throws IOException
	{
		//Specify urlto be tested
		URL url = new URL("https://selenium.dev/downloads/");
		
		//establish the conection
		HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
		
		//connect to url
		httpConnection.connect();
		
		//to get response code
		int code = httpConnection.getResponseCode();
		//to get tesponse msg
		String msg = httpConnection.getResponseMessage();
		URL url1 = httpConnection.getURL();
		System.out.println("Response Code is :"+code);
		System.out.println("Response Msg  is :"+msg);
		System.out.println("Url  is :"+url1);
	}

}
