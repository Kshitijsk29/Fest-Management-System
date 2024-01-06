package com.nt.proj;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ValidateAd extends HttpServlet{
	
	@Override
	public  void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {		
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		String uname =req.getParameter("Ausername");
		String pass =req.getParameter("Apassword");
		
		String u1 ="A101";
		String p1 ="1234";
		
		String u2 ="A102";
		String p2 ="5678";
		
		String u3 ="A103";
		String p3 ="ABCD";
		
		String u4 ="A104";
		String p4 ="abcd";
		
		if(uname.equals(u1) && pass.equals(p1))
		{
			RequestDispatcher rd = req.getRequestDispatcher("AdminEvent.html");
			rd.forward(req, res);
		}
		else if(uname.equals(u2) && pass.equals(p2))
		{
			RequestDispatcher rd = req.getRequestDispatcher("AdminEvent.html");
			rd.forward(req, res);
		}
		else if(uname.equals(u3) && pass.equals(p3))
		{
			RequestDispatcher rd = req.getRequestDispatcher("AdminEvent.html");
			rd.forward(req, res);
		}
		else if(uname.equals(u4) && pass.equals(p4))
		{
			RequestDispatcher rd = req.getRequestDispatcher("AdminEvent.html");
			rd.forward(req, res);
		}
		else
		{
			pw.println("<center><h1>!! Please Enter Valid Username & Password for Admin !!</h1><center>");
			RequestDispatcher rd = req.getRequestDispatcher("Alogin.html");
			rd.include(req, res);
		}
		pw.close();
	}

}
