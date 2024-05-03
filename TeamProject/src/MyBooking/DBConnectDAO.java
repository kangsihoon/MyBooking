// DB 연동 코드 

package MyBooking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBConnectDAO {
	
	// 드라이버 등록
	public DBConnectDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// DB 접속 함수
	public Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "C##Mybooking"; // 보류
		String password = "mb12345"; //보류
		
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		// 접속 성공시
		return conn;
	}
	
	
	// SQL 작업
	// 필요한 작업은 밑에서 수행 
	public int CreateAccountArticle(DBConnectDTO dto) {
		String sql = "insert into Member values(?, ?, ?, ?, ?, ?)";
		int result = 0;
		
		// DB 접속
		Connection conn = getConnection();
		PreparedStatement pmt = null;
		
		try {
			pmt = conn.prepareStatement(sql);
			pmt.setString(1, dto.getUserId());
			pmt.setString(2, dto.getUserPw());
			pmt.setString(3, dto.getUserName());
			pmt.setString(4, dto.getUserBirth());
			pmt.setString(5, dto.getUserTell());
			pmt.setString(6, dto.getUserMail());
			
			result = pmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			// DB 접속 해제
			try {
				if(pmt!=null) pmt.close();
				if(conn!=null) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	
}



















