package com.sathya.servlet;

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

import org.mindrot.jbcrypt.BCrypt;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		String username=request.getParameter("uname");
		String password=request.getParameter("pwd");
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			PreparedStatement pstmt= con.prepareStatement("select password from login where username= ?");
			pstmt.setString(1, username);
			ResultSet rs=pstmt.executeQuery();
			if (rs.next()==true)
			{
				String encryptedPassword=rs.getString(1);
				boolean flag= BCrypt.checkpw(password, encryptedPassword);
				if (flag==true)
				{
					out.println("<h1>Login Sucess</h1>");
				}
				else
				{
					out.println("<h1>Login Failed.</h1>");
				}
				rs.close();
				pstmt.close();
				con.close();
			}
			else
			{
				out.println("<h1>Login Failed.</h1>");
			}	
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		out.println("<br>");
		out.println("<a href=index.html> Home</a>");
		out.close();
	}

}
