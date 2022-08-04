package krw.qnaboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import krw.notificationboard.NotiVo;
import mini.common.JDBCTemplate;

public class QnaDao {

	public List<QnaVo> listUpQna(Connection conn) throws Exception {

		// sql 준비
		String sql = "SELECT QNA_NO, M_NO, QNA_TYPE, Q_NICK, Q_TITLE, Q_CONTENT, Q_ENROLL_DATE\r\n"
				+ "FROM QNA_BOARD\r\n" + "UNION \r\n"
				+ "SELECT QNA_NO, M_NO_ADMIN, QNA_TYPE, A_NICK, A_TITLE, A_CONTENT, A_ENROLL_DATE\r\n"
				+ "FROM ANSWER_BOARD\r\n" + "ORDER BY QNA_NO DESC, QNA_TYPE DESC";

		// sql 담을 객체 준비 및 sql 완성
		PreparedStatement pstmt = null;

		// sql 날리고 결과받아오기
		ResultSet rs = null;

		// 필드작성(리스트 선언)
		List<QnaVo> QnaBoardList = new ArrayList<QnaVo>();

		try {

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				// 결과 받아온것 객체에 담아서

				int qnaNo = rs.getInt("QNA_NO");
				int memberNo = rs.getInt("M_NO");
				String type = rs.getString("QNA_TYPE");
				String writer = rs.getString("Q_NICK");
				String title = rs.getString("Q_TITLE");
				String content = rs.getString("Q_CONTENT");
				Timestamp enrollDate = rs.getTimestamp("Q_ENROLL_DATE");
//				String complete = rs.getString("Q_REPLY_YN");
//				String delete = rs.getString("Q_DELETE_YN");

//				System.out.println("노티넘은 :" + notiNo);
//				객체 담기는지 확인용

				QnaVo vo = new QnaVo();
				vo.setQnaNo(qnaNo);
				vo.setMemberNo(memberNo);
				vo.setType(type);
				vo.setWriter(writer);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setEnrollDate(enrollDate);
//				vo.setComplete(complete);
//				vo.setDelete(delete);

				// 담은 객체들 리스트에 담기

				QnaBoardList.add(vo);

			}

		} finally {
			// pstmt, rs 닫아주기 위해서 try 블럭 생성
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);

		}

		System.out.println(QnaBoardList.size());

		return QnaBoardList;

	}

	/*
	 * 
	 * 개시글 상세조회
	 * 
	 */

//	public QnaVo showQnaDetailByNo(Connection conn, int num)

	// SQL

	public int writeQna(QnaVo vo, Connection conn) {

		int result = 0;
		PreparedStatement pstmt = null;

		try {

			// sql 작성
			String sql = "INSERT INTO QNA_BOARD(QNA_NO, M_NO, Q_NICK, Q_TITLE, Q_CONTENT) VALUES(SEQ_QNA_NO.NEXTVAL, ?, ?, ?, ?)";

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

	public QnaVo showQnaContentByNo(Connection conn, int num, String type) throws Exception {

		String sql = "SELECT QNA_NO, M_NO, QNA_TYPE, Q_NICK, Q_TITLE, Q_CONTENT, Q_ENROLL_DATE\r\n"
				+ "FROM QNA_BOARD\r\n"
				+ "WHERE QNA_TYPE = ? AND QNA_NO = ? \r\n"
				+ "UNION \r\n"
				+ "SELECT QNA_NO, M_NO_ADMIN, QNA_TYPE, A_NICK, A_TITLE, A_CONTENT, A_ENROLL_DATE\r\n"
				+ "FROM ANSWER_BOARD\r\n"
				+ "WHERE QNA_TYPE = ? AND QNA_NO = ? \r\n"
				+ "ORDER BY QNA_NO DESC, QNA_TYPE DESC";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		QnaVo vo = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, type);
			pstmt.setInt(2, num);
			pstmt.setString(3, type);
			pstmt.setInt(4, num);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				// TODO-first
				// 대충 rs.get 칼럼으로 데이터 받아와서
				int no = rs.getInt("QNA_NO");
				int memberNo = rs.getInt("M_NO");
				String qnaType = rs.getString("QNA_TYPE");
				String writer = rs.getString("Q_NICK");
				String title = rs.getString("Q_TITLE");
				String content = rs.getString("Q_CONTENT");
				Timestamp enrollDate = rs.getTimestamp("Q_ENROLL_DATE");

				vo = new QnaVo();

				// 객체에 넣고
				vo.setQnaNo(no);
				vo.setMemberNo(memberNo);
				vo.setType(qnaType);
				vo.setWriter(writer);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setEnrollDate(enrollDate);

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}

		return vo;
	}

}