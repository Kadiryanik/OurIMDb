import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.SwingConstants;


public class HomePageClass {
	private int cropLimit;
	//TODO: show most visited 6 movie
	//if logged then show most visited which match user profile 
	public HomePageClass( JPanel panelReal) {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 245, 245));
		panel.setBounds(0, 0, 550, 675);
		panel.setLayout(null);

		cropLimit = 25;
		
		String movieQuery = "SELECT movieId, mTitle FROM Movie ORDER BY mDate DESC";
		ArrayList<Movie> movieList = SqlOperations.getMovie(movieQuery);
		
		JLabel lblPopular = new JLabel("Popular Movies");
		lblPopular.setForeground(new Color(0, 0, 0));
		lblPopular.setHorizontalAlignment(SwingConstants.CENTER);
		lblPopular.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblPopular.setBounds(25, 11, 500, 30);
		panel.add(lblPopular);
		
		JPanel panelOne = new JPanel();
		panelOne.setBackground(new Color(245, 245, 245));
		panelOne.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panelOne.setBounds(25, 278, 150, 30);
		new LabelWithLinkForMovie(movieList.get(0).getmTitle(), movieList.get(0).getMovieId(), 11, cropLimit, panelOne);
		panel.add(panelOne);
		
		JLabel lblMovieOne = new JLabel("");
		lblMovieOne.setBounds(25, 74, 150, 200);
		lblMovieOne.setIcon(SqlOperations.getMovieImage(movieList.get(0).getMovieId(), lblMovieOne));
		panel.add(lblMovieOne);
		
		JPanel panelTwo = new JPanel();
		panelTwo.setBackground(new Color(245, 245, 245));
		panelTwo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panelTwo.setBounds(200, 278, 150, 30);
		new LabelWithLinkForMovie(movieList.get(1).getmTitle(), movieList.get(1).getMovieId(), 11, cropLimit, panelTwo);
		panel.add(panelTwo);
		
		JLabel lblMovieTwo = new JLabel("");
		lblMovieTwo.setBounds(200, 74, 150, 200);
		lblMovieTwo.setIcon(SqlOperations.getMovieImage(movieList.get(1).getMovieId(), lblMovieTwo));
		panel.add(lblMovieTwo);
		
		JPanel panelThree = new JPanel();
		panelThree.setBackground(new Color(245, 245, 245));
		panelThree.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panelThree.setBounds(375, 278, 150, 30);
		new LabelWithLinkForMovie(movieList.get(2).getmTitle(), movieList.get(2).getMovieId(), 11, cropLimit, panelThree);
		panel.add(panelThree);
		
		JLabel lblMovieThree = new JLabel("");
		lblMovieThree.setBounds(375, 74, 150, 200);
		lblMovieThree.setIcon(SqlOperations.getMovieImage(movieList.get(2).getMovieId(), lblMovieThree));
		panel.add(lblMovieThree);
		
		JPanel panelFour = new JPanel();
		panelFour.setBackground(new Color(245, 245, 245));
		panelFour.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panelFour.setBounds(25, 564, 150, 30);
		new LabelWithLinkForMovie(movieList.get(3).getmTitle(), movieList.get(3).getMovieId(), 11, cropLimit, panelFour);
		panel.add(panelFour);
		
		JLabel lblMovieFour = new JLabel("");
		lblMovieFour.setBounds(25, 360, 150, 200);
		lblMovieFour.setIcon(SqlOperations.getMovieImage(movieList.get(3).getMovieId(), lblMovieFour));
		panel.add(lblMovieFour);
		
		JPanel panelFive = new JPanel();
		panelFive.setBackground(new Color(245, 245, 245));
		panelFive.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panelFive.setBounds(200, 564, 150, 30);
		new LabelWithLinkForMovie(movieList.get(4).getmTitle(), movieList.get(4).getMovieId(), 11, cropLimit, panelFive);
		panel.add(panelFive);
		
		JLabel lblMovieFive = new JLabel("");
		lblMovieFive.setBounds(200, 360, 150, 200);
		lblMovieFive.setIcon(SqlOperations.getMovieImage(movieList.get(4).getMovieId(), lblMovieFive));
		panel.add(lblMovieFive);
		
		JPanel panelSix = new JPanel();
		panelSix.setBackground(new Color(245, 245, 245));
		panelSix.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panelSix.setBounds(375, 564, 150, 30);
		new LabelWithLinkForMovie(movieList.get(5).getmTitle(), movieList.get(5).getMovieId(), 11, cropLimit, panelSix);
		panel.add(panelSix);
		
		JLabel lblMovieSix = new JLabel("");
		lblMovieSix.setBounds(375, 360, 150, 200);
		lblMovieSix.setIcon(SqlOperations.getMovieImage(movieList.get(5).getMovieId(), lblMovieSix));
		panel.add(lblMovieSix);
		
		
		panelReal.add(panel);
	}

}
