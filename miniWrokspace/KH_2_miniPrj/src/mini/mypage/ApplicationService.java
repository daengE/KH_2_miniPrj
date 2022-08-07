package mini.mypage;

import java.sql.Connection;
import java.util.List;

import krw.notificationboard.NotiDao;
import mini.common.JDBCTemplate;
import sar.Util.AdVo;

public class ApplicationService {

	public List<AdVo> showMyApply() {
		
			// 커넥트
			Connection conn = null;
			List<AdVo> adoptionList = null;

			try {
				conn = JDBCTemplate.getConnection();
				adoptionList = new ApplicationDao().showMyApply(conn);
			} catch (Exception e) {
				System.out.println("커넥션, 리스트업 서비스중 예외발생");
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(conn);
				;
			}

			return adoptionList;
		
	}

}

