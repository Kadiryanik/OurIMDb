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

public class TryNine {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TryNine window = new TryNine();
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
	public TryNine() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 656, 703);
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
		
		final JLabel lblWriteReview = new JLabel("");
		lblWriteReview.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblWriteReview.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblWriteReview.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\WriteReviewA.png"));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblWriteReview.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\WriteReview.png"));
			}
		});
		lblWriteReview.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\WriteReview.png"));
		
		JLabel lblNewLabel = new JLabel("UserImage");
		
		JPanel panelUserName = new JPanel();
		panelUserName.setBackground(new Color(255, 255, 255));
		panelUserName.setLayout(new FlowLayout(FlowLayout.LEFT, 4, 5));
		
		JLabel lblShowComment = new JLabel("");
		lblShowComment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lblShowComment.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblShowComment.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\ShowComments.png"));
		
		JLabel lblCommentCount = new JLabel("1");
		lblCommentCount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lblCommentCount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCommentCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblCommentCount.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		lblCommentCount.setForeground(Color.WHITE);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addGap(15)
					.addComponent(scrollComment, GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(panelUserName, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addGap(286)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCommentCount, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblShowComment))
					.addGap(7)
					.addComponent(lblWriteReview, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollComment, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(panelUserName, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCommentCount, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblShowComment)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(4)
							.addComponent(lblWriteReview, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 156, 536, 501);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new WrapLayout(FlowLayout.CENTER, 5, 5));
		
		new CommentComponent(1, 0, panel_1);
		new CommentComponent(1, 0, panel_1);
		new CommentComponent(1, 0, panel_1);
		new CommentComponent(1, 1, panel_1);
		new CommentComponent(1, 3, panel_1);
	}
}
