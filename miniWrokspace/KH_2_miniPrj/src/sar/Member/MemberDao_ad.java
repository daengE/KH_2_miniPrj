package sar.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import sar.Util.JDBCTemplate_ad;

public class MemberDao_ad {

	public int join(MemberVo_ad vo, Connection conn) throws Exception{
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "INSERT INTO MEMBER(M_NO,M_ID,M_PWD,M_NICK) VALUES (SEQ_MEMBER_NO.NEXTVAL, ?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getNick());
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			throw e;
		}finally {
			JDBCTemplate_ad.close(pstmt);
		}
		return result;
	}
	
	public MemberVo_ad login(String inputId, String inputPwd) throws Exception {
		
	
		Connection conn = JDBCTemplate_ad.getConnection();
		
		String sql = "SELECT M_NO, M_ID, M_NICK FROM MEMBER WHERE M_ID = ? AND M_PWD = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, inputId);
		pstmt.setString(2, inputPwd);
		
		ResultSet rs = pstmt.executeQuery();
		
		MemberVo_ad vo = null;
		
		if(rs.next()) {
			String no = rs.getString("M_NO");
			String id = rs.getString("M_ID");
			String nick = rs.getString("M_NICK");
			
			vo = new MemberVo_ad();
			vo.setNo(no);
			vo.setId(id);
			vo.setNick(nick);
		}
		return vo;
	}

}
