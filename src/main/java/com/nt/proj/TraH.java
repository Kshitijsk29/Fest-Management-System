package com.nt.proj;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TraH extends HttpServlet 
{
	
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			res.setContentType("text/html");
	        PrintWriter pw = res.getWriter();
	         pw.println("<!DOCTYPE html>");
	         pw.println("<html>");
	         pw.println("<head>");
	         pw.println("<title> Transactions Page</title>");
	         pw.println("<link rel=\"stylesheet\" href=\"total.css\">");
	         pw.println("<link href=\"https://fonts.googleapis.com/css2?family=Balsamiq+Sans&display=swap\" rel=\"stylesheet\">");
	         pw.println("</head>");
	         pw.println("<body>");
	    
	    try {
	    	Class.forName("oracle.jdbc.driver.OracleDriver");
	    	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "Fullstack","java138");
	    	Statement st = con.createStatement();
	    	ResultSet rs= st.executeQuery("SELECT * FROM CARD");
	    	
	    	pw.println("<center><h1> Registration Details </h1></center>");
	    	pw.println("<div>");
	    	pw.println("<center>");
	    	pw.println("<table border=1 width=50% height=50%>");
	    	pw.println("<tr><th>Event No</th><th>Event Name</th><th> Name</th><th>Payment Date</th>");
	    	while(rs.next())
	    	{
	    		String en = rs.getString("enum");
	    		String re = rs.getString("ename");
	    		String pd = rs.getString("pdate");
	    		String name = rs.getString("cname");
	    		pw.println("<tr><td>"+en+"</td><td>"+re+"</td><td>"+name+"</td><td>"+pd+"</td></tr>");
	    	}
	    }
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    	}
	}
}
