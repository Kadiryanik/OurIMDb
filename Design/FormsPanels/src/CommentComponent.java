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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

public class CommentComponent {
	private int commentId;
	private int commentFlag;
	
	//commentFlag
	//0: movieComment which has own comments
	//1: movieComment without own comments
	//2: childComment for eachComment
	//3: parentComment for CommentsInComment
	CommentComponent(int comId, int cFlag,JPanel panelReal){
		commentId = comId;
		commentFlag = cFlag;
		
		if(commentFlag == 0){
			JPanel panel = new JPanel();
			panel.setBackground(new Color(248, 248, 248));
			panel.setBounds(0, 0, 510, 120);
			
			JTextArea textComment = new JTextArea();
			textComment.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
			textComment.setBackground(new Color(248, 248, 248));
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
				@Override
				public void mouseClicked(MouseEvent arg0) {
					String commentText = JOptionPane.showInputDialog(
					        null, 
					        "",
					        "Please, enter your comment", 
					        JOptionPane.INFORMATION_MESSAGE
					    );
					if(commentText != null && !commentText.equals("")){
						//TODO: yorumu veritabanýna kaydet
					}
				}
			});
			lblWriteReview.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\WriteReview.png"));
			
			JLabel lblNewLabel = new JLabel("UserImage");
			
			JPanel panelUserName = new JPanel();
			panelUserName.setBackground(new Color(248, 248, 248));
			panelUserName.setLayout(new FlowLayout(FlowLayout.CENTER, 4, 5));

			new LabelWithLinkForUser("cagatay-0", 1, panelUserName);
			
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
			
			panelReal.add(panel);
		}
		else if(commentFlag == 1){
			JPanel panel = new JPanel();
			panel.setBackground(new Color(248, 248, 248));
			panel.setBounds(0, 0, 510, 120);
			
			JTextArea textComment = new JTextArea();
			textComment.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
			textComment.setBackground(new Color(248, 248, 248));
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
				@Override
				public void mouseClicked(MouseEvent arg0) {
					String commentText = JOptionPane.showInputDialog(
					        null, 
					        "",
					        "Please, enter your comment", 
					        JOptionPane.INFORMATION_MESSAGE
					    );
					if(commentText != null && !commentText.equals("")){
						//TODO: yorumu veritabanýna kaydet
					}
				}
			});
			lblWriteReview.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\WriteReview.png"));
			
			JLabel lblNewLabel = new JLabel("UserImage");
			
			JPanel panelUserName = new JPanel();
			panelUserName.setBackground(new Color(248, 248, 248));
			panelUserName.setLayout(new FlowLayout(FlowLayout.CENTER, 4, 5));

			new LabelWithLinkForUser("kadir-1", 1, panelUserName);
			
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
						.addGap(317)
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
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(4)
								.addComponent(lblWriteReview, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))))
			);
			panel.setLayout(gl_panel);
			
			panelReal.add(panel);
		}
		else if(commentFlag == 2){
			JPanel panel = new JPanel();
			panel.setBackground(new Color(248, 248, 248));
			panel.setBounds(0, 0, 510, 120);
			
			JTextArea textComment = new JTextArea();
			textComment.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
			textComment.setBackground(new Color(248, 248, 248));
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
			panelUserName.setBackground(new Color(248, 248, 248));
			panelUserName.setLayout(new FlowLayout(FlowLayout.CENTER, 4, 5));
		
			new LabelWithLinkForUser("Cagatay-2", 1, panelUserName);
			
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
			
			panelReal.add(panel);
		}
		else if(commentFlag == 3){
			JPanel panel = new JPanel();
			panel.setBackground(new Color(248, 248, 248));
			panel.setBounds(0, 0, 510, 120);
			
			JTextArea textComment = new JTextArea();
			textComment.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
			textComment.setBackground(new Color(248, 248, 248));
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
				@Override
				public void mouseClicked(MouseEvent arg0) {
					String commentText = JOptionPane.showInputDialog(
					        null, 
					        "",
					        "Please, enter your comment", 
					        JOptionPane.INFORMATION_MESSAGE
					    );
					if(commentText != null && !commentText.equals("")){
						//TODO: yorumu veritabanýna kaydet
					}
				}
			});
			lblWriteReview.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\WriteReview.png"));
			
			JLabel lblNewLabel = new JLabel("UserImage");
			
			JPanel panelUserName = new JPanel();
			panelUserName.setBackground(new Color(248, 248, 248));
			panelUserName.setLayout(new FlowLayout(FlowLayout.CENTER, 4, 5));
			
			new LabelWithLinkForUser("kadir-3", 1, panelUserName);
			
			JLabel lblShowComment = new JLabel("");
			lblShowComment.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\ShowComments.png"));
			
			JLabel lblCommentCount = new JLabel("1");
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
			
			panelReal.add(panel);
		}
		else{
			System.out.println("CommentComponentUsage Error: Check your commentFlag");
		}
		
	}

}
