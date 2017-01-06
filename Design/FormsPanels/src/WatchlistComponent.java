import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class WatchlistComponent {
	private String movieId;
	private int userId;
	WatchlistComponent(int uId, String mId, JPanel panelReal){
		movieId = mId;
		userId = uId;
		int isAdded = 0;
		
		String Query = "SELECT movieId,mTitle FROM Movie WHERE movieId = '" + movieId + "' AND movieId IN"
				+ "(SELECT fkMovieId FROM WatchList WHERE fkUserId = " + userId + ")";
		ArrayList<Movie> watchList = SqlOperations.getMovie(Query);
		if(watchList.size() > 0){
			isAdded = 1;
		}
		//TODO: tüm filmler izleme listesindeyken scroll pane çalýþmýyor
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 500, 164);

		final JLabel lblAddedWatch = new JLabel("");
		final JLabel lblAddWatch = new JLabel("");
		
		JPanel panelName = new JPanel();
		panelName.setBackground(new Color(255, 255, 255));
		panelName.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
		new LabelWithLinkForMovie(watchList.get(0).getmTitle(), mId, 11, 50, panelName);
		
		JPanel panelUnderName = new JPanel();
		panelUnderName.setBackground(new Color(255, 255, 255));
		panelUnderName.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		lblAddWatch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String query = "INSERT INTO WatchList(fkUserId, fkMovieId) VALUES(" + MainForm.getLoggedUserId() + ",'" + movieId + "')";
				SqlOperations.insert(query);
				lblAddWatch.setVisible(false);
				lblAddedWatch.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblAddWatch.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\watch2026a.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblAddWatch.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\watch2026.png"));
			}
		});
		lblAddWatch.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\watch2026.png"));
		lblAddWatch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
	
		JLabel lblYourratingpoint = new JLabel();
		JLabel lblStarb = new JLabel("");
		
		/*getting movie rating which user rated*/
		String ratingQuery = "SELECT * FROM Rating WHERE fkUserId = " + userId + " AND fkMovieId = '" + movieId + "'";
		ArrayList<UserRatings> rating = SqlOperations.getUserRating(ratingQuery);
		if(rating.size() != 0){//if there is no rating don't need this field
			lblYourratingpoint.setText("" + rating.get(0).getRating());
			lblYourratingpoint.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
			lblStarb.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\StarBlueXXsmal.png"));
		}
		
		/*getting movie informations*/
		String movieQuery = "SELECT mRatingSum, mRatingCount, mDescription, mImage FROM Movie WHERE movieId = '" + movieId + "'";
		ArrayList<Movie> movieInfo = SqlOperations.getMovie(movieQuery);
		double movieRating = movieInfo.get(0).getmRatingSum() / movieInfo.get(0).getmRatingCount();
		String s = String.format("%.1f", movieRating);
		JLabel lblRatingPoint = new JLabel(s);
		lblRatingPoint.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		
		JLabel lblStary = new JLabel("");
		lblStary.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\StarYellowXXsmal.png"));
		
		JTextArea textInfo = new JTextArea();
		textInfo.setFont(new Font("Comic Sans MS", Font.PLAIN, 9));
		textInfo.setBackground(new Color(255, 255, 255));
		textInfo.setBounds(160, 61, 370, 83);
		textInfo.setEditable(false);
		textInfo.setFocusable(false);
		textInfo.setText(movieInfo.get(0).getmDescription());
		textInfo.setLineWrap(true);
		textInfo.setWrapStyleWord(true);
		
		JScrollPane scrollInfo = new JScrollPane(textInfo);
		scrollInfo.setBackground(new Color(255, 255, 255));
		scrollInfo.setViewportView(textInfo);
		lblAddedWatch.setVisible(false);
		lblAddedWatch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAddedWatch.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\WatchlistAdded_20x26.png"));
		
		lblAddedWatch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblAddedWatch.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\WatchlistAddedA_20x26.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblAddedWatch.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\WatchlistAdded_20x26.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				String query = "DELETE FROM WatchList WHERE fkUserId = " + MainForm.getLoggedUserId() + " AND fkMovieId = '" + movieId + "'";
				SqlOperations.delete(query);
				lblAddedWatch.setVisible(false);
				lblAddWatch.setVisible(true);
			}
		});
		
		if(isAdded == 0){
			lblAddWatch.setVisible(true);
			lblAddedWatch.setVisible(false);
		}
		if(isAdded == 1){
			lblAddWatch.setVisible(false);
			lblAddedWatch.setVisible(true);
		}
		
		JLabel lblImage = new JLabel("");
		lblImage.setBounds(0,0,96,142);
		lblImage.setIcon(SqlOperations.getMovieImage(movieId, lblImage));
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(8)
							.addComponent(lblAddWatch))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(8)
							.addComponent(lblAddedWatch))
						.addComponent(lblImage))
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(panelName, GroupLayout.PREFERRED_SIZE, 374, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelUnderName, GroupLayout.PREFERRED_SIZE, 374, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblStary)
							.addGap(6)
							.addComponent(lblRatingPoint, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addGap(3)
							.addComponent(lblStarb)
							.addGap(5)
							.addComponent(lblYourratingpoint, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollInfo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAddWatch)
						.addComponent(lblAddedWatch)
						.addComponent(lblImage)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(panelName, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
							.addGap(3)
							.addComponent(panelUnderName, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(1)
									.addComponent(lblStary))
								.addComponent(lblRatingPoint)
								.addComponent(lblStarb)
								.addComponent(lblYourratingpoint))
							.addGap(9)
							.addComponent(scrollInfo, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))))
		);
		panel.setLayout(gl_panel);
		panelReal.add(panel);
	}
}
