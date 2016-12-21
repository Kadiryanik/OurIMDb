public class Genre {
	private String mType;
	private int movieId;
	
	Genre(){}
	
	Genre(String mType, int movieId){
		this.setmType(mType);
		this.setmovieId(movieId);
	}

	public String getmType() {
		return mType;
	}
	public void setmType(String mType) {
		this.mType = mType;
	}
	public int getmovieId() {
		return movieId;
	}
	public void setmovieId(int movieId) {
		this.movieId = movieId;
	}
}
