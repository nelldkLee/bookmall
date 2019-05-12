package bookmall.vo;

import java.sql.Date;
import java.util.List;

public class OrderVo {

	private Long no;
	private MemberVo memberVo;
	private String orderCode;
	private Long orderPrice;
	private String address;
	private Date orderTime;
	private List<BookVo> bookList;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public Long getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(Long orderPrice) {
		this.orderPrice = orderPrice;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<BookVo> getBookList() {
		return bookList;
	}
	public void setBookList(List<BookVo> bookList) {
		this.bookList = bookList;
	}
	
	public MemberVo getMemberVo() {
		return memberVo;
	}
	public OrderVo setMemberVo(MemberVo memberVo) {
		this.memberVo = memberVo;
		return this;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	@Override
	public String toString() {
		return "주문코드 : " + orderCode + ", 주문 가격 : " + orderPrice 
				+ ", 주소 : " + address + ", 주문 시간 : " + orderTime 
				+ ", 상품 :" + bookList.get(0).getBookName() + "외 " + (bookList.size() -1) +"건";
	}
	
}
