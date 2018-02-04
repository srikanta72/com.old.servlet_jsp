package cfn;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class Servlet1
 */
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Properties p= new Properties();
		p.put("java.naming.factory.intial", "weblogic.jndi.WLInitialContextFactory");
		p.put("java.naming.provider.url", "t3://localhost:7001");
		try{
			Context c=new InitialContext(p);
			Object o= c.lookup("testjndi");
			DataSource ds= (DataSource)o;
			Connection con=ds.getConnection();
			Statement st= con.createStatement();
			ResultSet r= st.executeQuery("select empno, ename, sal, deptno from emp");
			out.println("<table border=2>");
			while (r.next())
			{
				out.println("<tr>");
				out.println("<td>"+r.getInt(1)+"</td>"+"<td>"+r.getString(2)+"</td>"+"<td>"+r.getInt(3)+"</td>"+"<td>"+r.getInt(4)+"</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.close();
			st.close();
			con.close();
		}
			catch(Exception e)
		{
				e.printStackTrace();
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
