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

@WebServlet("/youWatchServlet")
public class youWatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public youWatchServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		Gson gson = new GsonBuilder().create();
		youDAO dao = new youDAO();
		youHomeVO vo = new youHomeVO();
		
		String num = request.getParameter("viNum");
		int viNum = Integer.parseInt(num);
		vo = dao.getVideo(viNum);
		System.out.println(vo.getViewNum());
		out.println(gson.toJson(vo));
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
