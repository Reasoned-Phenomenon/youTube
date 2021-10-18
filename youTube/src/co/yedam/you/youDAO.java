package co.yedam.you;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.common.DAO;

public class youDAO extends DAO {

	public List<youHomeVO> showList () {
		
		connect();
		
		List<youHomeVO> list = new ArrayList<>();
		String sql = "SELECT * FROM home ORDER BY 6 DESC";
		
		try {
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while ( rs.next() ) {
				
				youHomeVO vo = new youHomeVO();
				vo.setViNum(rs.getInt("vi_num"));
				vo.setAuthor(rs.getString("author"));
				vo.setTitle(rs.getString("title"));
				vo.setTnTitle(rs.getString("tn_title"));
				vo.setViTitle(rs.getString("vi_title"));
				vo.setLikeIt(rs.getInt("like_it"));
				vo.setUploadDate(rs.getString("upload_date"));
				vo.setViewNum(rs.getInt("view_num"));
				vo.setCommentCnt(rs.getInt("comment_cnt"));
				
				list.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return list;
		
	}
	
	
	//파일 업로그 처리.
	//서블릿에서 파일 업로드, db저장.
	public youHomeVO uploadFile(String author, String title, String tnTitle, String viTitle) {
		
		connect();
		
		try {
			
			int nextNum = -1;
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT NVL(MAX(num),0)+1 FROM home");
			
			if ( rs.next()) {
				nextNum = rs.getInt(1);
			}
			
			String sql = "INSERT INTO home VALUES(?,?,?,?,?,0,sysdate,0,0)";
			
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, nextNum);
			psmt.setString(2, author);
			psmt.setString(3, title);
			psmt.setString(4, tnTitle);
			psmt.setString(5, viTitle);
			
			int r = psmt.executeUpdate();
			System.out.println(r+"건 입력.");
			
			youHomeVO vo = new youHomeVO();
			vo.setViNum(nextNum);
			vo.setAuthor(author);
			vo.setTitle(title);
			vo.setTnTitle(tnTitle);
			vo.setViTitle(viTitle);
			
			return vo;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			disconnect();
		}
		
	}
	
	public youHomeVO signUp () {
		
		connect();
		String sql = "INSERT INTO client VALUES(?,?,?,?)";
		
		
		try {
			
			
			
			stmt = conn.createStatement();
			youHomeVO vo = new youHomeVO();
			
			return vo;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
		
	}
	
	
	
}
