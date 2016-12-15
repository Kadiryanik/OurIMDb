import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class EachCeleb {
	private int celebId;
	
	public EachCeleb(int cId, JPanel panelReal) {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 550, 726);
		panel.setLayout(null);
		
		JLabel lblImage = new JLabel("image");
		lblImage.setBounds(20, 11, 175, 245);
		panel.add(lblImage);
		
		JLabel lblName = new JLabel("Adam Sandler");
		lblName.setForeground(new Color(40, 40, 40));
		lblName.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblName.setBounds(205, 11, 325, 32);
		panel.add(lblName);
		
		JPanel panelInfo = new JPanel();
		panelInfo.setBackground(new Color(255, 255, 255));
		panelInfo.setBounds(196, 43, 334, 18);
		panel.add(panelInfo);
		panelInfo.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
		
		new LabelWithoutLink("Actor", 100, 172, 228, false, panelInfo);
		new LabelWithoutLink("Producer", 100, 172, 228, false, panelInfo);
		new LabelWithoutLink("Writer", 100, 172, 228, true, panelInfo);
		
		
		JTextArea textBuzz = new JTextArea();
		textBuzz.setFont(new Font("Comic Sans MS", Font.PLAIN, 9));
		textBuzz.setBackground(new Color(255, 255, 255));
		textBuzz.setBounds(160, 61, 370, 83);
		textBuzz.setEditable(false);
		textBuzz.setFocusable(false);
		textBuzz.setText("BuAciklama");
		textBuzz.setLineWrap(true);
		textBuzz.setWrapStyleWord(true);
		
		JScrollPane scrollBio = new JScrollPane(textBuzz);
		scrollBio.setLocation(205, 65);
		scrollBio.setSize(325, 160);
		scrollBio.setViewportView(textBuzz);
		
		panel.add(scrollBio);
		
		JPanel panelBorn = new JPanel();
		panelBorn.setBackground(new Color(255, 255, 255));
		panelBorn.setBounds(205, 236, 325, 21);
		panel.add(panelBorn);
		panelBorn.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 1));
		
		JLabel lblBorn = new JLabel("Born: ");
		lblBorn.setForeground(new Color(40, 40, 40));
		lblBorn.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		panelBorn.add(lblBorn);

		JPanel panelFilmography = new JPanel();
		panelFilmography.setBackground(new Color(245, 245, 245));
		panelFilmography.setBounds(10, 294, 530, 421);
		panelFilmography.setLayout(null);
		
		JPanel panelFilmographyScroll = new JPanel();
		panelFilmographyScroll.setBackground(new Color(255, 255, 255));
		
		JScrollPane scrollPaneFilmography = new JScrollPane();
		scrollPaneFilmography.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panelFilmography.add(scrollPaneFilmography);
		scrollPaneFilmography.setBounds(0, 0, 530, 421);	
		
		scrollPaneFilmography.add(panelFilmographyScroll);
		scrollPaneFilmography.setViewportView(panelFilmographyScroll);
		panelFilmographyScroll.setLayout(new WrapLayout(FlowLayout.CENTER, 0, 1));
		
		panel.add(panelFilmography);
		
		JLabel lblFilmography = new JLabel("Filmography");
		lblFilmography.setForeground(new Color(40, 40, 40));
		lblFilmography.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblFilmography.setBounds(20, 267, 510, 21);
		panel.add(lblFilmography);
		
		new FilmographyComponent(12, 13, panelFilmographyScroll);
		new FilmographyComponent(12, 13, panelFilmographyScroll);
		new FilmographyComponent(12, 13, panelFilmographyScroll);
		new FilmographyComponent(12, 13, panelFilmographyScroll);
		new FilmographyComponent(12, 13, panelFilmographyScroll);
		new FilmographyComponent(12, 13, panelFilmographyScroll);
		new FilmographyComponent(12, 13, panelFilmographyScroll);
		new FilmographyComponent(12, 13, panelFilmographyScroll);
		new FilmographyComponent(12, 13, panelFilmographyScroll);
		new FilmographyComponent(12, 13, panelFilmographyScroll);
		new FilmographyComponent(12, 13, panelFilmographyScroll);
		new FilmographyComponent(12, 13, panelFilmographyScroll);
		new FilmographyComponent(12, 13, panelFilmographyScroll);
		new FilmographyComponent(12, 13, panelFilmographyScroll);
		
		panelReal.add(panel);
	}
}
