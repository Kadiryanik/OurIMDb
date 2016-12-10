import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class CelebsComponent {
	public static int Id = 0;
	private String name;
	private String bio;
	
	
	public CelebsComponent(String n, String b, JPanel panelReal){
		Id++;
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 530, 100);
		
		JLabel label = new JLabel(Id + ".");
		label.setBounds(10, 11, 42, 14);
		panel.add(label);
		
		JLabel lblImage = new JLabel();
		lblImage.setIcon(new ImageIcon("C:\\Users\\SadneS\\Desktop\\Button Png\\Celebs_1s.jpg"));
		lblImage.setBounds(62, 11, 57, 78);
		panel.add(lblImage);
		
		JLabel lblName = new JLabel(n);
		lblName.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblName.setBounds(145, 6, 264, 22);
		panel.add(lblName);
		
		JTextArea txtBio = new JTextArea();
		txtBio.setEditable(false);
		txtBio.setFocusable(false);
		txtBio.setText(b);
		txtBio.setLineWrap(true);
		txtBio.setWrapStyleWord(true);
		txtBio.setBounds(134, 35, 386, 54);
		
		if(Id % 2 == 0){
			panel.setBackground(new Color(230, 230, 245));
			txtBio.setBackground(new Color(230, 230, 245));
		}
		else{
			panel.setBackground(Color.WHITE);
			txtBio.setBackground(Color.WHITE);
		}
		
		panel.add(txtBio);
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(lblImage, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addGap(15)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(11)
							.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtBio, GroupLayout.PREFERRED_SIZE, 386, GroupLayout.PREFERRED_SIZE)))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(11)
					.addComponent(label))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(11)
					.addComponent(lblImage, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(6)
					.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(txtBio, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
		);
		panel.setLayout(gl_panel);
		panelReal.add(panel);
	}
}
