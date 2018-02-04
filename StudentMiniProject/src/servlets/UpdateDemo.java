package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateDemo
 */
@WebServlet("/update")
public class UpdateDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con=null;
		PreparedStatement ps=null;
		int rs=0;
		try{
			PrintWriter pw=response.getWriter();
			response.setContentType("text/html");
			pw.println("<html><form target='display'>");
			int sid=Integer.parseInt(request.getParameter("sid"));
			String sname=request.getParameter("sname");
			String sadd=request.getParameter("sadd");
			
			//Databse Connection
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			System.out.println("Connection to DB just made");
			ps=con.prepareCall("update student_info set sadd=?, sname=?, where sid=?)");
			ps.setString(1,sadd);
			ps.setString(2, sname);
			ps.setInt(3,  sid);
			rs=ps.executeUpdate();
			if(rs!=1)
				pw.println("<h2>Record is invalid or id is invalid </h2>");
			else
				pw.println("<h2 style='position:absolute;left:50;top;50'>One Record inserted sucessfully</h2>");
			ps.close();
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
