import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.ScrollPaneConstants;

public class TryTwelve {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TryTwelve window = new TryTwelve();
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
	public TryTwelve() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 802, 807);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 550, 726);
		frame.getContentPane().add(panel);
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
		new CommentComponent(1, 2, panelChilderen);
		new CommentComponent(1, 2, panelChilderen);
		new CommentComponent(1, 2, panelChilderen);
		new CommentComponent(1, 2, panelChilderen);
		new CommentComponent(1, 2, panelChilderen);
		new CommentComponent(1, 2, panelChilderen);
		new CommentComponent(1, 2, panelChilderen);
		new CommentComponent(1, 2, panelChilderen);
		new CommentComponent(1, 2, panelChilderen);
		new CommentComponent(1, 2, panelChilderen);
		
		
	}
}
