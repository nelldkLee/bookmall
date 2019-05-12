package bookmall.vo;

public class CategoryVo {
	
	private Long no;
	private String categoryName;
	
	public Long getNo() {
		return no;
	}
	public CategoryVo setNo(Long no) {
		this.no = no;
		return this;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public CategoryVo setCategoryName(String categoryName) {
		this.categoryName = categoryName;
		return this;
	}
	@Override
	public String toString() {
		return "번호 : " + no + ", 카테고리 이름 : " + categoryName;
	}
	
}
