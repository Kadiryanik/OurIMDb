import java.sql.Timestamp;

public class MovieCommentReplyClass {
	private int fkCommentId;
	private int fkUserId;
	private String comment;
	private Timestamp commentTime;
	private int commentId;
	
	MovieCommentReplyClass() {}
	MovieCommentReplyClass(int fkCommentId, int fkUserId, String comment,Timestamp commentTime, int commentId){
		this.setFkCommentId(fkCommentId);
		this.setFkUserId(fkUserId);
		this.setComment(comment);
		this.setCommentTime(commentTime);
		this.setCommentId(commentId);
	}
	
	public int getFkCommentId() {
		return fkCommentId;
	}
	public void setFkCommentId(int fkCommentId) {
		this.fkCommentId = fkCommentId;
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
