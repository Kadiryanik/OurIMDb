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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 600, 280);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel = new JPanel();
		panel_1.add(panel);
		panel.setBackground(new Color(192, 192, 192));
		
		final JLabel lblTextname = new JLabel("Y\u00FCz\u00FCklerin Efendisi");
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
				System.out.println("a");
			}
		});
		
		JLabel lblImage = new JLabel("");
		lblImage.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\icon32.png"));
		
		JLabel label = new JLabel("1.");
		label.setForeground(new Color(30, 144, 255));
		label.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblTextname.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		
		JLabel lblImdbrating = new JLabel("IMDbRating");
		lblImdbrating.setForeground(new Color(30, 144, 255));
		lblImdbrating.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		
		final JLabel lblAddwatchlist = new JLabel("");
		lblAddwatchlist.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAddwatchlist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//Kullanýcý izlenicek listesine ekle
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
		lblAddwatchlist.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\watch2026.png"));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(7)
					.addComponent(lblImage, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(lblTextname, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(lblImdbrating)
					.addGap(22)
					.addComponent(lblAddwatchlist))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(7)
					.addComponent(lblImage, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(20)
					.addComponent(label))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(20)
					.addComponent(lblTextname))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(20)
					.addComponent(lblImdbrating))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(17)
					.addComponent(lblAddwatchlist))
		);
		panel.setLayout(gl_panel);
		
		/*
		Top10Component temp = CreateObj(1, "YüzüklerinEdendisi", 8.5, panel_1);
		temp = CreateObj(2, "Hayri Pýtýrcýk", 7.5, panel_1);
		temp = new Top10Component(3, "Inception", 4.5, panel_1);
		
		*/
		
		
		
		
	}
}
