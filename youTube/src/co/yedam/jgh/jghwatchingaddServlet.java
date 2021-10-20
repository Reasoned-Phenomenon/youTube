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


@WebServlet("/jghwatchingaddServlet")
public class jghwatchingaddServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
 
    public jghwatchingaddServlet() {
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
      
      String author = request.getParameter("author");
      String content = request.getParameter("content");
      
      jghwatchinglVO comment = new jghwatchinglVO();
      System.out.println(content);
      
      comment.setAuthor(author);
      comment.setContent(content);
      
      dao.insertcomment(comment);
      
      out.println(gson.toJson(comment));
   }

   
   protected void doPost(HttpServletRequest request, HttpServletResponse response) 
         throws ServletException, IOException {
   
      doGet(request, response);
   }

}
