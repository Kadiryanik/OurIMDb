import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class WatchListPage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WatchListPage window = new WatchListPage();
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
	public WatchListPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 501, 653);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		final JPanel WatchScroll = new JPanel();

		JScrollPane scrollPaneWatch = new JScrollPane();
		scrollPaneWatch.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		frame.getContentPane().add(scrollPaneWatch);
		scrollPaneWatch.setBounds(0, 0, 550, 675);	
		
		scrollPaneWatch.add(WatchScroll);
		scrollPaneWatch.setViewportView(WatchScroll);
		WatchScroll.setLayout(new WrapLayout(FlowLayout.CENTER, 0, 1));
		
		final JPanel WatchScrollTop = new JPanel();
		WatchScroll.add(WatchScrollTop);
		
		
		
		JLabel lblYourwatchlist = new JLabel("YourWatchlist");
		lblYourwatchlist.setForeground(new Color(66, 66, 66));
		lblYourwatchlist.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		
		JLabel lblWithname = new JLabel("Name");
		lblWithname.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		
		JLabel lblSortBy = new JLabel("Sort by:");
		lblSortBy.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		
		JLabel lblRating = new JLabel("Rating");
		lblRating.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		
		JLabel lblYourRating = new JLabel("Your Rating");
		lblYourRating.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		
		JLabel lblForSize = new JLabel("");
		GroupLayout gl_WatchScrollTop = new GroupLayout(WatchScrollTop);
		gl_WatchScrollTop.setHorizontalGroup(
			gl_WatchScrollTop.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_WatchScrollTop.createSequentialGroup()
					.addGap(549)
					.addComponent(lblForSize, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_WatchScrollTop.createSequentialGroup()
					.addGap(10)
					.addComponent(lblYourwatchlist, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_WatchScrollTop.createSequentialGroup()
					.addGap(10)
					.addComponent(lblSortBy, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(lblWithname, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(lblRating, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(lblYourRating))
		);
		gl_WatchScrollTop.setVerticalGroup(
			gl_WatchScrollTop.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_WatchScrollTop.createSequentialGroup()
					.addComponent(lblForSize, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(lblYourwatchlist, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addGroup(gl_WatchScrollTop.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSortBy, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblWithname, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRating, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblYourRating, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)))
		);
		WatchScrollTop.setLayout(gl_WatchScrollTop);
		
		
		
		final JPanel WatchScrollContent = new JPanel();
		WatchScrollContent.setMinimumSize(new Dimension(550,0));
		WatchScroll.add(WatchScrollContent);
		WatchScrollContent.setLayout(new WrapLayout(FlowLayout.CENTER, 5, 1));
		
		JPanel panel = new JPanel();
		WatchScrollContent.add(panel);
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 450, 164);
		
		final JLabel lblAddWatch = new JLabel("");
		final JLabel lblAddedWatch = new JLabel("");
		lblAddedWatch.setVisible(false);
		lblAddedWatch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAddedWatch.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\WatchlistAdded_20x26.png"));
		
		JPanel panelName = new JPanel();
		panelName.setBackground(new Color(255, 255, 255));
		panelName.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JPanel panelUnderName = new JPanel();
		panelUnderName.setBackground(new Color(255, 255, 255));
		panelUnderName.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		lblAddWatch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//TODO: Kullanýcý izlenicek listesine ekle
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
				//TODO: kullanýcý listesinden çýkar
				lblAddedWatch.setVisible(false);
				lblAddWatch.setVisible(true);
			}
		});
		
		JLabel lblImage = new JLabel("");
		lblImage.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\TheShawshankRedemption.jpg"));
		
		JLabel lblYourratingpoint = new JLabel("9");
		lblYourratingpoint.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		
		JLabel lblStarb = new JLabel("");
		lblStarb.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\StarBlueXXsmal.png"));
		
		JLabel lblRatingPoint = new JLabel("8,3");
		lblRatingPoint.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		
		JLabel lblStary = new JLabel("");
		lblStary.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\StarYellowXXsmal.png"));
		
		JTextArea textInfo = new JTextArea();
		textInfo.setFont(new Font("Comic Sans MS", Font.PLAIN, 9));
		textInfo.setBackground(new Color(255, 255, 255));
		textInfo.setBounds(160, 61, 370, 83);
		textInfo.setEditable(false);
		textInfo.setFocusable(false);
		textInfo.setText("BuAciklama");
		textInfo.setLineWrap(true);
		textInfo.setWrapStyleWord(true);
		
		JScrollPane scrollInfo = new JScrollPane(textInfo);
		scrollInfo.setBackground(new Color(255, 255, 255));
		scrollInfo.setViewportView(textInfo);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(8)
							.addComponent(lblAddWatch))
						.addComponent(lblImage, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(8)
							.addComponent(lblAddedWatch)))
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panelName, GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
						.addComponent(panelUnderName, GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblStary)
							.addGap(6)
							.addComponent(lblRatingPoint, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addGap(3)
							.addComponent(lblStarb)
							.addGap(5)
							.addComponent(lblYourratingpoint, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollInfo, 0, 0, Short.MAX_VALUE))
					.addGap(48))
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
		
		
	}
}
