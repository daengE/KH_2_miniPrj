package krw.notificationboard;

import java.sql.Connection;
import java.util.List;

import mini.common.JDBCTemplate;

public class NotiService {

	public List<NotiVo> listUpNoti() {
		// 커넥트
		Connection conn = null;
		List<NotiVo> NotiBoardList = null;

		try {
			conn = JDBCTemplate.getConnection();
			NotiBoardList = new NotiDao().listUpNoti(conn);
		} catch (Exception e) {
			System.out.println("커넥션, 리스트업 서비스중 예외발생");
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
			;
		}

		return NotiBoardList;

	}

	public int writeNoti(NotiVo vo) {

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
			result = new NotiDao().writeNoti(vo, conn);

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

	public NotiVo showNotiContentByNo(int num) {

		Connection conn = null;
		NotiVo vo = null;

		try {
			conn = JDBCTemplate.getConnection();
			vo = new NotiDao().showNotiContentByNo(conn, num);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}

		return vo;
	}

}
