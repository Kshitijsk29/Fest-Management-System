package com.nt.proj;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VaPa extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res)  
	        throws ServletException, IOException {  
	    res.setContentType("text/html");  
	    PrintWriter pw = res.getWriter();  
	    
	    //Fetching data  from HTML form
	    String n=req.getParameter("Pausername");  
	    String p=req.getParameter("Papassword");  
	          
	    if(LoginDao.validate(n, p))
	    {  
	        RequestDispatcher rd=req.getRequestDispatcher("ParticipantEvent.html");  
	        rd.forward(req,res);  
	    }    
	    else
	    { 
	        pw.print("<center><h1>Sorry username and password incorrect</h1></center>");  
	        RequestDispatcher rd=req.getRequestDispatcher("Plogin.html");  
	        rd.include(req,res);  
	    }  
	    pw.close();  
	  }  
	}  