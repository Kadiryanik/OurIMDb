import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.ScrollPaneConstants;

public class TrySix {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrySix window = new TrySix();
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
	public TrySix() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 128));
		frame.setBounds(100, 100, 699, 988);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 245, 245));
		panel.setBounds(0, 0, 530, 726);
		frame.getContentPane().add(panel);
		
		JLabel lblImage = new JLabel("image");
		lblImage.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\TheShawshankRedemption.jpg"));
		lblImage.setBounds(10, 11, 67, 98);
		
		JPanel panelName = new JPanel();
		panelName.setBackground(new Color(245, 245, 245));
		panelName.setBounds(87, 11, 443, 27);
		panelName.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		new LabelWithLink("shawshank", 123, true, panelName);
		
		JLabel lblFullcastcrew = new JLabel("Full Cast & Crew");
		lblFullcastcrew.setBounds(87, 42, 167, 35);
		lblFullcastcrew.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		
		JLabel lblDirectedBy = new JLabel("Directed by");
		lblDirectedBy.setBounds(10, 121, 77, 14);
		lblDirectedBy.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		
		JLabel lblLine = new JLabel("");
		lblLine.setBounds(88, 121, 442, 14);
		lblLine.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\line.png"));
		
		JLabel lblWrittenBy = new JLabel("Written by");
		lblWrittenBy.setBounds(10, 177, 77, 14);
		lblWrittenBy.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		
		JLabel lblLine2 = new JLabel("");
		lblLine2.setBounds(87, 178, 443, 14);
		lblLine2.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\line.png"));
		
		JPanel panelDirecters = new JPanel();
		panelDirecters.setBackground(new Color(245, 245, 245));
		panelDirecters.setBounds(10, 144, 520, 20);
		panelDirecters.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		new LabelWithLink("shawshank", 123, true, panelDirecters);
		
		JPanel panelWriters = new JPanel();
		panelWriters.setBackground(new Color(245, 245, 245));
		panelWriters.setBounds(10, 200, 520, 20);
		panelWriters.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		new LabelWithLink("shawshank", 123, false, panelWriters);
		new LabelWithLink("shawshank", 123, true, panelWriters);
		
		JLabel lblCast = new JLabel("Cast");
		lblCast.setBounds(10, 230, 77, 14);
		lblCast.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		
		JLabel lblline3 = new JLabel("");
		lblline3.setBounds(87, 231, 443, 14);
		lblline3.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\line.png"));
		
		JPanel panelCast = new JPanel();
		panelCast.setBackground(new Color(245, 245, 245));
		panelCast.setBounds(10, 255, 510, 460);
		panelCast.setLayout(null);
		
		JPanel panelCastScroll = new JPanel();
		
		JScrollPane scrollPaneCast = new JScrollPane();
		scrollPaneCast.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panelCast.add(scrollPaneCast);
		scrollPaneCast.setBounds(0, 0, 510, 460);	
		
		scrollPaneCast.add(panelCastScroll);
		scrollPaneCast.setViewportView(panelCastScroll);
		panelCastScroll.setLayout(new WrapLayout(FlowLayout.CENTER, 0, 1));
		
		new CastComponentForEachMovie(12, "nativee", "asd", panelCastScroll);
		new CastComponentForEachMovie(12, "nativee", "asd", panelCastScroll);
		new CastComponentForEachMovie(12, "nativee", "asd", panelCastScroll);
		new CastComponentForEachMovie(12, "nativee", "asd", panelCastScroll);
		new CastComponentForEachMovie(12, "nativee", "asd", panelCastScroll);
		new CastComponentForEachMovie(12, "nativee", "asd", panelCastScroll);
		new CastComponentForEachMovie(12, "nativee", "asd", panelCastScroll);
		new CastComponentForEachMovie(12, "nativee", "asd", panelCastScroll);
		new CastComponentForEachMovie(12, "nativee", "asd", panelCastScroll);
		new CastComponentForEachMovie(12, "nativee", "asd", panelCastScroll);
		new CastComponentForEachMovie(12, "nativee", "asd", panelCastScroll);
		new CastComponentForEachMovie(12, "nativee", "asd", panelCastScroll);
		new CastComponentForEachMovie(12, "nativee", "asd", panelCastScroll);
		new CastComponentForEachMovie(12, "nativee", "asd", panelCastScroll);
		new CastComponentForEachMovie(12, "nativee", "asd", panelCastScroll);
		new CastComponentForEachMovie(12, "nativee", "asd", panelCastScroll);
		new CastComponentForEachMovie(12, "nativee", "asd", panelCastScroll);
		new CastComponentForEachMovie(12, "nativee", "asd", panelCastScroll);
		new CastComponentForEachMovie(12, "nativee", "asd", panelCastScroll);
		new CastComponentForEachMovie(12, "nativee", "asd", panelCastScroll);
		
		panel.setLayout(null);
		panel.add(lblImage);
		panel.add(panelName);
		panel.add(lblFullcastcrew);
		panel.add(lblDirectedBy);
		panel.add(lblLine);
		panel.add(lblWrittenBy);
		panel.add(lblLine2);
		panel.add(panelDirecters);
		panel.add(panelWriters);
		panel.add(lblCast);
		panel.add(lblline3);
		panel.add(panelCast);
	}
}
