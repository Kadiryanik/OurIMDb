import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class UrlDownloadWithPeopleTitle {
	
	public static void main(String[] args) throws KeyManagementException, NoSuchAlgorithmException, IOException, MalformedURLException{
		UrlDownloadWithPeopleTitle.deneme();
	}
	public static void deneme() throws NoSuchAlgorithmException, KeyManagementException, IOException, MalformedURLException{
		
		int i = 0;
		String movieQuery = "SELECT movieId FROM Movie";
		ArrayList<Movie> movieList = SqlOperations.getMovie(movieQuery);
		
		String[] movieIds = new String[movieList.size()];
		for(i = 0; i < movieIds.length; i++){
			movieIds[i] = movieList.get(i).getMovieId();
		}
		int j = 0;
		while(j < movieIds.length){
			String query = "SELECT pTitle,pImageUrl,pImage FROM people WHERE peopleId IN (SELECT fkPeopleId FROM moviepeople WHERE fkMovieId='" + movieIds[j] + "')";
			ArrayList<People> list = SqlOperations.getPeople(query);
	       
			for(i = 0; i < list.size(); i++){
				if(list.get(i).getpImage() == null && 
						list.get(i).getpImageUrl().substring(list.get(i).getpImageUrl().length()-3, list.get(i).getpImageUrl().length()) != "png"){
				    // Create a trust manager that does not validate certificate chains
			        TrustManager[] trustAllCerts = new TrustManager[] {new X509TrustManager() {
			               public java.security.cert.X509Certificate[] getAcceptedIssuers() {
			                   return null;
			               }
			               public void checkClientTrusted(X509Certificate[] certs, String authType) {
			               }
			               public void checkServerTrusted(X509Certificate[] certs, String authType) {
			               }
			           }
			        };
		
			       // Install the all-trusting trust manager
			       SSLContext sc = SSLContext.getInstance("SSL");
			       sc.init(null, trustAllCerts, new java.security.SecureRandom());
			       HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		
			       // Create all-trusting host name verifier
			       HostnameVerifier allHostsValid = new HostnameVerifier() {
			           public boolean verify(String hostname, SSLSession session) {
			               return true;
			           }
			       };
		
			       // Install the all-trusting host verifier
			       HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
			
			       //URL url = new URL("https://images-na.ssl-images-amazon.com/images/M/MV5BMjA5NTA3MDQyOV5BMl5BanBnXkFtZTcwODM4NDE3Mw@@._V1_.jpg");
			       	System.out.println(list.get(i).getpImageUrl());
			       URL url = new URL(list.get(i).getpImageUrl());
			       
			       
			       
					InputStream in = new BufferedInputStream(url.openStream());
					ByteArrayOutputStream out = new ByteArrayOutputStream();
					byte[] buf = new byte[1024];
					int n = 0;
					while (-1!=(n=in.read(buf)))
					{
					   out.write(buf, 0, n);
					}
					out.close();
					in.close();
					
					byte[] response = out.toByteArray();
					
					FileOutputStream fos = new FileOutputStream("C://Workplace//OurIMDb//DB//PeopleOriginalImages//"+ list.get(i).getpTitle() +".jpg");
					fos.write(response);
					fos.close();
					System.out.println("" + i + " of " + list.size() + "added");
				}
			}
			System.out.println(movieIds[j] + " - " + j + " of " + movieIds.length + " done");
			j++;
			
		}
		System.out.println("done");
	}
}
