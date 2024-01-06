package com.nt.proj;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Register extends HttpServlet {
	
	private static final String INSERT_QUERY ="INSERT INTO CARD VALUES (?,?,?,?,?,?,?)";
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		String cardno =req.getParameter("cardno");
		String cname = req.getParameter("cname");
		String  eno = req.getParameter("enum");
		String ename = req.getParameter("ename");
		String edate = req.getParameter("edate");
		String cvv= req.getParameter("cvv");
		 //java.util.Date date = new java.util.Date();
		 LocalDate ldt = LocalDate.now();
		 String cu_date =ldt.toString();
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "Fullstack","java138");
			PreparedStatement ps = con.prepareStatement(INSERT_QUERY);
			ps.setString(1, cardno);
			ps.setString(2, edate);
			ps.setString(3, cvv);
			ps.setString(4, cname);
			ps.setString(5, eno);
			ps.setString(6,ename);
			ps.setString(7, cu_date);
			int count =0;
			if(ps!=null)
				 count = ps.executeUpdate();
			
			con.close();
			RequestDispatcher rd = req.getRequestDispatcher("success.html");
			rd.forward(req, res);
		}catch(SQLException se)
		{
			se.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
