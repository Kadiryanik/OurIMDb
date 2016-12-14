import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class WatchlistComponent {
	private int movieId;
		

	WatchlistComponent(int mId, JPanel panelReal){
		final JLabel lblAddedWatch = new JLabel("");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 450, 164);
		
		JPanel panelName = new JPanel();
		panelName.setBackground(new Color(255, 255, 255));
		panelName.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JPanel panelUnderName = new JPanel();
		panelUnderName.setBackground(new Color(255, 255, 255));
		panelUnderName.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		final JLabel lblAddWatch = new JLabel("");
		lblAddWatch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//TODO: Kullanýcý izlenicek listesine ekle
				lblAddWatch.setVisible(false);
				lblAddedWatch.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblAddWatch.setIcon(new ImageIcon("C:\\Users\\SadneS\\Desktop\\Button Png\\watch2026a.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblAddWatch.setIcon(new ImageIcon("C:\\Users\\SadneS\\Desktop\\Button Png\\watch2026.png"));
			}
		});
		lblAddWatch.setIcon(new ImageIcon("C:\\Users\\SadneS\\Desktop\\Button Png\\watch2026.png"));
		lblAddWatch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAddedWatch.setVisible(false);
		lblAddedWatch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		lblAddedWatch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblAddedWatch.setIcon(new ImageIcon("C:\\Users\\SadneS\\Desktop\\Button Png\\WatchlistAddedA_20x26.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblAddedWatch.setIcon(new ImageIcon("C:\\Users\\SadneS\\Desktop\\Button Png\\WatchlistAdded_20x26.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				//TODO: kullanýcý listesinden çýkar
				lblAddedWatch.setVisible(false);
				lblAddWatch.setVisible(true);
			}
		});
		lblAddedWatch.setIcon(new ImageIcon("C:\\Users\\SadneS\\Desktop\\Button Png\\WatchlistAdded_20x26.png"));
		
		JLabel lblImage = new JLabel("\u0130mage");
		lblImage.setIcon(new ImageIcon("C:\\Users\\SadneS\\Desktop\\Button Png\\TheShawshankRedemption.jpg"));
		
		JLabel lblYourratingpoint = new JLabel("9");
		lblYourratingpoint.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		
		JLabel lblStarb = new JLabel("");
		lblStarb.setIcon(new ImageIcon("C:\\Users\\SadneS\\Desktop\\Button Png\\StarBlueXXsmal.png"));
		
		JLabel lblRatingPoint = new JLabel("8,3");
		lblRatingPoint.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		
		JLabel lblStary = new JLabel("");
		lblStary.setIcon(new ImageIcon("C:\\Users\\SadneS\\Desktop\\Button Png\\StarYellowXXsmal.png"));
		
		JTextArea textInfo = new JTextArea();
		textInfo.setFont(new Font("Comic Sans MS", Font.PLAIN, 9));
		textInfo.setBackground(new Color(255, 255, 255));
		textInfo.setBounds(160, 61, 370, 83);
		textInfo.setEditable(false);
		textInfo.setFocusable(false);
		textInfo.setText("BuAciklama");
		textInfo.setLineWrap(true);
		textInfo.setWrapStyleWord(true);
		
		JScrollPane scrollInfo = new JScrollPane(textInfo);
		scrollInfo.setBackground(new Color(255, 255, 255));
		scrollInfo.setViewportView(textInfo);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(8)
							.addComponent(lblAddWatch))
						.addComponent(lblImage, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(8)
							.addComponent(lblAddedWatch)))
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panelName, GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
						.addComponent(panelUnderName, GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblStary)
							.addGap(6)
							.addComponent(lblRatingPoint, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addGap(3)
							.addComponent(lblStarb)
							.addGap(5)
							.addComponent(lblYourratingpoint, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollInfo, 0, 0, Short.MAX_VALUE))
					.addGap(48))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAddWatch)
						.addComponent(lblImage)
						.addComponent(lblAddedWatch)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(panelName, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
							.addGap(3)
							.addComponent(panelUnderName, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(1)
									.addComponent(lblStary))
								.addComponent(lblRatingPoint)
								.addComponent(lblStarb)
								.addComponent(lblYourratingpoint))
							.addGap(9)
							.addComponent(scrollInfo, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))))
		);
		panel.setLayout(gl_panel);
		
		panelReal.add(panel);
	}
}
