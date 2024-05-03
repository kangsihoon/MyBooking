package MyBooking;

public class MyBookingImpl {
	DBConnectDAO dao = new DBConnectDAO();
	
	// 회원가입을 통한 insert
	public int CreateAccount(DBConnectDTO dto) {
		int result = dao.CreateAccountArticle(dto);
		return result;
	}
}
