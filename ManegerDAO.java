package MyBooking;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManegerDAO {
	ManegerDAO(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "C##dbexam";
		String password = "m1234";

		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 접속 성공 : Connection 객체, 접속 실패 : null
		return conn;
	}
	
	public int mlogin(String manegerId, String manegerPw) {
		String sql = "select manegerPw from Maneger where manegerId = ?";
		
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, manegerId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(manegerPw)) return 1; //로그인 성공
				else return 0; //비밀번호 틀림
			}
			return -1; //아이디 틀림
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return -2; //데이터베이스 오류
	}

}
