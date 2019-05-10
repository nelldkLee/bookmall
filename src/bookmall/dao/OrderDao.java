package bookmall.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	public final String ORDER_LIST = "SELECT m.member_name, orders_code, orders_price, address, orders_time " + 
								 	 "	FROM orders o, member m " + 
								 	 "WHERE o.member_no = ? " + 
								 	 "	AND o.member_no = m.no";
	
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
		OrderVo vo = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(ORDER_LIST);
			pstmt.setLong(1, condition.getMemberVo().getNo());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				vo = new OrderVo();
				vo.setMemberVo(new MemberVo().setMemberName(rs.getString(1)));
				vo.setOrderCode(rs.getString(2));
				vo.setOrderPrice(rs.getLong(3));
				vo.setAddress(rs.getString(4));
				vo.setOrderTime(rs.getDate(5));
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
		// TODO Auto-generated method stub
		return null;
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
