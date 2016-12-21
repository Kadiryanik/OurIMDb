import java.sql.Date;

public class People {
	private String pTitle;
	private String pBirthday;
	private String pBirthPlace;
	private byte[] pImage;
	private String pDescription;
	private String pImdbId;
	private String pImageUrl;
	private int peopleId;
	
	People(){}
	
	People(String pTitle, String pBirthday, String pBirthPlace,byte[] pImage,String pDescription, String pImdbId, String pImageUrl, int peopleId){
		this.setpTitle(pTitle);
		this.setpBirthday(pBirthday);
		this.setpBirthPlace(pBirthPlace);
		this.setpImage(pImage);
		this.setpDescription(pDescription);
		this.setpImdbId(pImdbId);
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
	public String getpImdbId() {
		return pImdbId;
	}
	public void setpImdbId(String pImdbId) {
		this.pImdbId = pImdbId;
	}
	public String getpImageUrl() {
		return pImageUrl;
	}
	public void setpImageUrl(String pImageUrl) {
		this.pImageUrl = pImageUrl;
	}
}
