package lcs.application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ApplicationDao {

	public int write(ApplicationVo aplyVo, Connection conn) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		//sql준비
		String sql = "INSERT INTO APPLICATION "
					+ "VALUES (SEQ_APPLICATION_NO.NEXTVAL, ? , ? , ?, ?, DEFAULT, ?, DEFAULT)";
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, aplyVo.getNo());
			pstmt.setString(2, aplyVo.getAtcName());
			pstmt.setString(3, aplyVo.getAnimalType());
			pstmt.setString(4, aplyVo.getPhone());
			pstmt.setString(5, aplyVo.getPsbDate());
			
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return result;
	}
	
	
	
	
}
