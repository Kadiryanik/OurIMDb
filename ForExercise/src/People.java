import java.sql.Date;

public class People {
	private String pTitle;
	private String pFirstName;
	private String pLastName;
	private Date pBirthday;
	private String pBirthPlace;
	private String pGender;
	private byte[] pImage;
	private String pDescription;
	private int peopleId;
	
	@Override
	public String toString(){
		return "" + this.pTitle + " | " +  this.pFirstName + " | " + this.pLastName + " | " + this.pBirthday 
				+ " | " + this.pBirthPlace + " | " + this.pGender + " | " + this.peopleId;
	}
	
	People(){}
	
	People(String pTitle, String pFirstName, String pLastName, Date pBirthday, String pBirthPlace, String pGender, 
			byte[] pImage,String pDescription, int peopleId){
		this.setpTitle(pTitle);
		this.setpFirstName(pFirstName);
		this.setpLastName(pLastName);
		this.setpBirthday(pBirthday);
		this.setpBirthPlace(pBirthPlace);
		this.setpGender(pGender);
		this.setpImage(pImage);
		this.setpDescription(pDescription);
		this.setPeopleId(peopleId);
	}
	
	public String getpTitle() {
		return pTitle;
	}
	public void setpTitle(String pTitle) {
		this.pTitle = pTitle;
	}
	public String getpFirstName() {
		return pFirstName;
	}
	public void setpFirstName(String pFirstName) {
		this.pFirstName = pFirstName;
	}
	public String getpLastName() {
		return pLastName;
	}
	public void setpLastName(String pLastName) {
		this.pLastName = pLastName;
	}
	public Date getpBirthday() {
		return pBirthday;
	}
	public void setpBirthday(Date pBirthday) {
		this.pBirthday = pBirthday;
	}
	public String getpBirthPlace() {
		return pBirthPlace;
	}
	public void setpBirthPlace(String pBirthPlace) {
		this.pBirthPlace = pBirthPlace;
	}
	public String getpGender() {
		return pGender;
	}
	public void setpGender(String pGender) {
		this.pGender = pGender;
	}
	public int getPeopleId() {
		return peopleId;
	}
	public void setPeopleId(int peopleId) {
		this.peopleId = peopleId;
	}

	public byte[] getpImage() {
		return pImage;
	}

	public void setpImage(byte[] pImage) {
		this.pImage = pImage;
	}

	public String getpDescription() {
		return pDescription;
	}

	public void setpDescription(String pDescription) {
		this.pDescription = pDescription;
	}
}
