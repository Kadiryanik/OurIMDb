
public class People {
	private String pTitle;
	private String pBirthday;
	private String pBirthPlace;
	private byte[] pImage;
	private String pDescription;
	private String pImageUrl;
	private String peopleId;
	
	People(){}
	
	People(String pTitle, String pBirthday, String pBirthPlace,byte[] pImage,String pDescription, String pImageUrl, String peopleId){
		this.setpTitle(pTitle);
		this.setpBirthday(pBirthday);
		this.setpBirthPlace(pBirthPlace);
		this.setpImage(pImage);
		this.setpDescription(pDescription);
		this.setpImageUrl(pImageUrl);
		this.setPeopleId(peopleId);
	}
	
	public String getpTitle() {
		return pTitle;
	}
	public void setpTitle(String pTitle) {
		this.pTitle = pTitle;
	}
	public String getpBirthday() {
		return pBirthday;
	}
	public void setpBirthday(String pBirthday) {
		this.pBirthday = pBirthday;
	}
	public String getpBirthPlace() {
		return pBirthPlace;
	}
	public void setpBirthPlace(String pBirthPlace) {
		this.pBirthPlace = pBirthPlace;
	}
	public String getPeopleId() {
		return peopleId;
	}
	public void setPeopleId(String peopleId) {
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
	public String getpImageUrl() {
		return pImageUrl;
	}
	public void setpImageUrl(String pImageUrl) {
		this.pImageUrl = pImageUrl;
	}
}
