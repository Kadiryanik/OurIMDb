import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.plaf.synth.SynthSeparatorUI;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Toolkit;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Window.Type;
import java.awt.Frame;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;


public class MainForm {
	
	private JFrame frmOurmdb;
	private JTextField textFieldId;
	private JPasswordField textFieldPw;
	private JPanel panelCelebs;
	public int xMouse;
	public int yMouse;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm window = new MainForm();
					window.frmOurmdb.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public MainForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmOurmdb = new JFrame();
		frmOurmdb.setResizable(false);
		frmOurmdb.setUndecorated(true);
		frmOurmdb.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\SadneS\\Desktop\\Button Png\\icon.png"));
		frmOurmdb.setTitle("OurIMDb");
		frmOurmdb.setBackground(Color.LIGHT_GRAY);
		frmOurmdb.getContentPane().setBackground(SystemColor.scrollbar);
		frmOurmdb.setBounds(100, 100, 550, 750);
		frmOurmdb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOurmdb.getContentPane().setLayout(null);
		
		JButton btnExit = new JButton("X");
		btnExit.setBackground(SystemColor.activeCaption);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		btnExit.setBounds(495, 0, 45, 15);
		frmOurmdb.getContentPane().add(btnExit);
		
		final JPanel panelTop = new JPanel();
		
		panelTop.setBackground(new Color(255, 255, 255, 0));
		panelTop.setBounds(0, 10, 550, 45);
		frmOurmdb.getContentPane().add(panelTop);
		panelTop.setLayout(null);
		

		final JPanel panelHome = new JPanel();
		panelHome.setBackground(new Color(0, 128, 128, 80));
		panelHome.setBounds(0, 55, 550, 695);
		frmOurmdb.getContentPane().add(panelHome);
		
		final JPanel panelMovies = new JPanel();
		panelMovies.setVisible(false);
		panelMovies.setBackground(new Color(119, 136, 153, 50));
		panelMovies.setBounds(0, 55, 550, 695);
		frmOurmdb.getContentPane().add(panelMovies);
		
		panelCelebs = new JPanel();
		panelCelebs.setVisible(false);
		panelCelebs.setBackground(new Color(221, 160, 221, 50));
		panelCelebs.setBounds(0, 55, 550, 695);
		frmOurmdb.getContentPane().add(panelCelebs);
		
		final JPanel panelTop50 = new JPanel();
		panelTop50.setVisible(false);
		panelTop50.setBackground(new Color(210, 180, 140, 50));
		panelTop50.setBounds(0, 55, 550, 695);
		frmOurmdb.getContentPane().add(panelTop50);
		
		final JPanel panelUser = new JPanel();
		panelUser.setVisible(false);
		panelUser.setBackground(new Color(106, 90, 205, 50));
		panelUser.setBounds(0, 55, 550, 695);
		frmOurmdb.getContentPane().add(panelUser);
		
		JButton btnHome = new JButton("");
		btnHome.setBackground(UIManager.getColor("CheckBox.light"));
		btnHome.setIcon(new ImageIcon("C:\\Users\\SadneS\\Desktop\\Button Png\\home.png"));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelHome.setVisible(true);
				panelMovies.setVisible(false);
				panelCelebs.setVisible(false);
				panelTop50.setVisible(false);
			}
		});
		btnHome.setBounds(10, 8, 46, 26);
		panelTop.add(btnHome);
		
		JButton btnMovies = new JButton("");
		btnMovies.setBackground(UIManager.getColor("CheckBox.light"));
		btnMovies.setIcon(new ImageIcon("C:\\Users\\SadneS\\Desktop\\Button Png\\movies.png"));
		btnMovies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelHome.setVisible(false);
				panelMovies.setVisible(true);
				panelCelebs.setVisible(false);
				panelTop50.setVisible(false);
			}
		});
		btnMovies.setBounds(57, 8, 54, 26);
		panelTop.add(btnMovies);
		
		JButton btnCelebs = new JButton("");
		btnCelebs.setBackground(UIManager.getColor("CheckBox.light"));
		btnCelebs.setIcon(new ImageIcon("C:\\Users\\SadneS\\Desktop\\Button Png\\celebs.png"));
		btnCelebs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelHome.setVisible(false);
				panelMovies.setVisible(false);
				panelCelebs.setVisible(true);
				panelTop50.setVisible(false);
			}
		});
		btnCelebs.setBounds(112, 8, 52, 26);
		panelTop.add(btnCelebs);
		
		JButton btnTop = new JButton("");
		btnTop.setBackground(UIManager.getColor("CheckBox.light"));
		btnTop.setIcon(new ImageIcon("C:\\Users\\SadneS\\Desktop\\Button Png\\Top50.png"));
		btnTop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelHome.setVisible(false);
				panelMovies.setVisible(false);
				panelCelebs.setVisible(false);
				panelTop50.setVisible(true);
			}
		});
		btnTop.setBounds(165, 8, 50, 26);
		panelTop.add(btnTop);
		
		final JButton btnWatchList = new JButton("");
		btnWatchList.setIcon(new ImageIcon("C:\\Users\\SadneS\\Desktop\\Button Png\\watchlist.png"));
		btnWatchList.setEnabled(false);
		btnWatchList.setVisible(true);
		btnWatchList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnWatchList.setBounds(217, 8, 76, 26);
		panelTop.add(btnWatchList);
		
		final JPanel panelUnLogin = new JPanel();
		panelUnLogin.setBackground(new Color(255, 255, 255, 0));
		panelUnLogin.setBounds(309, 0, 240, 45);
		panelTop.add(panelUnLogin);
		panelUnLogin.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(2, 10, 15, 13);
		panelUnLogin.add(lblId);
		lblId.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		
		JLabel lblPw = new JLabel("PW");
		lblPw.setBounds(0, 25, 21, 13);
		panelUnLogin.add(lblPw);
		lblPw.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		
		textFieldId = new JTextField();
		textFieldId.setBounds(20, 8, 86, 15);
		panelUnLogin.add(textFieldId);
		textFieldId.setColumns(10);
		
		textFieldPw = new JPasswordField();
		textFieldPw.setBounds(20, 23, 86, 15);
		panelUnLogin.add(textFieldPw);
		textFieldPw.setEchoChar('*');
		textFieldPw.setColumns(10);
		
		JButton btnLogin = new JButton("");
		btnLogin.setBounds(117, 8, 44, 26);
		panelUnLogin.add(btnLogin);
		btnLogin.setIcon(new ImageIcon("C:\\Users\\SadneS\\Desktop\\Button Png\\login.png"));
		
		JButton btnRegister = new JButton("");
		btnRegister.setBounds(165, 8, 64, 26);
		panelUnLogin.add(btnRegister);
		btnRegister.setIcon(new ImageIcon("C:\\Users\\SadneS\\Desktop\\Button Png\\register.png"));
		
		final JPanel panelLogined = new JPanel();
		panelLogined.setVisible(false);
		panelLogined.setBackground(new Color(255, 255, 255, 0));
		panelLogined.setBounds(381, 0, 168, 45);
		panelTop.add(panelLogined);
		panelLogined.setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome ");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 13));
		lblWelcome.setBounds(30, 5, 122, 19);
		panelLogined.add(lblWelcome);
		
		final JLabel lblUser = new JLabel("User");
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 13));
		lblUser.setBounds(30, 25, 116, 19);
		panelLogined.add(lblUser);
		
		final JButton btnProfile = new JButton("");
		btnProfile.setIcon(new ImageIcon("C:\\Users\\SadneS\\Desktop\\Button Png\\profile.png"));
		btnProfile.setVisible(false);
		btnProfile.setBounds(294, 8, 52, 26);
		panelTop.add(btnProfile);
		
		JLabel labelDrag = new JLabel("");
		labelDrag.setBackground(new Color(0, 0, 0));
		labelDrag.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				xMouse = arg0.getX();
				yMouse = arg0.getY();
			}
		});
		labelDrag.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				int x = arg0.getXOnScreen();
				int y = arg0.getYOnScreen();
				frmOurmdb.setLocation(x - xMouse, y - yMouse);
			}
		});
		labelDrag.setBounds(0, 0, 550, 15);
		frmOurmdb.getContentPane().add(labelDrag);
		
		JPanel panelBackground = new JPanel(){
			public void paintComponent(Graphics g){
				ImageIcon icon = new ImageIcon("C:\\Users\\SadneS\\Desktop\\Button Png\\back.jpg");
				Image i = icon.getImage();
				
				g.drawImage(i, 0, 0, this.getSize().width, this.getSize().height, this);
			}
		};
		panelBackground.setBounds(0, 0, 550, 750);
		frmOurmdb.getContentPane().add(panelBackground);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.print(textFieldId.getText());
				System.out.print(textFieldPw.getPassword());
				if("aa".equals(textFieldId.getText()) && "123".equals(textFieldPw.getText())){
					JOptionPane.showMessageDialog(null, "Welcome " + textFieldId.getText() + "!");
					panelUnLogin.setVisible(false);
					panelLogined.setVisible(true);
					btnWatchList.setEnabled(true);
					btnProfile.setVisible(true);
					
					lblUser.setText(textFieldId.getText());
					textFieldId.setText("");
					textFieldPw.setText("");
				}
				else{
					
				}
			}
		});
	}
}
