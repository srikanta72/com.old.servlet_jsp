package pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

/**
 * Servlet implementation class PdfServlet
 */
public class PdfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PdfServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/pdf");
		ServletOutputStream sos= response.getOutputStream();
		try{
			Document d= new Document();
			PdfWriter pw= PdfWriter.getInstance(d, sos);
			d.open();
			Paragraph p= new Paragraph();
			p.add("In today’s fast moving world, automobiles are facing challenges in terms of having to survive road accidents, increasing traffic, bad road-conditions and high/express ways. Brake systems play a vital role in controlling the vehicle speed while avoiding road accidents. ");
			Table t= new Table(2);
			t.addCell("Company Name");
			t.addCell("Websites");
			t.addCell("Google");
			t.addCell("www.google.co.in");
			t.addCell("Microsoft");
			t.addCell("www.ms.com");
			t.addCell("Facebook");
			t.addCell("www.facebook.com");
			d.add(p);
			d.add(t);
			d.close();
		}
		catch(Exception e){
			System.out.println(e);
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
