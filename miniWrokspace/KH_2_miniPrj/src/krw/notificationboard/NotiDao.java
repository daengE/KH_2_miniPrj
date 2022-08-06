package krw.notificationboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import mini.common.JDBCTemplate;

public class NotiDao {

	public List<NotiVo> listUpNoti(Connection conn) throws Exception {

		// sql 준비
		String sql = "SELECT NO_NO, M_NO, NO_NICK, NO_TITLE, NO_CONTENT, NO_ENROLL_DATE, NO_MODIFY_DATE, NO_DELETE_DATE, NO_DELETE_YN FROM NOTIFICATION_BOARD WHERE NO_DELETE_YN = 'N' ORDER BY NO_NO DESC";

		// sql 담을 객체 준비 및 sql 완성
		PreparedStatement pstmt = null;

		// sql 날리고 결과받아오기
		ResultSet rs = null;

		// 필드작성(리스트 선언)
		List<NotiVo> NotiBoardList = new ArrayList<NotiVo>();

		try {

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				// 결과 받아온것 객체에 담아서

				int notiNo = rs.getInt("NO_NO");
				int memberNo = rs.getInt("M_NO");
				String writer = rs.getString("NO_NICK");
				String title = rs.getString("NO_TITLE");
				String content = rs.getString("NO_CONTENT");
				Timestamp enrollDate = rs.getTimestamp("NO_ENROLL_DATE");
				Timestamp modifyDate = rs.getTimestamp("NO_MODIFY_DATE");
				Timestamp deleteDate = rs.getTimestamp("NO_DELETE_DATE");
				String usable = rs.getString("NO_DELETE_YN");

//				System.out.println("노티넘은 :" + notiNo);
//				객체 담기는지 확인용

				NotiVo vo = new NotiVo();
				vo.setNotiNo(notiNo);
				vo.setMemberNo(memberNo);
				vo.setWriter(writer);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setEnrollDate(enrollDate);
				vo.setModifyDate(modifyDate);
				vo.setDeleteDate(deleteDate);
				vo.setUsable(usable);

				// 담은 객체들 리스트에 담기

				NotiBoardList.add(vo);

			}

		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}


		return NotiBoardList;

	}

	public int writeNoti(NotiVo vo, Connection conn) {

		int result = 0;
		PreparedStatement pstmt = null;

		try {

			// sql 작성
			String sql = "INSERT INTO NOTIFICATION_BOARD(NO_NO, M_NO, NO_NICK, NO_TITLE, NO_CONTENT) VALUES(SEQ_NOTICE_NO.NEXTVAL, ?, ?, ?, ?)";

			// sql 객체에 담기
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getMemberNo());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getTitle());
			pstmt.setString(4, vo.getContent());

			// sql 실행 및 결과 저장
			result = pstmt.executeUpdate();

		} catch (Exception e) {

		} finally {
			JDBCTemplate.close(pstmt);

		}
		return result;

	}
	
	public int deleteNoti(int input, Connection conn) {
		
		int result = 0;
		PreparedStatement pstmt = null;

		try {

			// sql 작성
			String sql = "UPDATE NOTIFICATION_BOARD SET NO_DELETE_YN = 'Y' WHERE NO_NO = ?";

			// sql 객체에 담기
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, input);

			// sql 실행 및 결과 저장
			result = pstmt.executeUpdate();

		} catch (Exception e) {

		} finally {
			JDBCTemplate.close(pstmt);

		}
		
		
		return result;
	}

	public NotiVo showNotiContentByNo(Connection conn, int num) throws Exception {
		String sql = "SELECT NO_NO, M_NO, NO_NICK, NO_TITLE, NO_CONTENT, NO_ENROLL_DATE\n"
				+ ", NO_MODIFY_DATE, NO_DELETE_DATE, NO_DELETE_YN\n"
				+ " FROM NOTIFICATION_BOARD\n"
				+ " WHERE NO_NO = ? AND NO_DELETE_YN = 'N'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		NotiVo vo = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,  num);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt("NO_NO");
				int memberNo = rs.getInt("M_NO");
				String writer = rs.getString("NO_NICK");
				String title = rs.getString("NO_TITLE");
				String content = rs.getString("NO_CONTENT");
				Timestamp enrollDate = rs.getTimestamp("NO_ENROLL_DATE");
				Timestamp modifyDate= rs.getTimestamp("NO_MODIFY_DATE");
				Timestamp deleteDate = rs.getTimestamp("NO_DELETE_DATE");
				String usable = rs.getString("NO_DELETE_YN");
				
				vo = new NotiVo();
				vo.setNotiNo(no);
				vo.setMemberNo(memberNo);
				vo.setWriter(writer);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setEnrollDate(enrollDate);
				vo.setModifyDate(modifyDate);
				vo.setDeleteDate(deleteDate);
				vo.setUsable(usable);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
			
		}
		return vo;
	}

	
}


















