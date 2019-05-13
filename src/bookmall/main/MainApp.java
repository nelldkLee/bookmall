package bookmall.main;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import bookmall.dao.AbstractDao;
import bookmall.dao.BookDao;
import bookmall.dao.CartDao;
import bookmall.dao.CategoryDao;
import bookmall.dao.MemberDao;
import bookmall.dao.OrderDao;
import bookmall.vo.BookVo;
import bookmall.vo.CartVo;
import bookmall.vo.OrderVo;

public class MainApp {

	private Map<String, AbstractDao> list;

	public static void main(String[] args) {
		MainApp app = new MainApp();
		app.init();
		app.display();
	}

	private void init() {
		list = new LinkedHashMap();
		list.put("회원", new MemberDao());
		list.put("카테고리", new CategoryDao());
		list.put("상품", new BookDao());
		list.put("카트", new CartDao());
		list.put("주문", new OrderDao());
	}

	private void display() {
		list.forEach((key,dao)->{
			System.out.println(key +" 리스트");
			List VoList = dao.getList();
			VoList.forEach((vo)->{
				System.out.println(vo);
			});
			checkKey(key,VoList);
		});
	}

	private void checkKey(String key, List VoList) {
		if(key.equals("카트")) {
			int cartTotalPrice = 0;
			Iterator iter = VoList.iterator();
			while(iter.hasNext()) {
				CartVo vo = (CartVo) iter.next();
				cartTotalPrice += vo.getBookVo().getBookPrice() * vo.getCartCount();
			}
			System.out.println("카트 총 금액: " + cartTotalPrice);
		}
		if(key.equals("주문")) {
			displayOrderBookList(VoList);
		}
	}

	private void displayOrderBookList(List<OrderVo> voList) {
		System.out.println("주문도서 리스트");
		voList.forEach(vo ->{
			Iterator iter = vo.getBookList().iterator();
			while(iter.hasNext()) {
				BookVo bookVo = (BookVo) iter.next();
				System.out.println(bookVo + ", 수량 : " +bookVo.getBookCount());
			}
		});
		
	}
}
