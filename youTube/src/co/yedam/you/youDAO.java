package co.yedam.you;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.common.DAO;

public class youDAO extends DAO {

	public List<youHomeVO> showList () {
		
		connect();
		
		List<youHomeVO> list = new ArrayList<>();
		String sql = "SELECT * FROM home";
		
		try {
			
			youHomeVO vo = new youHomeVO();
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				
				vo.setId(rs.getInt("id"));
				vo.setAuthor(rs.getString("author"));
				vo.setTitle(rs.getString("title"));
				vo.setLikeIt(rs.getString("likeIt"));
				vo.setTime(rs.getString("time"));
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return list;
		
	}
	
}
