package bookmall.test;

import bookmall.dao.CartDao;
import bookmall.vo.CartVo;

public class CartDaoTest extends AbstractTest{

	private CartDao dao;

	public static void main(String[] args) {
		new CartDaoTest();
	}
	
	@Override
	public void testStart() {
		dao = new CartDao();
		insertTest();
		//getListTest();
		//updateTest();
		//deleteTest();
	}

	@Override
	public void insertTest() {
		CartVo vo = new CartVo(1L,2L, 2);
		dao.insert(vo);
		vo = new CartVo(1L,4L, 4);
		dao.insert(vo);
		vo = new CartVo(2L,2L, 1);
		dao.insert(vo);
	}

	@Override
	public void getListTest() {
		dao.getList(new CartVo().setMemberNo(1L)).forEach((cartvo)->System.out.println(cartvo));
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
