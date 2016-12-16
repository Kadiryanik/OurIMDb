import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MostRatedComponent {
	private String name;
	private int movieId;
	
	MostRatedComponent(String n, int mId, JPanel panelReal) {
		name = n;
		movieId = mId;
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 100, 230);
		panel.setLayout(new WrapLayout(FlowLayout.CENTER, 5, 0));
		
		
		JLabel lblIcon = new JLabel("");
		lblIcon.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\MostRated100x156.jpg"));
		lblIcon.setBounds(10, 10, 100, 156);
		panel.add(lblIcon);
		
		JPanel panelName = new JPanel();
		panelName.setBackground(new Color(255, 255, 255));
		panelName.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel.add(panelName);
		
		LabelWithLinkForMovie temp = new LabelWithLinkForMovie(name, movieId, panelName);
		
		JPanel panelRate = new JPanel();
		panelRate.setLayout(new FlowLayout(FlowLayout.CENTER, 35, 0));
		panelRate.setBackground(new Color(255, 255, 255));
		
		JLabel lblRate = new JLabel("10");
		lblRate.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblRate.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\MostRatedStar.png"));
		lblRate.setBounds(44, 192, 35, 15);
		
		panelRate.add(lblRate);
		panel.add(panelRate);
		
		panelReal.add(panel);
	}
}
