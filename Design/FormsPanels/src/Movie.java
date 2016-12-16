import java.sql.Date;

public class Movie {
	private String mTitle;
	private Date mYear;
	private String mCountry;
	private String mTime;
	private String mLanguage;
	private double mRating;
	private int mRatingCount;
	private String mDescription;
	private byte[] mImage;
	private String mUrlLink;
	private int movieId;
	
	@Override
	public String toString(){
		return "" + this.mTitle + " | " + this.mYear +  " | " + this.mCountry + " | " + this.mTime + " | " + 
				this.mLanguage + " | " + this.mRating + " | " + this.mRatingCount + " | " + this.movieId + " | "  + this.mUrlLink + "\n";
	}
	
	Movie(){}
	
	Movie(String mTitle, Date mYear, String mCountry, String mTime, String mLanguage, double mRating,
			int mRatingCount,String mDescription, byte[] mImage, String mUrlLink, int movieId){
		this.setmTitle(mTitle);
		this.setmYear(mYear);
		this.setmCountry(mCountry);
		this.setmTime(mTime);
		this.setmLanguage(mLanguage);
		this.setmRating(mRating);
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
	public Date getmYear() {
		return mYear;
	}
	public void setmYear(Date mYear) {
		this.mYear = mYear;
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
	public double getmRating() {
		return mRating;
	}
	public void setmRating(double mRating) {
		this.mRating = mRating;
	}
	public int getmRatingCount() {
		return mRatingCount;
	}
	public void setmRatingCount(int mRatingCount) {
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
