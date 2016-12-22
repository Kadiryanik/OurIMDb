import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class FilmographyComponent {
	public static int Id  = 0;
	private String movieId;
	private String celebId;
	
	public FilmographyComponent(String mId, String cId, JPanel panelReal) {
		Id++;
		movieId = mId;
		celebId = cId;
		
		String movieQuery = "SELECT mTitle, mDate, movieId FROM Movie WHERE movieId = '" + movieId + "'";
		ArrayList<Movie> movieList = SqlOperations.getMovie(movieQuery);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 723, 510, 50);
		
		JPanel panelMovieName = new JPanel();
		panelMovieName.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
		
		new LabelWithLinkForMovie(movieList.get(0).getmTitle(), movieList.get(0).getMovieId(), 11, panelMovieName);
		
		JPanel panelRoleInMovie = new JPanel();
		panelRoleInMovie.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
		
		String castQuery = "SELECT castName, actorFlag, directorFlag, writerFlag FROM MoviePeople WHERE "
				+ "fkMovieId = '" + movieId + "' AND fkPeopleId = '" + celebId + "'";
		ArrayList<RoleInMovie> castInfo = SqlOperations.getRole(castQuery);
		
		/*castname in movie*/
		new LabelWithoutLink(castInfo.get(0).getCastName(), 102, 102, 102, false, panelRoleInMovie);
		
		/*setting the roles of people(actor,director,writer) in the movie*/
		boolean isActor = false;
		boolean isDirector = false;
		boolean isWriter = false;
		if(castInfo.get(0).getActorFlag() == 1)isActor = true;
		if(castInfo.get(0).getDirectorFlag() == 1)isDirector = true;
		if(castInfo.get(0).getWriterFlag() == 1)isWriter = true;
		if(isActor)new LabelWithoutLink("actor", 102, 102, 102, (!isDirector && !isWriter), panelRoleInMovie);
		if(isDirector) new LabelWithoutLink("director", 102, 102, 102, !isWriter, panelRoleInMovie);
		if(isWriter)new LabelWithoutLink("writer", 102, 102, 102, true, panelRoleInMovie);
		
		/*getting year format like 1900*/
		JLabel lblDate = new JLabel("" + movieList.get(0).getmDate().substring(0, 4));
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
