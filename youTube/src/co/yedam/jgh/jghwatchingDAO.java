package co.yedam.jgh;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.common.DAO;

public class jghwatchingDAO extends DAO {
    
	// 댓글 목록.
	public List<jghwatchinglVO> showList() {

		connect();

		List<jghwatchinglVO> list = new ArrayList<>();
		String sql = "select * From commentboard order by 1 desc";

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				jghwatchinglVO vo = new jghwatchinglVO();
				
				vo.setCmtNum(rs.getInt("cmt_num"));
				vo.setAuthor(rs.getString("author"));
				vo.setUserNum(rs.getInt("user_num"));
				vo.setViNum(rs.getInt("vi_num"));
				vo.setContent(rs.getString("content"));
				vo.setCmtDay(rs.getString("cmt_day"));
				
		

				list.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 댓글 등록.
	public jghwatchinglVO insertcomment(jghwatchinglVO comment) {

		connect();

		try {
			int curNum = 0;

			stmt = conn.createStatement();
			rs = stmt.executeQuery("select MAX(cmt_num) From commentboard order by 1 desc");

			if (rs.next()) {

				curNum = rs.getInt("MAX(cmt_num)") + 1;

			}

			psmt = conn.prepareStatement("insert into commentboard values(?,?,?,?,?,sysdate)");
		
			psmt.setInt(1, curNum);
			psmt.setString(2, comment.getAuthor());
			psmt.setInt(3, comment.getUserNum());
			psmt.setInt(4, comment.getViNum());
			psmt.setString(5, comment.getContent());
			
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력되었습니다.");
			//

			stmt = conn.createStatement();
			String sql = "select cmt_day from commentboard";
			rs = stmt.executeQuery(sql);
			String lastDay = null;

			while (rs.next()) {

				lastDay = rs.getString("cmt_day");

			}
			
			comment.setCmtNum(curNum);
			comment.setCmtDay(lastDay);
			System.out.println(lastDay);

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			disconnect();
		}

		return comment;
	}
	
	
	// 댓글 삭제.
	public int deleteComment (int cmtNum) {
		
		connect();
		try {
			psmt = conn.prepareStatement("delete from commentboard where cmt_num=?");
			psmt.setInt(1, cmtNum);
			int r = psmt.executeUpdate();
			
			System.out.println(r + "건 삭제 되었습니다.");
			
			return cmtNum;
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			return -1;
			
		} finally {
			disconnect();
		}
		
	
	}

}