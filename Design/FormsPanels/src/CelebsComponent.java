import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CelebsComponent {
	public static int Id = 0;
	private String name;
	private String bio;
	private String celebId;
	public CelebsComponent(String cId, String n, String b, JPanel panelReal){
		Id++;
		name = n;
		bio = b;
		celebId = cId;
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 530, 113);

		JPanel panelName = new JPanel();
		panelName.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		new LabelWithLink(name, cId, true, panelName);
		panel.add(panelName);
		
		JLabel label = new JLabel(Id + ".");
		label.setBounds(10, 11, 42, 14);
		panel.add(label);
		
		JLabel lblImage = new JLabel("");
		lblImage.setBounds(51, 5, 73, 103);
		lblImage.setIcon(SqlOperations.getPeopleImage(celebId, lblImage));
		panel.add(lblImage);
		
		JLabel lblName = new JLabel(name);
		lblName.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblName.setBounds(145, 6, 264, 22);
		panel.add(lblName);
		
		JTextArea txtBio = new JTextArea();
		txtBio.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		txtBio.setEditable(false);
		txtBio.setFocusable(false);
		txtBio.setText(bio);
		txtBio.setLineWrap(true);
		txtBio.setWrapStyleWord(true);
		txtBio.setBounds(134, 35, 386, 54);
		
		JScrollPane scroll = new JScrollPane(txtBio);
	    scroll.setViewportView(txtBio);
		
		if(Id % 2 == 0){
			panelName.setBackground(new Color(241, 241, 241));
			panel.setBackground(new Color(241, 241, 241));
			txtBio.setBackground(new Color(241, 241, 241));
		}
		else{
			panelName.setBackground(Color.WHITE);
			panel.setBackground(Color.WHITE);
			txtBio.setBackground(Color.WHITE);
		}
		
		panel.add(scroll);
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(41)
							.addComponent(lblImage, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(21)
							.addComponent(panelName, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(scroll, GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
							.addContainerGap())))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(5)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(6)
									.addComponent(label))
								.addComponent(lblImage, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(6)
							.addComponent(panelName, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(7)
							.addComponent(scroll, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)))
					.addGap(5))
		);
		panel.setLayout(gl_panel);
		panelReal.add(panel);
	}
}
