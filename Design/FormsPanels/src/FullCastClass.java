import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
//ÇAÐATAY 9:24(17)
public class FullCastClass {
	private int movieId;
	
	public FullCastClass(int mId, JPanel panelReal) {
		movieId = mId;
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 245, 245));
		panel.setBounds(0, 0, 550, 726);
		
		/*getting directors informations with movieId*/
		String directorsQuery = "SELECT peopleId, pTitle FROM People WHERE peopleId IN"
				+ "(SELECT fkPeopleId FROM MoviePeople WHERE fkMovieId = " + mId + " AND directorFlag = 1) LIMIT 0,3";
		ArrayList<People> directorsList = SqlOperations.getPeople(directorsQuery); 
		
		/*getting writers informations with movieId*/
		String writersQuery = "SELECT peopleId, pTitle FROM People WHERE peopleId IN"
				+ "(SELECT fkPeopleId FROM MoviePeople WHERE fkMovieId = " + mId + " AND writerFlag = 1) LIMIT 0,3";
		ArrayList<People> writersList = SqlOperations.getPeople(writersQuery);
		
		/*getting actors informations with movieId*/
		String starsQuery = "SELECT peopleId, pTitle FROM People WHERE peopleId IN"
				+ "(SELECT fkPeopleId FROM MoviePeople WHERE fkMovieId = " + mId + " AND actorFlag = 1)";
		ArrayList<People> starsList = SqlOperations.getPeople(starsQuery);
		
		JLabel lblImage = new JLabel("");
		lblImage.setBounds(20, 11, 67, 98);
		lblImage.setIcon(SqlOperations.getMovieImage(mId, lblImage));
		
		JPanel panelName = new JPanel();
		panelName.setBackground(new Color(245, 245, 245));
		panelName.setBounds(97, 11, 443, 27);
		panelName.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		/* adding movie title with link*/ 
		new LabelWithLinkForMovie(SqlOperations.getMovie("SELECT mTitle FROM Movie WHERE movieId = " + mId).get(0).getmTitle(), mId, 15, panelName);
		
		JLabel lblFullcastcrew = new JLabel("Full Cast & Crew");
		lblFullcastcrew.setBounds(97, 42, 167, 35);
		lblFullcastcrew.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		
		JLabel lblDirectedBy = new JLabel("Directed by");
		lblDirectedBy.setBounds(20, 121, 77, 14);
		lblDirectedBy.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		
		JLabel lblLine = new JLabel("");
		lblLine.setBounds(98, 121, 442, 14);
		lblLine.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\line.png"));
		
		JLabel lblWrittenBy = new JLabel("Written by");
		lblWrittenBy.setBounds(20, 177, 77, 14);
		lblWrittenBy.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		
		JLabel lblLine2 = new JLabel("");
		lblLine2.setBounds(97, 178, 443, 14);
		lblLine2.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\line.png"));
		
		JPanel panelDirecters = new JPanel();
		panelDirecters.setBackground(new Color(245, 245, 245));
		panelDirecters.setBounds(20, 144, 520, 20);
		panelDirecters.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		/*directors with link*/
		for(int i = 0; i < directorsList.size(); i++){
			boolean isLast = false;
			if(i == directorsList.size() - 1) isLast = true;
			new LabelWithLink(directorsList.get(i).getpTitle(), directorsList.get(i).getPeopleId(), isLast, panelDirecters);
		}
		
		JPanel panelWriters = new JPanel();
		panelWriters.setBackground(new Color(245, 245, 245));
		panelWriters.setBounds(20, 200, 520, 20);
		panelWriters.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		/*writers with link*/
		for(int i = 0; i < writersList.size(); i++){
			boolean isLast = false;
			if(i == writersList.size() - 1) isLast = true;
			new LabelWithLink(writersList.get(i).getpTitle(), writersList.get(i).getPeopleId(), isLast, panelWriters);
		}
		
		JLabel lblCast = new JLabel("Cast");
		lblCast.setBounds(20, 230, 77, 14);
		lblCast.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		
		JLabel lblline3 = new JLabel("");
		lblline3.setBounds(97, 231, 443, 14);
		lblline3.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\line.png"));
		
		JPanel panelCast = new JPanel();
		panelCast.setBackground(new Color(245, 245, 245));
		panelCast.setBounds(20, 255, 510, 460);
		panelCast.setLayout(null);
		
		JPanel panelCastScroll = new JPanel();
		panelCastScroll.setBackground(new Color(245, 245, 245));
		
		JScrollPane scrollPaneCast = new JScrollPane();
		scrollPaneCast.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panelCast.add(scrollPaneCast);
		scrollPaneCast.setBounds(0, 0, 510, 460);	
		
		scrollPaneCast.add(panelCastScroll);
		scrollPaneCast.setViewportView(panelCastScroll);
		panelCastScroll.setLayout(new WrapLayout(FlowLayout.CENTER, 0, 1));
		
		for(int i = 0; i < starsList.size(); i++){
			String q = "SELECT castName, fkPeopleId FROM MoviePeople where fkMovieId = " + movieId
					+ " AND fkPeopleId = " + starsList.get(i).getPeopleId();
			ArrayList<RoleInMovie> castInfo = SqlOperations.getRole(q);
			new CastComponentForEachMovie(starsList.get(i).getPeopleId(), starsList.get(i).getpTitle(),
					castInfo.get(0).getCastName(), panelCastScroll);
		}	
		
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
		
		panelReal.add(panel);
	}
}
