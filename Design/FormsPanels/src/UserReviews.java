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
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class UserReviews {
	private String movieId;
	
	UserReviews(String mId, JPanel panelReal){
		movieId = mId;
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 550, 726);
		panel.setLayout(null);
		
		JLabel lblMovieImage = new JLabel("");
		lblMovieImage.setBounds(10, 10, 60, 83);
		lblMovieImage.setIcon(SqlOperations.getMovieImage(movieId, lblMovieImage));
		panel.add(lblMovieImage);
		
		JPanel panelMovieName = new JPanel();
		panelMovieName.setBackground(new Color(255, 255, 255));
		panelMovieName.setBounds(80, 10, 460, 30);
		panel.add(panelMovieName);
		panelMovieName.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		new LabelWithoutLink(SqlOperations.getMovie("SELECT mTitle FROM Movie WHERE movieId = '" + movieId + "'").get(0).getmTitle(), 
				102, 102, 102, true, panelMovieName);
		
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
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(MainForm.getIsLogined()){
					String commentText = JOptionPane.showInputDialog(
					        null, 
					        "",
					        "Please, enter your comment", 
					        JOptionPane.INFORMATION_MESSAGE
					    );
					if(commentText != null && !commentText.equals("")){
						//TODO: yorumu veritabanýna kaydet
						String insertComment = "INSERT INTO MovieCommend(fkMovieId, fkUserId, commend) VALUES('" 
								+ movieId + "'," 
								+ MainForm.getLoggedUserId() + ",'" 
								+ commentText + "')";
						SqlOperations.insert(insertComment);
						MainForm.refPanelEachOne.setVisible(false);
						MainForm.refPanelEachOne.removeAll();
						new UserReviews(movieId, MainForm.refPanelEachOne);
						MainForm.refPanelEachOne.setVisible(true);
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Please register to comment!");
				}
				
			}
		});
		lblWriteReview.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\WriteReview.png"));
		panel.add(lblWriteReview);
		
		JLabel lblShowComment = new JLabel("");
		lblShowComment.setLocation(425, 69);
		lblShowComment.setSize(24, 24);
		
		String commentQuery = "SELECT * FROM MovieCommend WHERE fkMovieId = '" + movieId + "' ORDER BY commendTime";
		ArrayList<MovieCommentClass> commentList = SqlOperations.getMovieComment(commentQuery);
		
		JLabel lblCommentCount = new JLabel("" + commentList.size());
		lblCommentCount.setSize(23, 20);
		lblCommentCount.setLocation(425, 69);
		lblCommentCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblCommentCount.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		lblCommentCount.setForeground(Color.WHITE);
		panel.add(lblCommentCount);
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
		
		for(int i = 0; i < commentList.size(); i++){
			new CommentComponent(commentList.get(i).getCommentId(), 0, panelComments);
		}
		
		panelReal.add(panel);
	}
}
