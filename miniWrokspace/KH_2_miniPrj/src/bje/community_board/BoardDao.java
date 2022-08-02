package bje.community_board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import mini.common.JDBCTemplate;

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

	public List<BoardVo> showList(Connection conn) throws Exception {
		//CONN 준비
		
		//SQL 준비
		String sql = "SELECT B.NO , B.TITLE , B.CONTENT , B.WRITER_NO , B.ENROLL_DATE , B.MODIFY_DATE , M.NICK FROM BOARD B JOIN MEMBER M ON B.WRITER_NO = M.NO WHERE B.STATUS = 'Y' ORDER BY ENROLL_DATE DESC";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVo> boardVoList = new ArrayList<BoardVo>();	
		
		try {
			//SQL 담을 객체 준비 및 SQL 완성
			pstmt = conn.prepareStatement(sql);
			
			//SQL 실행 및 결과 저장
			rs = pstmt.executeQuery();
			
			//커서 내리고, 칼럼별로 읽어오기, 객체로 ㄱ만들기   << 반복
			// rs.next, rs.getXXX("칼럼명"), vo.setXXX
			
			while(rs.next()) {
				int no = rs.getInt("NO");
				String title = rs.getString("TITLE");
				Timestamp enrollDate = rs.getTimestamp("ENROLL_DATE");
				String writer = rs.getString("NICK");
				
				BoardVo vo = new BoardVo();
				vo.setB_no(no);
				vo.setTitle(title);
				vo.setEnrollDate(enrollDate);
				vo.setWriter(writer);
				
				boardVoList.add(vo);
			}
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		
		//SQL 실행 결과 리턴
		return boardVoList;
	}//showList
	
}//class



















