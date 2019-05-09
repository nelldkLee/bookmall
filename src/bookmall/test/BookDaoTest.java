package bookmall.test;

import bookmall.dao.BookDao;
import bookmall.vo.BookVo;
import bookmall.vo.CategoryVo;

public class BookDaoTest extends AbstractTest{

	private BookDao dao;
	
	public static void main(String[] args) {
		new BookDaoTest();
	}

	@Override
	public void testStart() {
		dao = new BookDao();
		//insertTest();
		//getListTest();
		//updateTest();
		//deleteTest();
	}
	
	@Override
	public void insertTest() {
		BookVo vo = new BookVo();
		vo.setBookName("대규모 서비스를 지탱하는 기술");
		vo.setBookPrice(25000);
		vo.setCategoryVo(new CategoryVo().setNo(3L));
	}

	@Override
	public void getListTest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTest() {
		// TODO Auto-generated method stub
		
	}

	
}
