package testData;

public class Demo1
{
	public static void main(String[] args)
	{
		String un = DataUtiliry.getPropertyData("un");
		String pw = DataUtiliry.getPropertyData("pw");
		System.out.println("UserName is :"+un);
		System.out.println("Passwword is :"+pw);
	}

}
