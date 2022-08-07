package mini.mypage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import lcs.application.ApplicationVo;
import mini.common.JDBCTemplate;
import mini.main.Main;
import sar.Util.AdVo;

public class ApplicationDao {

	public List<AdVo> showMyApply(Connection conn) throws Exception {

		// sql 준비
		String sql = "SELECT AD_AP_NO, AD_ANIMAL, AD_TYPE, AD_SHELTER, AD_ADDRESS, AD_DATE\r\n"
				+ "FROM ADANDONED_BOARD B, ADOPTION D\r\n" + "WHERE B.AD_NO = D.AD_NO AND M_NO = ?";

		// sql 담을 객체 준비 및 sql 완성
		PreparedStatement pstmt = null;

		// sql 날리고 결과받아오기
		ResultSet rs = null;

		// 필드작성(리스트 선언)
		List<AdVo> applicationList = new ArrayList<AdVo>();

		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Main.loginMember.getNo());
			rs = pstmt.executeQuery();

			while (rs.next()) {

				// 결과 받아온것 객체에 담아서

				String animal = rs.getString("AD_ANIMAL");
				String type = rs.getString("AD_TYPE");
				String shelter = rs.getString("AD_SHELTER");
				String address = rs.getString("AD_ADDRESS");
				Timestamp ad_date =rs.getTimestamp("AD_DATE");

				AdVo adVo = new AdVo();
				adVo.setAnimal(animal);
				adVo.setType(type);
				adVo.setShelter(shelter);
				adVo.setAddress(address);
				adVo.setAd_date(ad_date);

				// 담은 객체들 리스트에 담기

				applicationList.add(adVo);

			}

		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		return applicationList;
	}

	public List<ApplicationVo> showMyTraining(Connection conn) throws Exception {

		// TODO sql 작성
		String sql = "SELECT ATC_NAME, ANIMAL_TYPE, APPLY_DATE FROM APPLICATION WHERE USER_NO = ?";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ApplicationVo> trainingList = new ArrayList<ApplicationVo>();

		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Main.loginMember.getNo());
			rs = pstmt.executeQuery();
			

			while (rs.next()) {
				// 결과받아온것 객체담기
				String atcName = rs.getString("ATC_NAME");
				String animalType = rs.getString("ANIMAL_TYPE");
				Timestamp aplyDate = rs.getTimestamp("APPLY_DATE");

				ApplicationVo apVo = new ApplicationVo();
				apVo.setAtcName(atcName);
				apVo.setAnimalType(animalType);
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				
				apVo.setAplyDate(sdf.format(aplyDate));

				// 객체 리스트에담기
				trainingList.add(apVo);
			}
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		return trainingList;
	}

}
