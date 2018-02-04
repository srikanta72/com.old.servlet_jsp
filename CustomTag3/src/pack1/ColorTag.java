package pack1;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ColorTag extends SimpleTagSupport {
	private String cname;
	

	public String getCname() {
		return cname;
	}


	public void setCname(String cname) {
		this.cname = cname;
	}


	public void doTag() throws JspException, IOException
	{
		PageContext pageContext=(PageContext)getJspContext();
		JspWriter out= pageContext.getOut();
		JspFragment body= getJspBody();
		StringWriter sw=new StringWriter();
		body.invoke(sw);
		out.println("<font color="+ cname+ ">");
		out.println(sw);
		out.println("</font>");
		
	}
}
