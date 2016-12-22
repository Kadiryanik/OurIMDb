import java.awt.EventQueue;
import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;


//Gerekli
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
//GerekliEnd
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
public class TryLink {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws Exception{
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TryLink window = new TryLink();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	

	/**
	 * Create the application.
	 * @throws IOException 
	 * @throws NoSuchAlgorithmException 
	 * @throws KeyManagementException 
	 */
	//Gerekli
	
	
	public TryLink() throws IOException, KeyManagementException, NoSuchAlgorithmException {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 * @throws NoSuchAlgorithmException 
	 * @throws KeyManagementException 
	 */
	private void initialize() throws IOException, NoSuchAlgorithmException, KeyManagementException {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		
		JLabel lblImage = new JLabel("Image");
		lblImage.setBounds(39, 43, 138, 138);
		frame.getContentPane().add(lblImage);
		
		
		//Gerekli
		int i = 0;
		String [] urls = new String[2];
		urls[0] = "http://ia.media-imdb.com/images/G/01/imdb/images/nopicture/medium/name-2135195744._CB522736367_.png";
		urls[1] = "https://images-na.ssl-images-amazon.com/images/M/MV5BMjA0MTIwMzIyN15BMl5BanBnXkFtZTgwNDEyMzg1NDE@._V1_.jpg";
		
		String [] names = new String[2];
		names[0] = "Adam Sandler";
		names[1] = "Felicity Jones";
		for(i = 0; i < 2; i++){
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
	       URL url = new URL(urls[i]);
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
			
			FileOutputStream fos = new FileOutputStream("C://Workplace//"+ names[i] +".jpg");
			fos.write(response);
			fos.close();
		}
		
		String insertString = "INSERT INTO People(pTitle, pBirthday, pBirthPlace, pImdbId, pImageUrl, pDescription) " +
                "VALUES('" + "kadir" + "', '" + "2016-123" + "', '" + "Usa" + "', '" + "imdbId" + "', '" + "imageUrl" + "', '" + "biografi" + "');";
		System.out.println(insertString);
		//Gerekli end
	}
	
	
}
