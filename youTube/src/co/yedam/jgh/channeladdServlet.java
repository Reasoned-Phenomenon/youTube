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


@WebServlet("/channeladdServlet")
public class channeladdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public channeladdServlet() {
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
	      
	      String Author = request.getParameter("Author");
	      String Content = request.getParameter("Content");
	      String  Email = request.getParameter("Email");
	      
	      jghchannelVO comment = new jghchannelVO();
	     // System.out.println(Content);
	      
	      comment.setAuthor(Author);
	      comment.setContent(Content);
	      comment.setEmail(Email);
	      
	      dao.insertcomment(comment);
	      
	      out.println(gson.toJson(comment));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
