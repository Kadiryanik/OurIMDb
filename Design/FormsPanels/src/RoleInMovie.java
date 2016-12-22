
public class RoleInMovie {
	private String castName;
	private int actorFlag;
	private int directorFlag;
	private int writerFlag;
	private String fkPeopleId;
	private String fkMovieId;
	
	RoleInMovie(){}
	
	RoleInMovie(String castName, int actorFlag, int directorFlag, int writerFlag, String fkPeopleId, String fkMovieId ){
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
	public String getFkPeopleId() {
		return fkPeopleId;
	}
	public void setFkPeopleId(String fkPeopleId) {
		this.fkPeopleId = fkPeopleId;
	}
	public String getFkMovieId() {
		return fkMovieId;
	}
	public void setFkMovieId(String fkMovieId) {
		this.fkMovieId = fkMovieId;
	}
}
