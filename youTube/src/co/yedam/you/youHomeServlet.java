package co.yedam.you;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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

@WebServlet("/youHomeServlet")
public class youHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public youHomeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		Gson gson = new GsonBuilder().create();
		
		String cmd = request.getParameter("cmd");
		youDAO dao = new youDAO();
		
		if (cmd.equals("list")) {
			
			List<youHomeVO> list = dao.showList();
			out.println(gson.toJson(list));
			
		} 
		
		else if (cmd.equals("upload")) {
			
			ServletContext context = getServletContext();
			String saveDir = context.getRealPath("upload");
			int maxSize = 1024 * 1024 *30; //30메가
			String encoding = "UTF-8";
			
			//request요청정보, saveDir저장폴더위치, maxFileSize, encode, renamePolicy
			MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy()); 
			
			String author = multi.getParameter("author");
			String title = multi.getParameter("title");
			String file = multi.getFilesystemName("file");
			
			youHomeVO vo = dao.uploadFile(author, title, file);
			response.getWriter().println( gson.toJson(vo) );
			
			System.out.println(saveDir);
		}	
		
//		else if (cmd.equals("mod")) {
//			
//			//cmd���� mod�̸� ������� ȣ��
//			System.out.println("<h1>���� �������Դϴ�.</h1>");
//			
//			String id = request.getParameter("id");
//			String name = request.getParameter("name");
//			String content = request.getParameter("content");
//			
//			Comment comment = new Comment();
//			comment.setId(id);
//			comment.setName(name);
//			comment.setContent(content);
//			
//			dao.updateComment(comment);
//			
//			out.println(gson.toJson(comment));
//			
//		} else if (cmd.equals("del")) {
//			
//			//cmd���� del�̸� ������� ȣ��
//			System.out.println("<h1>���� �������Դϴ�.</h1>");
//			String id = request.getParameter("id");
//			
//			if(dao.deleteComment(id) == null) {
//				
//				//{"retCode":"fail"}
//				out.println("{\"retCode\":\"fail\"}");
//				return;
//				
//			} else {
//				
//				out.println("{\"retCode\":\"success\"}");
//				
//			}
//			
//		} else {
//			out.println("<h1>" + cmd + "</h1>");
//		}
//	
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
