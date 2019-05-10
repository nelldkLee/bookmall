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
		return "OrderVo [no=" + no + ", memberVo=" + memberVo + ", orderCode=" + orderCode + ", orderPrice="
				+ orderPrice + ", address=" + address + ", orderTime=" + orderTime + ", bookList=" + bookList + "]";
	}
}
