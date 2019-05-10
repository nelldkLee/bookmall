package bookmall.test;

import java.util.Arrays;
import java.util.List;

import bookmall.dao.OrderDao;
import bookmall.vo.BookVo;
import bookmall.vo.MemberVo;
import bookmall.vo.OrderVo;

public class OrderDaoTest extends AbstractTest{

	private OrderDao dao;
	
	public static void main(String[] args) {
		new OrderDaoTest();
	}
	
	@Override
	public void testStart() {
		dao = new OrderDao();
		//insertTest();
		getListTest();
		//updateTest();
		//deleteTest();
	}
	
	@Override
	public void insertTest() {
		OrderVo vo = new OrderVo();
		vo.getMemberVo().setNo(1L);
		vo.setAddress("대한민국 경기도 성남시");
		List<BookVo> list =  Arrays.asList(new BookVo(1L,30000, 1),
										   new BookVo(2L,15000, 1),
										   new BookVo(4L,27000, 2));
		vo.setOrderPrice(99000L);
		vo.setBookList(list);
		dao.insert(vo);
				
	}

	@Override
	public void getListTest() {
		dao.getList(new OrderVo().setMemberVo(new MemberVo().setNo(1L))).forEach((vo)->System.out.println(vo));
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
