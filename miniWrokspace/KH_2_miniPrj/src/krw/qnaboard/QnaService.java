package krw.qnaboard;

import java.sql.Connection;
import java.util.List;

import mini.common.JDBCTemplate;

public class QnaService {

	public List<QnaVo> listUpQna() {
		// 커넥트
		Connection conn = null;
		List<QnaVo> QnaBoardList = null;

		try {
			conn = JDBCTemplate.getConnection();
			QnaBoardList = new QnaDao().listUpQna(conn);
		} catch (Exception e) {
			System.out.println("커넥션, 리스트업 서비스중 예외발생");
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}

		return QnaBoardList;

	}

	public int writeQna(QnaVo vo) {

		// 글쓰기 유효성

		if (vo.getTitle().length() < 1) {
			return -1;
		}

		if (vo.getContent().length() < 1) {
			return -2;
		}

		int result = 0;
		Connection conn = null;

		// 커넥션 만들고 NotiDao 에서 DB작업 진행 해주기

		try {

			conn = JDBCTemplate.getConnection();
			result = new QnaDao().writeQna(vo, conn);

			if (result == 1) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}

		} catch (Exception e) {

		} finally {
			JDBCTemplate.close(conn);
		}
		return result;

	}

	public QnaVo showQnaContenByNo(int num, String type) {

		Connection conn = null;
		QnaVo vo = null;

		try {
			conn = JDBCTemplate.getConnection();
			vo = new QnaDao().showQnaContentByNo(conn, num, type);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);

		}
		return vo;
	}

}
