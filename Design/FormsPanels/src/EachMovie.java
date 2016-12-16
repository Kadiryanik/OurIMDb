import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

public class EachMovie {
	
	EachMovie(int movieId, final JPanel panelReal){
		/*Getting informations from database*/
		String starsQuery = "SELECT peopleId,pTitle,pFirstName FROM People WHERE peopleId IN"
				+ "(SELECT fkPeopleId FROM MoviePeople WHERE fkMovieId = " + movieId + " AND actorFlag = 'Y') LIMIT 0,3";
		
		String directorsQuery = "SELECT pTitle FROM People WHERE peopleId IN"
				+ "(SELECT fkPeopleId FROM MoviePeople WHERE fkMovieId = " + movieId + " AND directorFlag = 'Y') LIMIT 0,3";
		
		String writersQuery = "SELECT pTitle FROM People WHERE peopleId IN"
				+ "(SELECT fkPeopleId FROM MoviePeople WHERE fkMovieId = " + movieId + " AND writerFlag = 'Y') LIMIT 0,3";
		
		ArrayList<Movie> movieList = SqlOperations.getMovie("SELECT * FROM Movie WHERE movieId = " + movieId);
		ArrayList<People> starsList = SqlOperations.getPeople(starsQuery);
		ArrayList<People> directorsList = SqlOperations.getPeople(directorsQuery);
		ArrayList<People> writersList = SqlOperations.getPeople(writersQuery);
		ArrayList<Genre> genreList = SqlOperations.getGenre(movieId);
		
		final JLabel lblAddedWatch = new JLabel("");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 550, 1108);
		panel.setLayout(null);
		
		JPanel panelInfo = new JPanel();
		panelInfo.setBackground(new Color(231, 231, 231));
		panelInfo.setBounds(0, 324, 550, 170);
		panel.add(panelInfo);
		
		JTextArea textInfo = new JTextArea();
		textInfo.setFont(new Font("Comic Sans MS", Font.PLAIN, 9));
		textInfo.setBackground(new Color(231, 231, 231));
		textInfo.setEditable(false);
		textInfo.setFocusable(false);
		textInfo.setText(movieList.get(0).getmDescription());//movie description
		textInfo.setLineWrap(true);
		textInfo.setWrapStyleWord(true);
		
		JLabel lblDirector = new JLabel("Director  :");
		lblDirector.setForeground(new Color(51, 51, 51));
		lblDirector.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblWriters = new JLabel("Writers   :");
		lblWriters.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblWriters.setForeground(new Color(51, 51, 51));
		
		JLabel lblStars = new JLabel("Stars       :");
		lblStars.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStars.setForeground(new Color(51, 51, 51));
		
		
		JPanel panelDirectorLinks = new JPanel();
		panelDirectorLinks.setPreferredSize(new Dimension(10, 14));
		panelDirectorLinks.setBackground(new Color(231, 231, 231));
		panelDirectorLinks.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		panelDirectorLinks.setForeground(new Color(19, 148, 209));
		panelDirectorLinks.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
		
		/*adding directors with link on panelDirektorLinks's panel*/
		for(int i = 0; i < directorsList.size(); i++){
			boolean isLast = false;
			if(i == directorsList.size() - 1) isLast = true;
			new LabelWithLink(directorsList.get(i).getpTitle(), directorsList.get(i).getPeopleId(), isLast, panelDirectorLinks);
		}
		
		JPanel panelWriterLinks = new JPanel();
		panelWriterLinks.setPreferredSize(new Dimension(10, 14));
		panelWriterLinks.setBackground(new Color(231, 231, 231));
		panelWriterLinks.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		panelWriterLinks.setForeground(new Color(19, 148, 209));
		panelWriterLinks.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
		
		/*adding writers with link on panelWritersLinks's panel*/
		for(int i = 0; i < writersList.size(); i++){
			boolean isLast = false;
			if(i == writersList.size() - 1) isLast = true;
			new LabelWithLink(writersList.get(i).getpTitle(), writersList.get(i).getPeopleId(), isLast, panelWriterLinks);
		}
		
		JPanel panelStarLinks = new JPanel();
		panelStarLinks.setPreferredSize(new Dimension(10, 14));
		panelStarLinks.setBackground(new Color(231, 231, 231));
		panelStarLinks.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		panelStarLinks.setForeground(new Color(19, 148, 209));
		panelStarLinks.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
		
		/*adding actors with link on panelStarLinks's panel*/
		for(int i = 0; i < starsList.size(); i++){
			boolean isLast = false;
			if(i == starsList.size() - 1) isLast = true;
			new LabelWithLink(starsList.get(i).getpTitle(), starsList.get(i).getPeopleId(), isLast, panelStarLinks);
		}
		
		JSeparator seperator = new JSeparator(SwingConstants.VERTICAL);
		seperator.setForeground(new Color(51, 51, 51));
		seperator.setPreferredSize(new Dimension(2, 10));
		
		final JLabel lblSeeFullCast = new JLabel("See full cast & crew >>");
		lblSeeFullCast.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblSeeFullCast.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Font font = lblSeeFullCast.getFont();
				Map attributes = font.getAttributes();
				attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
				lblSeeFullCast.setFont(font.deriveFont(attributes));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblSeeFullCast.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				panelReal.setVisible(false);
				panelReal.removeAll();
				new FullCastClass(1, panelReal);
				panelReal.setVisible(true);
			}
		});
		
		lblSeeFullCast.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblSeeFullCast.setForeground(new Color(19, 148, 209));
		GroupLayout gl_panelInfo = new GroupLayout(panelInfo);
		gl_panelInfo.setHorizontalGroup(
			gl_panelInfo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelInfo.createSequentialGroup()
					.addGroup(gl_panelInfo.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelInfo.createSequentialGroup()
							.addGap(10)
							.addComponent(lblStars, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(panelStarLinks, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblSeeFullCast, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelInfo.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(gl_panelInfo.createSequentialGroup()
								.addGap(10)
								.addComponent(lblWriters, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
								.addGap(10)
								.addComponent(panelWriterLinks, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGroup(gl_panelInfo.createSequentialGroup()
								.addGap(10)
								.addComponent(lblDirector, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
								.addGap(10)
								.addComponent(panelDirectorLinks, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addComponent(textInfo, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 528, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(10, Short.MAX_VALUE))
		);
		gl_panelInfo.setVerticalGroup(
			gl_panelInfo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelInfo.createSequentialGroup()
					.addGap(5)
					.addComponent(textInfo, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panelInfo.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelInfo.createSequentialGroup()
							.addGap(11)
							.addComponent(lblDirector))
						.addGroup(gl_panelInfo.createSequentialGroup()
							.addGap(10)
							.addComponent(panelDirectorLinks, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_panelInfo.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelInfo.createSequentialGroup()
							.addGap(8)
							.addComponent(lblWriters))
						.addGroup(gl_panelInfo.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelWriterLinks, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelInfo.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelInfo.createSequentialGroup()
							.addGap(2)
							.addComponent(lblStars))
						.addComponent(panelStarLinks, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelInfo.createSequentialGroup()
							.addGap(1)
							.addComponent(lblSeeFullCast, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))))
		);
		panelInfo.setLayout(gl_panelInfo);
		
		JPanel panelTop = new JPanel();
		panelTop.setBackground(new Color(51, 51, 51));
		panelTop.setBounds(0, 0, 550, 323);
		panel.add(panelTop);
		panelTop.setLayout(null);
		
		final JPanel panelRate = new JPanel();
		panelRate.setVisible(false);
		panelRate.setBounds(193, 22, 251, 42);
		panelTop.add(panelRate);
		panelRate.setLayout(null);
		
		final JLabel lblBackground = new JLabel("");
		
		JLabel lblExit = new JLabel("");
		lblExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblBackground.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\Rate_Exit.png"));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblBackground.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\Rate_0.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				panelRate.setVisible(false);
			}
		});
		lblExit.setBounds(12, 12, 15, 15);
		panelRate.add(lblExit);
		
		JLabel lblR1 = new JLabel("");
		lblR1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblR1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblBackground.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\Rate_1.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblBackground.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\Rate_0.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				//TODO: yýldýz oyla panelRate Visiblety false
			}
		});
		lblR1.setBounds(42, 14, 17, 15);
		panelRate.add(lblR1);
		
		JLabel lblR2 = new JLabel("");
		lblR2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblBackground.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\Rate_2.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblBackground.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\Rate_0.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				//TODO: yýldýz oyla panelRate Visiblety false
			}
		});
		lblR2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblR2.setBounds(62, 14, 17, 15);
		panelRate.add(lblR2);
		
		JLabel lblR3 = new JLabel("");
		lblR3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblBackground.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\Rate_3.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblBackground.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\Rate_0.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				//TODO: yýldýz oyla panelRate Visiblety false
			}
		});
		lblR3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblR3.setBounds(82, 14, 17, 15);
		panelRate.add(lblR3);
		
		JLabel lblR4 = new JLabel("");
		lblR4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblBackground.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\Rate_4.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblBackground.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\Rate_0.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				//TODO: yýldýz oyla panelRate Visiblety false
			}
		});
		lblR4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblR4.setBounds(102, 14, 17, 15);
		panelRate.add(lblR4);
		
		JLabel lblR5 = new JLabel("");
		lblR5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblBackground.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\Rate_5.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblBackground.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\Rate_0.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				//TODO: yýldýz oyla panelRate Visiblety false
			}
		});
		lblR5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblR5.setBounds(122, 14, 17, 15);
		panelRate.add(lblR5);
		
		JLabel lblR6 = new JLabel("");
		lblR6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblBackground.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\Rate_6.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblBackground.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\Rate_0.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				//TODO: yýldýz oyla panelRate Visiblety false
			}
		});
		lblR6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblR6.setBounds(142, 14, 17, 15);
		panelRate.add(lblR6);
		
		JLabel lblR7 = new JLabel("");
		lblR7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblBackground.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\Rate_7.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblBackground.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\Rate_0.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				//TODO: yýldýz oyla panelRate Visiblety false
			}
		});
		lblR7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblR7.setBounds(162, 14, 17, 15);
		panelRate.add(lblR7);
		
		JLabel lblR8 = new JLabel("");
		lblR8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblBackground.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\Rate_8.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblBackground.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\Rate_0.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				//TODO: yýldýz oyla panelRate Visiblety false
			}
		});
		lblR8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblR8.setBounds(182, 14, 17, 15);
		panelRate.add(lblR8);
		
		JLabel lblR9 = new JLabel("");
		lblR9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblBackground.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\Rate_9.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblBackground.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\Rate_0.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				//TODO: yýldýz oyla panelRate Visiblety false
			}
		});
		lblR9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblR9.setBounds(202, 14, 17, 15);
		panelRate.add(lblR9);
		
		JLabel lblR10 = new JLabel("");
		lblR10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblBackground.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\Rate_10.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblBackground.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\Rate_0.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				//TODO: yýldýz oyla panelRate Visiblety false
			}
		});
		lblR10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblR10.setBounds(222, 14, 16, 15);
		panelRate.add(lblR10);
		
		lblBackground.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\Rate_0.png"));
		lblBackground.setBounds(0, 0, 251, 42);
		panelRate.add(lblBackground);
		
		JLabel labelImage = new JLabel("");
		labelImage.setBounds(0, 97, 153, 226);
		/*adding movie image on labelImage*/
		labelImage.setIcon(SqlOperations.getMovieImage(movieId, labelImage));
		labelImage.setForeground(new Color(0, 0, 0));
		labelImage.setBackground(Color.CYAN);
		
		panelTop.add(labelImage);
		
		JPanel panelYoutube = new JPanel();
		panelYoutube.setBounds(163, 97, 365, 226);
		panelTop.add(panelYoutube);
		panelYoutube.setLayout(new BorderLayout(0, 0));
		
		JWebBrowser wb = new JWebBrowser();
		panelYoutube.add(wb);
		wb.setBarsVisible(false);
		/*getting youtube link for trailer*/
		wb.navigate(movieList.get(0).getmUrlLink());
		
		final JLabel lblAddWatch = new JLabel("");
		lblAddWatch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//TODO: Kullanýcý izlenicek listesine ekle
				lblAddWatch.setVisible(false);
				lblAddedWatch.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblAddWatch.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\watch_39x49a.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblAddWatch.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\watch_39x49.png"));
			}
		});
		lblAddWatch.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\watch_39x49.png"));
		lblAddWatch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAddWatch.setBounds(27, 22, 39, 49);
		panelTop.add(lblAddWatch);
		
		/*movie title*/
		JLabel lblName = new JLabel(movieList.get(0).getmTitle());
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblName.setBounds(76, 22, 306, 28);
		panelTop.add(lblName);
		
		JPanel panelDesc = new JPanel();
		panelDesc.setBackground(new Color(51, 51, 51));
		panelDesc.setBounds(76, 52, 278, 28);
		panelTop.add(panelDesc);
		panelDesc.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		/*setting panelDesc min, genre, year*/
		new LabelWithoutLink(movieList.get(0).getmTime() + "min", 102, 102, 102, false, panelDesc);
		String genres = new String();
		for(int i = 0; i < genreList.size(); i++){
			genres = genres + genreList.get(i).getmType();
			if(i != genreList.size() - 1){
				genres = genres + ",";
			}
		}
		new LabelWithoutLink(genres, 102, 102, 102, false, panelDesc);
		new LabelWithoutLink("" + movieList.get(0).getmYear(), 102, 102, 102, true, panelDesc);
		
		JLabel lblStar = new JLabel("");
		lblStar.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\StarYellow.png"));
		lblStar.setBounds(370, 30, 28, 25);
		panelTop.add(lblStar);
	
		/*movie rating*/
		JLabel lblPoint = new JLabel("" + movieList.get(0).getmRating());
		lblPoint.setForeground(Color.WHITE);
		lblPoint.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblPoint.setBounds(404, 30, 33, 19);
		panelTop.add(lblPoint);
		
		/*movie rating count*/
		JLabel lblPointcount = new JLabel("" + movieList.get(0).getmRatingCount());
		lblPointcount.setForeground(new Color(192, 192, 192));
		lblPointcount.setBackground(new Color(245, 245, 245));
		lblPointcount.setFont(new Font("Comic Sans MS", Font.PLAIN, 9));
		lblPointcount.setBounds(404, 46, 39, 14);
		panelTop.add(lblPointcount);
		
		//TODO:
		//Bi panel daha olucak oy kullanýlmýþsa o gösterilicek
		//bu panele basýlýrsa yanda 10 yýldýzlý oy kullanma açýlýcak imdb de mevcut
		final JPanel panelHover = new JPanel();
		panelHover.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelHover.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelHover.setBackground(new Color(19, 108, 178));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelHover.setBackground(new Color(51, 51, 51));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(panelRate.isVisible()){ panelRate.setVisible(false); }
				else{panelRate.setVisible(true);}
			}
		});
		panelHover.setBackground(new Color(51, 51, 51));
		panelHover.setBounds(447, 24, 81, 38);
		panelTop.add(panelHover);
		panelHover.setLayout(null);
		
		JLabel lblStarRight = new JLabel("");
		lblStarRight.setBounds(0, 0, 37, 38);
		panelHover.add(lblStarRight);
		lblStarRight.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\Star.png"));
		
		JLabel lblRate = new JLabel("Rate");
		lblRate.setBounds(42, 7, 26, 14);
		panelHover.add(lblRate);
		lblRate.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		lblRate.setForeground(new Color(255, 255, 255));
		
		JLabel lblThis = new JLabel("This");
		lblThis.setBounds(45, 17, 24, 14);
		panelHover.add(lblThis);
		lblThis.setForeground(new Color(255, 255, 255));
		lblThis.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		
		JLabel lblLinevertical = new JLabel("");
		lblLinevertical.setBounds(446, 24, 3, 38);
		panelTop.add(lblLinevertical);
		lblLinevertical.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\LineVertical.png"));
		
		/*lblAddedWatch*/
		lblAddedWatch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAddedWatch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblAddedWatch.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\WatchlistAddedA.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblAddedWatch.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\WatchlistAdded.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				//TODO: kullanýcý listesinden çýkar
				lblAddedWatch.setVisible(false);
				lblAddWatch.setVisible(true);
			}
		});
		lblAddedWatch.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\WatchlistAdded.png"));
		lblAddedWatch.setBounds(28, 21, 39, 49);
		panelTop.add(lblAddedWatch);
		
		JPanel panelAward = new JPanel();
		panelAward.setBackground(new Color(239, 227, 165));
		panelAward.setBounds(0, 495, 550, 22);
		panelAward.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 2));
		panel.add(panelAward);
		
		//TODO: Bu labelden önce win notification labeli oluþturup eklencek
		final JLabel labelSeeFullAward = new JLabel("See more award >>");
		labelSeeFullAward.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labelSeeFullAward.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Font font = labelSeeFullAward.getFont();
				Map attributes = font.getAttributes();
				attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
				labelSeeFullAward.setFont(font.deriveFont(attributes));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				labelSeeFullAward.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				//TODO: Full award page
			}
		});
		labelSeeFullAward.setForeground(new Color(19, 148, 209));
		labelSeeFullAward.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		panelAward.add(labelSeeFullAward);
		
		JPanel panelCast = new JPanel();
		panelCast.setBounds(0, 518, 550, 590);
		panel.add(panelCast);
		panelCast.setBackground(new Color(231, 231, 231));
		panelCast.setLayout(new WrapLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panelCastTop = new JPanel();
		panelCast.add(panelCastTop);
		panelCastTop.setBackground(new Color(231, 231, 231));
		
		JLabel lblCast = new JLabel("Cast");
		lblCast.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		
		JLabel lblDescr = new JLabel("Cast overview, first billed only:");
		lblDescr.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		
		JLabel lblFordontwrap = new JLabel("");
		GroupLayout gl_panelCastTop = new GroupLayout(panelCastTop);
		gl_panelCastTop.setHorizontalGroup(
			gl_panelCastTop.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCastTop.createSequentialGroup()
					.addComponent(lblCast, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 412, Short.MAX_VALUE)
					.addComponent(lblFordontwrap))
				.addComponent(lblDescr, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
		);
		gl_panelCastTop.setVerticalGroup(
			gl_panelCastTop.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCastTop.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_panelCastTop.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblFordontwrap)
						.addComponent(lblCast, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(16)
					.addComponent(lblDescr, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
		);
		panelCastTop.setLayout(gl_panelCastTop);
		
		/*creating cast component */ 
		for(int i = 0; i < starsList.size(); i++){
			
			new CastComponentForEachMovie(starsList.get(i).getPeopleId(), starsList.get(i).getpTitle(),
					starsList.get(i).getpFirstName(), panelCast);
		}
	
		/*lblSeeFullCast button for panelCast*/
		final JLabel lblSeeFullCastForPanelCast = new JLabel("See full cast & crew >>");
		lblSeeFullCastForPanelCast.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblSeeFullCastForPanelCast.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Font font = lblSeeFullCastForPanelCast.getFont();
				Map attributes = font.getAttributes();
				attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
				lblSeeFullCastForPanelCast.setFont(font.deriveFont(attributes));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblSeeFullCastForPanelCast.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				panelReal.setVisible(false);
				panelReal.removeAll();
				new FullCastClass(1, panelReal);
				panelReal.setVisible(true);
			}
		});
		lblSeeFullCastForPanelCast.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblSeeFullCastForPanelCast.setForeground(new Color(19, 148, 209));
		lblSeeFullCastForPanelCast.setBounds(414, 140, 126, 14);
		/*EdnOf - lblSeeFullCast button for panelCast*/
		
		panelCast.add(lblSeeFullCastForPanelCast);
		
		panel.setPreferredSize(new Dimension(550, 1108));
		
		JScrollPane scrollPaneEachOne = new JScrollPane();
		scrollPaneEachOne.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneEachOne.setBounds(0, 0, 550, 726);
		
		scrollPaneEachOne.add(panel);
		scrollPaneEachOne.setViewportView(panel);
		
		panelReal.add(scrollPaneEachOne);
		//panelReal.add(panel);
	}
}
