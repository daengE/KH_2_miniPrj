package lcs.ps;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lcs.atc.ATCDao;
import lcs.atc.ATCVo;
import mini.common.JDBCTemplate;

public class PSDao {

	public List<PSVo> showPSList(Connection conn) {
		
		String sql = "SELECT PS_NO,PS_NAME, PS_CONTENT FROM PS ORDER BY PS_NO";
				
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<PSVo> PSVoList = new ArrayList<PSVo>();	
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
					
					while(rs.next()) 
						{
						
						int no = rs.getInt("PS_NO");
						String q = rs.getString("PS_NAME");
						String a = rs.getString("PS_CONTENT");
						
						PSVo psvo = new PSVo();
						
						psvo.setNo(no);
						psvo.setQ(q);
						psvo.setA(a);
						
						
						PSVoList.add(psvo);
					}
						
				} 
		catch (Exception e) {
					e.printStackTrace();
				}
		
		finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return PSVoList;
	}



	public PSVo showDetailPS(Connection conn, int num) throws Exception{
		
		String sql = "SELECT PS_NAME, PS_CONTENT FROM PS WHERE PS_NO = ?";
		PSVo psvo = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
				
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				String q = rs.getString("PS_NAME");
				String a = rs.getString("PS_CONTENT");
				
				psvo = new PSVo();
				
				psvo.setQ(q);
				psvo.setA(a);

			}
		}
		finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
			
		}
		
		
		return psvo;
	
	}

	

	}
