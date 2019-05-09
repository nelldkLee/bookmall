package bookmall.vo;

import java.util.List;

public class OrderVo {

	private Long no;
	private String orderCode;
	private String orderPrice;
	private String address;
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
	public String getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(String orderPrice) {
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
	@Override
	public String toString() {
		return "OrderVo [no=" + no + ", orderCode=" + orderCode + ", orderPrice=" + orderPrice + ", address=" + address
				+ ", bookList=" + bookList + "]";
	}
}
