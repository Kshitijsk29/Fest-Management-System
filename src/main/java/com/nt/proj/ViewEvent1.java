package com.nt.proj;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewEvent1 extends HttpServlet {

	private static final String RETRIVE_DATA ="SELECT *  FROM EVENT";
		@Override
		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
			
			res.setContentType("text/html");
			PrintWriter pw = res.getWriter();
			pw.println("<html>");
	        pw.println("<head>");
	        pw.println("<title>Event  Page</title>");
	        pw.println("<link rel=\"stylesheet\" href=\"total.css\">");
	        pw.println("<link href=\"https://fonts.googleapis.com/css2?family=Balsamiq+Sans&display=swap\" rel=\"stylesheet\">");
	        pw.println("</head>");
	        pw.println("<body>");
	        try {
	        	
	        	Class.forName("oracle.jdbc.driver.OracleDriver");
	        	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "Fullstack" ,"java138");
	        	PreparedStatement ps = con.prepareStatement(RETRIVE_DATA);
	        	ResultSet rs = ps.executeQuery();
	        	
	        	pw.println("<center><h1>Event Details</h1></center>");
	            pw.println("<br>");
	            pw.println("<div>");  
	            pw.println("<center>");
	            pw.println("<table border=1 width=75% height=20%>");  
	            pw.println("<tr><th>EventNumber</th><th>EventName</th><th>Coordinator</th><th>Coordinator Contact</th><th>Fees</th><th>Venue</th><th>Date</th>");  
	     
	            while(rs.next())
	            {
	            	String n        =rs.getString("enum");
	            	String nm    =rs.getString("ename");
	            	String co      =rs.getString("coord");
	            	String cono =rs.getString("coordnum");
	            	String f         =rs.getString("fee");
	            	String v        =rs.getString("venue");
	            	String d        =rs.getString("edate");
	         
	            	 pw.println("<tr><td>" + n + "</td><td>" + nm +"</td><td>"+co+"</td><td>"+cono+"</td><td>"+f+"</td><td>"+v+"</td><td>"+d+"</td></tr>");   
	            }
//	            while(rs!=null)
//	            {
//	            	 pw.println("<tr><td>" + rs.getString("enum") + "</td><td>" + rs.getString("ename") +"</td><td>"+rs.getString("coord")+"</td><td>"+rs.getString("coordnum")+"</td><td>"+rs.getString("fee")+"</td><td>"+rs.getString("venue")+"</td><td>"+rs.getString("date")+"</td></tr>"); 
//	            }
	            con.close(); 
	            pw.println("</table>"); 
	            pw.println("</center>");
	            pw.print("</body>");
	            pw.print("</html>");   
	        }catch(Exception e)
	        {
	        	e.printStackTrace();
	        }
		}
	}
