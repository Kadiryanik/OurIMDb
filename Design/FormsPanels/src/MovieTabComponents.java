import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;

public class MovieTabComponents {
	public static int Id = 0;
	private int movieId;
	
	MovieTabComponents(int mId, JPanel panelReal){
		Id++;
		movieId = mId;
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 540, 400);
		
		JPanel panelName = new JPanel();
		JTextArea textInfo = new JTextArea();
		JTextArea textBuzz = new JTextArea();
		JPanel panelDirector = new JPanel();
		JPanel panelStars = new JPanel();
		JPanel panelGenres = new JPanel();
		
		if(Id % 2 == 0){
			panel.setBackground(new Color(230, 230, 230));
			panelName.setBackground(new Color(230, 230, 230));
			textInfo.setBackground(new Color(230, 230, 230));
			textBuzz.setBackground(new Color(230, 230, 230));
			panelDirector.setBackground(new Color(230, 230, 230));
			panelStars.setBackground(new Color(230, 230, 230));
			panelGenres.setBackground(new Color(230, 230, 230));
		}
		else{
			panel.setBackground(new Color(245, 245, 245));
			panelName.setBackground(new Color(245, 245, 245));
			textInfo.setBackground(new Color(245, 245, 245));
			textBuzz.setBackground(new Color(245, 245, 245));
			panelDirector.setBackground(new Color(245, 245, 245));
			panelStars.setBackground(new Color(245, 245, 245));
			panelGenres.setBackground(new Color(245, 245, 245));
		}
		
		/*panelName*/
		panelName.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
		
		JLabel lblImage = new JLabel("");
		lblImage.setIcon(new ImageIcon("C:\\Users\\SadneS\\Desktop\\Button Png\\Movies140x209.jpg"));/*TODO: movId den çek*/
		
		JLabel lblMin = new JLabel(128+"min");/*TODO: movId den çek*/
		lblMin.setForeground(new Color(102, 102, 102));
		
		JLabel label = new JLabel("-");
		
		/*panelGenres*/
		panelGenres.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
		
		/*textInfo*/
		textInfo.setFont(new Font("Comic Sans MS", Font.PLAIN, 9));
		textInfo.setBounds(160, 61, 370, 83);
		textInfo.setEditable(false);
		textInfo.setFocusable(false);
		textInfo.setText("bu bir aciklama");/*TODO: movId den çek*/
		textInfo.setLineWrap(true);
		textInfo.setWrapStyleWord(true);
		
		JScrollPane scroll = new JScrollPane(textInfo);
	    scroll.setViewportView(textInfo);
		
		final JLabel lblWatchTrailer = new JLabel("");
		lblWatchTrailer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblWatchTrailer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblWatchTrailer.setIcon(new ImageIcon("C:\\Users\\SadneS\\Desktop\\Button Png\\WatchTrailerButtonA.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblWatchTrailer.setIcon(new ImageIcon("C:\\Users\\SadneS\\Desktop\\Button Png\\WatchTrailerButton.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				//TODO: Yönlendir
			}
		});
		lblWatchTrailer.setIcon(new ImageIcon("C:\\Users\\SadneS\\Desktop\\Button Png\\WatchTrailerButton.png"));
		
		final JLabel lblAddWatchlist = new JLabel("add watchlist");
		lblAddWatchlist.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAddWatchlist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblAddWatchlist.setIcon(new ImageIcon("C:\\Users\\SadneS\\Desktop\\Button Png\\WatchlistButtonA.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblAddWatchlist.setIcon(new ImageIcon("C:\\Users\\SadneS\\Desktop\\Button Png\\WatchlistButton.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				//TODO: Yönlendir
			}
		});
		lblAddWatchlist.setIcon(new ImageIcon("C:\\Users\\SadneS\\Desktop\\Button Png\\WatchlistButton.png"));
		
		JLabel lblDirector = new JLabel("Director  :");
		lblDirector.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDirector.setForeground(new Color(102, 102, 102));
		
		JLabel lblStars = new JLabel("Stars       :");
		lblStars.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStars.setForeground(new Color(102, 102, 102));
		
		/*textBuzz*/
		textBuzz.setFont(new Font("Comic Sans MS", Font.PLAIN, 9));
		textBuzz.setBounds(160, 61, 370, 83);
		textBuzz.setEditable(false);
		textBuzz.setFocusable(false);
		textBuzz.setText("BuAciklama");/*TODO: movId den çek*/
		textBuzz.setLineWrap(true);
		textBuzz.setWrapStyleWord(true);
		
		JScrollPane scrollBuzz = new JScrollPane(textBuzz);
		scrollBuzz.setViewportView(textBuzz);
		
		/*panelDirector*/
		panelDirector.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
		
		/*panelStars*/
		panelStars.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
		
		/*GruopLayout*/
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(scrollBuzz, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addComponent(lblImage)
							.addGap(10)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(panelName, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(1)
									.addComponent(lblStars, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
									.addGap(3)
									.addComponent(panelStars, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblWatchTrailer, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(lblAddWatchlist, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
									.addComponent(lblDirector, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(panelDirector, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(scroll, 0, 0, Short.MAX_VALUE)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblMin, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
									.addGap(5)
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
									.addGap(8)
									.addComponent(panelGenres, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)))))
					.addGap(19))
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
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(4)
									.addComponent(lblDirector))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(2)
									.addComponent(panelDirector, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(7)
									.addComponent(lblStars))
								.addGroup(gl_panel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(panelStars, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)))
							.addGap(21)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblWatchTrailer)
								.addComponent(lblAddWatchlist))))
					.addGap(10)
					.addComponent(scrollBuzz, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		panelReal.add(panel);
	}
	
	

}
