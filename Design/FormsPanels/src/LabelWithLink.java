import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class LabelWithLink {
	private String name;
	private String celebId;
	private boolean isLast = false;
	
	LabelWithLink(String n, String c, boolean L, JPanel panelReal){
		name = n;
		celebId = c;
		isLast = L;
		
		JSeparator seperator = new JSeparator(SwingConstants.VERTICAL);
		seperator.setForeground(new Color(51, 51, 51));
		seperator.setPreferredSize(new Dimension(2, 10));
		
		
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
				MainForm.refPanelTop.setVisible(false);
				MainForm.refPanelHome.setVisible(false);
				MainForm.refPanelMovies.setVisible(false);
				MainForm.refPanelCelebs.setVisible(false);
				MainForm.refPanelTop10.setVisible(false);
				MainForm.refPanelUser.setVisible(false);
				MainForm.refPanelWatchlist.setVisible(false);
				MainForm.refLabelGoBackD.setVisible(false);
				MainForm.refLabelBack.setVisible(true);
				
				MainForm.refPanelEachOne.setVisible(false);
				MainForm.refPanelEachOne.removeAll();
				new EachCeleb(celebId, MainForm.refPanelEachOne);
				MainForm.refPanelEachOne.setVisible(true);
			}
		});
		panelReal.add(lblLink);
		if(!isLast){
			panelReal.add(seperator);
		}
	}
}
