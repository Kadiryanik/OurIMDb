import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import com.mysql.jdbc.Statement;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;

import java.awt.SystemColor;
import java.awt.Toolkit;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Window.Type;
import java.awt.Frame;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.MouseMotionAdapter;
import java.awt.font.TextAttribute;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLClientInfoException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Cursor;
import javax.swing.JScrollPane;

import java.awt.FlowLayout;
import javax.swing.JTabbedPane;
import java.awt.Dimension;
import javax.swing.ScrollPaneConstants;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


//final JOptionPane pane = new JOptionPane("Hello");
//final JDialog d = pane.createDialog(null, "Title");
//d.setLocationRelativeTo(frmOurmdb);
//d.setVisible(true);

public class MainForm {
	
	private JFrame frmOurmdb;
	private JTextField textFieldId;
	private JPasswordField textFieldPw;
	
	private static int loggedUserId;
	private static boolean isLogined;
	
	public static String staticMovieId;
	
	public int xMouse;
	public int yMouse;
	private JTextField textFieldYourName;
	private JTextField textFieldEmail;
	private JPasswordField passwordFieldPass;
	private JPasswordField passwordFieldPassA;
	private int limitValueLeft;	  //For celebs Pages
	private int howManyComponent; //For celebs Pages
	private int celebSorting; /* -1 default , 0 A-Z , 1 Birthday */
	
	//OtherClass references
	public static JFrame refFrmOurmdb;
	public static JPanel refPanelEachOne;
	public static JPanel refPanelTop;	
	public static JPanel refPanelHome;
	public static JPanel refPanelMovies;
	public static JPanel refPanelCelebs;
	public static JPanel refPanelTop10;
	public static JPanel refPanelUser;
	public static JPanel refPanelWatchlist;
	public static JPanel refPanelRegister;
	public static JLabel refLabelTurnHome;
	public static JLabel refLabelturnHomeD;
	
	private JTextField textFieldSearch;
	
	public static void main(String[] args) {
		NativeInterface.open();
		
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
		NativeInterface.runEventPump();
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable(){
			@Override
			public void run(){
				NativeInterface.close();
			}
		}));
	}
	
	public MainForm() {
		howManyComponent = 20;
		limitValueLeft = 0;
		loggedUserId = -1;
		celebSorting = -1;
		isLogined = false;
		initialize();
	}
	public static int getLoggedUserId(){
		return loggedUserId;
	}
	public static boolean getIsLogined(){
		return isLogined;
	}
	
	//Hash md5 method
	public String getHash(String passStr){
		return ("" + passStr.hashCode());
	}

	private void initialize() {
		frmOurmdb = new JFrame();
		frmOurmdb.setResizable(false);
		frmOurmdb.setUndecorated(true);
		frmOurmdb.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Workplace\\OurIMDb\\Design\\Button Png\\icon.png"));
		frmOurmdb.setTitle("OurIMDb");
		frmOurmdb.setBackground(Color.LIGHT_GRAY);
		frmOurmdb.getContentPane().setBackground(SystemColor.scrollbar);
		frmOurmdb.setBounds(100, 100, 550, 750);
		frmOurmdb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOurmdb.getContentPane().setLayout(null);
		//center JFrame depend screen size
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frmOurmdb.setLocation(dim.width/2-frmOurmdb.getSize().width/2, dim.height/2-frmOurmdb.getSize().height/2);
		//reference
		refFrmOurmdb = frmOurmdb;
		
		boolean NewMovieIn = false;
		if(NewMovieIn){	
			String movieQuery = "SELECT movieId FROM Movie";
			ArrayList<Movie> movieList = SqlOperations.getMovie(movieQuery);
			
			String[] movieIds = new String[movieList.size()];
			for(int i = 0; i < movieIds.length; i++){
				movieIds[i] = movieList.get(i).getMovieId();
			}
			
			SqlOperations.postMovieImage("C:\\Workplace\\OurIMDb\\DB\\MovieOriginalImages");
			
			for(int i = 0; i < movieIds.length; i++){
				staticMovieId = movieIds[i];
				System.out.println(staticMovieId);
				SqlOperations.postPeopleImage("C:\\Workplace\\OurIMDb\\DB\\PeopleMinimizedImages");	
			}
		}
		
		final JButton btnWatchList = new JButton("");
		btnWatchList.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		JButton btnLogin = new JButton("");
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		final JLabel labelExit = new JLabel("");
		labelExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmOurmdb.getContentPane().removeAll();
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				labelExit.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\exitA.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				labelExit.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\exit.png"));
			}
		});

		//------------------------------------------
		final JPanel panelEachOne = new JPanel();
		refPanelEachOne = panelEachOne;
		panelEachOne.setVisible(false);
		panelEachOne.setBackground(Color.BLACK);
		panelEachOne.setBounds(0, 24, 550, 726);
		panelEachOne.setLayout(null);
		frmOurmdb.getContentPane().add(panelEachOne);
		
		//labelExit
		labelExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labelExit.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\exit.png"));
		labelExit.setBounds(510, 0, 24, 24);
		frmOurmdb.getContentPane().add(labelExit);
		
		JLabel labelIcon = new JLabel("");
		labelIcon.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\Logo.png"));
		labelIcon.setBounds(0, 0, 50, 24);
		labelIcon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labelIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				final JOptionPane pane = new JOptionPane("This program developed by\n   Çaðatay Avþar and Kadir Yanýk",
						JOptionPane.INFORMATION_MESSAGE);
				final JDialog jDialog = pane.createDialog(
				        null, 
				        "About");
				jDialog.setLocationRelativeTo(frmOurmdb);
				jDialog.setVisible(true);
			}
		});
		frmOurmdb.getContentPane().add(labelIcon);
		
		/*Panels Inýt*/
		final JPanel panelTop = new JPanel();
		refPanelTop = panelTop;
		panelTop.setBackground(new Color(255, 255, 255, 0));
		panelTop.setBounds(0, 25, 550, 45);
		frmOurmdb.getContentPane().add(panelTop);
		panelTop.setLayout(null);
	
		final JPanel panelHome = new JPanel();
		refPanelHome = panelHome;
		panelHome.setBackground(UIManager.getColor("Button.shadow"));
		panelHome.setBounds(0, 75, 550, 675);
		frmOurmdb.getContentPane().add(panelHome);
		panelHome.setLayout(null);
		
		final JPanel panelMovies = new JPanel();
		refPanelMovies = panelMovies;
		panelMovies.setVisible(false);
		panelMovies.setBackground(UIManager.getColor("windowBorder"));
		panelMovies.setBounds(0, 75, 550, 675);
		frmOurmdb.getContentPane().add(panelMovies);
		panelMovies.setLayout(null);
		
		final JPanel panelRegister = new JPanel();
		refPanelRegister = panelRegister;
		panelRegister.setBackground(Color.WHITE);
		panelRegister.setVisible(false);
		panelRegister.setBounds(0, 75, 550, 675);
		frmOurmdb.getContentPane().add(panelRegister);
		panelRegister.setLayout(null);
	
		final JPanel panelCelebs = new JPanel();
		refPanelCelebs = panelCelebs;
		panelCelebs.setVisible(false);
		panelCelebs.setBackground(new Color(30, 144, 255));
		panelCelebs.setBounds(0, 75, 550, 675);
		panelCelebs.setLayout(null);
		frmOurmdb.getContentPane().add(panelCelebs);
		
		final JPanel panelTop10 = new JPanel();
		refPanelTop10 = panelTop10;
		panelTop10.setVisible(false);
		panelTop10.setBackground(Color.CYAN);
		panelTop10.setBounds(0, 75, 550, 675);
		frmOurmdb.getContentPane().add(panelTop10);
		panelTop10.setLayout(null);
		
		final JPanel panelUser = new JPanel();
		refPanelUser = panelUser;
		panelUser.setBounds(0, 75, 550, 675);
		panelUser.setVisible(false);
		panelUser.setBackground(new Color(106, 90, 205, 50));
		panelUser.setLayout(null);
		frmOurmdb.getContentPane().add(panelUser);
		
		final JPanel panelWatchList = new JPanel();
		refPanelWatchlist = panelWatchList;
		
		final JPanel panelUnLogin = new JPanel();
		panelUnLogin.setBackground(new Color(255, 255, 255, 0));
		panelUnLogin.setBounds(309, 0, 240, 45);
		panelTop.add(panelUnLogin);
		panelUnLogin.setLayout(null);
		
		final JPanel panelLogined = new JPanel();
		final JLabel lblUser = new JLabel("User");
		
		textFieldId = new JTextField("ID");
		textFieldId.setFocusTraversalKeysEnabled(false);
		textFieldId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar() == e.VK_TAB){
					textFieldPw.requestFocusInWindow();
					textFieldPw.setText("");
				}
				if(e.getKeyChar() == e.VK_ENTER){
					String userQuery = "SELECT * FROM Users WHERE uDisplayName = '" + textFieldId.getText() + "'";
					ArrayList<UserClass> userInfo = SqlOperations.getUserInfo(userQuery);
					if(userInfo.size() != 0){
						if(getHash(textFieldPw.getText()).equals(userInfo.get(0).getuPassword())){
							panelTop.setVisible(false);
							panelUnLogin.setVisible(false);
							panelLogined.setVisible(true);
							btnWatchList.setEnabled(true);
							panelTop.setVisible(true);
							lblUser.setText(textFieldId.getText());
							textFieldId.setText("");
							textFieldPw.setText("");
							
							isLogined = true;
							loggedUserId = userInfo.get(0).getUserId();
							
							new HomePageClass(panelHome);
							panelHome.setVisible(true);
						}
						else{
							textFieldPw.setText("");
							final JOptionPane pane = new JOptionPane("Password wrong!",
									JOptionPane.ERROR_MESSAGE);
							final JDialog jDialog = pane.createDialog(
							        null, 
							        "Upss!");
							jDialog.setLocationRelativeTo(frmOurmdb);
							jDialog.setVisible(true);
						}
					}
					else{
						textFieldPw.setText("......");
						textFieldId.setText("ID");
						final JOptionPane pane = new JOptionPane("User Name or Password wrong!",
								JOptionPane.ERROR_MESSAGE);
						final JDialog jDialog = pane.createDialog(
						        null, 
						        "Upss!");
						jDialog.setLocationRelativeTo(frmOurmdb);
						jDialog.setVisible(true);
					}
					
				}
			}
		});
		textFieldId.setFont(new Font("Tahoma", Font.ITALIC, 11));
		textFieldId.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if(textFieldId.getText().equals("")){
					textFieldId.setText("ID");
				}
			}
		});
		textFieldId.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(textFieldId.getText().equals("ID")){
					textFieldId.setText("");
				}
			}
		});
		textFieldId.setBounds(20, 1, 86, 18);
		panelUnLogin.add(textFieldId);
		textFieldId.setColumns(10);
		
		textFieldPw = new JPasswordField("......");
		textFieldPw.setFocusTraversalKeysEnabled(false);
		textFieldPw.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar() == e.VK_TAB){
					textFieldId.requestFocusInWindow();
					if(textFieldId.getText().equals("ID")){
							textFieldId.setText("");
					}
				}
				if(e.getKeyChar() == e.VK_ENTER){
					String userQuery = "SELECT * FROM Users WHERE uDisplayName = '" + textFieldId.getText() + "'";
					ArrayList<UserClass> userInfo = SqlOperations.getUserInfo(userQuery);
					if(userInfo.size() != 0){
						if(getHash(textFieldPw.getText()).equals(userInfo.get(0).getuPassword())){
							panelTop.setVisible(false);
							panelUnLogin.setVisible(false);
							panelLogined.setVisible(true);
							btnWatchList.setEnabled(true);
							panelTop.setVisible(true);
							
							lblUser.setText(textFieldId.getText());
							textFieldId.setText("");
							textFieldPw.setText("");
							
							isLogined = true;
							loggedUserId = userInfo.get(0).getUserId();
							
							new HomePageClass(panelHome);
							panelHome.setVisible(true);
						}
						else{
							textFieldPw.setText("");
							final JOptionPane pane = new JOptionPane("Password wrong!",
									JOptionPane.ERROR_MESSAGE);
							final JDialog jDialog = pane.createDialog(
							        null, 
							        "Upss!");
							jDialog.setLocationRelativeTo(frmOurmdb);
							jDialog.setVisible(true);
						}
					}
					else{
						textFieldPw.setText("......");
						textFieldId.setText("ID");
						final JOptionPane pane = new JOptionPane("User Name or Password wrong!",
								JOptionPane.ERROR_MESSAGE);
						final JDialog jDialog = pane.createDialog(
						        null, 
						        "Upss!");
						jDialog.setLocationRelativeTo(frmOurmdb);
						jDialog.setVisible(true);
					}
				}
			}
		});
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
		
		//panelLogined
		panelLogined.setVisible(false);
		panelLogined.setBackground(new Color(255, 255, 255, 0));
		panelLogined.setBounds(381, 0, 168, 45);
		panelTop.add(panelLogined);
		panelLogined.setLayout(null);
		
		
		//lblUser
		lblUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				/*UserPage Init*/
				panelUser.removeAll();
				new UserPageClass(loggedUserId, panelUser);
				
				panelRegister.setVisible(false);
				panelWatchList.setVisible(false);
				panelHome.setVisible(false);
				panelMovies.setVisible(false);
				panelCelebs.setVisible(false);
				panelTop10.setVisible(false);
				panelUser.setVisible(true);
			}
		});
		
		JLabel lblWelcome = new JLabel("Welcome ");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setForeground(new Color(0, 0, 0));
		lblWelcome.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 13));
		lblWelcome.setBounds(0, 5, 168, 19);
		panelLogined.add(lblWelcome);
		lblUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setForeground(new Color(0, 0, 0));
		lblUser.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 13));
		lblUser.setBounds(0, 25, 110, 19);
		panelLogined.add(lblUser);
		
		final JLabel lblLogOut = new JLabel("LogOut");
		lblLogOut.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 13));
		lblLogOut.setForeground(new Color(0, 0, 0));
		lblLogOut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelTop.setVisible(false);
				panelUnLogin.setVisible(true);
				panelLogined.setVisible(false);
				btnWatchList.setEnabled(false);
				panelUser.setVisible(false);
				panelTop.setVisible(true);
				panelHome.setVisible(true);
				
				textFieldId.setText("ID");
				textFieldPw.setText("......");
				
				isLogined = false;
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
		lblLogOut.setBounds(115, 25, 50, 19);
		panelLogined.add(lblLogOut);
		
		/*EndOf Panel Inýt*/
		
		
		//Back Button 
		final JLabel lblturnHomeD = new JLabel("");
		refLabelturnHomeD = lblturnHomeD;
		final JLabel lblTurnHome = new JLabel("");
		refLabelTurnHome = lblTurnHome;
		
		lblTurnHome.setVisible(false);
		lblTurnHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblTurnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panelEachOne.removeAll();
				new HomePageClass(panelHome);
				
				lblTurnHome.setVisible(false);
				lblturnHomeD.setVisible(true);
				panelTop.setVisible(true);
				panelEachOne.setVisible(false);
				panelHome.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblTurnHome.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\turnHomeA.png"));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblTurnHome.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\turnHome.png"));
			}
		});
		
		
		lblturnHomeD.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\turnHomeDA.png"));
		lblturnHomeD.setBounds(480, 0, 24, 24);
		frmOurmdb.getContentPane().add(lblturnHomeD);
		lblTurnHome.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\turnHome.png"));
		lblTurnHome.setBounds(480, 0, 24, 24);
		frmOurmdb.getContentPane().add(lblTurnHome);
		//End Back Button 
		
		//SearchField 
		final JLabel lblSearch = new JLabel("");
		lblSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblSearch.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\SearchButtonA.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblSearch.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\SearchButton.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!textFieldSearch.getText().equals("")){
					lblturnHomeD.setVisible(false);
					panelTop.setVisible(false);
					panelHome.setVisible(false);
					panelCelebs.setVisible(false);
					panelTop10.setVisible(false);
					panelUser.setVisible(false);
					panelRegister.setVisible(false);
					panelEachOne.setVisible(false);
					panelWatchList.setVisible(false);
					panelTop.setVisible(false);
					panelEachOne.removeAll();
					panelEachOne.setVisible(false);
					new SearchResult(textFieldSearch.getText(), panelEachOne);
					textFieldSearch.setText("");
					panelEachOne.setVisible(true);
					lblTurnHome.setVisible(true);
				}
			}
		});
		lblSearch.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\SearchButton.png"));
		lblSearch.setBounds(450, 0, 24, 24);
		frmOurmdb.getContentPane().add(lblSearch);
		
		final JLabel lblRight = new JLabel("");
		lblRight.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		final JLabel lblLeft = new JLabel("");
		lblLeft.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLeft.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblLeft.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\SearchLeftA.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblLeft.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\SearchLeft.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				lblLeft.setVisible(false);
				textFieldSearch.setVisible(true);
				lblRight.setVisible(true);
			}
		});
		lblLeft.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\SearchLeft.png"));
		lblLeft.setBounds(442, 0, 8, 24);
		frmOurmdb.getContentPane().add(lblLeft);
		
		//lblRight
		lblRight.setVisible(false);
		lblRight.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblRight.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\SearchRightA.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblRight.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\SearchRight.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldSearch.setVisible(false);
				lblRight.setVisible(false);
				lblLeft.setVisible(true);
			}
		});
		lblRight.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\SearchRight.png"));
		lblRight.setBounds(125, 0, 8, 24);
		frmOurmdb.getContentPane().add(lblRight);
		
		textFieldSearch = new JTextField();
		textFieldSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyChar() == arg0.VK_ENTER){
					lblturnHomeD.setVisible(false);
					panelTop.setVisible(false);
					panelHome.setVisible(false);
					panelCelebs.setVisible(false);
					panelTop10.setVisible(false);
					panelUser.setVisible(false);
					panelRegister.setVisible(false);
					panelEachOne.setVisible(false);
					panelWatchList.setVisible(false);
					panelTop.setVisible(false);
					panelEachOne.removeAll();
					panelEachOne.setVisible(false);
					new SearchResult(textFieldSearch.getText(), panelEachOne);
					textFieldSearch.setText("");
					panelEachOne.setVisible(true);
					lblTurnHome.setVisible(true);
				}
			}
		});
		textFieldSearch.setVisible(false);
		textFieldSearch.setBounds(132, 0, 320, 25);
		frmOurmdb.getContentPane().add(textFieldSearch);
		textFieldSearch.setColumns(10);
		//SearchField End
		
		
		JLabel labelDrag = new JLabel("         OurIMDb");
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
		
		//panelWatchList
		panelWatchList.setBounds(0, 75, 550, 675);
		frmOurmdb.getContentPane().add(panelWatchList);
		panelWatchList.setLayout(null);
		
		//labelDrag
		labelDrag.setBounds(0, 0, 550, 24);
		frmOurmdb.getContentPane().add(labelDrag);
		
		/*-------------------------------Buttons-------------------------------*/
		
		JButton btnHome = new JButton("");
		btnHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHome.setBackground(UIManager.getColor("CheckBox.light"));
		btnHome.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\home.png"));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelHome.removeAll();
				new HomePageClass(panelHome);
				
				panelHome.setVisible(true);
				panelMovies.setVisible(false);
				panelCelebs.setVisible(false);
				panelTop10.setVisible(false);
				panelUser.setVisible(false);
				panelRegister.setVisible(false);
				panelEachOne.setVisible(false);
				panelWatchList.setVisible(false);
			}
		});
		btnHome.setBounds(10, 8, 46, 26);
		panelTop.add(btnHome);
		
		JButton btnMovies = new JButton("");
		btnMovies.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMovies.setBackground(UIManager.getColor("CheckBox.light"));
		btnMovies.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\movies.png"));
		btnMovies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMovies.removeAll();
				MovieTabComponents.Id = 0;
				//Movies Init
				JPanel panelInTheaters = new JPanel();
				panelInTheaters.setLayout(new WrapLayout(FlowLayout.CENTER, 0, 5));
				panelInTheaters.setBackground(Color.GRAY);
				
				JPanel panelComingSoon = new JPanel();
				panelComingSoon.setLayout(new WrapLayout(FlowLayout.CENTER, 0, 5));
				panelComingSoon.setBackground(Color.LIGHT_GRAY);
			
				JScrollPane scrollPaneInThe = new JScrollPane();
				scrollPaneInThe.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				scrollPaneInThe.setBounds(0, 0, 550, 675);
				scrollPaneInThe.add(panelInTheaters);
				scrollPaneInThe.setViewportView(panelInTheaters);
				
				JScrollPane scrollPaneComing = new JScrollPane();
				scrollPaneComing.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				scrollPaneComing.setBounds(0, 0, 550, 675);
				scrollPaneComing.add(panelComingSoon);
				scrollPaneComing.setViewportView(panelComingSoon);
				
				JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
				tabbedPane.setBackground(new Color(245, 245, 245));
				tabbedPane.setBounds(0, 0, 550, 675);
				tabbedPane.addTab("In Theaters", scrollPaneInThe);
				tabbedPane.addTab("Coming Soon", scrollPaneComing);
				panelMovies.add(tabbedPane);
				//EndOf-Movies Init
				panelMovies.setVisible(false);
				
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				timestamp.setHours(timestamp.getHours() + 1);
				Timestamp timestampTwoWeekEarlier = new Timestamp(System.currentTimeMillis());
				timestampTwoWeekEarlier.setDate(timestamp.getDay() - 14);
				String movieQueryInTheaters = "SELECT movieId FROM Movie WHERE mDate < '" + timestamp.toString().substring(0, 10) 
						+ "' AND mDate > '" + timestampTwoWeekEarlier.toString().substring(0, 10) + "'";
				ArrayList<Movie> movieList = SqlOperations.getMovie(movieQueryInTheaters);
				for(int i = 0; i < movieList.size(); i++){
					new MovieTabComponents(movieList.get(i).getMovieId(), panelInTheaters);
				}
				
				Timestamp timestampTwoWeekLater = new Timestamp(System.currentTimeMillis());
				timestampTwoWeekLater.setDate(timestamp.getDay() + 14);
				String movieQueryComingSoon = "SELECT movieId FROM Movie WHERE mDate > '" + timestamp.toString().substring(0, 10) 
						+ "' AND mDate < '" + timestampTwoWeekLater.toString().substring(0, 10) + "'";
				ArrayList<Movie> movieListComingSoon = SqlOperations.getMovie(movieQueryComingSoon);
				for(int i = 0; i < movieListComingSoon.size(); i++){
					new MovieTabComponents(movieListComingSoon.get(i).getMovieId(), panelComingSoon);
				}
				
				panelHome.setVisible(false);
				panelCelebs.setVisible(false);
				panelTop10.setVisible(false);
				panelUser.setVisible(false);
				panelRegister.setVisible(false);
				panelMovies.setVisible(true);
				panelEachOne.setVisible(false);
				panelWatchList.setVisible(false);
			}
		});
		btnMovies.setBounds(57, 8, 54, 26);
		panelTop.add(btnMovies);
		
		JButton btnCelebs = new JButton("");
		btnCelebs.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCelebs.setBackground(UIManager.getColor("CheckBox.light"));
		btnCelebs.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\celebs.png"));
		btnCelebs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*Celebs Inýt*/
				CelebsComponent.Id = 0;
				limitValueLeft = 0;
				celebSorting = -1;
				final int peopleCount = SqlOperations.getPeopleCount();
				
				panelCelebs.removeAll();
				final JPanel panelCelebsTop = new JPanel();
				panelCelebsTop.setBackground(new Color(248, 248, 248));
				panelCelebsTop.setBounds(0, 0, 550, 53);
				panelCelebs.add(panelCelebsTop);
				panelCelebsTop.setLayout(null);

				JScrollPane scrollPaneContent = new JScrollPane();
				scrollPaneContent.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				scrollPaneContent.setBounds(0, 53, 550, 622);
				panelCelebs.add(scrollPaneContent);
				
				final JPanel panelCelebsContents= new JPanel();
				panelCelebsContents.setBackground(new Color(248, 248, 248));
				panelCelebsContents.setLayout(new WrapLayout(FlowLayout.CENTER, 10, 5));
				panelCelebsContents.setBounds(0, 0, 10, 10);
				scrollPaneContent.add(panelCelebsContents);
				scrollPaneContent.setViewportView(panelCelebsContents);

				//String celebQuery = "SELECT peopleId,pTitle,pDescription FROM People";
				//final ArrayList<People> celebList = SqlOperations.getPeople(celebQuery);
				final JLabel lblPage = new JLabel("Page: " + (limitValueLeft/howManyComponent+1) + " of " + ((peopleCount-1)/howManyComponent+1));
				lblPage.setBounds(291, 32, 150, 14);
				panelCelebsTop.add(lblPage);
				
				JLabel lblSortBy = new JLabel("Sort by: ");
				lblSortBy.setBounds(205, 5, 46, 14);
				panelCelebsTop.add(lblSortBy);
				
				JLabel lblAz = new JLabel("A-Z,");
				lblAz.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						panelCelebs.setVisible(false);
						panelCelebsContents.removeAll();
						limitValueLeft = 0;
						celebSorting = 0;
						CelebsComponent.Id = 0;
						String celebQuery = "SELECT peopleId,pTitle,pDescription FROM People ORDER BY pTitle "
								+ "LIMIT " + howManyComponent + " OFFSET " + limitValueLeft;
						ArrayList<People> celebList = SqlOperations.getPeople(celebQuery);
						if(celebList.size() > howManyComponent-1){
							for(int i = 0; i < howManyComponent; i++){
								new CelebsComponent(celebList.get(i).getPeopleId(), celebList.get(i).getpTitle(), 
										celebList.get(i).getpDescription(), panelCelebsContents);
							}
						}
						else{
							for(int i = 0; i < peopleCount; i++){
								new CelebsComponent(celebList.get(i).getPeopleId(), celebList.get(i).getpTitle(), 
										celebList.get(i).getpDescription(), panelCelebsContents);
							}
						}
						lblPage.setText("Page: " + (limitValueLeft/howManyComponent+1) + " of " + ((peopleCount-1)/howManyComponent+1));
						panelCelebs.setVisible(true);
					}
				});
				lblAz.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lblAz.setBounds(261, 5, 26, 14);
				panelCelebsTop.add(lblAz);
				
				JLabel lblBirthDate = new JLabel("Birth Date");
				lblBirthDate.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						panelCelebs.setVisible(false);
						panelCelebsContents.removeAll();
						limitValueLeft = 0;
						CelebsComponent.Id = 0;
						celebSorting = 1;
						String celebQuery = "SELECT peopleId,pTitle,pDescription FROM People ORDER BY pBirthday "
								+ "LIMIT " + howManyComponent + " OFFSET " + limitValueLeft;
						ArrayList<People> celebList = SqlOperations.getPeople(celebQuery);
						
						if(celebList.size() > howManyComponent-1){
							for(int i = 0; i < howManyComponent; i++){
								new CelebsComponent(celebList.get(i).getPeopleId(), celebList.get(i).getpTitle(), 
										celebList.get(i).getpDescription(), panelCelebsContents);
							}
						}
						else{
							for(int i = 0; i < peopleCount; i++){
								new CelebsComponent(celebList.get(i).getPeopleId(), celebList.get(i).getpTitle(), 
										celebList.get(i).getpDescription(), panelCelebsContents);
							}
						}
						lblPage.setText("Page: " + (limitValueLeft/howManyComponent+1) + " of " + ((peopleCount-1)/howManyComponent+1));
						panelCelebs.setVisible(true);
					}
				});
				lblBirthDate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lblBirthDate.setBounds(296, 5, 56, 14);
				panelCelebsTop.add(lblBirthDate);
				
				JLabel lblLine = new JLabel("");
				lblLine.setBounds(25, 24, 500, 2);
				lblLine.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\line.png"));
				panelCelebsTop.add(lblLine);
				
				JLabel lblTotalNames = new JLabel("Total Names: " + peopleCount);
				lblTotalNames.setBounds(180, 32, 125, 14);
				panelCelebsTop.add(lblTotalNames);
				
				final JLabel lblPrev = new JLabel("<< PreviusPage");
				lblPrev.setBounds(10, 32, 85, 14);
				lblPrev.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
				lblPrev.setForeground(new Color(150,90,240));
				lblPrev.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lblPrev.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						Font font = lblPrev.getFont();
						Map attributes = font.getAttributes();
						attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
						lblPrev.setFont(font.deriveFont(attributes));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						lblPrev.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
					}
					@Override
					public void mouseClicked(MouseEvent e) {
						int highLimit;
						//prev page olmadýðý koþul
						if(limitValueLeft - howManyComponent < 0){
							CelebsComponent.Id = 0;
							//bi sonraki sayfaya geçmeyecek 
							if(peopleCount < howManyComponent){
								highLimit = peopleCount;
							}else{
								highLimit = howManyComponent;
							}
							System.out.println("prev Page yok");
						}else{
							//For delete before celebs
							panelCelebsContents.removeAll();
							
							highLimit = limitValueLeft;
							limitValueLeft -= howManyComponent;
							CelebsComponent.Id = limitValueLeft;
							if(celebSorting == 0){
								String celebQuery = "SELECT peopleId,pTitle,pDescription FROM People ORDER BY pTitle "
										+ "LIMIT " + howManyComponent + " OFFSET " + limitValueLeft;
								ArrayList<People> celebList = SqlOperations.getPeople(celebQuery);
								
								for(int i = 0; i < celebList.size(); i++){
									new CelebsComponent(celebList.get(i).getPeopleId(), celebList.get(i).getpTitle(), 
											celebList.get(i).getpDescription(), panelCelebsContents);
								}
								lblPage.setText("Page: " + (limitValueLeft/howManyComponent+1) + " of " + ((peopleCount-1)/howManyComponent+1));
							}
							else if(celebSorting == 1){
								String celebQuery = "SELECT peopleId,pTitle,pDescription FROM People ORDER BY pBirthday "
										+ "LIMIT " + howManyComponent + " OFFSET " + limitValueLeft;
								ArrayList<People> celebList = SqlOperations.getPeople(celebQuery);
								
								for(int i = 0; i < celebList.size(); i++){
									new CelebsComponent(celebList.get(i).getPeopleId(), celebList.get(i).getpTitle(), 
											celebList.get(i).getpDescription(), panelCelebsContents);
								}
								lblPage.setText("Page: " + (limitValueLeft/howManyComponent+1) + " of " + ((peopleCount-1)/howManyComponent+1));
							}
							else{
								String celebQuery = "SELECT peopleId,pTitle,pDescription FROM People LIMIT " + howManyComponent + " OFFSET " + limitValueLeft;
								ArrayList<People> celebList = SqlOperations.getPeople(celebQuery);
								
								for(int i = 0; i < celebList.size(); i++){
									new CelebsComponent(celebList.get(i).getPeopleId(), celebList.get(i).getpTitle(), 
											celebList.get(i).getpDescription(), panelCelebsContents);
								}
								lblPage.setText("Page: " + (limitValueLeft/howManyComponent+1) + " of " + ((peopleCount-1)/howManyComponent+1));
							}
						}
					
					}
				});
				panelCelebsTop.add(lblPrev);
				
				final JLabel lblNext = new JLabel("NextPage >>");
				lblNext.setBounds(470, 32, 70, 17);
				lblNext.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
				lblNext.setForeground(new Color(150,90,240));
				lblNext.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lblNext.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						Font font = lblNext.getFont();
						Map attributes = font.getAttributes();
						attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
						lblNext.setFont(font.deriveFont(attributes));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						lblNext.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
					}
					@Override
					public void mouseClicked(MouseEvent e) {
						int highLimit;
						//next page olmadýðý koþul
						if(limitValueLeft + howManyComponent > peopleCount){
							//bi sonraki sayfaya geçmeyecek 
							highLimit = limitValueLeft;
							System.out.println("Next Page yok");
						}else{
							
							//For delete before celebs
							panelCelebsContents.removeAll(); 
							limitValueLeft += howManyComponent;
							highLimit = limitValueLeft + howManyComponent;
							CelebsComponent.Id = limitValueLeft;
							if(highLimit > peopleCount){
								highLimit = peopleCount;
							}
							
							if(celebSorting == 0){
								String celebQuery = "SELECT peopleId,pTitle,pDescription FROM People ORDER BY pTitle "
										+ "LIMIT " + howManyComponent + " OFFSET " + limitValueLeft;
								ArrayList<People> celebList = SqlOperations.getPeople(celebQuery);
	
								for(int i = 0; i < celebList.size(); i++){
									new CelebsComponent(celebList.get(i).getPeopleId(), celebList.get(i).getpTitle(), 
											celebList.get(i).getpDescription(), panelCelebsContents);
								}
								lblPage.setText("Page: " + (limitValueLeft/howManyComponent+1) + " of " + ((peopleCount-1)/howManyComponent+1));
							}
							else if(celebSorting == 1){
								String celebQuery = "SELECT peopleId,pTitle,pDescription FROM People ORDER BY pBirthday "
										+ "LIMIT " + howManyComponent + " OFFSET " + limitValueLeft;
								ArrayList<People> celebList = SqlOperations.getPeople(celebQuery);
	
								for(int i = 0; i < celebList.size(); i++){
									new CelebsComponent(celebList.get(i).getPeopleId(), celebList.get(i).getpTitle(), 
											celebList.get(i).getpDescription(), panelCelebsContents);
								}
								lblPage.setText("Page: " + (limitValueLeft/howManyComponent+1) + " of " + ((peopleCount-1)/howManyComponent+1));
							}
							else{
								String celebQuery = "SELECT peopleId,pTitle,pDescription FROM People LIMIT " + howManyComponent + " OFFSET " + limitValueLeft;
								ArrayList<People> celebList = SqlOperations.getPeople(celebQuery);
								
								for(int i = 0; i < celebList.size(); i++){
									new CelebsComponent(celebList.get(i).getPeopleId(), celebList.get(i).getpTitle(), 
											celebList.get(i).getpDescription(), panelCelebsContents);
								}
								lblPage.setText("Page: " + (limitValueLeft/howManyComponent+1) + " of " + ((peopleCount-1)/howManyComponent+1));
							}
							
						}
					}
				});
				panelCelebsTop.add(lblNext);
				
				String celebQuery = "SELECT peopleId,pTitle,pDescription FROM People LIMIT " + howManyComponent + " OFFSET " + 0;
				ArrayList<People> celebList = SqlOperations.getPeople(celebQuery);
				
				if(celebList.size() > howManyComponent-1){
					for(int i = 0; i < howManyComponent; i++){
						new CelebsComponent(celebList.get(i).getPeopleId(), celebList.get(i).getpTitle(), 
								celebList.get(i).getpDescription(), panelCelebsContents);
					}
				}
				else{
					for(int i = 0; i < peopleCount; i++){
						new CelebsComponent(celebList.get(i).getPeopleId(), celebList.get(i).getpTitle(), 
								celebList.get(i).getpDescription(), panelCelebsContents);
					}
				}
				
				/*EndOF Celebs Inýt*/
				panelHome.setVisible(false);
				panelMovies.setVisible(false);
				panelCelebs.setVisible(true);
				panelTop10.setVisible(false);
				panelUser.setVisible(false);
				panelRegister.setVisible(false);
				panelEachOne.setVisible(false);
				panelWatchList.setVisible(false);
			}
		});
		btnCelebs.setBounds(112, 8, 52, 26);
		panelTop.add(btnCelebs);
		
		JButton btnTop10 = new JButton("");
		btnTop10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTop10.setBackground(UIManager.getColor("CheckBox.light"));
		btnTop10.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\Top50.png"));//TODO: change image
		btnTop10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Top10Component.Id = 0;
				/*Top10 Inýt*/
				panelTop10.removeAll();
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(0, 0, 550, 675);
				panelTop10.add(scrollPane);
				
				JPanel panelTop10Scroll = new JPanel();
				panelTop10Scroll.setBackground(new Color(245, 245, 245));
				panelTop10Scroll.setLayout(new WrapLayout(FlowLayout.CENTER, 10, 10));
				panelTop10Scroll.setBounds(0, 0, 10, 10);
				
				scrollPane.add(panelTop10Scroll);
				scrollPane.setViewportView(panelTop10Scroll);
				panelTop10.setVisible(false);
				/*EndOf Top10 Inýt*/
				String movieQuery = "SELECT movieId,mTitle,mRatingSum,mRatingCount FROM Movie ORDER BY mRatingSum/mRatingCount DESC";
				ArrayList<Movie> movieTop10List = SqlOperations.getMovie(movieQuery);

				for(int i = 0; i < movieTop10List.size(); i++){
					new Top10Component(movieTop10List.get(i).getMovieId(), movieTop10List.get(i).getmTitle(),
							movieTop10List.get(i).getmRatingSum()/movieTop10List.get(i).getmRatingCount(), panelTop10Scroll);
				}
				
				panelHome.setVisible(false);
				panelMovies.setVisible(false);
				panelCelebs.setVisible(false);
				panelTop10.setVisible(true);
				panelUser.setVisible(false);
				panelRegister.setVisible(false);
				panelEachOne.setVisible(false);
				panelWatchList.setVisible(false);
			}
		});
		btnTop10.setBounds(165, 8, 50, 26);
		panelTop.add(btnTop10);
		
		//btnWatchList
		btnWatchList.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\watchlist.png"));
		btnWatchList.setEnabled(false);
		btnWatchList.setVisible(true);
		btnWatchList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelWatchList.removeAll();
				final JPanel WatchScroll = new JPanel();

				JScrollPane scrollPaneWatch = new JScrollPane();
				scrollPaneWatch.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
				scrollPaneWatch.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panelWatchList.add(scrollPaneWatch);
				scrollPaneWatch.setBounds(0, 0, 550, 675);	
				
				scrollPaneWatch.add(WatchScroll);
				scrollPaneWatch.setViewportView(WatchScroll);
				WatchScroll.setLayout(new WrapLayout(FlowLayout.CENTER, 0, 1));
				
				final JPanel WatchScrollTop = new JPanel();
				WatchScrollTop.setBackground(new Color(238, 238, 238));
				WatchScroll.add(WatchScrollTop);
				
				
				
				JLabel lblYourwatchlist = new JLabel("YourWatchlist");
				lblYourwatchlist.setForeground(new Color(66, 66, 66));
				lblYourwatchlist.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
				
				//TODO: Link these ones with db
				JLabel lblWithname = new JLabel("Name");
				lblWithname.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
				
				JLabel lblSortBy = new JLabel("Sort by:");
				lblSortBy.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
				
				JLabel lblRating = new JLabel("Rating");
				lblRating.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
				
				JLabel lblYourRating = new JLabel("Your Rating");
				lblYourRating.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
				
				JLabel lblForSize = new JLabel("");
				GroupLayout gl_WatchScrollTop = new GroupLayout(WatchScrollTop);
				gl_WatchScrollTop.setHorizontalGroup(
					gl_WatchScrollTop.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_WatchScrollTop.createSequentialGroup()
							.addGap(549)
							.addComponent(lblForSize, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_WatchScrollTop.createSequentialGroup()
							.addGap(10)
							.addComponent(lblYourwatchlist, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_WatchScrollTop.createSequentialGroup()
							.addGap(10)
							.addComponent(lblSortBy, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblWithname, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(lblRating, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(lblYourRating))
				);
				gl_WatchScrollTop.setVerticalGroup(
					gl_WatchScrollTop.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_WatchScrollTop.createSequentialGroup()
							.addComponent(lblForSize, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblYourwatchlist, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addGroup(gl_WatchScrollTop.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSortBy, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblWithname, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblRating, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblYourRating, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)))
				);
				WatchScrollTop.setLayout(gl_WatchScrollTop);
				
				final JPanel WatchScrollContent = new JPanel();
				WatchScroll.add(WatchScrollContent);
				WatchScrollContent.setLayout(new WrapLayout(FlowLayout.CENTER, 5, 2));
				
				String movieQuery = "SELECT movieId, mTitle from Movie,WatchList WHERE fkMovieid = movieId AND "
						+ "fkUserId = " + loggedUserId + " ORDER BY addedTime DESC";
				ArrayList<Movie> watchList = SqlOperations.getMovie(movieQuery);
				for(int i = 0; i < watchList.size(); i++){
					new WatchlistComponent(loggedUserId, watchList.get(i).getMovieId(), WatchScrollContent);
				}
				
				
				panelHome.setVisible(false);
				panelMovies.setVisible(false);
				panelCelebs.setVisible(false);
				panelTop10.setVisible(false);
				panelUser.setVisible(false);
				panelRegister.setVisible(false);
				panelWatchList.setVisible(true);
				panelEachOne.setVisible(false);
			}
		});
		btnWatchList.setBounds(217, 8, 76, 26);
		panelTop.add(btnWatchList);
		
		//btnLogin
		btnLogin.setBounds(117, 10, 44, 26);
		panelUnLogin.add(btnLogin);
		btnLogin.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\login.png"));
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*getting user name from database which is same with textFieldId*/
				String userQuery = "SELECT * FROM Users WHERE uDisplayName = '" + textFieldId.getText() + "'";
				ArrayList<UserClass> userInfo = SqlOperations.getUserInfo(userQuery);
				if(userInfo.size() != 0){
					if(getHash(textFieldPw.getText()).equals(userInfo.get(0).getuPassword())){
						panelTop.setVisible(false);
						panelUnLogin.setVisible(false);
						panelRegister.setVisible(false);
						panelLogined.setVisible(true);
						btnWatchList.setEnabled(true);
						panelTop.setVisible(true);
						
						lblUser.setText(textFieldId.getText());
						textFieldId.setText("");
						textFieldPw.setText("");
						
						isLogined = true;
						loggedUserId = userInfo.get(0).getUserId();
						
						new HomePageClass(panelHome);
						panelHome.setVisible(true);
					}
					else{
						textFieldPw.setText("");
						final JOptionPane pane = new JOptionPane("Password wrong!",
								JOptionPane.ERROR_MESSAGE);
						final JDialog jDialog = pane.createDialog(
						        null, 
						        "Upss!");
						jDialog.setLocationRelativeTo(frmOurmdb);
						jDialog.setVisible(true);
					}
					
				}
				else{
					textFieldPw.setText("......");
					textFieldId.setText("ID");
					final JOptionPane pane = new JOptionPane("User Name or Password wrong!",
							JOptionPane.ERROR_MESSAGE);
					final JDialog jDialog = pane.createDialog(
					        null, 
					        "Upss!");
					jDialog.setLocationRelativeTo(frmOurmdb);
					jDialog.setVisible(true);
				}
				
			}
		});
		
		JButton btnRegister = new JButton("");
		btnRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				/*Initilize Panel*/
				panelRegister.removeAll();
				
				JLabel lblCreateAccount = new JLabel("Create Account");
				lblCreateAccount.setFont(new Font("Comic Sans MS", Font.BOLD, 19));
				lblCreateAccount.setForeground(Color.BLACK);
				lblCreateAccount.setBounds(120, 41, 160, 45);
				panelRegister.add(lblCreateAccount);
				
				JLabel lblRegInfo1 = new JLabel("YourName");
				lblRegInfo1.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
				lblRegInfo1.setBounds(120, 97, 187, 14);
				panelRegister.add(lblRegInfo1);
				
				JLabel lblRegInfo2 = new JLabel("Email");
				lblRegInfo2.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
				lblRegInfo2.setBounds(120, 172, 46, 14);
				panelRegister.add(lblRegInfo2);
				
				JLabel lblRegInfo3 = new JLabel("Password");
				lblRegInfo3.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
				lblRegInfo3.setBounds(120, 247, 97, 14);
				panelRegister.add(lblRegInfo3);
				
				JLabel lblRegInfo4 = new JLabel("Password again");
				lblRegInfo4.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
				lblRegInfo4.setBounds(120, 322, 112, 14);
				panelRegister.add(lblRegInfo4);
				
				final JLabel lblYourname = new JLabel("YourName");
				textFieldYourName = new JTextField();
				textFieldYourName.addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent arg0) {
						lblYourname.setVisible(true);
					}
					@Override
					public void focusLost(FocusEvent arg0) {
						lblYourname.setVisible(false);
					}
				});
				textFieldYourName.setBounds(120, 126, 310, 30);
				panelRegister.add(textFieldYourName);
				textFieldYourName.setColumns(10);
				
				
				lblYourname.setVisible(false);
				lblYourname.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\RegisterTextBackgroundA.png"));
				lblYourname.setBounds(116, 122, 318, 37);
				panelRegister.add(lblYourname);
				
				final JLabel labelEmail = new JLabel("");
				textFieldEmail = new JTextField();
				textFieldEmail.addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent arg0) {
						labelEmail.setVisible(true);
					}
					@Override
					public void focusLost(FocusEvent arg0) {
						labelEmail.setVisible(false);
					}
				});
				textFieldEmail.setColumns(10);
				textFieldEmail.setBounds(120, 201, 310, 30);
				panelRegister.add(textFieldEmail);
				
				labelEmail.setVisible(false);
				labelEmail.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\RegisterTextBackgroundA.png"));
				labelEmail.setBounds(116, 197, 318, 37);
				panelRegister.add(labelEmail);
				
				final JLabel labelPassword = new JLabel("");
				passwordFieldPass = new JPasswordField();
				passwordFieldPass.addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent arg0) {
						labelPassword.setVisible(true);
					}
					@Override
					public void focusLost(FocusEvent arg0) {
						labelPassword.setVisible(false);
					}
				});
				passwordFieldPass.setBounds(120, 276, 310, 30);
				panelRegister.add(passwordFieldPass);
				
				labelPassword.setVisible(false);
				labelPassword.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\RegisterTextBackgroundA.png"));
				labelPassword.setBounds(116, 272, 318, 37);
				panelRegister.add(labelPassword);
				
				final JLabel labelPassworda = new JLabel("");
				passwordFieldPassA = new JPasswordField();
				passwordFieldPassA.addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent arg0) {
						labelPassworda.setVisible(true);
					}
					@Override
					public void focusLost(FocusEvent arg0) {
						labelPassworda.setVisible(false);
					}
				});
				passwordFieldPassA.setBounds(120, 351, 310, 30);
				panelRegister.add(passwordFieldPassA);
				
				labelPassworda.setVisible(false);
				labelPassworda.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\RegisterTextBackgroundA.png"));
				labelPassworda.setBounds(116, 347, 318, 37);
				panelRegister.add(labelPassworda);
				
				final JLabel lblButton = new JLabel("");
				lblButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lblButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						lblButton.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\RegisterButtonA.png"));
					}
					@Override
					public void mouseExited(MouseEvent arg0) {
						lblButton.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\RegisterButton.png"));
					}
					@Override
					public void mouseClicked(MouseEvent arg0) {
						boolean nameCanBeCreated = true;
						boolean emailCanBeCreated = true;
						
						String userNameQuery = "SELECT uDisplayName FROM Users WHERE "
								+ "uDisplayName = '" + textFieldYourName.getText() + "'";
						ArrayList<UserClass> userName = SqlOperations.getUserInfo(userNameQuery);
						
						String userEmailQuery = "SELECT uEmail FROM Users WHERE "
								+ "uEmail = '" + textFieldEmail.getText() + "'";
						ArrayList<UserClass> userEmail = SqlOperations.getUserInfo(userEmailQuery);
						if(userName.size() > 0){
							nameCanBeCreated = false;
						}
						if(userEmail.size() > 0){
							emailCanBeCreated = false;
						}
						if(nameCanBeCreated && emailCanBeCreated){
							if(textFieldYourName.getText().length() == 0){
								final JOptionPane pane = new JOptionPane("User Name can not be empty!",
										JOptionPane.ERROR_MESSAGE);
								final JDialog jDialog = pane.createDialog(
								        null, 
								        "Upss!");
								jDialog.setLocationRelativeTo(frmOurmdb);
								jDialog.setVisible(true);
							}
							else if(textFieldEmail.getText().length() == 0){
								final JOptionPane pane = new JOptionPane("Email can not be empty!",
										JOptionPane.ERROR_MESSAGE);
								final JDialog jDialog = pane.createDialog(
								        null, 
								        "Upss!");
								jDialog.setLocationRelativeTo(frmOurmdb);
								jDialog.setVisible(true);
							}
							else if(passwordFieldPass.getText().length() == 0){
								final JOptionPane pane = new JOptionPane("Password can not be empty!",
										JOptionPane.ERROR_MESSAGE);
								final JDialog jDialog = pane.createDialog(
								        null, 
								        "Upss!");
								jDialog.setLocationRelativeTo(frmOurmdb);
								jDialog.setVisible(true);
							}
							else{
								if(passwordFieldPass.getText().equals(passwordFieldPassA.getText())){
									String insertQuery = "INSERT INTO Users(uEmail,uDisplayName,uPassword) VALUES('" 
											+ textFieldEmail.getText() + "','" 
											+ textFieldYourName.getText() + "','"
											+ getHash(passwordFieldPass.getText()) + "')";
									SqlOperations.insert(insertQuery);
									
									lblUser.setText(textFieldYourName.getText());
									textFieldId.setText("");
									textFieldPw.setText("");
									
									String userQuery = "SELECT * FROM Users WHERE uDisplayName = '" + textFieldYourName.getText() + "'";
									ArrayList<UserClass> userInfo = SqlOperations.getUserInfo(userQuery);
									
									isLogined = true;
									loggedUserId = userInfo.get(0).getUserId();
									panelRegister.setVisible(false);
									panelTop.setVisible(false);
									panelUnLogin.setVisible(false);
									panelLogined.setVisible(true);
									btnWatchList.setEnabled(true);
									panelTop.setVisible(true);
									
									new HomePageClass(panelHome);
									panelHome.setVisible(true);
								}
								else{
									final JOptionPane pane = new JOptionPane("Please enter the same password!",
											JOptionPane.ERROR_MESSAGE);
									final JDialog jDialog = pane.createDialog(
									        null, 
									        "Upss!");
									jDialog.setLocationRelativeTo(frmOurmdb);
									jDialog.setVisible(true);
								}
							}
						}
						else{
							if(!nameCanBeCreated && !emailCanBeCreated){
								final JOptionPane pane = new JOptionPane("Please enter a different name and email!",
										JOptionPane.ERROR_MESSAGE);
								final JDialog jDialog = pane.createDialog(
								        null, 
								        "Upss!");
								jDialog.setLocationRelativeTo(frmOurmdb);
								jDialog.setVisible(true);
							}
							if(!nameCanBeCreated && emailCanBeCreated){
								final JOptionPane pane = new JOptionPane("Please enter a different name!",
										JOptionPane.ERROR_MESSAGE);
								final JDialog jDialog = pane.createDialog(
								        null, 
								        "Upss!");
								jDialog.setLocationRelativeTo(frmOurmdb);
								jDialog.setVisible(true);
							}
							if(nameCanBeCreated && !emailCanBeCreated){
								final JOptionPane pane = new JOptionPane("Please enter a different email!",
										JOptionPane.ERROR_MESSAGE);
								final JDialog jDialog = pane.createDialog(
								        null, 
								        "Upss!");
								jDialog.setLocationRelativeTo(frmOurmdb);
								jDialog.setVisible(true);
							}
						}
					}
				});
				lblButton.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\RegisterButton.png"));
				lblButton.setBounds(120, 397, 312, 31);
				panelRegister.add(lblButton);
				/*EndOf Initialize*/
				
				panelHome.setVisible(false);
				panelMovies.setVisible(false);
				panelCelebs.setVisible(false);
				panelTop10.setVisible(false);
				panelUser.setVisible(false);
				panelRegister.setVisible(true);
				panelEachOne.setVisible(false);
				panelWatchList.setVisible(false);
			}
		});
		btnRegister.setBounds(165, 10, 64, 26);
		panelUnLogin.add(btnRegister);
		btnRegister.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\register.png"));
		/*----------------------------EndOf-Buttons----------------------------*/
		
		/*BackgroundPanel*/
		JPanel panelBackground = new JPanel();
		panelBackground.setBackground(new Color(0, 191, 255));
		panelBackground.setBounds(0, 0, 550, 750);
		frmOurmdb.getContentPane().add(panelBackground);
		/*EndOf-BackgroundPanel*/
		
		//TODO: bunu daha uygun bi yere al
		panelHome.removeAll();
		new HomePageClass(panelHome);
	}
}
