package bje;

import static mini.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import bje.community_board.BoardDao;
import bje.community_board.BoardVo;
import mini.common.JDBCTemplate;

public class BcommentService {

   /*
    * 게시글 작성
    * 
    * 데이터 받기 (컨트롤러)
    * 
    * 비지니스 로직 (서비스)
    * 
    * DB에 insert (DAO)
    */
   public int write(BcommentVo vocom, int boardnum) {

      //비지니스 로직 (내용 1글자 이상인지)
      if(vocom.getContent().length() < 1) {
         //내용이 비어있음. 다음단계 진행 X
         return -1;
      }
      
      Connection conn = null;
      int result = 0;
      
      try {
         conn = getConnection();
         result = new BcommentDao().write(vocom, conn, boardnum);
         
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

   
   public List<BcommentVo> showList(int num) {
      
      Connection conn = null;
      List<BcommentVo> BcommentVoList = null;
      
      try{
         conn = JDBCTemplate.getConnection();
         BcommentVoList = new BcommentDao().showList(conn, num);
         
      } catch(Exception e) {
         e.printStackTrace();
      } finally {
         JDBCTemplate.close(conn);
      }
      
      return BcommentVoList;
   }//showList
   
}//class