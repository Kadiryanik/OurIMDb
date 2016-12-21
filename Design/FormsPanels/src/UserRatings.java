
public class UserRatings {
	private int fkUserId;
	private int fkMovieId;
	private int rating;
	
	UserRatings(){}
	
	UserRatings(int fkUserId, int fkMovieId, int rating){
		this.setFkUserId(fkUserId);
		this.setFkMovieId(fkMovieId);
		this.setRating(rating);
	}
	
	public int getFkUserId() {
		return fkUserId;
	}
	public void setFkUserId(int fkUserId) {
		this.fkUserId = fkUserId;
	}
	public int getFkMovieId() {
		return fkMovieId;
	}
	public void setFkMovieId(int fkMovieId) {
		this.fkMovieId = fkMovieId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
}
