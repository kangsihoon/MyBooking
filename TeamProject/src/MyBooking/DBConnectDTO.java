package MyBooking;

public class DBConnectDTO {
	private String userId, userPw, userName, userBirth, userTell, userMail;

	public DBConnectDTO(String userId, String userPw, String userName, String userBirth, String userTell,
			String userMail) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userBirth = userBirth;
		this.userTell = userTell;
		this.userMail = userMail;
	}

	public DBConnectDTO() {}

	@Override
	public String toString() {
		return "DBConnectDTO [userId=" + userId + ", userPw=" + userPw + ", userName=" + userName + ", userBirth="
				+ userBirth + ", userTell=" + userTell + ", userMail=" + userMail + "]";
	}

	
	// getter & setter 
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserBirth() {
		return userBirth;
	}

	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}

	public String getUserTell() {
		return userTell;
	}

	public void setUserTell(String userTell) {
		this.userTell = userTell;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	
	
	
	

}
