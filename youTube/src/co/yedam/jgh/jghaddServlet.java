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


@WebServlet("/jghaddServlet")
public class jghaddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public jghaddServlet() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		Gson gson = new GsonBuilder().create();
		
		jghDAO dao = new jghDAO();
		
		String id = request.getParameter("id");
		String content = request.getParameter("content");
		
		jghwatchinglVO comment = new jghwatchinglVO();
		System.out.println(id);
		
		comment.setId(id);
		comment.setContent(content);
		
		
		dao.insertcomment(comment);
		
		out.println(gson.toJson(comment));
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
		doGet(request, response);
	}

}
