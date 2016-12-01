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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.Cursor;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.Scrollbar;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.ScrollPaneConstants;
import java.awt.FlowLayout;

//Finalde sformdaki bi butnu mesela tutup baþka yere taþýmak için hangi eventlerle ilgilenilmeli nasýl yapýlýr
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
		
		final JLabel labelExit = new JLabel("");
		labelExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				labelExit.setIcon(new ImageIcon("C:\\Users\\SadneS\\Desktop\\Button Png\\rsz_x_kýrmýzý.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				labelExit.setIcon(new ImageIcon("C:\\Users\\SadneS\\Desktop\\Button Png\\rsz_x_siyah.png"));
			}
		});
		labelExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labelExit.setIcon(new ImageIcon("C:\\Users\\SadneS\\Desktop\\Button Png\\rsz_x_siyah.png"));
		labelExit.setBounds(510, 0, 24, 24);
		frmOurmdb.getContentPane().add(labelExit);
		
		JLabel labelIcon = new JLabel("");
		labelIcon.setIcon(new ImageIcon("C:\\Users\\SadneS\\Desktop\\Button Png\\icon.png"));
		labelIcon.setBounds(0, 0, 24, 24);
		frmOurmdb.getContentPane().add(labelIcon);
		
		final JPanel panelTop = new JPanel();
		panelTop.setBackground(new Color(255, 255, 255, 0));
		panelTop.setBounds(0, 25, 550, 45);
		frmOurmdb.getContentPane().add(panelTop);
		panelTop.setLayout(null);
	
		final JPanel panelHome = new JPanel();
		panelHome.setBackground(new Color(0, 128, 128, 80));
		panelHome.setBounds(0, 75, 550, 675);
		frmOurmdb.getContentPane().add(panelHome);
		
		final JPanel panelMovies = new JPanel();
		panelMovies.setVisible(false);
		panelMovies.setBackground(new Color(119, 136, 153, 50));
		panelMovies.setBounds(0, 75, 550, 675);
		frmOurmdb.getContentPane().add(panelMovies);
		
		panelCelebs = new JPanel();
		panelCelebs.setVisible(false);
		panelCelebs.setBackground(new Color(221, 160, 221, 50));
		panelCelebs.setBounds(0, 75, 550, 675);
		frmOurmdb.getContentPane().add(panelCelebs);
		
		final JPanel panelTop10 = new JPanel();
		panelTop10.setVisible(false);
		panelTop10.setBackground(new Color(210, 180, 140, 50));
		panelTop10.setBounds(0, 75, 550, 675);
		frmOurmdb.getContentPane().add(panelTop10);
		panelTop10.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 550, 675);
		panelTop10.add(scrollPane);
		
		JPanel panelTop10Scroll = new JPanel();
		panelTop10Scroll.setBackground(new Color(30, 144, 255));
		panelTop10Scroll.setLayout(new WrapLayout());
		panelTop10Scroll.setBounds(0, 0, 10, 10);
		
		Top10Component temp = new Top10Component(1, "YüzüklerinEdendisi", 8.5, panelTop10Scroll);
		temp = new Top10Component(3, "Inception", 4.5, panelTop10Scroll);
		temp = new Top10Component(3, "Inception", 4.5, panelTop10Scroll);
		temp = new Top10Component(3, "Inception", 4.5, panelTop10Scroll);
		temp = new Top10Component(3, "Inception", 4.5, panelTop10Scroll);
		temp = new Top10Component(3, "Inception", 4.5, panelTop10Scroll);
		temp = new Top10Component(3, "Inception", 4.5, panelTop10Scroll);
		temp = new Top10Component(3, "Inception", 4.5, panelTop10Scroll);
		temp = new Top10Component(3, "Inception", 4.5, panelTop10Scroll);
		temp = new Top10Component(3, "Inception", 4.5, panelTop10Scroll);
		temp = new Top10Component(3, "Inception", 4.5, panelTop10Scroll);
		temp = new Top10Component(3, "Inception", 4.5, panelTop10Scroll);
		temp = new Top10Component(3, "Inception", 4.5, panelTop10Scroll);
		temp = new Top10Component(3, "Inception", 4.5, panelTop10Scroll);
		temp = new Top10Component(3, "Inception", 4.5, panelTop10Scroll);
		temp = new Top10Component(3, "Inception", 4.5, panelTop10Scroll);
		
		
		
		scrollPane.add(panelTop10Scroll);
		scrollPane.setViewportView(panelTop10Scroll);
		
		final JPanel panelUser = new JPanel();
		panelUser.setVisible(false);
		panelUser.setBackground(new Color(106, 90, 205, 50));
		panelUser.setBounds(0, 75, 550, 675);
		frmOurmdb.getContentPane().add(panelUser);
		
		JButton btnHome = new JButton("");
		btnHome.setBackground(UIManager.getColor("CheckBox.light"));
		btnHome.setIcon(new ImageIcon("C:\\Users\\SadneS\\Desktop\\Button Png\\home.png"));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelHome.setVisible(true);
				panelMovies.setVisible(false);
				panelCelebs.setVisible(false);
				panelTop10.setVisible(false);
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
				panelTop10.setVisible(false);
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
				panelTop10.setVisible(false);
			}
		});
		btnCelebs.setBounds(112, 8, 52, 26);
		panelTop.add(btnCelebs);
		
		JButton btnTop50 = new JButton("");
		btnTop50.setBackground(UIManager.getColor("CheckBox.light"));
		btnTop50.setIcon(new ImageIcon("C:\\Users\\SadneS\\Desktop\\Button Png\\Top50.png"));
		btnTop50.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Top10Component.Id = 0;
				panelHome.setVisible(false);
				panelMovies.setVisible(false);
				panelCelebs.setVisible(false);
				panelTop10.setVisible(true);
			}
		});
		btnTop50.setBounds(165, 8, 50, 26);
		panelTop.add(btnTop50);
		
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
		
		textFieldId = new JTextField("ID");
		//textFieldId.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		//textFieldId.setBackground(new Color(255, 255, 255, 80));
		textFieldId.setFont(new Font("Tahoma", Font.ITALIC, 11));
		textFieldId.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if(textFieldId.getText().equals("")){
					//textFieldId.setFont(new Font("Tahoma", Font.ITALIC, 11));
					textFieldId.setText("ID");
				}
			}
		});
		textFieldId.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(textFieldId.getText().equals("ID")){
					//panelTop.setVisible(false);
					//textFieldId.setFont(new Font("Tahoma", Font.BOLD, 11));
					textFieldId.setText("");
					//panelTop.setVisible(true);
				}
			}
		});
		textFieldId.setBounds(20, 1, 86, 18);
		panelUnLogin.add(textFieldId);
		textFieldId.setColumns(10);
		
		textFieldPw = new JPasswordField("......");
		//textFieldPw.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		//textFieldPw.setBackground(new Color(255, 255, 255, 80));
		textFieldPw.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if(textFieldPw.getText().equals("")){
					textFieldPw.setText("......");
				}
			}
		});
		textFieldPw.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(textFieldPw.getText().equals("......")){
					textFieldPw.setText("");
				}
			}
		});
		textFieldPw.setBounds(20, 22, 86, 18);
		panelUnLogin.add(textFieldPw);
		textFieldPw.setEchoChar('•');
		textFieldPw.setColumns(10);
		
		JButton btnLogin = new JButton("");
		btnLogin.setBounds(117, 10, 44, 26);
		panelUnLogin.add(btnLogin);
		btnLogin.setIcon(new ImageIcon("C:\\Users\\SadneS\\Desktop\\Button Png\\login.png"));
		
		JButton btnRegister = new JButton("");
		btnRegister.setBounds(165, 10, 64, 26);
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
		lblWelcome.setForeground(new Color(0, 0, 0));
		lblWelcome.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 13));
		lblWelcome.setBounds(30, 5, 122, 19);
		panelLogined.add(lblWelcome);
		
		final JLabel lblUser = new JLabel("User");
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setForeground(new Color(0, 0, 0));
		lblUser.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 13));
		lblUser.setBounds(30, 25, 116, 19);
		panelLogined.add(lblUser);
		
		final JButton btnProfile = new JButton("");
		btnProfile.setIcon(new ImageIcon("C:\\Users\\SadneS\\Desktop\\Button Png\\profile.png"));
		btnProfile.setVisible(false);
		btnProfile.setBounds(294, 8, 52, 26);
		panelTop.add(btnProfile);
		
		JLabel labelDrag = new JLabel("     OurIMDb");
		
		labelDrag.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 13));
		labelDrag.setForeground(new Color(0, 0, 0));
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
		
		JPanel panelBackground = new JPanel();
		panelBackground.setBackground(new Color(30,144,255));
		/*Background image*/
		/*JPanel panelBackground = new JPanel(){
			public void paintComponent(Graphics g){
				ImageIcon icon = new ImageIcon("C:\\Users\\SadneS\\Desktop\\Button Png\\back.jpg");
				Image i = icon.getImage();
				
				g.drawImage(i, 0, 0, this.getSize().width, this.getSize().height, this);
			}
		};*/
		panelBackground.setBounds(0, 0, 550, 750);
		frmOurmdb.getContentPane().add(panelBackground);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if("aa".equals(textFieldId.getText()) && "123".equals(textFieldPw.getText())){
					//JOptionPane.showMessageDialog(null, "Welcome " + textFieldId.getText() + "!");
					panelTop.setVisible(false);
					panelUnLogin.setVisible(false);
					panelLogined.setVisible(true);
					btnWatchList.setEnabled(true);
					btnProfile.setVisible(true);
					panelTop.setVisible(true);
					
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
