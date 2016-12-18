import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.util.Map;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import net.miginfocom.swing.MigLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

public class TryOne {

	private JFrame frame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TryOne window = new TryOne();
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
	public TryOne() {
		initialize();
	}
	
	public Top10Component CreateObj(int m, String n, double r, JPanel panelReal){
		Top10Component temp = new Top10Component(m, n, r, panelReal);
		return temp;
	};
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 819, 495);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		int Id = 1;
		String n = "kadir";
		final String name = "kadir";
		int r = 5;
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 600, 280);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 440, 60);
		
		JLabel lblImage = new JLabel("");
		lblImage.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\icon32.png"));
		
		JLabel label = new JLabel(Id + ".");
		label.setForeground(new Color(30, 144, 255));
		label.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		
		final JLabel lblTextname = new JLabel(n);
		lblTextname.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblTextname.setForeground(new Color(30, 144, 255));
		lblTextname.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Font font = lblTextname.getFont();
				Map attributes = font.getAttributes();
				attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
				lblTextname.setFont(font.deriveFont(attributes));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblTextname.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(name);
			}
		});
		lblTextname.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		
		JLabel lblImdbrating = new JLabel("" + r);
		lblImdbrating.setForeground(new Color(30, 144, 255));
		lblImdbrating.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		
		final JLabel lblAddedwatchlist = new JLabel("");
		final JLabel lblAddwatchlist = new JLabel("");
		lblAddwatchlist.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAddwatchlist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblAddwatchlist.setVisible(false);
				lblAddedwatchlist.setVisible(true);
				//Kullanıcı izlenicek listesine ekle
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblAddwatchlist.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\watch2026a.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblAddwatchlist.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\watch2026.png"));
			}
		});
		
		
		lblAddedwatchlist.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAddedwatchlist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblAddedwatchlist.setVisible(false);
				lblAddwatchlist.setVisible(true);
				//Kullanici izlenicek listesinden cikar
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblAddedwatchlist.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\WatchlistAddedA_20x26.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblAddedwatchlist.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\WatchlistAdded_20x26.png"));
			}
		});
		lblAddedwatchlist.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\WatchlistAdded_20x26.png"));
		lblAddwatchlist.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\watch2026.png"));
		
		panel_1.add(panel);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(7)
					.addComponent(lblImage, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(lblTextname, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblImdbrating, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAddwatchlist)
						.addComponent(lblAddedwatchlist)))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(lblTextname)))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAddwatchlist)
						.addComponent(lblAddedwatchlist)))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(20)
					.addComponent(lblImdbrating))
				.addComponent(lblImage, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
		);
		panel.setLayout(gl_panel);
		
		/*
		Top10Component temp = CreateObj(1, "YüzüklerinEdendisi", 8.5, panel_1);
		temp = CreateObj(2, "Hayri Pıtırcık", 7.5, panel_1);
		temp = new Top10Component(3, "Inception", 4.5, panel_1);
		
		*/
		
		
		
		
	}
}
