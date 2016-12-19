
public class UserClass {
	private String uEmail;
	private String uDisplayName;
	private String uPassword;
	private String uRegistrationDate;
	private int userId;
	
	@Override
	public String toString(){
		return uEmail + " | " + uDisplayName + " | " + uPassword + " | ";
	}
	UserClass(){
		this.setuEmail(null);
		this.setuDisplayName(null);
		this.setuPassword(null);
		this.setuRegistrationDate(null);
		this.setUserId(0);
	}
	
	UserClass(String uEmail, String uDisplayName, String uPassword, String uRegistrationDate, int userId){
		this.setuEmail(uEmail);
		this.setuDisplayName(uDisplayName);
		this.setuPassword(uPassword);
		this.setuRegistrationDate(uRegistrationDate);
		this.setUserId(userId);
	}

	public String getuEmail() {
		return uEmail;
	}

	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}

	public String getuDisplayName() {
		return uDisplayName;
	}

	public void setuDisplayName(String uDisplayName) {
		this.uDisplayName = uDisplayName;
	}

	public String getuPassword() {
		return uPassword;
	}

	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getuRegistrationDate() {
		return uRegistrationDate;
	}
	public void setuRegistrationDate(String uRegistrationDate) {
		this.uRegistrationDate = uRegistrationDate;
	}
}
