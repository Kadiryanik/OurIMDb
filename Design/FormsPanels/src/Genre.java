public class Genre {
	private String mType;
	private String movieId;
	
	Genre(){}
	
	Genre(String mType, String movieId){
		this.setmType(mType);
		this.setmovieId(movieId);
	}

	public String getmType() {
		return mType;
	}
	public void setmType(String mType) {
		this.mType = mType;
	}
	public String getmovieId() {
		return movieId;
	}
	public void setmovieId(String movieId) {
		this.movieId = movieId;
	}
}
