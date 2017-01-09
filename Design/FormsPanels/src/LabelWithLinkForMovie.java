import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class LabelWithLinkForMovie {
	private String name;
	private String movieId;
	private int fontSize;
	private int crop;
	LabelWithLinkForMovie(String n, String mId, int f, int c, JPanel panelReal){
		movieId = mId;
		name = n;
		fontSize = f;
		crop = c;
		if(name.length() > c){
			name = name.substring(0, c);
			name = name + "...";
		}
		final JLabel lblLink = new JLabel(name);
		
		lblLink.setSize(15, 15);
		lblLink.setFont(new Font("Comic Sans MS", Font.PLAIN, fontSize));
		lblLink.setForeground(new Color(19, 148, 209));
		lblLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Font font = lblLink.getFont();
				Map attributes = font.getAttributes();
				attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
				lblLink.setFont(font.deriveFont(attributes));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblLink.setFont(new Font("Comic Sans MS", Font.PLAIN, fontSize));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(MainForm.getIsLogined()){
					String query = "SELECT fkMovieId FROM NumberOfVisit WHERE fkUserId = " + MainForm.getLoggedUserId() 
						+ " AND fkMovieId = '" + movieId + "'";
					ArrayList<Movie> movieList = SqlOperations.getMovie(query);
					if(movieList.isEmpty())
					{
						//insert if not exist
						String insertQuery = "INSERT INTO NumberOfVisit(fkUserId,fkMovieId) VALUES(" 
								+ MainForm.getLoggedUserId() + ",'" + movieId + "')";
						SqlOperations.insert(insertQuery);
					}
					else{
						String updateQuery = "UPDATE NumberOfVisit SET counter=counter+1 WHERE fkUserId = " + MainForm.getLoggedUserId() 
							+ " AND fkMovieId = '" + movieId + "'";
						SqlOperations.update(updateQuery);
					}
				}

				String updateQuery = "UPDATE Movie SET mNumOfVisit=mNumOfVisit+1 WHERE movieId = '" + movieId + "'";
				SqlOperations.update(updateQuery);
				
				MainForm.refPanelTop.setVisible(false);
				MainForm.refPanelHome.setVisible(false);
				MainForm.refPanelMovies.setVisible(false);
				MainForm.refPanelCelebs.setVisible(false);
				MainForm.refPanelTop10.setVisible(false);
				MainForm.refPanelUser.setVisible(false);
				MainForm.refPanelWatchlist.setVisible(false);
				MainForm.refLabelturnHomeD.setVisible(false);
				MainForm.refLabelTurnHome.setVisible(true);
				
				MainForm.refPanelEachOne.setVisible(false);
				MainForm.refPanelEachOne.removeAll();
				int isLogin = -1;
				if(MainForm.getIsLogined()){
					isLogin = 0;
				}
				new EachMovie(movieId, MainForm.refPanelEachOne, isLogin);
				MainForm.refPanelEachOne.setVisible(true);
			}
		});
		panelReal.add(lblLink);
	}
}
