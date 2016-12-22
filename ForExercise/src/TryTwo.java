import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class TryTwo {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TryTwo window = new TryTwo();
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
	public TryTwo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 633, 486);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		int Id = 0;
		String name = "kadir";
		String bio = "biografi";
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 530, 113);
		
		JPanel panelName = new JPanel();
		
		JLabel label = new JLabel(Id + ".");
		
		//73,103
		JLabel lblImage = new JLabel("image");
		
		
		JTextArea txtBio = new JTextArea();
		txtBio.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		txtBio.setEditable(false);
		txtBio.setFocusable(false);
		txtBio.setText(bio);
		txtBio.setLineWrap(true);
		txtBio.setWrapStyleWord(true);
		
		
		JScrollPane scroll = new JScrollPane(txtBio);
	    scroll.setViewportView(txtBio);
		
		if(Id % 2 == 0){
			panelName.setBackground(new Color(241, 241, 241));
			panel.setBackground(new Color(241, 241, 241));
			txtBio.setBackground(new Color(241, 241, 241));
		}
		else{
			panelName.setBackground(Color.WHITE);
			panel.setBackground(Color.WHITE);
			txtBio.setBackground(Color.WHITE);
		}
		
		frame.getContentPane().add(panel);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(41)
							.addComponent(lblImage, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(21)
							.addComponent(panelName, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(scroll, GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
							.addContainerGap())))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(5)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(6)
									.addComponent(label))
								.addComponent(lblImage, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(6)
							.addComponent(panelName, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(7)
							.addComponent(scroll, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)))
					.addGap(5))
		);
		panel.setLayout(gl_panel);
		
		
		
	}
}
