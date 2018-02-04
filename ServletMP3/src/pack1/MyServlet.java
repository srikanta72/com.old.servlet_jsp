package pack1;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MyServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String fileName= request.getParameter("file");
		if (fileName==null || fileName.equals(""))
		{
			throw new ServletException("invalid existance of file parameter");
		}
		if (fileName.indexOf(".mp3")==-1)
		{
			fileName=fileName+".mp3";
		}
		String mp3Dir= getServletContext().getInitParameter("mp3-dir");
		if (mp3Dir==null || mp3Dir.equals(""))
		{
			throw new ServletException("Invalid existance of mp3Dir");
		}
			ServletOutputStream stream=null;
		BufferedInputStream buf=null;
		try{
			stream=response.getOutputStream();
			File mp3=new File(mp3Dir+"/"+fileName);
			response.setContentType("audio/mpeg");
			response.addHeader("Content-Disposition","attachment; Filename="+fileName);
			response.setContentLength((int)mp3.length());
			FileInputStream input= new FileInputStream(mp3);
			buf= new BufferedInputStream(input);
			int readBytes=0;
			while ((readBytes=buf.read())!=-1)
			{
				stream.write(readBytes);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			if (stream!=null)
				stream.close();
			if (buf!=null)
				buf.close();
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
