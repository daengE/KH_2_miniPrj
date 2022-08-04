package bje;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import bje.community_board.BoardVo;
import mini.common.JDBCTemplate;

public class BcommentDao {

	/*
	 * 게시글 작성
	 * 
	 * 데이터 받기 (컨트롤러)
	 * 
	 * 비지니스 로직 (서비스)
	 * 
	 * DB에 insert (DAO)
	 */
	public int write(BcommentVo vocom, Connection conn) throws Exception {
		
		//커넥션 준비
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			
			//SQL 작성
			String sql = "INSERT INTO BCOMMENT VALUES(SEQ_BCOMMENT_COM_NO.NEXTVAL , 1 , '누구게' , ? , DEFAULT , 'N' , DEFAULT)";
			
			//SQL 객체에 담기 및 완성(물음표 채우기)
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vocom.getContent());
			
			//SQL 실행 및 결과 저장
			result = pstmt.executeUpdate();
			
		} finally{
			JDBCTemplate.close(pstmt);
		}
		
		return result;
		
	}//write

	public List<BcommentVo> showList(Connection conn) throws Exception {
		//CONN 준비
		
		//SQL 준비
		String sql = "SELECT B_NO , COM_NICK , COM_CONTENTS , COM_ENROLL_DATE FROM BCOMMENT";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BcommentVo> BcommentVoList = new ArrayList<BcommentVo>();	
		
		try {
			//SQL 담을 객체 준비 및 SQL 완성
			pstmt = conn.prepareStatement(sql);
			
			//SQL 실행 및 결과 저장
			rs = pstmt.executeQuery();
			
			//커서 내리고, 칼럼별로 읽어오기, 객체로 ㄱ만들기   << 반복
			// rs.next, rs.getXXX("칼럼명"), vo.setXXX
			
			while(rs.next()) {
				int no = rs.getInt("B_NO");
				String nick = rs.getString("COM_NICK");
				Timestamp comenrolldate = rs.getTimestamp("COM_ENROLL_DATE");
				String comcontents = rs.getString("COM_CONTENTS");
				
				BcommentVo vo = new BcommentVo();
				vo.setB_no(no);
				vo.setWriter(nick);
				vo.setEnrollDate(comenrolldate);
				vo.setContent(comcontents);
				
				BcommentVoList.add(vo);
			}
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		
		//SQL 실행 결과 리턴
		return BcommentVoList;
	}//showList
	
}//class



















