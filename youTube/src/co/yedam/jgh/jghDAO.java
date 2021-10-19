package co.yedam.jgh;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.common.DAO;

public class jghDAO extends DAO {

	public List<jghwatchinglVO> showList() {

		connect();

		List<jghwatchinglVO> list = new ArrayList<>();
		String sql = "select * From commentboard order by 1 desc";

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				jghwatchinglVO vo = new jghwatchinglVO();
				vo.setNum(rs.getInt("num"));
				vo.setId(rs.getString("id"));
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

	// 댓글 등록
	public jghwatchinglVO insertcomment(jghwatchinglVO comment) {

		connect();

		try {
			int curNum = 0;

			stmt = conn.createStatement();
			rs = stmt.executeQuery("select MAX(num) From commentboard order by 1 desc");

			if (rs.next()) {

				curNum = rs.getInt("MAX(num)") + 1;

			}

			psmt = conn.prepareStatement("insert into commentboard values(?,?,?,sysdate)");
			psmt.setInt(1, curNum);
			psmt.setString(2, comment.getId());
			psmt.setString(3, comment.getContent());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력되었습니다.");
			//

			stmt = conn.createStatement();
			String sql = "select comment_day from commentboard";
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

}