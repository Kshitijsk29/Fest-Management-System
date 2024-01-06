package com.nt.proj;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class LoginDao {
	private static final String LOGIN_QUERY ="SELECT * FROM PLOGINDETAILS WHERE USER_NAME=? AND PASS_WORD=?";
	static boolean status =false;
	public static boolean validate(String User_name ,String Pass_word)throws IOException 
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(ClassNotFoundException cnfe)
		{
			cnfe.printStackTrace();
		}
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","Fullstack","java138");
				PreparedStatement ps =con.prepareStatement(LOGIN_QUERY);)
		{
			if(ps!=null)
			{
				ps.setString(1, User_name);
				ps.setString(2, Pass_word);
			}
			try(ResultSet rs=ps.executeQuery();)
			{
				status =rs.next();
			}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		return status;
	}
}//class
