package mini.mypage;

import java.sql.Connection;
import java.util.List;

import lcs.application.ApplicationVo;
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

	public List<ApplicationVo> showMyTraining() {

		// 커넥트
		Connection conn = null;
		List<ApplicationVo> trainingList = null;

		try {
			conn = JDBCTemplate.getConnection();
			trainingList = new ApplicationDao().showMyTraining(conn);
		} catch (Exception e) {
			System.out.println("커넥션, 리스트업 서비스중 예외발생");
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
			;
		}

		return trainingList;

	}

}
