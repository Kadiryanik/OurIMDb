import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class TryTen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TryTen window = new TryTen();
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
	public TryTen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 821, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 510, 120);
		frame.getContentPane().add(panel);
		
		JTextArea textComment = new JTextArea();
		textComment.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		textComment.setBackground(new Color(255, 255, 255));
		textComment.setEditable(false);
		textComment.setFocusable(false);
		textComment.setText("bu bir aciklamabu bir aciklamabu bir aciklamabu bir aciklamabu bir aciklamabu bir aciklama"
				+ "bu bir aciklamabu bir aciklamabu bir aciklamabu bir aciklamabu bir aciklamabu bir aciklama"
				+ "bu bir aciklamabu bir aciklamabu bir aciklamabu bir aciklamabu bir aciklamabu bir aciklama"
				+ "bu bir aciklamabu bir aciklamabu bir aciklamabu bir aciklamabu bir aciklamabu bir aciklama");
		textComment.setLineWrap(true);
		textComment.setWrapStyleWord(true);
		
		JScrollPane scrollComment = new JScrollPane(textComment);
		scrollComment.setViewportView(textComment);
		
		JLabel lblNewLabel = new JLabel("UserImage");
		
		JPanel panelUserName = new JPanel();
		panelUserName.setBackground(new Color(255, 255, 255));
		panelUserName.setLayout(new FlowLayout(FlowLayout.LEFT, 4, 5));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
						.addComponent(panelUserName, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
					.addGap(3)
					.addComponent(scrollComment, GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollComment, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(panelUserName, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		
	}

}
