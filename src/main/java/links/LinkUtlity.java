package links;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.testng.Reporter;


public class LinkUtlity 
{
	public static void verifyLink(String href) throws IOException
	{
		try
		{
			URL url = new URL(href);
			HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
			httpUrlConnection.setConnectTimeout(2000);
			httpUrlConnection.connect();
			int acode = httpUrlConnection.getResponseCode();
			String msg = httpUrlConnection.getResponseMessage();
			URL pUrl = httpUrlConnection.getURL();
			if (acode == 200) {
				Reporter.log("Url is "+pUrl+"Response Code is :"+acode+"Response Msg is :"+msg);
			} 
			else 
			{
				Reporter.log("Url is "+pUrl+"Response Code is :"+acode+"Response Msg is :"+msg);
			}
			

		} 
		catch (Exception e)
		{
			
			Reporter.log("lINK IS BROKEN,",true);
		}
		
	}
}
