import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;

public class MovieTabComponents {
	public static int Id = 0;
	private String movieId;
	
	MovieTabComponents(String mId, int isAdded, JPanel panelReal){
		Id++;
		movieId = mId;
		
		if(isAdded == 0){
			String movieQuery = "SELECT movieId FROM Movie WHERE movieId = '" + movieId + "' AND movieId IN"
					+ "(SELECT fkMovieId FROM WatchList WHERE fkUserId = " + MainForm.getLoggedUserId() + ")";
			ArrayList<Movie> d = SqlOperations.getMovie(movieQuery);
			if(d.size() > 0){
				isAdded = 1;
			}
		}
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 524, 233);
		
		JPanel panelName = new JPanel();
		JTextArea textInfo = new JTextArea();
		JPanel panelDirector = new JPanel();
		JPanel panelStars = new JPanel();
		JPanel panelGenres = new JPanel();

		if(Id % 2 == 0){
			panel.setBackground(new Color(230, 230, 230));
			panelName.setBackground(new Color(230, 230, 230));
			textInfo.setBackground(new Color(230, 230, 230));
			panelDirector.setBackground(new Color(230, 230, 230));
			panelStars.setBackground(new Color(230, 230, 230));
			panelGenres.setBackground(new Color(230, 230, 230));
		}
		else{
			panel.setBackground(new Color(245, 245, 245));
			panelName.setBackground(new Color(245, 245, 245));
			textInfo.setBackground(new Color(245, 245, 245));
			panelDirector.setBackground(new Color(245, 245, 245));
			panelStars.setBackground(new Color(245, 245, 245));
			panelGenres.setBackground(new Color(245, 245, 245));
		}
		
		panelName.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
		
		String movieQuery = "SELECT mTitle, mImage, mTime, mDescription FROM Movie WHERE movieId = '" + movieId + "'";
		ArrayList<Movie> movieList = SqlOperations.getMovie(movieQuery);
		new LabelWithLinkForMovie(movieList.get(0).getmTitle(), movieId, 12, 50, panelName);
		
		ArrayList<Genre> genreList = SqlOperations.getGenre(movieId);
		for(int i = 0;i < genreList.size(); i++){
			boolean isLast = false;
			if(i == genreList.size() - 1)
				isLast = true;
			
			new LabelWithoutLink(genreList.get(i).getmType(), 102, 102, 102, isLast, panelGenres);
		}
		
		String starsQuery = "SELECT peopleId, pTitle FROM People WHERE peopleId IN"
				+ "(SELECT fkPeopleId FROM MoviePeople WHERE fkMovieId = '" + movieId + "' AND actorFlag = 1) LIMIT 0,3";
		ArrayList<People> starsList = SqlOperations.getPeople(starsQuery);
		for(int i = 0; i < starsList.size(); i++ ){
			boolean isLast = false;
			if(i == starsList.size() - 1)
				isLast = true;
			
			new LabelWithLink(starsList.get(i).getpTitle(), starsList.get(i).getPeopleId(), isLast, panelStars);
		}
		 
		String directorQuery = "SELECT peopleId, pTitle FROM People WHERE peopleId IN"
				+ "(SELECT fkPeopleId FROM MoviePeople WHERE fkMovieId = '" + movieId + "' AND directorFlag = 1) LIMIT 0,1";
		ArrayList<People> directorList = SqlOperations.getPeople(directorQuery);
		for(int i = 0; i < directorList.size(); i++ ){
			boolean isLast = false;
			if(i == directorList.size() - 1)
				isLast = true;
			
			new LabelWithLink(directorList.get(i).getpTitle(), directorList.get(i).getPeopleId(), isLast, panelDirector);
		}
		
		JLabel lblImage = new JLabel("");
		lblImage.setBounds(10, 11, 140, 209);
		lblImage.setIcon(SqlOperations.getMovieImage(movieId, lblImage));
		
		//TODO::
		JLabel lblMin = new JLabel(movieList.get(0).getmTime() + "min");
		lblMin.setForeground(new Color(102, 102, 102));
		
		JLabel label = new JLabel("-");
		
		panelGenres.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
		
		textInfo.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		textInfo.setBounds(160, 61, 370, 83);
		textInfo.setEditable(false);
		textInfo.setFocusable(false);

		textInfo.setText(movieList.get(0).getmDescription());
		textInfo.setLineWrap(true);
		textInfo.setWrapStyleWord(true);
		
		JScrollPane scroll = new JScrollPane(textInfo);
	    scroll.setViewportView(textInfo);
		
		final JLabel lblWatchTrailer = new JLabel("watch trailer");
		lblWatchTrailer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblWatchTrailer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblWatchTrailer.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\WatchTrailerButtonA.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblWatchTrailer.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\WatchTrailerButton.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				MainForm.refPanelTop.setVisible(false);
				MainForm.refPanelHome.setVisible(false);
				MainForm.refPanelMovies.setVisible(false);
				MainForm.refPanelCelebs.setVisible(false);
				MainForm.refPanelTop10.setVisible(false);
				MainForm.refPanelUser.setVisible(false);
				MainForm.refPanelWatchlist.setVisible(false);
				MainForm.refLabelturnHomeD.setVisible(false);
				MainForm.refLabelTurnHome.setVisible(true);
				
				MainForm.refPanelEachOne.setVisible(false);
				MainForm.refPanelEachOne.removeAll();
				int isLogin = -1;
				if(MainForm.getIsLogined()){
					isLogin = 0;
				}
				
				new EachMovie(movieId, MainForm.refPanelEachOne, isLogin);
				MainForm.refPanelEachOne.setVisible(true);
			}
		});
		lblWatchTrailer.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\WatchTrailerButton.png"));
		
		final JLabel lblAddWatchlist = new JLabel("add watchlist");
		final JLabel lblAddedWatchlist = new JLabel("");
		lblAddWatchlist.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAddWatchlist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblAddWatchlist.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\WatchlistButtonA.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblAddWatchlist.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\WatchlistButton.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(MainForm.getIsLogined()){
					String query = "INSERT INTO WatchList(fkUserId, fkMovieId) VALUES(" + MainForm.getLoggedUserId() + ",'" + movieId + "')";
					SqlOperations.insert(query);
					lblAddWatchlist.setVisible(false);
					lblAddedWatchlist.setVisible(true);
				}
				else{
					final JOptionPane pane = new JOptionPane("Please register for adding watchlist!",
							JOptionPane.ERROR_MESSAGE);
					final JDialog jDialog = pane.createDialog(
					        null, 
					        "Upss!");
					jDialog.setLocationRelativeTo(MainForm.refFrmOurmdb);
					jDialog.setVisible(true);
				}
			}
		});
		lblAddWatchlist.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\WatchlistButton.png"));
		

		//lblAddedWatchlist
		lblAddedWatchlist.setVisible(false);
		lblAddedWatchlist.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblAddedWatchlist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblAddedWatchlist.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\AddedWatchlistButtonA.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblAddedWatchlist.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\AddedWatchlistButton.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				String query = "DELETE FROM WatchList WHERE fkUserId = " + MainForm.getLoggedUserId() 
				+ " AND fkMovieId = '" + movieId + "'";
				SqlOperations.delete(query);
				lblAddedWatchlist.setVisible(false);
				lblAddWatchlist.setVisible(true);
			}
		});
		lblAddedWatchlist.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\AddedWatchlistButton.png"));
		
		if(isAdded == 0){
			lblAddWatchlist.setVisible(true);
			lblAddedWatchlist.setVisible(false);
		}
		if(isAdded == 1){
			lblAddWatchlist.setVisible(false);
			lblAddedWatchlist.setVisible(true);
		}
		
		JLabel lblDirector = new JLabel("Director  :");
		lblDirector.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDirector.setForeground(new Color(102, 102, 102));
		
		JLabel lblStars = new JLabel("Stars       :");
		lblStars.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStars.setForeground(new Color(102, 102, 102));
		
		panelDirector.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
		panelStars.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
		
		JLabel lblForGroup = new JLabel("");
		lblForGroup.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\line.png"));
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addComponent(lblImage)
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(panelName, GroupLayout.PREFERRED_SIZE, 353, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblMin, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(panelGenres, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE))
						.addComponent(scroll, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblDirector, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(panelDirector, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(1)
							.addComponent(lblStars, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addGap(3)
							.addComponent(panelStars, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(175)
							.addComponent(lblWatchTrailer, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAddedWatchlist)
								.addComponent(lblAddWatchlist, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)))))
				.addComponent(lblForGroup, GroupLayout.PREFERRED_SIZE, 524, GroupLayout.PREFERRED_SIZE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblImage)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(panelName, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
							.addGap(9)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMin)
								.addComponent(label)
								.addComponent(panelGenres, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
							.addGap(9)
							.addComponent(scroll, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(2)
									.addComponent(lblDirector))
								.addComponent(panelDirector, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
							.addGap(6)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(1)
									.addComponent(lblStars))
								.addComponent(panelStars, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
							.addGap(21)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblWatchTrailer)
								.addComponent(lblAddedWatchlist)
								.addComponent(lblAddWatchlist))))
					.addGap(8)
					.addComponent(lblForGroup, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
		);
		panel.setLayout(gl_panel);
		panelReal.add(panel);
	}

}
