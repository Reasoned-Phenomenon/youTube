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

@WebServlet("/youSignupServlet")
public class youSignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public youSignupServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		Gson gson = new GsonBuilder().create();
		
		String email = request.getParameter("email");
		String author = request.getParameter("name"); //이름 -> 작성자
		String birthDay = request.getParameter("birthDay");
		String gender = request.getParameter("gender");
		String pw = request.getParameter("pw");

		youDAO dao = new youDAO();
		youClientVO vo = new youClientVO();
		
		vo = dao.signUp(email,author,birthDay,gender,pw);
		
		if ( vo == null) {
			String end = "{\"errCode\":\"err\"}";
			out.println(gson.toJson(end));
		}
		
		out.println(gson.toJson(vo));
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
