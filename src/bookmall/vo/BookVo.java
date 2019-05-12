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
	public BookVo setNo(Long no) {
		this.no = no;
		return this;
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

	public BookVo setBookCount(int bookCount) {
		this.bookCount = bookCount;
		return this;
	}

	@Override
	public String toString() {
		return "번호 : " + no + ", 책 이름 : " + bookName + ", 책 가격: " + bookPrice;
	}
}
