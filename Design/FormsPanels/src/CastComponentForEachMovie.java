import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CastComponentForEachMovie {
	public static int Id = 0;
	private int celebId;
	private String name;
	private String nameInMovie;
	
	CastComponentForEachMovie(int c, String n, String nM, JPanel panelReal){
		Id++;
		celebId = c;
		name = n;
		nameInMovie = nM;
		
		JPanel panelCastComponent = new JPanel();
		panelCastComponent.setBackground(new Color(192, 192, 192));
		panelCastComponent.setBounds(0, 0, 530, 44);
		
		/*setting image with id*/
		JLabel lblImage = new JLabel("");
		lblImage.setBounds(0, 0, 32, 44);
		lblImage.setIcon(SqlOperations.getPeopleImage(c, lblImage));
		
		JPanel panelRealName = new JPanel();
		panelRealName.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 2));
		if(Id % 2 == 0){
			panelRealName.setBackground(new Color(240, 240, 240));
			panelCastComponent.setBackground(new Color(240, 240, 240));
		}
		else{
			panelRealName.setBackground(new Color(251, 251, 251));
			panelCastComponent.setBackground(new Color(251, 251, 251));
		}
		LabelWithLink tempL = new LabelWithLink(n, c, true, panelRealName);
		
		JLabel labelSep = new JLabel("...");
		labelSep.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		
		JLabel lblNameInMovie = new JLabel(nM);
		lblNameInMovie.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		GroupLayout gl_panelCastComponent = new GroupLayout(panelCastComponent);
		gl_panelCastComponent.setHorizontalGroup(
			gl_panelCastComponent.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCastComponent.createSequentialGroup()
					.addComponent(lblImage)
					.addGap(8)
					.addComponent(panelRealName, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(labelSep, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(15)
					.addComponent(lblNameInMovie, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
		);
		gl_panelCastComponent.setVerticalGroup(
			gl_panelCastComponent.createParallelGroup(Alignment.LEADING)
				.addComponent(lblImage)
				.addGroup(gl_panelCastComponent.createSequentialGroup()
					.addGap(11)
					.addComponent(panelRealName, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelCastComponent.createSequentialGroup()
					.addGap(11)
					.addComponent(labelSep, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelCastComponent.createSequentialGroup()
					.addGap(11)
					.addComponent(lblNameInMovie, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
		);
		panelCastComponent.setLayout(gl_panelCastComponent);
		
		panelReal.add(panelCastComponent);
	}
}
