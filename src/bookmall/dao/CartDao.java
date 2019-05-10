package bookmall.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.BookVo;
import bookmall.vo.CartVo;
import bookmall.vo.MemberVo;

public class CartDao extends AbstractDao<CartVo> {

	public final String CART_INSERT = "INSERT INTO cart(member_no, book_no, cart_count) " +
									  "VALUES(?,?,?)";
	public final String CART_LIST = "SELECT m.no, b.no, c.cart_count, m.member_name, b.book_name, b.book_price " + 
									"	FROM book b, cart c, member m " + 
									"WHERE b.no = c.book_no " + 
									"	AND c.member_no = m.no " + 
									"	AND m.no = ?";
		
	@Override
	public int insert(CartVo vo) {
		int result = 0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(CART_INSERT);
			pstmt.setLong(1, vo.getMemberNo());
			pstmt.setLong(2, vo.getBookNo());
			pstmt.setLong(3, vo.getCartCount());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			destroyedConnection(conn, pstmt);
		}
		return result;
	}

	@Override
	public List<CartVo> getList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<CartVo> getList(CartVo condition) {
		List<CartVo> list = new ArrayList<CartVo>();
		CartVo vo = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(CART_LIST);
			pstmt.setLong(1, condition.getMemberNo());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				vo = new CartVo();
				vo.setMemberNo(rs.getLong(1));
				vo.setBookNo(rs.getLong(2));
				vo.setCartCount(rs.getInt(3));
				
				vo.setMemberVo(new MemberVo().setMemberName(rs.getString(4)));
				vo.setBookVo(new BookVo().setBookName(rs.getString(5)).setBookPrice(rs.getInt(6)));
				
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
	public int update(int no, CartVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int no) {
		// TODO Auto-generated method stub
		return 0;
	}

}
