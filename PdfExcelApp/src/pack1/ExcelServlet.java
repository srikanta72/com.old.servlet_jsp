package pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;


/**
 * Servlet implementation class ExcelServlet
 */
public class ExcelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/vnd.ms-excel");
		HSSFWorkbook wb= new HSSFWorkbook();
		Sheet sheet= wb.createSheet("sheet2");
		Row r1= sheet.createRow(0);
		Cell c1= r1.createCell(0);
		c1.setCellValue("Comapny names");
		Cell c2= r1.createCell(1);
		c2.setCellValue("Website");
		Row r2= sheet.createRow(1);
		Cell c3= r2.createCell(0);
		c3.setCellValue("Oracle");
		Cell c4= r2.createCell(1);
		c4.setCellValue("www.oracle.com");
		Row r3= sheet.createRow(2);
		Cell c5= r3.createCell(0);
		c5.setCellValue("IBM");
		Cell c6= r3.createCell(1);
		c6.setCellValue("ww.ibm.com");
		ServletOutputStream sos= response.getOutputStream();
		wb.write(sos);
		sos.close();
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
