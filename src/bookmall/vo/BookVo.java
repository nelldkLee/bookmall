package bookmall.vo;

public class BookVo {
	
	private Long no;
	private String bookName;
	private int bookPrice;
	private int bookCount;
	private CategoryVo categoryVo;
	
	public BookVo(String bookName, int bookPrice, CategoryVo categoryVo) {
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.categoryVo = categoryVo;
	}
	public BookVo(Long no, int bookPrice, int bookCount) {
		this.no = no;
		this.bookPrice = bookPrice;
		this.bookCount = bookCount;
	}
	
	public BookVo() {
		
	}
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getBookName() {
		return bookName;
	}
	public BookVo setBookName(String bookName) {
		this.bookName = bookName;
		return this;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public BookVo setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
		return this;
	}
	public CategoryVo getCategoryVo() {
		return categoryVo;
	}
	public void setCategoryVo(CategoryVo categoryVo) {
		this.categoryVo = categoryVo;
	}
	
	public int getBookCount() {
		return bookCount;
	}

	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}

	@Override
	public String toString() {
		return "BookVo [no=" + no + ", bookName=" + bookName + ", bookPrice=" + bookPrice + ", bookCount=" + bookCount
				+ ", categoryVo=" + categoryVo + "]";
	}
}
