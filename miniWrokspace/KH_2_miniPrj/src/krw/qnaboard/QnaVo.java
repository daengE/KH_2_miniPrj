package krw.qnaboard;

import java.sql.Timestamp;

public class QnaVo {
	
	public QnaVo(){
		
	}
	
	public QnaVo(int qnaNo, int memberNo, String type, String writer, String title, String content,
			Timestamp enrollDate, String complete, String delete) {
		super();
		this.qnaNo = qnaNo;
		this.memberNo = memberNo;
		this.type = type;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.enrollDate = enrollDate;
		this.complete = complete;
		this.delete = delete;
	}

	private int qnaNo;
	private int memberNo;
	private String type;
	private String writer;
	private String title;
	private String content;
	private Timestamp enrollDate;
	private String complete;
	private String delete;
	
	public int getQnaNo() {
		return qnaNo;
	}
	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String getComplete() {
		return complete;
	}
	public void setComplete(String complete) {
		this.complete = complete;
	}
	public String getDelete() {
		return delete;
	}
	public void setDelete(String delete) {
		this.delete = delete;
	}

	@Override
	public String toString() {
		return "QnaVo [qnaNo=" + qnaNo + ", memberNo=" + memberNo + ", type=" + type + ", writer=" + writer + ", title="
				+ title + ", content=" + content + ", enrollDate=" + enrollDate + ", complete=" + complete + ", delete="
				+ delete + "]";
	}
	

}
