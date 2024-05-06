package MyBooking;

public class ManegerDTO {
	private String manegerId;
	private String manegerPw;
	private String manegerName;
	private String manegerTell;
	private String placeName;
	
	public ManegerDTO(String managerId, String managerPw, String managerName, String managerTell, String placeName) {
		super();
		this.manegerId = managerId;
		this.manegerPw = managerPw;
		this.manegerName = managerName;
		this.manegerTell = managerTell;
		this.placeName = placeName;
	}

	@Override
	public String toString() {
		return "ManagerDTO [managerId=" + manegerId + ", managerPw=" + manegerPw + ", managerName=" + manegerName
				+ ", managerTell=" + manegerTell + ", placeName=" + placeName + "]";
	}

	public String getManagerId() {
		return manegerId;
	}

	public void setManagerId(String managerId) {
		this.manegerId = managerId;
	}

	public String getManagerPw() {
		return manegerPw;
	}

	public void setManagerPw(String managerPw) {
		this.manegerPw = managerPw;
	}

	public String getManagerName() {
		return manegerName;
	}

	public void setManagerName(String managerName) {
		this.manegerName = managerName;
	}

	public String getManagerTell() {
		return manegerTell;
	}

	public void setManagerTell(String managerTell) {
		this.manegerTell = managerTell;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	
	
	
	
	
	

}
