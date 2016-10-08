
public class Person {
	private String fName;
	private String lName;
	private int age;
	private int PK;
	
	public Person(String f, String l, int a, int p){
		this.fName = f;
		this.lName = l;
		this.age = a;
		this.PK = p;
	}
	public String getfName(){
		return fName;
	}
	public String getlName(){
		return lName;
	}
	public int getAge(){
		return age;
	}
	public int getPK(){
		return PK;
	}
}
