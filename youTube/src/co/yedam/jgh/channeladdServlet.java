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
	      
	      String author = request.getParameter("author");
	      String content = request.getParameter("content");
	      String  email = request.getParameter("email");
	      
	      jghchannelVO comment = new jghchannelVO();
	     // System.out.println(Content);
	      
	      comment.setAuthor(author);
	      comment.setContent(content);
	      comment.setEmail(email);
	      
	      dao.insertcomment(comment);
	      
	      out.println(gson.toJson(comment));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
