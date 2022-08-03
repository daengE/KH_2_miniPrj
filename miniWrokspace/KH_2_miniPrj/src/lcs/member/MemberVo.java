package lcs.member;

import java.sql.Timestamp;

public class MemberVo {
public MemberVo() {
		
	}

	public MemberVo(int no, String id, String pwd, String nick) {
		this.no = no;
		this.id = id;
		this.pwd = pwd;
		this.nick = nick;
	}
	
	public MemberVo(int no, String id, String pwd, String pwd2, String name, String nick, String email, String birth,
			String address, String cell, String isAnimal, Timestamp createDate, Timestamp modifyDate, int disabled,
			int mbRight) {
		super();
		this.no = no;
		this.id = id;
		this.pwd = pwd;
		this.pwd2 = pwd2;
		this.name = name;
		this.nick = nick;
		this.email = email;
		this.birth = birth;
		this.address = address;
		this.cell = cell;
		this.animal = isAnimal;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.disabled = disabled;
		this.mbRight = mbRight;
	}

	private int no;
	private String id;
	private String pwd;
	private String pwd2;
	private String name;
	private String nick;
	private String email;
	private String birth;
	private String address;
	private String cell;
	
	private String animal;
	private Timestamp createDate;
	private Timestamp modifyDate;
	
	private int disabled;
	private int mbRight;
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPwd2() {
		return pwd2;
	}

	public void setPwd2(String pwd2) {
		this.pwd2 = pwd2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCell() {
		return cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}

	public String animal() {
		return animal;
	}

	public void setAnimal(String animal) {
		this.animal = animal;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}

	public int getDisaled() {
		return disabled;
	}

	public void setDisaled(int disaled) {
		this.disabled = disaled;
	}

	public int getMbRight() {
		return mbRight;
	}

	public void setMbRight(int mbRight) {
		this.mbRight = mbRight;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "MemberVo [no=" + no + ", id=" + id + ", pwd=" + pwd + ", pwd2=" + pwd2 + ", name=" + name + ", nick="
				+ nick + ", email=" + email + ", birth=" + birth + ", address=" + address + ", cell=" + cell
				+ ", isAnimal=" + animal + ", createDate=" + createDate + ", modifyDate=" + modifyDate + ", disabled="
				+ disabled + ", mbRight=" + mbRight + "]";
	}

}
