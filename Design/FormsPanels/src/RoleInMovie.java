
public class RoleInMovie {
	private String castName;
	private int actorFlag;
	private int directorFlag;
	private int writerFlag;
	private int fkPeopleId;
	private int fkMovieId;
	
	RoleInMovie(){}
	
	RoleInMovie(String castName, int actorFlag, int directorFlag, int writerFlag,int fkPeopleId, int fkMovieId ){
		this.setCastName(castName);
		this.setActorFlag(actorFlag);
		this.setDirectorFlag(directorFlag);
		this.setWriterFlag(writerFlag);
		this.setFkPeopleId(fkPeopleId);
		this.setFkMovieId(fkMovieId);
	}
	
	public String getCastName() {
		return castName;
	}
	public void setCastName(String castName) {
		this.castName = castName;
	}
	public int getActorFlag() {
		return actorFlag;
	}
	public void setActorFlag(int actorFlag) {
		this.actorFlag = actorFlag;
	}
	public int getDirectorFlag() {
		return directorFlag;
	}
	public void setDirectorFlag(int directorFlag) {
		this.directorFlag = directorFlag;
	}
	public int getWriterFlag() {
		return writerFlag;
	}
	public void setWriterFlag(int writerFlag) {
		this.writerFlag = writerFlag;
	}
	public int getFkPeopleId() {
		return fkPeopleId;
	}
	public void setFkPeopleId(int fkPeopleId) {
		this.fkPeopleId = fkPeopleId;
	}
	public int getFkMovieId() {
		return fkMovieId;
	}
	public void setFkMovieId(int fkMovieId) {
		this.fkMovieId = fkMovieId;
	}
}
