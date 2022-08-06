package krw.notificationboard;

import java.sql.Timestamp;

public class NotiVo {
	
	//constructor
	public NotiVo() {
		
	}
	
	public NotiVo(int notiNo, int memberNo, String writer, String title, String content, Timestamp enrollDate,
			Timestamp modifyDate, Timestamp deleteDate, String disabled) {
		super();
		this.notiNo = notiNo;
		this.memberNo = memberNo;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.deleteDate = deleteDate;
		this.disabled = disabled;
	}
	
	//field
	private int notiNo;
	private int memberNo;
	private String writer;
	private String title;
	private String content;
	private Timestamp enrollDate;
	private Timestamp modifyDate;
	private Timestamp deleteDate;
	private String disabled;
	
	//getter, setter
	public int getNotiNo() {
		return notiNo;
	}

	public void setNotiNo(int notiNo) {
		this.notiNo = notiNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
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

	public Timestamp getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Timestamp getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(Timestamp deleteDate) {
		this.deleteDate = deleteDate;
	}

	public String getUsable() {
		return disabled;
	}

	public void setUsable(String usable) {
		this.disabled = usable;
	}

	//toString
	public String toString() {
		return "NotiVO [notiNo=" + notiNo + ", memberNo=" + memberNo + ", writer=" + writer + ", title=" + title
				+ ", content=" + content + ", enrollDate=" + enrollDate + ", modifyDate=" + modifyDate + ", deleteDate="
				+ deleteDate + ", usable=" + disabled + "]";
	}
	
	
}