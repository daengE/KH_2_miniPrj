package bje.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bje.common.JDBCTemplate;

public class MemberDao {

	public MemberVo login(String inputId, String inputPwd) throws Exception {
		// DB 가서 , id pwd 일치하는 행 조회
		
		// CONNECTION 준비
		Connection conn = JDBCTemplate.getConnection();
		
		// SQL 작성
		String sql = "SELECT M_NO , M_ID , M_NICK FROM MEMBER WHERE M_ID = ? AND M_PWD = ? ";
		
		// SQL 객체에 담기
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, inputId);	//대소문자 어찌하실지 고민해보세요~!
		pstmt.setString(2, inputPwd);
		
		// SQL 실행
		ResultSet rs = pstmt.executeQuery();
		
		MemberVo vo = null;
		
		if(rs.next()) {
			String no = rs.getString("M_NO");
			String id = rs.getString("M_ID");
			String nick = rs.getString("M_NICK");
			
			vo = new MemberVo();
			vo.setNo(no);
			vo.setId(id);
			vo.setNick(nick);
		}
		
		return vo;
		
	}//login

	public int join(MemberVo vo, Connection conn) throws Exception {
		
		//DB insert
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			//SQL 준비
			String sql = "INSERT INTO MEMBER(M_NO, M_ID, M_PWD, M_NICK) VALUES(4, ?, ?, ?)";
			
			//SQL 담을 객체 만들기
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getNick());
			
			//SQL 실행 및 결과 저장
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
		
		
	}//join
	
}//class



















