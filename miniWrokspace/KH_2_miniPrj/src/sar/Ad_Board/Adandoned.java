package sar.Ad_Board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mini.common.JDBCTemplate;
import mini.util.InputUtil;
import sar.Util.AdVo;

public class Adandoned {

	public AdVo list() {
		
		System.out.println("\n\n====[유기동물 게시판]====");
		System.out.println("====[전체 글 조회]====");

		String sql = "SELECT AD_NO, AD_ADOPT, AD_ANIMAL, AD_TYPE, AD_CITY, AD_KILL, AD_GENDER, AD_AGE FROM ADANDONED_BOARD";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn;
		AdVo vo = null;
		
		try {
			conn = JDBCTemplate.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			

			System.out.println(" 입양유무 / 축종 / 세부종류 / 지역 / 안락사일정 / 성별 / 나이 ");
			
			while(rs.next()) {
				
				int ad_no = rs.getInt("AD_NO");
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
				
				System.out.println(ad_no + "|" + adopt + "/"+ animal + "/"+ type + "/"+ city + "/"+ kill + "/"+ gender + "/"+ age + "/");
			
			}//while
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
	         JDBCTemplate.close(rs);
	         JDBCTemplate.close(pstmt);
	      }
		return vo;
	}
	
	
	public void detail(int num) {
		
		String sql = "SELECT * FROM ADANDONED_BOARD WHERE AD_NO = ?";
		
		AdVo vo = null;
		PreparedStatement pstmt = null;
		Connection conn;
		try {
			conn = JDBCTemplate.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,num);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int ad_no = rs.getInt("AD_NO");
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

				System.out.println(ad_no + "|" + adopt + "/"+ animal + "/"+ type + "/"+ city + "/"+ kill + "/"+ gender + "/"+ age + "/");
				System.out.print("보호장소 : " + vo.getShelter()+" / ");
				System.out.println(vo.getAddress());
				System.out.println("특이사항 : " +vo.getFeature());
				System.out.print("중성화여부 : " +vo.getNt());
				mini.main.Main.selected = vo;
			}//if
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
	         JDBCTemplate.close(pstmt);
	    }
		
//		return vo;
	}
	
	public void search() {
		System.out.println(" 서울 | 경기도 | 경상도 | 전라도 | 제주도 | 충청도 | 강원도 ");
		System.out.print("지역명을 입력하세요 : ");
//		JDBCTemplate_ad.sc.nextLine();
		String search = InputUtil.sc.nextLine();
		
			if(search.equals("서울시")) {
				
			}
			else if(search.equals("경기도")) {
//				 cityName = "경기도";
			}
			else if(search.equals("경상도")) {
			}
			else if(search.equals("전라도")){
			}
			else if(search.equals("제주도")) {
			}
			else if(search.equals("충청도")){
			}
			else if(search.equals("강원도")){
			}
			else {
				System.out.println("번호입력을 잘못하셨습니다.");
			}
			
		Connection conn = null;
		AdVo vo = null;
		ResultSet rs = null;
		
		String sql = "SELECT AD_NO, AD_ADOPT, AD_ANIMAL, AD_TYPE, AD_CITY, AD_KILL, AD_GENDER, AD_AGE FROM ADANDONED_BOARD WHERE AD_CITY = ?";
				
		PreparedStatement pstmt;
		try {
			try {
				conn = JDBCTemplate.getConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,search);
			
			rs = pstmt.executeQuery();
			
			System.out.println("입양유무 / 축종 / 세부종류 / 지역 / 안락사일정 / 성별 / 나이 ");

			while(rs.next()) {
				int ad_no = rs.getInt("AD_NO");
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
				
				System.out.println(ad_no + "|" + adopt + "/"+ animal + "/"+ type + "/"+ city + "/"+ kill + "/"+ gender + "/"+ age + "/");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
	         JDBCTemplate.close(rs);
//	         JDBCTemplate.close(pstmt);
	    }
	}//search
	
	
	public void ADOPT_YN() {
		
		System.out.println("1. 입양된 동물 조회하기  ");
		System.out.println("2. 입양되지 않은 동물 조회하기 ");
		
		String adopt1 = null;
		int search = InputUtil.getInt();
		if(search == 1) {
			adopt1 = "Y";
		}else {
			adopt1 = "N";
		}
		
		Connection conn = null;
		AdVo vo = null;
		ResultSet rs = null;
		
		String sql = "SELECT AD_NO, AD_ADOPT, AD_ANIMAL, AD_TYPE, AD_CITY, AD_KILL, AD_GENDER, AD_AGE FROM ADANDONED_BOARD WHERE AD_ADOPT = ?";
				
		PreparedStatement pstmt;
		try {
			try {
				conn = JDBCTemplate.getConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,adopt1);
			rs = pstmt.executeQuery();
			
			System.out.println("입양유무 / 축종 / 세부종류 / 지역 / 안락사일정 / 성별 / 나이 ");

			while(rs.next()) {
				int ad_no = rs.getInt("AD_NO");
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
				
				System.out.println(ad_no + "|" + adopt + "/"+ animal + "/"+ type + "/"+ city + "/"+ kill + "/"+ gender + "/"+ age + "/");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
	         JDBCTemplate.close(rs);
//	         JDBCTemplate.close(pstmt);
	    }
	}//ADOPT_YN
	
}
