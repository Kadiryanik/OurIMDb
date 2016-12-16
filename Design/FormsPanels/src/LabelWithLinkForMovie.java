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
	private int movieId;
	
	LabelWithLinkForMovie(String n, int mId, JPanel panelReal){
		movieId = mId;
		name = n;
		final JLabel lblLink = new JLabel(name);
		
		lblLink.setSize(15, 15);
		lblLink.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
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
				lblLink.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				//TODO: Goto eachCelebs with id
				MainForm.refPanelEachOne.setVisible(false);
				MainForm.refPanelEachOne.removeAll();
				new EachMovie(movieId,MainForm.refPanelEachOne);
				MainForm.refPanelEachOne.setVisible(true);
			}
		});
		panelReal.add(lblLink);
	}
}
