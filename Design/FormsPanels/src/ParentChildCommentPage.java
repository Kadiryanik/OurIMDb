import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.ScrollPaneConstants;

public class ParentChildCommentPage {
	private int commentId;
	
	ParentChildCommentPage(int comId,JPanel panelReal) {
		commentId = comId;
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 550, 726);
		panel.setLayout(null);
		
		JPanel panelParent = new JPanel();
		panelParent.setBackground(new Color(105, 105, 105));
		panelParent.setBounds(0, 0, 550, 121);
		panel.add(panelParent);
		panelParent.setLayout(new WrapLayout(FlowLayout.CENTER, 5, 2));
		
		JPanel panelChilderen = new JPanel();
		panelChilderen.setLayout(new WrapLayout(FlowLayout.CENTER, 5, 5));
		
		JScrollPane scrollPaneChilderen = new JScrollPane();
		scrollPaneChilderen.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneChilderen.setBounds(0, 124, 550, 602);
		
		scrollPaneChilderen.setViewportView(panelChilderen);
		panel.add(scrollPaneChilderen);
		
		new CommentComponent(1, 3, panelParent);
		new CommentComponent(1, 0, panelChilderen);
		new CommentComponent(1, 1, panelChilderen);
		new CommentComponent(1, 2, panelChilderen);
		new CommentComponent(1, 1, panelChilderen);
		new CommentComponent(1, 1, panelChilderen);
		new CommentComponent(1, 2, panelChilderen);
		new CommentComponent(1, 2, panelChilderen);
		new CommentComponent(1, 0, panelChilderen);
		new CommentComponent(1, 0, panelChilderen);
		new CommentComponent(1, 2, panelChilderen);
		
		panelReal.add(panel);
	}

}
