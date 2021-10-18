package co.yedam.you;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/youUploadServlet")
public class youUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public youUploadServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		Gson gson = new GsonBuilder().create();
		
		youDAO dao = new youDAO();
			
		ServletContext context = getServletContext();
		String saveDir = context.getRealPath("upload");
		int maxSize = 1024 * 1024 *30; //30메가
		String encoding = "UTF-8";
		
		//request요청정보, saveDir저장폴더위치, maxFileSize, encode, renamePolicy
		MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy()); 
		
		String author = multi.getParameter("author");
		String title = multi.getParameter("title");
		String tn = multi.getFilesystemName("tn");
		String vi = multi.getFilesystemName("vi");
		
		youHomeVO vo = dao.uploadFile(author,title,tn, vi);
		response.getWriter().println( gson.toJson(vo) );
		
		System.out.println(saveDir);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
