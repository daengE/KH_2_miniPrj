package bje.community_board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import common.JDBCTemplate;

public class BoardDao {

	/*
	 * 게시글 작성
	 * 
	 * 데이터 받기 (컨트롤러)
	 * 
	 * 비지니스 로직 (서비스)
	 * 
	 * DB에 insert (DAO)
	 */
	public int write(BoardVo vo, Connection conn) throws Exception {
		
		//커넥션 준비
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			
			//SQL 작성
			String sql = "INSERT INTO COMMUNITY_BOARD (B_NO, M_NO, POST_TYPE, B_TAG, B_TITLE, B_CONTENTS, B_ENROLL_DATE, B_NICK, B_DELETE_YN, B_MODIFY, B_MDATE) "
					+ "		VALUES(SEQ_COMMUNITY_BOARD_B_NO.NEXTVAL, 1 , 'CB' , '[자유]' , ? , ? , DEFAULT, '누굴까' , 'N' , 'N' , DEFAULT)";
			
			//SQL 객체에 담기 및 완성(물음표 채우기)
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			
			//SQL 실행 및 결과 저장
			result = pstmt.executeUpdate();
			
		} finally{
			JDBCTemplate.close(pstmt);
		}
		
		return result;
		
	}//write
	
}//class



















