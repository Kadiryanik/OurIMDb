
public class Person {
	private String fName;
	private String lName;
	private int age;
	
	public Person(String f, String l, int a){
		this.fName = f;
		this.lName = l;
		this.age = a;
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
}
