package co.yedam.you;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.common.DAO;

public class youDAO extends DAO {

	public List<youHomeVO> showList () {
		
		connect();
		
		List<youHomeVO> list = new ArrayList<>();
		String sql = "SELECT * FROM home ORDER BY 1";
		
		try {
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while ( rs.next() ) {
				
				youHomeVO vo = new youHomeVO();
				vo.setNum(rs.getInt("num"));
				vo.setAuthor(rs.getString("author"));
				vo.setTitle(rs.getString("title"));
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
	
}
