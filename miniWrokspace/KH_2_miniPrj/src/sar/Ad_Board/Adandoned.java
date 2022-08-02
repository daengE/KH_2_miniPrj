package sar.Ad_Board;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.JDBCTemplate;
import sar.Util.AdVo;
import sar.Util.JDBCTemplate_ad;
import util.InputUtil;

public class Adandoned {

	public AdVo list() throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		String sql = "SELECT AD_NO, AD_ADOPT, AD_ANIMAL, AD_TYPE, AD_CITY, AD_KILL, AD_GENDER, AD_AGE FROM ADANDONED_BOARD";
				
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		AdVo vo = null;
		
		System.out.println(" 입양유무 / 축종 / 세부종류 / 지역 / 안락사일정 / 성별 / 나이 ");

		while(rs.next()) {
			String ad_no = rs.getString("AD_NO");
			String adopt = rs.getString("AD_ADOPT");
			String animal = rs.getString("AD_ANIMAL");
			String type = rs.getString("AD_TYPE");
			String city = rs.getString("AD_CITY");
			String kill = rs.getString("AD_KILL");
			String gender = rs.getString("AD_GENDER");
			String age = rs.getString("AD_AGE");
			
			vo = new AdVo();
			vo.setAd_no(ad_no);
			vo.setAd_adopt(adopt);
			vo.setAnimal(animal);
			vo.setType(type);
			vo.setCity(city);
			vo.setKill(kill);
			vo.setGender(gender);
			vo.setAge(age);
			
			System.out.print(vo.getAd_no() + "| ");
			System.out.print(vo.getAd_adopt() + " / ");
			System.out.print(vo.getAnimal() + " / ");
			System.out.print(vo.getType()+" / ");
			System.out.print(vo.getCity()+" / ");
			System.out.print(vo.getKill()+" / ");
			System.out.print(vo.getGender()+" / ");
			System.out.println(vo.getAge());
		}
		return vo;
	}
	
	
	public void detail(int num) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		String sql = "SELECT * FROM ADANDONED_BOARD WHERE AD_NO = ?";
				
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,num);
		
		ResultSet rs = pstmt.executeQuery();
		
		AdVo vo = null;
		
		if(rs.next())	
		{
			String ad_no = rs.getString("AD_NO");
			String adopt = rs.getString("AD_ADOPT");
			String animal = rs.getString("AD_ANIMAL");
			String type = rs.getString("AD_TYPE");
			String city = rs.getString("AD_CITY");
			String kill = rs.getString("AD_KILL");
			String gender = rs.getString("AD_GENDER");
			String age = rs.getString("AD_AGE");
			String shelter = rs.getString("AD_SHELTER");
			String address = rs.getString("AD_ADDRESS");
			String feature = rs.getString("AD_FEATURE");
			String nt = rs.getString("AD_NT");
			
			vo = new AdVo();
			vo.setAd_no(ad_no);
			vo.setAd_adopt(adopt);
			vo.setAnimal(animal);
			vo.setType(type);
			vo.setCity(city);
			vo.setKill(kill);
			vo.setGender(gender);
			vo.setAge(age);
			vo.setShelter(shelter);
			vo.setAddress(address);
			vo.setFeature(feature);
			vo.setNt(nt);
			
			System.out.println(" 입양유무 / 축종 / 세부종류 / 지역 / 안락사일정 / 성별 / 나이 ");

			System.out.print(vo.getAd_no() + "| ");
			System.out.print(vo.getAd_adopt() + " / ");
			System.out.print(vo.getAnimal() + " / ");
			System.out.print(vo.getType()+" / ");
			System.out.print(vo.getCity()+" / ");
			System.out.print(vo.getKill()+" / ");
			System.out.print(vo.getGender()+" / ");
			System.out.println(vo.getAge()+" / ");
			System.out.print("보호장소 : " + vo.getShelter()+" / ");
			System.out.println(vo.getAddress());
			System.out.println("특이사항 : " +vo.getFeature());
			System.out.print("중성화여부 : " +vo.getNt());

		}
		
	}
	
	public void search() throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		System.out.print("지역명을 입력하세요 : ");
//		JDBCTemplate_ad.sc.nextLine();
		String search = InputUtil.sc.nextLine();
		
		String sql = "SELECT AD_NO, AD_ADOPT, AD_ANIMAL, AD_TYPE, AD_CITY, AD_KILL, AD_GENDER, AD_AGE FROM ADANDONED_BOARD WHERE AD_CITY = ?";
				
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,search);
		
		ResultSet rs = pstmt.executeQuery();
		
		AdVo vo = null;
		
		System.out.println("입양유무 / 축종 / 세부종류 / 지역 / 안락사일정 / 성별 / 나이 ");

		while(rs.next()) {
			String ad_no = rs.getString("AD_NO");
			String adopt = rs.getString("AD_ADOPT");
			String animal = rs.getString("AD_ANIMAL");
			String type = rs.getString("AD_TYPE");
			String city = rs.getString("AD_CITY");
			String kill = rs.getString("AD_KILL");
			String gender = rs.getString("AD_GENDER");
			String age = rs.getString("AD_AGE");
			
			vo = new AdVo();
			vo.setAd_no(ad_no);
			vo.setAd_adopt(adopt);
			vo.setAnimal(animal);
			vo.setType(type);
			vo.setCity(city);
			vo.setKill(kill);
			vo.setGender(gender);
			vo.setAge(age);
			
			System.out.print(vo.getAd_no() + "| ");
			System.out.print(vo.getAd_adopt() + " / ");
			System.out.print(vo.getAnimal() + " / ");
			System.out.print(vo.getType()+" / ");
			System.out.print(vo.getCity()+" / ");
			System.out.print(vo.getKill()+" / ");
			System.out.print(vo.getGender()+" / ");
			System.out.println(vo.getAge());
		}
	}
	
}
