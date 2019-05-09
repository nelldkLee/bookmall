package bookmall.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstractTest implements TestInterface{
	
	private Connection conn;
	
	// Dao 내부에 Connection 처리를 하여 로직이 변경됨.
	// Dao가 Connection에 종속적이지 않을 때 사용가능 하다 예상됨.
	public AbstractTest() {
		//initConnection();
		System.out.println("테스트 시작");
		testStart();
		System.out.println("테스트 종료");
		//destroyedConnection();
	}

	public abstract void testStart();
	
	// Dao 내부에 Connection 처리를 하여 로직이 변경됨.
	private void initConnection(){
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://192.168.1.222:3307/bookmall";
			conn = DriverManager.getConnection(url,"bookmall","bookmall");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver 로딩 실패");
		} catch (SQLException e) {
			System.out.println("error :" + e);
		}
		
	}
	// Dao 내부에 Connection 처리를 하여 로직이 변경됨.
	private void destroyedConnection() {
		if(conn != null) try { conn.close();} catch (SQLException e){}
	}
}
