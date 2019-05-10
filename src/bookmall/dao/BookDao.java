package bookmall.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.BookVo;
import bookmall.vo.CategoryVo;

public class BookDao extends AbstractDao<BookVo>{

	public final String BOOK_INSERT = "INSERT INTO book(book_name, book_price, category_no) "
			  + "VALUES(?,?,?)";  
	public final String BOOK_LIST = "SELECT book.no, book_name, book_price, category.no, category.category_name " + 
									"FROM book, category " + 
									"where book.category_no = category.no";
	public final String BOOK_UPDATE = "UPDATE book SET book_name=?, book_price=? WHERE no=?";
	public final String BOOK_DELETE = "DELETE FROM book WHERE no=?";
	
	@Override
	public int insert(BookVo vo) {
		int result = 0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(BOOK_INSERT);
			pstmt.setString(1, vo.getBookName());
			pstmt.setLong(2, vo.getBookPrice());
			pstmt.setLong(3, vo.getCategoryVo().getNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			destroyedConnection(conn, pstmt);
		}
		return result;
	}

	@Override
	public List<BookVo> getList() {
		List<BookVo> list = new ArrayList<BookVo>();
		BookVo vo = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(BOOK_LIST);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new BookVo();
				vo.setNo(rs.getLong(1));
				vo.setBookName(rs.getString(2));
				vo.setBookPrice(rs.getInt(3));
				vo.setCategoryVo(new CategoryVo().setNo(rs.getLong(4)).setCategoryName(rs.getString(5)));
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
	public List<BookVo> getList(BookVo condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(int no, BookVo vo) {
		int result = 0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(BOOK_UPDATE);
			pstmt.setString(1, vo.getBookName());
			pstmt.setInt(2, vo.getBookPrice());
			pstmt.setLong(3, no);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			destroyedConnection(conn, pstmt);
		}
		return result;
	}

	@Override
	public int delete(int no) {
		int result = 0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(BOOK_DELETE);
			pstmt.setLong(1, no);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			destroyedConnection(conn, pstmt);
		}
		return result;
	}
	
}
