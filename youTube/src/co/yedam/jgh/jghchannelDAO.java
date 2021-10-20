package co.yedam.jgh;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.common.DAO;

public class jghchannelDAO extends DAO {

	public List<jghchannelVO> showList() {

		connect();

		List<jghchannelVO> list = new ArrayList<>();
		String sql = "select * from channel order by 1 desc";

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				jghchannelVO vo = new jghchannelVO();
				vo.setUserNum(rs.getInt("user_num"));
				vo.setEmail(rs.getString("email"));
				vo.setAuthor(rs.getString("author"));
				vo.setContent(rs.getString("content"));
				vo.setCommentDay(rs.getString("comment_day"));

				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
	// channel 댓글등록..
	public jghchannelVO insertcomment (jghchannelVO comment) {
		
		connect();
		
		try {
		 
		 int curNum = 0; 
			
		 stmt = conn.createStatement();
		 rs = stmt.executeQuery("select MAX(user_num) From channel order by 1 desc");
		 
		 if (rs.next()) {
			 curNum = rs.getInt("MAX(user_num)") + 1;
		 }
		 
		 psmt = conn.prepareStatement("insert into channel values(?,?,?,?,sysdate)");
		 psmt.setInt(1, curNum);
		 psmt.setString(2, comment.getEmail());
		 psmt.setString(3, comment.getAuthor());
		 psmt.setString(4, comment.getContent());
		 
		 int r = psmt.executeUpdate();
		 System.out.println(r + "건 입력되었습니다.");
		 
			stmt = conn.createStatement();
			String sql = "select comment_day from channel";
			rs = stmt.executeQuery(sql);
			String lastDay = null;

			while (rs.next()) {

				lastDay = rs.getString("comment_day");

			}

		    comment.setCommentDay(lastDay);
			System.out.println(lastDay);
			
		    
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			disconnect();
		}
		
		return comment;
	}
	
	// 댓글 삭제.
	public int deleteComment (int userNum) {
		
		connect();
		try {
			psmt = conn.prepareStatement("delete from channel where user_num=?");
			psmt.setInt(1, userNum);
			int r = psmt.executeUpdate();
			
			System.out.println(r + "건 삭제 되었습니다.");
			
			return userNum;
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			return -1;
			
		} finally {
			disconnect();
		}
		
	
	}

}
