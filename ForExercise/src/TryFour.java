import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.TextArea;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.util.Map;
import java.awt.Cursor;

public class TryFour {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TryFour window = new TryFour();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TryFour() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 699, 871);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(0, 0, 540, 400);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblImage = new JLabel("");
		lblImage.setIcon(new ImageIcon("C:\\Users\\SadneS\\Desktop\\Button Png\\Movies140x209.jpg"));
		lblImage.setBackground(UIManager.getColor("menu"));
		lblImage.setBounds(10, 11, 140, 209);
		panel.add(lblImage);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(new Color(19, 152, 216));
		lblName.setBackground(Color.LIGHT_GRAY);
		lblName.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblName.setBounds(160, 11, 300, 14);
		panel.add(lblName);
		
		JLabel lblMin = new JLabel("128 min");
		lblMin.setForeground(new Color(102, 102, 102));
		lblMin.setBounds(160, 36, 49, 14);
		panel.add(lblMin);
		
		JLabel label = new JLabel("-");
		label.setBounds(214, 36, 12, 14);
		panel.add(label);
		
		JPanel panelGenres = new JPanel();
		panelGenres.setBounds(234, 36, 296, 14);
		panel.add(panelGenres);
		panelGenres.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JTextArea textInfo = new JTextArea();
		textInfo.setFont(new Font("Comic Sans MS", Font.PLAIN, 9));
		textInfo.setBackground(new Color(231, 231, 231));
		textInfo.setBounds(160, 61, 370, 83);
		textInfo.setEditable(false);
		textInfo.setFocusable(false);
		textInfo.setText("bu bir a\u00E7\u0131klama");
		textInfo.setLineWrap(true);
		textInfo.setWrapStyleWord(true);
		
		JScrollPane scroll = new JScrollPane(textInfo);
		scroll.setLocation(160, 61);
		scroll.setSize(370, 83);
	    scroll.setViewportView(textInfo);
		panel.add(scroll);
		
		final JLabel lblWatchTrailer = new JLabel("watch trailer");
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
		lblWatchTrailer.setBounds(160, 200, 75, 18);
		panel.add(lblWatchTrailer);
		
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
		lblAddWatchlist.setBounds(245, 200, 93, 18);
		panel.add(lblAddWatchlist);
		
		JLabel lblDirector = new JLabel("Director  :");
		lblDirector.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDirector.setForeground(new Color(102, 102, 102));
		lblDirector.setBounds(160, 148, 58, 14);
		panel.add(lblDirector);
		
		JLabel lblStars = new JLabel("Stars       :");
		lblStars.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStars.setForeground(new Color(102, 102, 102));
		lblStars.setBounds(161, 164, 58, 14);
		panel.add(lblStars);
		
		JTextArea textBuzz = new JTextArea();
		textBuzz.setFont(new Font("Comic Sans MS", Font.PLAIN, 9));
		textBuzz.setBackground(new Color(231, 231, 231));
		textBuzz.setBounds(160, 61, 370, 83);
		textBuzz.setEditable(false);
		textBuzz.setFocusable(false);
		textBuzz.setText("BuAciklama");
		textBuzz.setLineWrap(true);
		textBuzz.setWrapStyleWord(true);
		
		JScrollPane scrollBuzz = new JScrollPane(textBuzz);
		scrollBuzz.setLocation(10, 230);
		scrollBuzz.setSize(520, 159);
		scrollBuzz.setViewportView(textBuzz);
		panel.add(scrollBuzz);
		
		final JLabel lblDirectorLink = new JLabel("Director link");
		lblDirectorLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblDirectorLink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Font font = lblDirectorLink.getFont();
				Map attributes = font.getAttributes();
				attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
				lblDirectorLink.setFont(font.deriveFont(attributes));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblDirectorLink.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				//TODO: Goto eachCelebs for director
			}
		});
		lblDirectorLink.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblDirectorLink.setForeground(new Color(74, 134, 232));
		lblDirectorLink.setBounds(222, 147, 123, 14);
		panel.add(lblDirectorLink);
		
		JLabel lblStarLinks = new JLabel("Stars");
		lblStarLinks.setForeground(new Color(74, 134, 232));
		lblStarLinks.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblStarLinks.setBounds(222, 164, 116, 14);
		panel.add(lblStarLinks);
		
	}
}
