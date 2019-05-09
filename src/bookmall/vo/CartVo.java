package bookmall.vo;

public class CartVo {
	
	private Long memberNo;
	private Long bookNo;
	
	public Long getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}
	public Long getBookNo() {
		return bookNo;
	}
	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}
	@Override
	public String toString() {
		return "CartVo [memberNo=" + memberNo + ", bookNo=" + bookNo + "]";
	}
	@Override
	public int hashCode() {
		return memberNo.hashCode() + bookNo.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		// 아직 미구현 equals로 비교하기보다 HashMap에서 키로 중복을 체크
		// 할 것이라 hashCode만 구현해둠.
		return super.equals(obj);
	}
}

