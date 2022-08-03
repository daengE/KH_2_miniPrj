package lcs.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import mini.common.JDBCTemplate;
import mini.member.MemberVo;

public class MemberDao {
	public MemberVo login(String inputId, String inputPwd) throws Exception {
		//DB 가서 , id pwd 일치하는 행 조회
		
		// CONNECTION 준비
		Connection conn = JDBCTemplate.getConnection();
		
		// SQL 작성
		String sql = "SELECT * FROM MEMBER WHERE M_ID = ? AND M_PWD = ? AND DISABLED = 0";
		
		// SQL 객체에 담기
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, inputId);
		pstmt.setString(2, inputPwd);
		
		// SQL 실행
		ResultSet rs = pstmt.executeQuery();
		
		MemberVo vo = null;
		
		if(rs.next()) {
			
			int no = rs.getInt("M_NO");
			String id = rs.getString("M_ID");
			String name = rs.getString("M_NAME");
			String nick = rs.getString("M_NICK");
			String email = rs.getString("M_EMAIL");
			String birth = rs.getString("M_BIRTH");
			String address = rs.getString("M_ADDRESS");
			String cell = rs.getString("M_CELL");
			String animal = rs.getString("ISANIMAL");
			
			Timestamp createDate = rs.getTimestamp("CREATE_DATE");
			Timestamp modifyDate = rs.getTimestamp("MODIFY_DATE");
			
			int disabled = rs.getInt("DISABLED");
			int mbRight = rs.getInt("MB_RIGHT");
			
			vo = new MemberVo();
			vo.setNo(no);
			vo.setId(id);
			vo.setName(name);
			vo.setNick(nick);
			vo.setEmail(email);
			vo.setBirth(birth);
			vo.setAddress(address);
			vo.setCell(cell);
			vo.setAnimal(animal);
			vo.setCreateDate(createDate);
			vo.setModifyDate(modifyDate);
			vo.setDisaled(disabled);
			vo.setMbRight(mbRight);

			System.out.println(vo); //객체확인용
			
		}
		
		return vo;
	}

	
	public int join(MemberVo vo, Connection conn) throws Exception {
		//DB insert
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			//SQL 준비
			String sql = "INSERT INTO MEMBER(M_NO, M_ID, M_PWD, M_NICK) VALUES(SEQ_MEMBER_NO.NEXTVAL , ?, ?, ?)";
			
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
	}//method
}
