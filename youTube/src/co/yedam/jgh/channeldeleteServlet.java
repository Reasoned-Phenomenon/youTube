package co.yedam.jgh;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@WebServlet("/channeldeleteServlet")
public class channeldeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public channeldeleteServlet() {
        super();
    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		 request.setCharacterEncoding("UTF-8");
	      response.setCharacterEncoding("UTF-8");
	      response.setContentType("text/html; charset=UTF-8");
	      
	      PrintWriter out = response.getWriter();
	      Gson gson = new GsonBuilder().create();
	      
	      jghchannelDAO dao = new jghchannelDAO();
	      
	      int userNum = Integer.parseInt(request.getParameter("userNum"));
	      System.out.println(userNum);
	      
	      if(dao.deleteComment(userNum) == -1) {
	    	  out.println("{\"retcode\":\"fail\"}");
	    	  return;
	    	  
	      } else {
	    	  out.println("{\"retcode\":\"success\",\"userNum\":\""+userNum+"\"}");
	      }
	}

	 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
