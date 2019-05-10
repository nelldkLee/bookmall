package bookmall.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.CategoryVo;

public class CategoryDao extends AbstractDao<CategoryVo> {

	public final String CATEGORY_INSERT = "INSERT INTO category(category_name) "
			+ "VALUES(?)";
	public final String CATEGORY_LIST = "SELECT no, category_name FROM category";
	public final String CATEGORY_UPDATE = "UPDATE category SET category_name=? WHERE no=?";
	public final String CATEGORY_DELETE = "DELETE FROM category WHERE no=?";

	@Override
	public int insert(CategoryVo vo) {
		int result = 0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(CATEGORY_INSERT);
			pstmt.setString(1, vo.getCategoryName());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			destroyedConnection(conn, pstmt);
		}
		return result;
	}

	@Override
	public List<CategoryVo> getList() {
		List<CategoryVo> list = new ArrayList<CategoryVo>();
		CategoryVo vo = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(CATEGORY_LIST);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				vo = new CategoryVo();
				vo.setNo(rs.getLong(1));
				vo.setCategoryName(rs.getString(2));
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
	public List<CategoryVo> getList(CategoryVo condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(int no, CategoryVo vo) {
		int result = 0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(CATEGORY_UPDATE);
			pstmt.setString(1, vo.getCategoryName());
			pstmt.setLong(2, no);
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
			pstmt = conn.prepareStatement(CATEGORY_DELETE);
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
