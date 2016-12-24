import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class SearchMovieComponent {
	public static int Id = 0;
	private String name;
	private String movieId;
	
	public SearchMovieComponent(String n, String mId, JPanel panelReal) {
		Id++;
		name = n;
		movieId = mId;
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 722, 530, 44);
		
		JLabel lblImage = new JLabel();
		lblImage.setBounds(0, 0, 32, 44);
		lblImage.setIcon(SqlOperations.getMovieImage(movieId, lblImage));
		
		JPanel panelNameDate = new JPanel();
		panelNameDate.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
		
		new LabelWithLinkForMovie(name, movieId, 11, 50, panelNameDate);
		
		String date = SqlOperations.getMovie("SELECT mDate FROM Movie WHERE movieId = '" + movieId + "'").get(0).getmDate().substring(0, 4);
		JLabel lblDate = new JLabel("(" + date + ")");
		lblDate.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblDate.setForeground(new Color(51, 51, 51));
		panelNameDate.add(lblDate);
		
		if(Id % 2 == 0){
			panel.setBackground(new Color(240, 240, 240));
			panelNameDate.setBackground(new Color(240, 240, 240));
		}
		else{
			panel.setBackground(new Color(251, 251, 251));
			panelNameDate.setBackground(new Color(251, 251, 251));
		}
		
		GroupLayout gl_panel_1 = new GroupLayout(panel);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(lblImage, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(panelNameDate, GroupLayout.PREFERRED_SIZE, 494, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(lblImage, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(11)
					.addComponent(panelNameDate, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
		);
		panel.setLayout(gl_panel_1);
		
		panelReal.add(panel);
	}

}
