package bookmall.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class AbstractConnection {

	private Connection getConnection() throws ClassNotFoundException, SQLException {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://192.168.1.222:3307/bookmall";
			return DriverManager.getConnection(url,"bookmall","bookmall");
	}
	protected void executeUpdate() {
		try {
			Connection conn = getConnection();
			System.out.println(" 연결성공");
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver 로딩 실패");
		} catch (SQLException e) {
			System.out.println("error :" + e);
		} finally {
			/*
			 * if(conn != null) try { conn.close();} catch (SQLException e){} if(pstmt !=
			 * null) try { pstmt.close();} catch (SQLException e){}
			 */
		}
	}
}
