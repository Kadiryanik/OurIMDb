import java.sql.Timestamp;

public class MovieCommentClass {
	private String fkMovieId;
	private int fkUserId;
	private String comment;
	private Timestamp commentTime;
	private int commentId;
	
	MovieCommentClass() {	}
	
	MovieCommentClass(String fkMovieId, int fkUserId, String comment, Timestamp commentTime, int commentId){
		this.setFkMovieId(fkMovieId);
		this.setFkUserId(fkUserId);
		this.setComment(comment);
		this.setCommentTime(commentTime);
		this.setCommentId(commentId);
	}
	
	public String getFkMovieId() {
		return fkMovieId;
	}
	public void setFkMovieId(String fkMovieId) {
		this.fkMovieId = fkMovieId;
	}
	public int getFkUserId() {
		return fkUserId;
	}
	public void setFkUserId(int fkUserId) {
		this.fkUserId = fkUserId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public Timestamp getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(Timestamp commentTime) {
		this.commentTime = commentTime;
	}
}
