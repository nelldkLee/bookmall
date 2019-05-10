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
		insertTest();
		//getListTest();
		//updateTest();
		//deleteTest();
	}
	
	@Override
	public void insertTest() {
		BookVo vo = new BookVo("코스모스",30000,new CategoryVo().setNo(1L));
		dao.insert(vo);
		vo = new BookVo("존엄하게 산다는 것",15000,new CategoryVo().setNo(4L));
		dao.insert(vo);
		vo = new BookVo("스프링 프레임워크 입문",25000,new CategoryVo().setNo(3L));
		dao.insert(vo);
		vo = new BookVo("대규모 시스템을 지탱하는 기술",27000,new CategoryVo().setNo(3L));
		dao.insert(vo);
	}

	@Override
	public void getListTest() {
		dao.getList().forEach((vo)->System.out.println(vo));
	}

	@Override
	public void updateTest() {
		
	}

	@Override
	public void deleteTest() {

	}

	
}
