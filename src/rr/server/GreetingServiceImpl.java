package rr.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rr.client.GreetingService;
import rr.shared.FieldVerifier;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {
	
	

	protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
		
        System.out.println("======> Greeting Service called!");
   
    }
	
	public String greetServer(String input) throws IllegalArgumentException {

		try {
			Thread.sleep(2222);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
		HttpServletRequest req = this.getThreadLocalRequest();
		String s= req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + req.getContextPath();
		
		s=rfu_utf(s+"/sse?7");
		return "SSE setup to 7 ";
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
