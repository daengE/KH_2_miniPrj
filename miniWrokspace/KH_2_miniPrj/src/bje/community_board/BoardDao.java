package bje.community_board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.xml.sax.helpers.ParserAdapter;

import bje.BcommentVo;

import java.util.*;

import mini.common.JDBCTemplate;

public class BoardDao {

   /*
    * 게시글 작성
    * 
    * 데이터 받기 (컨트롤러)
    * 
    * 비지니스 로직 (서비스)
    * 
    * DB에 insert (DAO)
    */
   public int write(BoardVo vo, Connection conn) throws Exception {
      
      //커넥션 준비
      
      int result = 0;
      PreparedStatement pstmt = null;
      
      try {
         
         //SQL 작성
         String sql = "INSERT INTO COMMUNITY_BOARD (B_NO, M_NO, POST_TYPE, B_TAG, B_TITLE, B_CONTENTS, B_ENROLL_DATE, B_NICK, B_DELETE_YN, B_MODIFY, B_MDATE) "
               + "      VALUES(SEQ_COMMUNITY_BOARD_B_NO.NEXTVAL, ? , 'CB' , ? , ? , ? , DEFAULT, ? , 'N' , 'N' , DEFAULT)";
         
         
         //SQL 객체에 담기 및 완성(물음표 채우기)
         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, vo.getM_no());
         pstmt.setString(2, vo.getTag());
         pstmt.setString(3, vo.getTitle());
         pstmt.setString(4, vo.getContent());
         pstmt.setString(5, vo.getWriter());
         
         //SQL 실행 및 결과 저장
         result = pstmt.executeUpdate();
         
      } finally{
         JDBCTemplate.close(pstmt);
      }
      
      return result;
   }//write

   
   public List<BoardVo> showList(Connection conn) throws Exception {
      //CONN 준비
      
      //SQL 준비
      String sql = "SELECT B_TAG , B_NO , B_TITLE , B_CONTENTS , B_NICK , B_ENROLL_DATE FROM COMMUNITY_BOARD WHERE B_DELETE_YN = 'N' ORDER BY B_NO";
      
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      List<BoardVo> boardVoList = new ArrayList<BoardVo>();   
      
      try {
         //SQL 담을 객체 준비 및 SQL 완성
         pstmt = conn.prepareStatement(sql);
         
         //SQL 실행 및 결과 저장
         rs = pstmt.executeQuery();
         
         //커서 내리고, 칼럼별로 읽어오기, 객체로 ㄱ만들기   << 반복
         // rs.next, rs.getXXX("칼럼명"), vo.setXXX
         
         while(rs.next()) {
        	 String tag = rs.getString("B_TAG");
        	 int no = rs.getInt("B_NO");
             String title = rs.getString("B_TITLE");
             Timestamp enrollDate = rs.getTimestamp("B_ENROLL_DATE");
             String writer = rs.getString("B_NICK");
            
             BoardVo vo = new BoardVo();
             vo.setTag(tag);
             vo.setB_no(no);
             vo.setTitle(title);
             vo.setEnrollDate(enrollDate);
             vo.setWriter(writer);
            
             boardVoList.add(vo);
         }
      } finally {
         JDBCTemplate.close(rs);
         JDBCTemplate.close(pstmt);
      }
      
      //SQL 실행 결과 리턴
      return boardVoList;
   }//showList

   
   public List<BoardVo> choiceBoardTag(Connection conn, String tag) throws Exception {
      //CONN 준비
      
      //SQL 준비
      String sql = "SELECT B_TAG, B_NO , B_TITLE , B_CONTENTS , B_NICK , B_ENROLL_DATE FROM COMMUNITY_BOARD WHERE B_TAG = ?";
      
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      List<BoardVo> boardVoList = new ArrayList<BoardVo>();   
      
      try {
         //SQL 담을 객체 준비 및 SQL 완성
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, tag);
         
         //SQL 실행 및 결과 저장
         rs = pstmt.executeQuery();
         
         //커서 내리고, 칼럼별로 읽어오기, 객체로 ㄱ만들기   << 반복
         // rs.next, rs.getXXX("칼럼명"), vo.setXXX
         
         while(rs.next()) {
        	 tag = rs.getString("B_TAG");
        	 int no = rs.getInt("B_NO");
             String title = rs.getString("B_TITLE");
             Timestamp enrollDate = rs.getTimestamp("B_ENROLL_DATE");
             String writer = rs.getString("B_NICK");
            
             BoardVo vo = new BoardVo();
             vo.setTag(tag);
             vo.setB_no(no);
             vo.setTitle(title);
             vo.setEnrollDate(enrollDate);
             vo.setWriter(writer);
            
             boardVoList.add(vo);
         }
      } finally {
         JDBCTemplate.close(rs);
         JDBCTemplate.close(pstmt);
      }
      
      //SQL 실행 결과 리턴
      return boardVoList;
   }//choiceBoardTag   
   
   
   public BoardVo showDetailByNo(Connection conn, int num) throws Exception {
      //connection 준비
      
      //SQL 준비
      String sql = "SELECT B_TAG , B_NO , B_TITLE , B_CONTENTS , B_NICK , B_ENROLL_DATE FROM COMMUNITY_BOARD WHERE B_NO = ?";
      
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      BoardVo vo = null;
      
      try {
         //SQL 객체에 담기 및 쿼리 완성하기
         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, num);
         
         //SQL 실행 및 결과 저장
         rs = pstmt.executeQuery();
         
         //ResultSet -> 자바객체
         if(rs.next()) {
        	String tag = rs.getString("B_TAG");
            int no = rs.getInt("B_NO");
            String title = rs.getString("B_TITLE");
            String content = rs.getString("B_CONTENTS");
            String nick = rs.getString("B_NICK");
            Timestamp enrollDate = rs.getTimestamp("B_ENROLL_DATE");
            
            vo = new BoardVo();
            vo.setTag(tag);
            vo.setB_no(no);
            vo.setTitle(title);
            vo.setContent(content);
            vo.setWriter(nick);
            vo.setEnrollDate(enrollDate);
         }
      }catch(Exception e) {
         e.printStackTrace();
         throw e;
      }finally {
         mini.common.JDBCTemplate.close(pstmt);
         mini.common.JDBCTemplate.close(rs);
      }
      //실행결과(자바객체) 리턴
      return vo;
   }//showDetailByNo
   
}//class


















