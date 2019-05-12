package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class AbstractDao<E> implements DaoInterface<E>{
	
	protected Connection conn;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	
	protected Connection getConnection() throws SQLException{
		Connection conn = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://localhost:3307/bookmall";
			conn = DriverManager.getConnection(url,"bookmall","bookmall");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver 로딩 실패");
		} 
		//System.out.println("Connection open");
		return conn;
	}
	protected void destroyedConnection(Connection conn,PreparedStatement pstmt, ResultSet rs) {
		destroyedConnection(conn,pstmt);
		
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//System.out.println("ResultSet closed");
	}
	protected void destroyedConnection(Connection conn,PreparedStatement pstmt) {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//System.out.println("Connection closed");
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//System.out.println("PreparedStatement closed");
	}
	
}
