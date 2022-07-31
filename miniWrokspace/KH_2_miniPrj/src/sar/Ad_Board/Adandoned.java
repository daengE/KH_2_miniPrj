package sar.Ad_Board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import sar.Util.AdVo;
import sar.Util.JDBCTemplate_ad;

public class Adandoned {

	public AdVo list() throws Exception {
		
		Connection conn = JDBCTemplate_ad.getConnection();
		
		String sql = "SELECT * FROM ADANDONED_BOARD";
				
				
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		AdVo vo = null;
		
		while(rs.next()) {
			String adopt = rs.getString("AD_ADOPT");
			String animal = rs.getString("AD_ANIMAL");
			String type = rs.getString("AD_TYPE");
			String city = rs.getString("AD_CITY");
			String kill = rs.getString("AD_KILL");
			String gender = rs.getString("AD_GENDER");
			String age = rs.getString("AD_AGE");
			
			vo = new AdVo();
			vo.setAd_adopt(adopt);
			vo.setAnimal(animal);
			vo.setType(type);
			vo.setCity(city);
			vo.setKill(kill);
			vo.setGender(gender);
			vo.setAge(age);
			
			System.out.println(vo);
		}
		return vo;
	}
}
