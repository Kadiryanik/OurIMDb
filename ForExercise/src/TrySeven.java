import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

public class TrySeven {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrySeven window = new TrySeven();
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
	public TrySeven() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 744, 865);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 530, 819);//726
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblImage = new JLabel("image");
		lblImage.setBounds(10, 11, 175, 245);
		panel.add(lblImage);
		
		JLabel lblName = new JLabel("Adam Sandler");
		lblName.setForeground(new Color(40, 40, 40));
		lblName.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblName.setBounds(195, 11, 325, 32);
		panel.add(lblName);
		
		JPanel panelInfo = new JPanel();
		panelInfo.setBounds(186, 43, 334, 18);
		panel.add(panelInfo);
		panelInfo.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
		
		new LabelWithoutLink("Actor", 12, 100, 172, 228, false, panelInfo);
		new LabelWithoutLink("Producer", 12, 100, 172, 228, false, panelInfo);
		new LabelWithoutLink("Writer", 12, 100, 172, 228, true, panelInfo);
		
		
		JTextArea textBuzz = new JTextArea();
		textBuzz.setFont(new Font("Comic Sans MS", Font.PLAIN, 9));
		textBuzz.setBackground(new Color(231, 231, 231));
		textBuzz.setBounds(160, 61, 370, 83);
		textBuzz.setEditable(false);
		textBuzz.setFocusable(false);
		textBuzz.setText("BuAciklama");
		textBuzz.setLineWrap(true);
		textBuzz.setWrapStyleWord(true);
		
		JScrollPane scrollBio = new JScrollPane(textBuzz);
		scrollBio.setLocation(195, 65);
		scrollBio.setSize(325, 160);
		scrollBio.setViewportView(textBuzz);
		
		panel.add(scrollBio);
		
		JPanel panelBorn = new JPanel();
		panelBorn.setBounds(195, 236, 325, 21);
		panel.add(panelBorn);
		panelBorn.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 1));
		
		JLabel lblBorn = new JLabel("Born: ");
		lblBorn.setForeground(new Color(40, 40, 40));
		lblBorn.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		panelBorn.add(lblBorn);

		JPanel panelFilmography = new JPanel();
		panelFilmography.setBackground(new Color(245, 245, 245));
		panelFilmography.setBounds(0, 294, 530, 421);
		panelFilmography.setLayout(null);
		
		JPanel panelFilmographyScroll = new JPanel();
		
		JScrollPane scrollPaneFilmography = new JScrollPane();
		scrollPaneFilmography.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panelFilmography.add(scrollPaneFilmography);
		scrollPaneFilmography.setBounds(0, 0, 530, 421);	
		
		scrollPaneFilmography.add(panelFilmographyScroll);
		scrollPaneFilmography.setViewportView(panelFilmographyScroll);
		panelFilmographyScroll.setLayout(new WrapLayout(FlowLayout.CENTER, 0, 1));
		
		panel.add(panelFilmography);
		
		JLabel lblFilmography = new JLabel("Filmography");
		lblFilmography.setForeground(new Color(40, 40, 40));
		lblFilmography.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblFilmography.setBounds(10, 267, 510, 21);
		panel.add(lblFilmography);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 723, 510, 50);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panelMovieName = new JPanel();
		panelMovieName.setBounds(0, 0, 450, 25);
		panel_1.add(panelMovieName);
		panelMovieName.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
		
		JPanel panelRoleInMovie = new JPanel();
		panelRoleInMovie.setBounds(0, 24, 450, 25);
		panel_1.add(panelRoleInMovie);
		panelRoleInMovie.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblDate = new JLabel("2009");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setForeground(new Color(0, 191, 255));
		lblDate.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblDate.setBounds(449, 0, 61, 50);
		panel_1.add(lblDate);
	}
}
