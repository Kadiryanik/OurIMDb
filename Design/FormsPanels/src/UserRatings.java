import java.sql.Timestamp;

public class UserRatings {
	private String fkUserId;
	private String fkMovieId;
	private int rating;
	private Timestamp ratedTime;
	
	UserRatings(){}
	
	UserRatings(String fkUserId, String fkMovieId, int rating, Timestamp ratedTime){
		this.setFkUserId(fkUserId);
		this.setFkMovieId(fkMovieId);
		this.setRating(rating);
		this.setRatedTime(ratedTime);
	}
	
	public String getFkUserId() {
		return fkUserId;
	}
	public void setFkUserId(String fkUserId) {
		this.fkUserId = fkUserId;
	}
	public String getFkMovieId() {
		return fkMovieId;
	}
	public void setFkMovieId(String fkMovieId) {
		this.fkMovieId = fkMovieId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}

	public Timestamp getRatedTime() {
		return ratedTime;
	}

	public void setRatedTime(Timestamp ratedTime) {
		this.ratedTime = ratedTime;
	}
}
