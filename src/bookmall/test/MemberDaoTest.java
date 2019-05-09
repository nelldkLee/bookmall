package bookmall.test;

import bookmall.dao.MemberDao;
import bookmall.vo.MemberVo;

public class MemberDaoTest extends AbstractTest{
	
	private MemberDao dao;
	
	public static void main(String[] args) {
		new MemberDaoTest();
	}
	// 테스트 하는 메소드.
	@Override
	public void testStart() {
		dao = new MemberDao();
		//insertTest();
		//getListTest();
		//updateTest();
		//deleteTest();
	}


	@Override
	public void insertTest() {
		MemberVo vo = new MemberVo();
		vo.setMemberName("유정근");
		vo.setPhoneNumber("0101234567");
		vo.setEmail("justsmile@gmail.com");
		vo.setPassword("qwer");
		dao.insert(vo);
	}

	@Override
	public void getListTest() {
		dao.getList().forEach((vo)->System.out.println(vo));
	}

	@Override
	public void updateTest() {
		MemberVo vo = new MemberVo();
		vo.setMemberName("김지용");
		vo.setPhoneNumber("0101234567");
		vo.setEmail("justsmile@gmail.com");
		vo.setPassword("qwer");
		dao.update(2, vo);
	}

	@Override
	public void deleteTest() {
		dao.delete(2);
	}

}
