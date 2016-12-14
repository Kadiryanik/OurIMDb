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

public class LabelWithoutLink {
	private String name;
	private int r;
	private int g;
	private int b;
	private boolean isLast = false;
	
	LabelWithoutLink(String n, int r, int g, int b, boolean L, JPanel panelReal){
		name = n;
		isLast = L;
		
		JSeparator seperator = new JSeparator(SwingConstants.VERTICAL);
		seperator.setForeground(new Color(51, 51, 51));
		seperator.setPreferredSize(new Dimension(2, 10));
		
		
		final JLabel lblLink = new JLabel(n);
		lblLink.setSize(15, 15);
		lblLink.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblLink.setForeground(new Color(r, g, b));
		
		panelReal.add(lblLink);
		if(!isLast){
			panelReal.add(seperator);
		}
	}
}
