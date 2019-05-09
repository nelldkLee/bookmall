package bookmall.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.MemberVo;

public class MemberDao extends AbstractDao<MemberVo>{

	public final String MEMBER_INSERT = "INSERT INTO member(member_name, phone_number, email, password) "
									  + "VALUES(?,?,?,?)";  
	public final String MEMBER_LIST = "SELECT no, member_name, phone_number, email FROM member";
	public final String MEMBER_UPDATE = "UPDATE member SET member_name=?, phone_number=?, email=?,password=? WHERE no=?";
	public final String MEMBER_DELETE = "DELETE FROM member WHERE no=?";
	 
	@Override
	public int insert(MemberVo vo) {
		int result = 0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(MEMBER_INSERT);
			pstmt.setString(1, vo.getMemberName());
			pstmt.setString(2, vo.getPhoneNumber());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getPassword());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			destroyedConnection(conn, pstmt);
		}
		return result;
	}

	@Override
	public List<MemberVo> getList() {
		List<MemberVo> list = new ArrayList<MemberVo>();
		MemberVo vo = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(MEMBER_LIST);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new MemberVo();
				vo.setNo(rs.getLong(1));
				vo.setMemberName(rs.getString(2));
				vo.setPhoneNumber(rs.getString(3));
				vo.setEmail(rs.getString(4));
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
	public int update(int no, MemberVo vo) {
		int result = 0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(MEMBER_UPDATE);
			pstmt.setString(1, vo.getMemberName());
			pstmt.setString(2, vo.getPhoneNumber());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getPassword());
			pstmt.setLong(5, no);
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
			pstmt = conn.prepareStatement(MEMBER_DELETE);
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
