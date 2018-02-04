package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet2
 */
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int sal=Integer.parseInt(request.getParameter("sal").trim());
		double da= (Double)request.getAttribute("da");
		double hra= sal*0.24;
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		RequestDispatcher rd= request.getRequestDispatcher("header");
		rd.include(request, response);
		out.println("<hr>");
		out.println("<center>");
		out.println("Salary: "+sal);
		out.println("<br>");
		out.println("HRA: "+hra);
		out.println("</center>");
		out.println("</hr>");
		RequestDispatcher rd2=request.getRequestDispatcher("footer");
		rd2.include(request, response);
		out.close();
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
