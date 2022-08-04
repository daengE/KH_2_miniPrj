package bje;

import java.sql.Timestamp;

public class BcommentVo {

   public BcommentVo() {
      
   }
   
   public BcommentVo(int com_no, int b_no, String writer, String content, Timestamp enrollDate, String modity,
         Timestamp modifyDate) {
      this.com_no = com_no;
      this.b_no = b_no;
      this.writer = writer;
      this.content = content;
      this.enrollDate = enrollDate;
      this.modity = modity;
      this.modifyDate = modifyDate;
   }

   private int com_no;
   private int b_no;
   private String writer;
   private String content;
   private Timestamp enrollDate;
   private String modity;
   private Timestamp modifyDate;
   
   public int getCom_no() {
      return com_no;
   }

   public void setCom_no(int com_no) {
      this.com_no = com_no;
   }

   public int getB_no() {
      return b_no;
   }

   public void setB_no(int b_no) {
      this.b_no = b_no;
   }

   public String getWriter() {
      return writer;
   }

   public void setWriter(String writer) {
      this.writer = writer;
   }

   public String getContent() {
      return content;
   }

   public void setContent(String content) {
      this.content = content;
   }

   public Timestamp getEnrollDate() {
      return enrollDate;
   }

   public void setEnrollDate(Timestamp enrollDate) {
      this.enrollDate = enrollDate;
   }

   public String getModity() {
      return modity;
   }

   public void setModity(String modity) {
      this.modity = modity;
   }

   public Timestamp getModifyDate() {
      return modifyDate;
   }

   public void setModifyDate(Timestamp modifyDate) {
      this.modifyDate = modifyDate;
   }

   @Override
   public String toString() {
      return "BcommentVo [com_no=" + com_no + ", b_no=" + b_no + ", writer=" + writer + ", content=" + content
            + ", enrollDate=" + enrollDate + ", modity=" + modity + ", modifyDate=" + modifyDate + "]";
   }
   
}//class


















