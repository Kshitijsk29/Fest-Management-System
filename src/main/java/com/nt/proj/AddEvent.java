package com.nt.proj;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddEvent extends HttpServlet {
	private static final String  INSERT_QUERY ="INSERT INTO EVENT VALUES (?,?,?,?,?,?,?)";
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			PrintWriter pw = res.getWriter();
			res.setContentType("text/html");
			
			String eventNo= req.getParameter("EventNo");
			String eventName = req.getParameter("EventName");
			String co_Name =req.getParameter("coordinatorName");
			String co_No =req.getParameter("CoordinatorNo");
			String fee = req.getParameter("fee");
			String venue = req.getParameter("venue");
			String date= req.getParameter("date");
			
 try {
	 Class.forName("oracle.jdbc.driver.OracleDriver");
	 Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "Fullstack", "java138");
	 PreparedStatement ps = con.prepareStatement(INSERT_QUERY);
	 ps.setString(1, eventNo);
	 ps.setString(2,eventName);
	 ps.setString(3, co_Name);
	 ps.setString(4, co_No);
	 ps.setString(5, fee);
	 ps.setString(6, venue);
	 ps.setString(7, date);
	
	 int count = 0;
	 count = ps.executeUpdate();
	 
	 RequestDispatcher rd = req.getRequestDispatcher("CreateEvent.html"); 
	 rd.forward(req, res);
 
	 pw.println("<br><center><h3> Event Added</h3></center>");
     System.out.println("Added to database!");
     con.close();
 }
 catch(SQLException se)
 {
	 se.printStackTrace();
 }
 catch(Exception e)
 {
	 e.printStackTrace();
 }
			
	}
}
