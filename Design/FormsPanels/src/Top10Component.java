import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.util.Map;
import java.awt.Color;
import java.awt.Cursor;


public class Top10Component {
	public static int Id = 0;
	private int movieId;
	private String name;
	private double rating;
	
	public Top10Component(int m, String n, double r, JPanel panelReal){
		Id++;
		movieId = m;
		name = n;
		rating = r;
		
		JPanel panel = new JPanel();
		if(Id % 2 == 0){
			panel.setBackground(new Color(230, 230, 245));
		}
		else{
			panel.setBackground(new Color(255, 255, 255));
		}
		panel.setBounds(0, 0, 500, 300);
		
		
		JLabel lblImage = new JLabel("");
		lblImage.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\icon32.png"));
		lblImage.setBounds(10, 5, 43, 58);
		panel.add(lblImage);
		
		JLabel label = new JLabel(Id + ".");
		label.setForeground(new Color(30, 144, 255));
		label.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		label.setBounds(63, 15, 28, 36);
		panel.add(label);
		
		final JLabel lblTextname = new JLabel(n);
		lblTextname.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblTextname.setForeground(new Color(30, 144, 255));
		lblTextname.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Font font = lblTextname.getFont();
				Map attributes = font.getAttributes();
				attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
				lblTextname.setFont(font.deriveFont(attributes));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblTextname.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(name);
			}
		});
		lblTextname.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblTextname.setBounds(99, 15, 239, 36);
		panel.add(lblTextname);
		
		JLabel lblImdbrating = new JLabel("" + r);
		lblImdbrating.setForeground(new Color(30, 144, 255));
		lblImdbrating.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblImdbrating.setBounds(361, 15, 66, 36);
		panel.add(lblImdbrating);
		
		final JLabel lblAddwatchlist = new JLabel("");
		lblAddwatchlist.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAddwatchlist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//Kullanýcý izlenicek listesine ekle
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblAddwatchlist.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\watch2026a.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblAddwatchlist.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\watch2026.png"));
			}
		});
		lblAddwatchlist.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\watch2026.png"));
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(7)
					.addComponent(lblImage, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(lblTextname, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(lblImdbrating)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblAddwatchlist)
					.addGap(26))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(7)
							.addComponent(lblImage, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(20)
							.addComponent(label))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblAddwatchlist)
								.addComponent(lblImdbrating)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(20)
							.addComponent(lblTextname)))
					.addContainerGap(10, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		panelReal.add(panel);
	}
	
}