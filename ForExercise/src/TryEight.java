import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class TryEight {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TryEight window = new TryEight();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TryEight() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 728, 936);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 550, 726);
		frame.getContentPane().add(panel);
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
		
		JLabel lblSearchFor = new JLabel("\"Search\"");
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
		
		new SearchMovieComponent("Ahmetül abbas", 1, panelTitleResults);
		new SearchMovieComponent("Ahmetül abbas", 1, panelTitleResults);
		new SearchMovieComponent("Ahmetül abbas", 1, panelTitleResults);
		new SearchMovieComponent("Ahmetül abbas", 1, panelTitleResults);
		new SearchMovieComponent("Ahmetül abbas", 1, panelTitleResults);
		new SearchMovieComponent("Ahmetül abbas", 1, panelTitleResults);
		new SearchMovieComponent("Ahmetül abbas", 1, panelTitleResults);
		new SearchMovieComponent("Ahmetül abbas", 1, panelTitleResults);
		new SearchMovieComponent("Ahmetül abbas", 1, panelTitleResults);
		
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

		new SearchCelebComponent("Adam Sandler", 1, panelCelebResults);
		new SearchCelebComponent("Adam Sandler", 1, panelCelebResults);
		new SearchCelebComponent("Adam Sandler", 1, panelCelebResults);
		new SearchCelebComponent("Adam Sandler", 1, panelCelebResults);
		new SearchCelebComponent("Adam Sandler", 1, panelCelebResults);
		new SearchCelebComponent("Adam Sandler", 1, panelCelebResults);
		new SearchCelebComponent("Adam Sandler", 1, panelCelebResults);
		new SearchCelebComponent("Adam Sandler", 1, panelCelebResults);
		
		JLabel lblCelebNames = new JLabel("Celeb Names");
		lblCelebNames.setForeground(new Color(165, 133, 0));
		lblCelebNames.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblCelebNames.setBounds(10, 381, 140, 20);
		panel.add(lblCelebNames);
		
	}
}
