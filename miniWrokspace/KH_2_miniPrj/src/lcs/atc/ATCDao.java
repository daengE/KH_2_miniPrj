package lcs.atc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import mini.common.JDBCTemplate;

public class ATCDao {

	public List<ATCVo> showATCList(Connection conn) throws Exception {
		
		String sql = "SELECT ATC_NO, ATC_NAME, ATC_CALL, ATC_SKILL, ATC_LOC, ATC_ANIMALS, ATC_CITY FROM ATC";
				
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<ATCVo> ATCVoList = new ArrayList<ATCVo>();	
		
	try {
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
					
					while(rs.next()) 
						{
						
						int no = rs.getInt("ATC_NO");
						String name = rs.getString("ATC_NAME");
						String call = rs.getString("ATC_CALL");
						String skill = rs.getString("ATC_SKILL");
						String loc = rs.getString("ATC_LOC");
						String animal = rs.getString("ATC_ANIMALS");
						String city = rs.getString("ATC_CITY");
						
						ATCVo atcvo = new ATCVo();
						
						atcvo.setNo(no);
						atcvo.setName(name);
						atcvo.setCall(call);
						atcvo.setSkill(skill);
						atcvo.setLoc(loc);
						atcvo.setAnimal(animal);
						atcvo.setCity(city);
						
						ATCVoList.add(atcvo);
					}
						
				}
		
		finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return ATCVoList;
	}//method

	
	
	public ATCVo showDetailByNo(Connection conn, int num) throws Exception {
		
		String sql = "SELECT  ATC_NO, ATC_NAME, ATC_CALL, ATC_SKILL, ATC_LOC, ATC_ANIMALS, ATC_CITY "
				+ "FROM ATC WHERE ATC_NO = ?";
		ATCVo atcvo = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
				
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int no = rs.getInt("ATC_NO");
				String name = rs.getString("ATC_NAME");
				String call = rs.getString("ATC_CALL");
				String skill = rs.getString("ATC_SKILL");
				String loc = rs.getString("ATC_LOC");
				String animal = rs.getString("ATC_ANIMALS");
				String city = rs.getString("ATC_CITY");
				
				atcvo = new ATCVo();
				
				atcvo.setNo(no);
				atcvo.setName(name);
				atcvo.setCall(call);
				atcvo.setSkill(skill);
				atcvo.setLoc(loc);
				atcvo.setAnimal(animal);
				atcvo.setCity(city);
				
			}
		}
		finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
			
		}
		
		
		return atcvo;
	}
	

}//class
