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


@WebServlet("/jghwatchingdeleteServlet")
public class jghwatchingdeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public jghwatchingdeleteServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		  request.setCharacterEncoding("UTF-8");
	      response.setCharacterEncoding("UTF-8");
	      response.setContentType("text/html; charset=UTF-8");
	      
	      PrintWriter out = response.getWriter();
	      Gson gson = new GsonBuilder().create();
	      
	      jghwatchingDAO dao = new jghwatchingDAO();
	      
	      String id = request.getParameter("id");
	      
	      dao.deleteComment(id);
	      
	      out.println(gson.toJson(id));
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
