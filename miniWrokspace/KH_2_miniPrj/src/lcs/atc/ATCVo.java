package lcs.atc;

public class ATCVo {
	
	public ATCVo() {
		
	}
	
	public ATCVo(int no, String name, String call, String skill, String loc, String animal, String city) {
		super();
		this.no = no;
		this.name = name;
		this.call = call;
		this.skill = skill;
		this.loc = loc;
		this.animal = animal;
		this.city = city;
	}
	
	private int no;
	private String name;
	private String call;
	private String skill;
	private String loc;
	private String animal;
	private String city;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCall() {
		return call;
	}
	public void setCall(String call) {
		this.call = call;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String getAnimal() {
		return animal;
	}
	public void setAnimal(String animal) {
		this.animal = animal;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	public String toString() {
		return "ATCDao [no=" + no + ", name=" + name + ", call=" + call + ", skill=" + skill + ", loc=" + loc
				+ ", animal=" + animal + ", city=" + city + "]";
	}
	

	
	
	
}
