package bookmall.vo;

public class MemberVo {
	
	private Long no;
	private String memberName;
	private String phoneNumber;
	private String email;
	private String password;
	
	public Long getNo() {
		return no;
	}
	public MemberVo setNo(Long no) {
		this.no = no;
		return this;
	}
	public String getMemberName() {
		return memberName;
	}
	public MemberVo setMemberName(String memberName) {
		this.memberName = memberName;
		return this;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "번호 : " + no + ", 이름 : " + memberName + ", 전화번호 : " + phoneNumber + ", 이메일 : " + email;
	}
	
}
