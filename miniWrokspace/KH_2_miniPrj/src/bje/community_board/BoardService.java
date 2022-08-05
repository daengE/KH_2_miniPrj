package bje.community_board;

import static mini.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import mini.common.JDBCTemplate;
import mini.util.InputUtil;
import sar.Util.AdVo;

public class BoardService {

   /*
    * 게시글 작성
    * 
    * 데이터 받기 (컨트롤러)
    * 
    * 비지니스 로직 (서비스)
    * 
    * DB에 insert (DAO)
    */
   public int write(BoardVo vo) {

      //비지니스 로직 (제목, 내용 1글자 이상인지)
      if(vo.getTitle().length() < 1) {
         //제목이 비어있음. 다음단계 진행 X
         return -1;
      }
      
      if(vo.getContent().length() < 1) {
         //내용이 비어있음. 다음단계 진행 X
         return -2;
      }
      
      Connection conn = null;
      int result = 0;
      
      try {
         conn = getConnection();
         result = new BoardDao().write(vo, conn);
         
         if(result == 1) {
            commit(conn);
         }else {
            rollback(conn);
         }
         
      } catch (Exception e) {
         rollback(conn);
         e.printStackTrace();
      } finally {
         close(conn);
      }
      
      return result;
   }//write

   public List<BoardVo> showList() {
      
      Connection conn = null;
      List<BoardVo> boardVoList = null;
      
      try{
         conn = JDBCTemplate.getConnection();
         boardVoList = new BoardDao().showList(conn);
         
      } catch(Exception e) {
         e.printStackTrace();
      } finally {
         JDBCTemplate.close(conn);
      }
      
      return boardVoList;
   }//showList
   
   /*
    * 게시글 상세조회
    */
   public BoardVo showDetailByNo(int num) {
      
      Connection conn = null;
      BoardVo vo = null;
      
      try {
         conn = getConnection();
         vo = new BoardDao().showDetailByNo(conn, num);
      }catch(Exception e) {
         System.out.println("[ERROR] 게시글 상세조회 중 예외 발생 !!!");
         e.printStackTrace();
      }finally {
         close(conn);
      }
      
      return vo;
   }
   
//	public void search(){
//		
//
//		System.out.print("게시판 태그를 입력하세요 : ");
//		String search = InputUtil.sc.nextLine();
//		
//		Connection conn = null;
//		BoardVo vo = null;
//		ResultSet rs = null;
//		
//		String sql = "SELECT AD_NO, AD_ADOPT, AD_ANIMAL, AD_TYPE, AD_CITY, AD_KILL, AD_GENDER, AD_AGE FROM ADANDONED_BOARD WHERE AD_CITY = ?";
//				
//		PreparedStatement pstmt;
//		try {
//			try {
//				conn = JDBCTemplate.getConnection();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1,search);
//			
//			rs = pstmt.executeQuery();
//			
//			System.out.println("입양유무 / 축종 / 세부종류 / 지역 / 안락사일정 / 성별 / 나이 ");
//
//			while(rs.next()) {
//				int ad_no = rs.getInt("AD_NO");
//				String adopt = rs.getString("AD_ADOPT");
//				String animal = rs.getString("AD_ANIMAL");
//				String type = rs.getString("AD_TYPE");
//				String city = rs.getString("AD_CITY");
//				String kill = rs.getString("AD_KILL");
//				String gender = rs.getString("AD_GENDER");
//				String age = rs.getString("AD_AGE");
//				
//				vo = new AdVo();
//				vo.setAd_no(ad_no);
//				vo.setAd_adopt(adopt);
//				vo.setAnimal(animal);
//				vo.setType(type);
//				vo.setCity(city);
//				vo.setKill(kill);
//				vo.setGender(gender);
//				vo.setAge(age);
//				
//				System.out.print(vo.getAd_no() + "| ");
//				System.out.print(vo.getAd_adopt() + " / ");
//				System.out.print(vo.getAnimal() + " / ");
//				System.out.print(vo.getType()+" / ");
//				System.out.print(vo.getCity()+" / ");
//				System.out.print(vo.getKill()+" / ");
//				System.out.print(vo.getGender()+" / ");
//				System.out.println(vo.getAge());
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//	         JDBCTemplate.close(rs);
////	         JDBCTemplate.close(pstmt);
//	      }
//		
//	}
   
}//class


















