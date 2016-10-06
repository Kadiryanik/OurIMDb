import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {
	public static void main(String[] args) throws Exception{
		//Accessing driver from JAR file
		Class.forName("com.mysql.jdbc.Driver");
		
		//Creating connection with variable which named "con" 	  DB address	root user and password for DB
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DbTest", "root", "81035241");
		
		//Create query
		PreparedStatement statement = con.prepareStatement("select * from information");
		
		//Creating a variable ("result") to execute query
		ResultSet result = statement.executeQuery();
		
		//List all
		while(result.next()){
			System.out.println(result.getString(1) + " " + result.getString(2) + " " + result.getInt(3));
		}//End of while
	}//End of main
}//End of Main
