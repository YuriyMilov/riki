package rr.server;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.*;
import javax.servlet.http.*;


public class Ontos extends HttpServlet {
private static final long serialVersionUID = 1L;
public static int i = 0;

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {      
      response.setContentType("text/event-stream; charset=UTF8");
      PrintWriter out = response.getWriter();
      
      try {
		Thread.sleep(2222);
	} catch (InterruptedException e) {
	}          

      out.println(String.valueOf(i++));
      
  }
  

  public static String rfu_utf(String s) {
		try {
			URL url = new URL(s);

			URLConnection conn = url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(
					conn.getInputStream(), "utf8"));
			s = "";
			String thisLine = "";
			while ((thisLine = br.readLine()) != null) { // while loop begins
															// here
				s = s + thisLine + "\r\n";
			}
			br.close();
			return s.toString();

		} catch (Exception e) {
			return e.toString();
		}
	}
 
}
