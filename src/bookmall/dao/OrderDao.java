package bookmall.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bookmall.vo.BookVo;
import bookmall.vo.MemberVo;
import bookmall.vo.OrderVo;

public class OrderDao extends AbstractDao<OrderVo>{

	public final String ORDER_INSERT = "INSERT INTO orders(member_no, orders_code, orders_price, address) " + 
									   "values(?,(select concat(date_format(now(),'%Y%m%d'),'_',LPAD(count(*)+1,6,'0')) " + 
									   "					from orders a " + 
									   "				  where date_format(a.orders_time,'%Y%m%d') = date_format(now(),'%Y%m%d')) " + 
									   "       ,?,?)";
	public final String ORDER_BOOK_INSERT = "INSERT INTO orders_book(book_no, orders_no, orders_count) VALUES(?,?,?)";
	public final String ORDER_LIST = "select m.member_name, orders_code, orders_price, address, orders_time, b.no, b.book_name, b.book_price, ob.orders_count\r\n" + 
									 "	from orders o, member m, orders_book ob, book b " + 
									 "where o.member_no = ? " + 
									 "	and o.member_no = m.no " + 
									 "  and o.no = ob.orders_no " + 
									 "  and ob.book_no = b.no ";
	
	@Override
	public int insert(OrderVo vo) {
		int result = 0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(ORDER_INSERT,pstmt.RETURN_GENERATED_KEYS);
			pstmt.setLong(1, vo.getMemberVo().getNo());
			pstmt.setLong(2, vo.getOrderPrice());
			pstmt.setString(3, vo.getAddress());

			result = pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			long insertedPK = 0;
			if(rs.next()) {
				insertedPK = rs.getLong(1);
			}
			
			List<BookVo> bookList = vo.getBookList();
			for(BookVo bookVo: bookList) {
				System.out.println("--------------------------------");
				System.out.println(vo);
				pstmt = conn.prepareStatement(ORDER_BOOK_INSERT);
				pstmt.setLong(1, bookVo.getNo());
				pstmt.setLong(2, insertedPK);
				pstmt.setLong(3, bookVo.getBookCount());
				pstmt.executeUpdate();
			};
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			destroyedConnection(conn, pstmt);
		}
		return result;
	}

	
	@Override
	public List<OrderVo> getList(OrderVo condition) {
		List<OrderVo> list = new ArrayList<OrderVo>();
		Map<String,OrderVo> ordersMap = new HashMap<>(); 
		OrderVo vo = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(ORDER_LIST);
			pstmt.setLong(1, condition.getMemberVo().getNo());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				vo = new OrderVo();
				vo.setMemberVo(new MemberVo().setMemberName(rs.getString(1)));
				String ordersCode = rs.getString(2);
				vo.setOrderCode(rs.getString(2));
				vo.setOrderPrice(rs.getLong(3));
				vo.setAddress(rs.getString(4));
				vo.setOrderTime(rs.getDate(5));
				BookVo bookVo = new BookVo().setNo(rs.getLong(6)).setBookName(rs.getString(7)).setBookPrice(rs.getInt(8)).setBookCount(rs.getInt(9));
				if(ordersMap.containsKey(ordersCode)) {
					ordersMap.get(ordersCode).getBookList().add(bookVo);
					continue;
				}
				List<BookVo> bookList = new ArrayList<>();
				bookList.add(bookVo);
				vo.setBookList(bookList);
				ordersMap.put(ordersCode,vo);
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			destroyedConnection(conn, pstmt);
		}
		return list;
	}

	@Override
	public List<OrderVo> getList() {
		return getList(new OrderVo().setMemberVo(new MemberVo().setNo(1L)));
	}


	@Override
	public int update(int no, OrderVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int no) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
