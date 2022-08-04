package mini.member;

public class MemberPetVo {

	//기본생성자
	public MemberPetVo() {
		
	}
	
	//회원번호xxx 생성자
	public MemberPetVo(String type, String name, String birth, String gender) {
		this.aniType = type;
		this.aniName = name;
		this.aniBirth = birth;
		this.aniGender = gender;
	}


	public MemberPetVo(int memberNo, String type, String name, String birth, String gender) {
		this.memberNo = memberNo;
		this.aniType = type;
		this.aniName = name;
		this.aniBirth = birth;
		this.aniGender = gender;
	}
	
	private int memberNo;
	private String aniType;
	private String aniName;
	private String aniBirth;
	private String aniGender;
	
	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getType() {
		return aniType;
	}

	public void setType(String type) {
		this.aniType = type;
	}

	public String getName() {
		return aniName;
	}

	public void setName(String name) {
		this.aniName = name;
	}

	public String getBirth() {
		return aniBirth;
	}

	public void setBirth(String birth) {
		this.aniBirth = birth;
	}

	public String getGender() {
		return aniGender;
	}

	public void setGender(String gender) {
		this.aniGender = gender;
	}

	public String toString() {
		return "MemberPetVo [memberNo=" + memberNo + ", type=" + aniType + ", name=" + aniName + ", birth=" + aniBirth
				+ ", gender=" + aniGender + "]";
	}
	

}
