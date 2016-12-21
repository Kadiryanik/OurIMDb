import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MostRatedComponent {
	private String name;
	private int movieId;
	private int userId;
	MostRatedComponent(String n, int uId, int mId, JPanel panelReal) {
		name = n;
		movieId = mId;
		userId = uId;
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 100, 230);
		panel.setLayout(new WrapLayout(FlowLayout.CENTER, 5, 0));
		
		
		JLabel lblIcon = new JLabel("");
		lblIcon.setBounds(10, 10, 100, 150);
		lblIcon.setIcon(SqlOperations.getMovieImage(movieId, lblIcon));
		
		panel.add(lblIcon);
		
		JPanel panelName = new JPanel();
		panelName.setBackground(new Color(255, 255, 255));
		panelName.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel.add(panelName);
		
		new LabelWithLinkForMovie(name, movieId, 11, panelName);
		
		JPanel panelRate = new JPanel();
		panelRate.setLayout(new FlowLayout(FlowLayout.CENTER, 35, 0));
		panelRate.setBackground(new Color(255, 255, 255));
		
		/*getting movie rating which user rated*/
		JLabel lblRate = new JLabel("");
		String ratingQuery = "SELECT * FROM Rating WHERE fkUserId = " + userId + " AND fkMovieId = " + movieId;
		ArrayList<UserRatings> rating = SqlOperations.getUserRating(ratingQuery);
		if(rating.size() != 0){
			lblRate.setText("" + rating.get(0).getRating());
			lblRate.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\MostRatedStar.png"));
		}
		else{
			String movieQuery = "SELECT mRatingSum, mRatingCount FROM Movie WHERE movieId = " + movieId;
			ArrayList<Movie> movieInfo = SqlOperations.getMovie(movieQuery);
			double movieRating = movieInfo.get(0).getmRatingSum() / movieInfo.get(0).getmRatingCount();
			String s = String.format("%.1f", movieRating);
			lblRate.setText(s);
			lblRate.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\WatchListUnratedStar.png"));
		}
		lblRate.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		
		lblRate.setBounds(44, 192, 35, 15);
		
		panelRate.add(lblRate);
		panel.add(panelRate);
		
		panelReal.add(panel);
	}
}
