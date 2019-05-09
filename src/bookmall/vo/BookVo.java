package bookmall.vo;

public class BookVo {
	
	private Long no;
	private String bookName;
	private int bookPrice;
	private CategoryVo categoryVo;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	public CategoryVo getCategoryVo() {
		return categoryVo;
	}
	public void setCategoryVo(CategoryVo categoryVo) {
		this.categoryVo = categoryVo;
	}
	@Override
	public String toString() {
		return "BookVo [no=" + no + ", bookName=" + bookName + ", bookPrice=" + bookPrice + ", categoryVo=" + categoryVo
				+ "]";
	}
}
