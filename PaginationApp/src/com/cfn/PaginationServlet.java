package com.cfn;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PaginationServlet
 */
public class PaginationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaginationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    Connection con=null;
    Statement stmt=null;
	public void init(ServletConfig config) throws ServletException {
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}		
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try{
			stmt.close();
			con.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			response.setContentType("text/html");
			PrintWriter out= response.getWriter();
			int pageNumber=Integer.parseInt(request.getParameter("no"));
			stmt= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs= stmt.executeQuery("select empno,ename,sal,deptno from emp");
			int start= pageNumber*4-4+1;
			rs.absolute(start);
			out.println("<center><table border=2>");
			int i=1;
			do{
			out.println("<tr>");
			out.println("<td>"+rs.getString(1)+"</td>");
			out.println("<td>"+rs.getString(2)+"</td>");
			out.println("<td>"+rs.getString(3)+"</td>");
			out.println("<td>"+rs.getString(4)+"</td>");
			out.println("</td>");
			i++;
		}while(rs.next() && i!=5);
		out.println("</table>");
		rs.last();
		int total= rs.getRow();
		int pages=total/4;
		
		if (total%4!=0)
		{
			pages++;
		}
		if (pageNumber==1)
		{
			out.println(pageNumber);
			for (int m=2; m<4;m++)
			{
				out.println("<a href=pagination?no="+m+">"+m+"</a>");
			}
			int n=pageNumber+1;
			out.println("&nbsp;&nbsp;&nbsp;&nbsp;");
			out.println("<a href=pagination?no="+n+"> Next-> </a>");
		}
		else if(pageNumber==pages)
		{			
			int n=pageNumber-1;
			out.println("<a href=pagination?no="+n+"> <-Prev </a>");
			for (int m=2; m<4;m++)
			{
				out.println("<a href=pagination?no="+m+">"+m+"</a>");
			}
			out.println(pageNumber);
		}
		else
		{
			int n=pageNumber-1;
			out.println("<a href=pagination?no="+n+"><- Prev </a>");
			for (int m=2; m<5;m++)
			{
				if (m==pageNumber)
				{
					out.println(m);
				}
				else{
				out.println("<a href=pagination?no="+m+">"+m+"</a>");
				}
			}
			int n1= pageNumber+1;
			out.println("&nbsp;&nbsp;&nbsp;&nbsp;");
			out.println("<a href=pagination?no="+n1+"> Next-> </a>");
		}
		out.println("<form action=pagination>");
		out.println("Go to<input type=text name=no>");
		out.println("<input type=submit value=submit><br></form>");
		out.println("<h1>Enter only number between 1 to "+pages+"</h1>");
		out.println("</center>");
		out.close();
		rs.close();
		}
		catch( Exception e)
		{
			response.sendRedirect("error.html");
		}
		
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
