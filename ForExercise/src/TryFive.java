import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.FlowLayout;

public class TryFive {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TryFive window = new TryFive();
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
	public TryFive() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 630, 779);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 500, 696);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblIcon = new JLabel("Icon");
		lblIcon.setBounds(10, 11, 55, 65);
		panel.add(lblIcon);
		
		JLabel lblName = new JLabel("name");
		lblName.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblName.setBounds(75, 11, 200, 25);
		panel.add(lblName);
		
		JLabel lblInfo = new JLabel("IMDb member since December 2016");
		lblInfo.setFont(new Font("Comic Sans MS", Font.PLAIN, 9));
		lblInfo.setBounds(75, 36, 200, 14);
		panel.add(lblInfo);
		
		JLabel lblLine = new JLabel("");
		lblLine.setIcon(new ImageIcon("C:\\Users\\SadneS\\Desktop\\Button Png\\line.png"));
		lblLine.setBounds(0, 80, 500, 2);
		panel.add(lblLine);
		
		JPanel panelYourRatings = new JPanel();
		panelYourRatings.setBackground(Color.WHITE);
		panelYourRatings.setBounds(0, 86, 500, 312);
		panel.add(panelYourRatings);
		panelYourRatings.setLayout(null);
		
		JLabel lblYourRatings = new JLabel("Your Ratings");
		lblYourRatings.setForeground(new Color(165, 133, 0));
		lblYourRatings.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblYourRatings.setBounds(10, 11, 134, 21);
		panelYourRatings.add(lblYourRatings);
		
		JLabel lblMostRecentlyRated = new JLabel("Most Recently Rated");
		lblMostRecentlyRated.setForeground(new Color(102, 102, 102));
		lblMostRecentlyRated.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblMostRecentlyRated.setBounds(10, 30, 226, 21);
		panelYourRatings.add(lblMostRecentlyRated);
		
		JPanel panelContentMost = new JPanel();
		panelContentMost.setBackground(new Color(255, 255, 255));
		panelContentMost.setBounds(10, 72, 480, 230);
		panelYourRatings.add(panelContentMost);
		panelContentMost.setLayout(new WrapLayout(FlowLayout.LEFT, 8, 5));
		
		MostRatedComponent temp = new MostRatedComponent(12, panelContentMost);
		temp = new MostRatedComponent(12, panelContentMost);
		temp = new MostRatedComponent(12, panelContentMost);
		temp = new MostRatedComponent(12, panelContentMost);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setBackground(Color.WHITE);
		lblBackground.setIcon(new ImageIcon("C:\\Users\\SadneS\\Desktop\\Button Png\\UserPagePanelBackground.png"));
		lblBackground.setBounds(0, 62, 500, 250);
		panelYourRatings.add(lblBackground);
		
		JLabel lblLine2 = new JLabel("");
		lblLine2.setIcon(new ImageIcon("C:\\Users\\SadneS\\Desktop\\Button Png\\line.png"));
		lblLine2.setBounds(0, 400, 500, 2);
		panel.add(lblLine2);
		
		JPanel panelYourWatchlist = new JPanel();
		panelYourWatchlist.setLayout(null);
		panelYourWatchlist.setBackground(Color.WHITE);
		panelYourWatchlist.setBounds(0, 409, 500, 287);
		panel.add(panelYourWatchlist);
		
		JLabel lblYourWatchlist = new JLabel("Your Watchlist");
		lblYourWatchlist.setForeground(new Color(165, 133, 0));
		lblYourWatchlist.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblYourWatchlist.setBounds(10, 11, 134, 21);
		panelYourWatchlist.add(lblYourWatchlist);
		
		JPanel panelContentWatch = new JPanel();
		panelContentWatch.setBackground(new Color( 255, 255, 255));
		panelContentWatch.setBounds(10, 47, 480, 230);
		panelYourWatchlist.add(panelContentWatch);
		
		temp = new MostRatedComponent(12, panelContentWatch);
		temp = new MostRatedComponent(12, panelContentWatch);
		temp = new MostRatedComponent(12, panelContentWatch);
		
		JLabel lblBackground2 = new JLabel("");
		lblBackground2.setIcon(new ImageIcon("C:\\Users\\SadneS\\Desktop\\Button Png\\UserPagePanelBackground.png"));
		lblBackground2.setBackground(Color.WHITE);
		lblBackground2.setBounds(0, 37, 500, 250);
		panelYourWatchlist.add(lblBackground2);
	}
}
