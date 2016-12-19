import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TryEleven {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TryEleven window = new TryEleven();
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
	public TryEleven() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 790, 867);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 550, 726);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblMovieImage = new JLabel("");
		lblMovieImage.setBounds(10, 10, 60, 83);
		panel.add(lblMovieImage);
		
		JPanel panelMovieName = new JPanel();
		panelMovieName.setBackground(new Color(255, 255, 255));
		panelMovieName.setBounds(80, 10, 460, 30);
		panel.add(panelMovieName);
		panelMovieName.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		final JLabel lblWriteReview = new JLabel("");
		lblWriteReview.setSize(88, 21);
		lblWriteReview.setLocation(452, 72);
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
		panel.add(lblWriteReview);
		
		JLabel lblShowComment = new JLabel("");
		lblShowComment.setLocation(425, 69);
		lblShowComment.setSize(24, 24);
		lblShowComment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		JLabel lblCommentCount = new JLabel("1");
		lblCommentCount.setSize(23, 20);
		lblCommentCount.setLocation(425, 69);
		lblCommentCount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lblCommentCount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCommentCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblCommentCount.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		lblCommentCount.setForeground(Color.WHITE);
		panel.add(lblCommentCount);
		lblShowComment.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblShowComment.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\ShowComments.png"));
		panel.add(lblShowComment);
		
		JPanel panelComments = new JPanel();
		panelComments.setBackground(new Color(255, 255, 255));
		panelComments.setLayout(new WrapLayout(FlowLayout.LEFT, 5, 5));
		
		JScrollPane scrollPaneComments = new JScrollPane();
		scrollPaneComments.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel.add(scrollPaneComments);
		scrollPaneComments.setBounds(5, 115, 540, 600);	
		
		scrollPaneComments.add(panelComments);
		scrollPaneComments.setViewportView(panelComments);
		
		new CommentComponent(1, 1, panelComments);
		new CommentComponent(1, 0, panelComments);
		new CommentComponent(1, 1, panelComments);
		new CommentComponent(1, 1, panelComments);
		new CommentComponent(1, 0, panelComments);
		new CommentComponent(1, 0, panelComments);
		new CommentComponent(1, 0, panelComments);
		new CommentComponent(1, 0, panelComments);
		
	}

}