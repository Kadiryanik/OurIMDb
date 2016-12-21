import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class SearchResult {
	String text;
	
	public SearchResult(String t, JPanel panelReal) {
		text = t;
		
		String celebQuery = "SELECT peopleId, pTitle FROM People WHERE pTitle LIKE '%" + text + "%'";
		ArrayList<People> celebList = SqlOperations.getPeople(celebQuery);
		
		String movieQuery = "SELECT movieId, mTitle FROM Movie WHERE mTitle LIKE '%" + text + "%'";
		ArrayList<Movie> movieList = SqlOperations.getMovie(movieQuery);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 550, 726);
		panel.setLayout(null);
		
		JPanel panelInfo = new JPanel();
		panelInfo.setBackground(new Color(255, 255, 255));
		panelInfo.setBounds(10, 11, 530, 30);
		panel.add(panelInfo);
		panelInfo.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblResultFor = new JLabel("Results for ");
		lblResultFor.setForeground(new Color(32, 32, 32));
		panelInfo.add(lblResultFor);
		lblResultFor.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		
		JLabel lblSearchFor = new JLabel("\"" + text + "\"");
		lblSearchFor.setForeground(new Color(51, 51, 51));
		lblSearchFor.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		panelInfo.add(lblSearchFor);
		
		JPanel panelTitleResults = new JPanel();
		panelTitleResults.setBackground(new Color(255, 255, 255));
		panelTitleResults.setLayout(new WrapLayout(FlowLayout.CENTER, 5, 1));
		
		JScrollPane scrollPaneTitleResults = new JScrollPane();
		scrollPaneTitleResults.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneTitleResults.setBounds(10, 70, 530, 307);
		scrollPaneTitleResults.add(panelTitleResults);
		scrollPaneTitleResults.setViewportView(panelTitleResults);
		panel.add(scrollPaneTitleResults);
		
		for(int i = 0; i < movieList.size(); i++){
			new SearchMovieComponent(movieList.get(i).getmTitle(), movieList.get(i).getMovieId(), panelTitleResults);
		}
		
		JLabel lblMovieTitles = new JLabel("Movie Titles");
		lblMovieTitles.setForeground(new Color(165, 133, 0));
		lblMovieTitles.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblMovieTitles.setBounds(10, 45, 140, 20);
		panel.add(lblMovieTitles);
		
		JPanel panelCelebResults = new JPanel();
		panelCelebResults.setBackground(new Color(255, 255, 255));
		panelCelebResults.setLayout(new WrapLayout(FlowLayout.CENTER, 5, 5));
		
		JScrollPane scrollPaneCelebResults = new JScrollPane();
		scrollPaneCelebResults.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneCelebResults.setBounds(10, 405, 530, 307);
		scrollPaneCelebResults.add(panelCelebResults);
		scrollPaneCelebResults.setViewportView(panelCelebResults);
		panel.add(scrollPaneCelebResults);

		for(int i = 0; i < celebList.size(); i++){
			new SearchCelebComponent(celebList.get(i).getpTitle(), celebList.get(i).getPeopleId(), panelCelebResults);
		}
		
		JLabel lblCelebNames = new JLabel("Celeb Names");
		lblCelebNames.setForeground(new Color(165, 133, 0));
		lblCelebNames.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblCelebNames.setBounds(10, 381, 140, 20);
		panel.add(lblCelebNames);
		
		panelReal.add(panel);
	}

}
