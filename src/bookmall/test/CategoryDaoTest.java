package bookmall.test;

import bookmall.dao.CategoryDao;
import bookmall.vo.CategoryVo;

public class CategoryDaoTest extends AbstractTest{

	private CategoryDao dao;
	
	public static void main(String[] args) {
		new CategoryDaoTest();
	}
	@Override
	public void testStart() {
		dao = new CategoryDao();
		insertTest();
		//getListTest();
		//updateTest();
		//deleteTest();
	}
	
	@Override
	public void insertTest() {
		CategoryVo vo = new CategoryVo();
		vo.setCategoryName("자연과학");
		dao.insert(vo);
		vo.setCategoryName("정치");
		dao.insert(vo);
		vo.setCategoryName("컴퓨터과학");
		dao.insert(vo);
		vo.setCategoryName("인문");
		dao.insert(vo);
	}

	@Override
	public void getListTest() {
		dao.getList().forEach((vo)->System.out.println(vo));
	}

	@Override
	public void updateTest() {
		CategoryVo vo = new CategoryVo();
		vo.setCategoryName("정치");
		dao.update(2, vo);
	}

	@Override
	public void deleteTest() {
		dao.delete(2);
	}

}
