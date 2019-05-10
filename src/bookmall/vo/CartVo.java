package bookmall.vo;

public class CartVo {
	
	private Long memberNo;
	private Long bookNo;
	private int cartCount;
	private MemberVo memberVo;
	private BookVo bookVo;
	
	
	public CartVo(Long memberNo, Long bookNo, int cartCount) {
		this.memberNo = memberNo;
		this.bookNo = bookNo;
		this.cartCount = cartCount;
	}
	public CartVo() {
	}
	public Long getMemberNo() {
		return memberNo;
	}
	public CartVo setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
		return this;
	}
	public Long getBookNo() {
		return bookNo;
	}
	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}
	
	public int getCartCount() {
		return cartCount;
	}
	public void setCartCount(int cartCount) {
		this.cartCount = cartCount;
	}
	
	public MemberVo getMemberVo() {
		return memberVo;
	}
	public void setMemberVo(MemberVo memberVo) {
		this.memberVo = memberVo;
	}
	public BookVo getBookVo() {
		return bookVo;
	}
	public void setBookVo(BookVo bookVo) {
		this.bookVo = bookVo;
	}
	
	@Override
	public String toString() {
		return "CartVo [memberNo=" + memberNo + ", bookNo=" + bookNo + ", cartCount=" + cartCount + ", memberName="
				+ memberVo.getMemberName() + ", bookName=" + bookVo.getBookName() + ", bookPrice=" + bookVo.getBookPrice()+ "]";
	}
	@Override
	public int hashCode() {
		return memberNo.hashCode() + bookNo.hashCode();
	}
	//내부 로직 조금 더 추가할 것 있나 확인하기.
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(this.bookNo != ((CartVo)obj).bookNo) {
			return false;
		}
		if(this.memberNo != ((CartVo)obj).memberNo) {
			return false;
		}
		return true;
	}
}

