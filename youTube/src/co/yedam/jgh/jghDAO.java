package co.yedam.jgh;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.common.DAO;

public class jghDAO extends DAO {

	public List<jghCannelVO> showList() {
		
		connect();
		
		List<jghCannelVO> list = new ArrayList<>();
		String sql = "select * From commentboard";
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				jghCannelVO vo = new jghCannelVO();
				vo.setNum(rs.getInt("num"));
				vo.setId(rs.getString("id"));
				vo.setContent(rs.getString("content"));
				vo.setDay(rs.getString("day"));
				
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
