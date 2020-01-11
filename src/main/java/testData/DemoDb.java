package testData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class DemoDb 
{
	@Test
	public void testA() throws SQLException
	{
		String url = "jdbc:mysql://localhost:3306/sel";
		String un = "root";
		String pw = "root";
		
		//Conect to DB
		Connection con = DriverManager.getConnection(url, un, pw);
		
		//To send the Query to DB(path)
		Statement stmt = con.createStatement();
		
		//Send the Query to DB and get the record
		ResultSet res = stmt.executeQuery("select * from EmpInfo where Name='Raghus'");
		
		while(res.next())
		{
			String name = res.getString("Name");
			Reporter.log("Name is :"+name,true);
			String id = res.getString("Id");
			Reporter.log("Id is :"+id,true);
			String dept = res.getString("Dept");
			Reporter.log("Dept is :"+dept,true);
			String gender = res.getString("Gender");
			Reporter.log("Gender is :"+gender,true);
			String name1 = res.getString(1);
			Reporter.log("Name is :"+name1,true);
			
		}
		//to disconnect
		con.close();	
	}

}
