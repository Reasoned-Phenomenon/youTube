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
	
public List<youHomeVO> topList () {
		
		connect();
		
		List<youHomeVO> list = new ArrayList<>();
		String sql = "SELECT * FROM home ORDER BY 8 DESC";
		
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
			rs = stmt.executeQuery("SELECT NVL(MAX(vi_num),0)+1 FROM home");
			
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
	
	public youClientVO signUp (String email, String author, String birthDay, String gender, String pw) {
		
		connect();
		
		try {
			int beforeClientNum=0;
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT MAX(user_num) FROM client");
			
			youClientVO vo = new youClientVO();
			
			if (rs.next()) {
				
				beforeClientNum = rs.getInt("MAX(user_num)");
				
			}
			
			psmt = conn.prepareStatement("INSERT INTO client VALUES(?,?,?,?,?,?)");
			
			psmt.setString(1, email);
			psmt.setInt(2, beforeClientNum+1);
			psmt.setString(3, author);
			psmt.setString(4, birthDay);
			psmt.setString(5, gender);
			psmt.setString(6, pw);
			
			int r = psmt.executeUpdate();
			System.out.println(r+"건 입력 완료");
			
			vo.setEmail(email);
			vo.setUserNum(beforeClientNum+1);
			vo.setAuthor(author);
			vo.setBirthDay(birthDay);
			vo.setGender(gender);
			vo.setPw(pw);
			
			return vo;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			disconnect();
		}
		
	}
	
	public String signIn (String email, String pw) {
		
		connect();
		
		try {
			
			String dbPw = null;
			String author = null;
			String sql = "SELECT * FROM client WHERE email=?";
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, email);
			rs = psmt.executeQuery();
			
			if ( rs.next() ) {
				
				dbPw = rs.getString("pw");
				author = rs.getString("author");
				
			}
			
			if ( dbPw.equals(pw)) {
				return author;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			disconnect();
		}
		return null;
		
	}
	
}
