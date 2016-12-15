import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class FilmographyComponent {
	public static int Id  = 0;
	private int movieId;
	private int celebId;
	
	public FilmographyComponent(int mId, int cId, JPanel panelReal) {
		Id++;
		movieId = mId;
		celebId = cId;
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 723, 510, 50);
		
		JPanel panelMovieName = new JPanel();
		panelMovieName.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
		
		new LabelWithLinkForMovie("Happy Gilmore",123, panelMovieName);
		
		JPanel panelRoleInMovie = new JPanel();
		panelRoleInMovie.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
		
		new LabelWithoutLink("Tom", 102, 102, 102, false, panelRoleInMovie);
		new LabelWithoutLink("Actor", 102, 102, 102, true, panelRoleInMovie);
		
		JLabel lblDate = new JLabel("2009");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setForeground(new Color(0, 191, 255));
		lblDate.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		
		if(Id % 2 == 0){
			panel.setBackground(new Color(241, 241, 241));
			panelRoleInMovie.setBackground(new Color(241, 241, 241));
			panelMovieName.setBackground(new Color(241, 241, 241));
		}
		else{
			panel.setBackground(new Color(255, 255, 255));
			panelRoleInMovie.setBackground(new Color(255, 255, 255));
			panelMovieName.setBackground(new Color(255, 255, 255));
		}
		
		GroupLayout gl_panel_1 = new GroupLayout(panel);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(449)
					.addComponent(lblDate, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
				.addComponent(panelMovieName, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(20)
					.addComponent(panelRoleInMovie, GroupLayout.PREFERRED_SIZE, 430, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(lblDate, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
				.addComponent(panelMovieName, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(24)
					.addComponent(panelRoleInMovie, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
		);
		panel.setLayout(gl_panel_1);
		
		panelReal.add(panel);
	}

}
