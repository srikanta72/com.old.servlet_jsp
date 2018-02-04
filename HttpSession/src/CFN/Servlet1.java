package CFN;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		PrintWriter out= response.getWriter();
		HttpSession session= request.getSession();
		out.println("ID :"+session.getId());
		out.println("<br>");
		out.println("Is it a new User: "+session.isNew());
		out.println("<br>");
		long ms= session.getCreationTime();
		java.util.Date d1= new java.util.Date(ms);
		out.println("Creation time: "+ d1);		
		out.println("<br>");
		long ms2= session.getLastAccessedTime();
		java.util.Date d2= new java.util.Date(ms2);
		out.println("Creation time: "+ d2);
		out.println("<br>");
		out.println("Time out: "+session.getMaxInactiveInterval());
		out.close();
		
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
