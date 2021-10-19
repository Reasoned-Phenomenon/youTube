package co.yedam.you;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/youSigninServlet")
public class youSigninServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public youSigninServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		Gson gson = new GsonBuilder().create();
		
		String email = request.getParameter("email");
		String pw = request.getParameter("pw"); 
		//이름 -> 작성자
		youDAO dao = new youDAO();
		String code = null;
		String author = dao.signIn(email, pw);
		if (!author.isEmpty()) {
			 code = "{\"code\":\"success\",\"email\":\"" + email + "\",\"author\":\""+ author +"\"}";
		} else {
			 code = "{\"code\":\"fail\"}";
		}
		System.out.println(code);
		out.println(gson.toJson(code));
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
