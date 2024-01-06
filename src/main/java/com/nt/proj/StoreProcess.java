package com.nt.proj;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StoreProcess extends HttpServlet {
	private static final String INSERT_QUERY ="INSERT INTO PLOGINDETAILS VALUES (?,?,?)";
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		String pUserName = req.getParameter("Pusername");
		String Ppassword = req.getParameter("Ppassword");
		String Cpassword = req.getParameter("Cpassword");
		String pName =req.getParameter("Pname");
		
		if(Ppassword.equals(Cpassword))
		{
			try 
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","Fullstack", "java138");
				PreparedStatement ps = con.prepareStatement(INSERT_QUERY);
				 if(ps!=null)
				 {
					 ps.setString(1,pUserName );
					 ps.setString(2,Ppassword );
					 ps.setString(3, pName);
				 }
				 int result = 0;
				 result = ps.executeUpdate();
			
				 RequestDispatcher rd = req.getRequestDispatcher("Plogin.html");
				 rd.forward(req, res);
				 con.close();
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		else
		{
			pw.println("<center><h1>!! Please Enter Passwprd And Confirm Password same  !!</h1></center> ");
			RequestDispatcher rd =req.getRequestDispatcher("Psignup.html");
			rd.include(req, res);
		}
	}
}