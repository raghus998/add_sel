package listers;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo 
{
	@Test
	public void testA()
	{
		Reporter.log("TestA()............",true);
	}
	
	@Test
	public void testB()
	{
		Reporter.log("TestB()............",true);
	}

}
