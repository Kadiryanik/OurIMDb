package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;


public class Main {

	public static void main(String[] args) throws Exception {
		
		ArrayList<Movie> list = get();
		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i));
		}
		// post();

	}

	public static ArrayList<Movie> get() throws Exception {

		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT * FROM movie");
			ResultSet result = statement.executeQuery();
			
			ResultSetMetaData rsMetaData = result.getMetaData();
			int columnCount = rsMetaData.getColumnCount(); //number of column return from sql query
			
			String[] b = new String[]{"m_Title","m_Year","m_Country","m_Time","m_Language","m_Rating","m_Rating_Count","Movie_ID"};
			ArrayList<Movie> array = new ArrayList<Movie>();
			
			
			while(result.next()){
				Movie a = new Movie();
				if(columnCount == b.length){
					Movie temp = new Movie(result.getString(b[0]),result.getDate(b[1]),result.getString(b[2]),
							result.getString(b[3]),result.getString(b[4]),result.getDouble(b[5]),result.getInt(b[6]),
							result.getInt(b[7]));
					array.add(temp);
				}
				else{
					for(int i = 1; i <= columnCount ; i++){
						String g = rsMetaData.getColumnName(i); //return column name in ResultSet with index (first index is 1) 
						if(g.equals(b[0])){a.setm_title(result.getString(b[0]));}
						if(g.equals(b[1])){a.setm_date(result.getDate(b[1]));}
						if(g.equals(b[2])){a.setm_country(result.getString(b[2]));}
						if(g.equals(b[3])){a.setm_time(result.getString(b[3]));}
						if(g.equals(b[4])){a.setm_language(result.getString(b[4]));}
						if(g.equals(b[5])){a.setm_rating(result.getDouble(b[5]));}
						if(g.equals(b[6])){a.setm_rating_count(result.getInt(b[6]));}
						if(g.equals(b[7])){a.setMovie_ID(result.getInt(b[7]));}
					}
					array.add(a);
				}
				
			}
			System.out.println("All records have been selected!");
			return array;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public static Connection getConnection() throws Exception {

		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3307/imdb";
			String username = "root";
			String password = "h3b9er1po";
			Class.forName(driver);

			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connected");
			return conn;
		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}
	
	/*public static void post() throws Exception {
		final String var1 = "John";
		final String var2 = "Miller";
		try {
			Connection con = getConnection();
			PreparedStatement posted = con.prepareStatement(
					"INSERT INTO tablename(first, last)" + " VALUES ('" + var1 + "', '" + var2 + "')");

			posted.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("Insert Completed.");
		}
	}

	public static void createTable(String sqlString) throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement create = con.prepareStatement(sqlString);
			create.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("Function complete");
		}
	}
	*/
	
}
