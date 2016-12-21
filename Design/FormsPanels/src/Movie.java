import java.sql.Date;

public class Movie {
	private String mTitle;
	private String mDate;
	private String mCountry;
	private String mTime;
	private String mLanguage;
	private double mRatingSum;
	private double mRatingCount;
	private String mDescription;
	private byte[] mImage;
	private String mUrlLink;
	private int movieId;
	
	Movie(){}
	
	Movie(String mTitle, String mDate, String mCountry, String mTime, String mLanguage, double mRatingSum,
			double mRatingCount,String mDescription, byte[] mImage, String mUrlLink, int movieId){
		this.setmTitle(mTitle);
		this.setmDate(mDate);
		this.setmCountry(mCountry);
		this.setmTime(mTime);
		this.setmLanguage(mLanguage);
		this.setmRatingSum(mRatingSum);
		this.setmRatingCount(mRatingCount);
		this.setmDescription(mDescription);
		this.setmImage(mImage);
		this.setmUrlLink(mUrlLink);
		this.setMovieId(movieId);
	}
	
	public String getmTitle() {
		return mTitle;
	}
	public void setmTitle(String mTitle) {
		this.mTitle = mTitle;
	}
	public String getmDate() {
		return mDate;
	}
	public void setmDate(String mDate) {
		this.mDate = mDate;
	}
	public String getmCountry() {
		return mCountry;
	}
	public void setmCountry(String mCountry) {
		this.mCountry = mCountry;
	}
	public String getmTime() {
		return mTime;
	}
	public void setmTime(String mTime) {
		this.mTime = mTime;
	}
	public String getmLanguage() {
		return mLanguage;
	}
	public void setmLanguage(String mLanguage) {
		this.mLanguage = mLanguage;
	}
	public double getmRatingSum() {
		return mRatingSum;
	}
	public void setmRatingSum(double mRatingSum) {
		this.mRatingSum = mRatingSum;
	}
	public double getmRatingCount() {
		return mRatingCount;
	}
	public void setmRatingCount(double mRatingCount) {
		this.mRatingCount = mRatingCount;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public byte[] getmImage() {
		return mImage;
	}
	public void setmImage(byte[] mImage) {
		this.mImage = mImage;
	}
	public String getmUrlLink() {
		return mUrlLink;
	}
	public void setmUrlLink(String mUrlLink) {
		this.mUrlLink = mUrlLink;
	}
	public String getmDescription() {
		return mDescription;
	}
	public void setmDescription(String mDescription) {
		this.mDescription = mDescription;
	}
}