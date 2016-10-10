
public class User {
	private String id;
	private String pw;
	private int PK;
	
	public User(int p, String id, String pw){
		this.id = id;
		this.pw = pw;
		this.PK = p;
	}
	public String getID(){
		return id;
	}
	public String getPW(){
		return pw;
	}
	public int getPK(){
		return PK;
	}
}
