package rr.server;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class SSEAsyncServlet extends HttpServlet {

	public static int i = 0;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		res.setContentType("text/event-stream");
		res.setCharacterEncoding("UTF-8");

		String s = req.getQueryString();	
		
		PrintWriter writer = res.getWriter();
		try {
			if(s!=null)
				i=Integer.parseInt(s);
			s= "The value is "+String.valueOf(i++);
			Thread.sleep(2222);
		} catch (Exception e) {
			s=e.toString();
		}
		
		writer.write("data: " + s + "\n\n");
	}
}