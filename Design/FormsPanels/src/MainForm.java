import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
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
import java.sql.Connection;
import java.sql.DriverManager;
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
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;

//Finalde sformdaki bi butnu mesela tutup baþka yere taþýmak için hangi eventlerle ilgilenilmeli nasýl yapýlýr
public class MainForm {
	
	private JFrame frmOurmdb;
	private JTextField textFieldId;
	private JPasswordField textFieldPw;
	
	private int loggedUserId;
	private boolean isLogined;
	
	public int xMouse;
	public int yMouse;
	private JTextField textFieldYourName;
	private JTextField textFieldEmail;
	private JPasswordField passwordFieldPass;
	private JPasswordField passwordFieldPassA;
	
	//OtherClass referances
	public static JPanel refPanelEachOne;
	public EachMovie tempEachMovie;
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
	/*Database Connection*/
	public Connection getConnection(){
		Connection con;
		try{
			//Creating connection with variable which named "con" 
			Properties properties = new Properties();
			properties.setProperty("user", "root");
			properties.setProperty("password", "81035241");
			properties.setProperty("useSSL", "false");
			properties.setProperty("autoReconnect", "true");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/imdb", properties);
			return con;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	//Execute SQL query
	public void executeSqlQuery(String query){
		Connection con = getConnection();
		Statement statement;
		try {
			statement = (Statement) con.createStatement();
			statement.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public MainForm() {
		loggedUserId = -1;
		isLogined = false;
		initialize();
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
		
		SqlOperations.postPeopleImage("b");
		SqlOperations.postMovieImage("a");
		
		final JButton btnWatchList = new JButton("");
		JButton btnLogin = new JButton("");
		
		final JLabel labelExit = new JLabel("");
		labelExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmOurmdb.getContentPane().removeAll();
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				labelExit.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\rsz_x_kýrmýzý.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				labelExit.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\rsz_x_siyah.png"));
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
		//------------------------------------------
		
		final JPanel panelComment = new JPanel();
		panelComment.setVisible(false);
		panelComment.setBounds(0, 24, 100, 726);
		frmOurmdb.getContentPane().add(panelComment);
		panelComment.setLayout(new WrapLayout(FlowLayout.CENTER, 5, 5));
		
		labelExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labelExit.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\rsz_x_siyah.png"));
		labelExit.setBounds(510, 0, 24, 24);
		frmOurmdb.getContentPane().add(labelExit);
		
		JLabel labelIcon = new JLabel("");
		labelIcon.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\icon.png"));
		labelIcon.setBounds(0, 0, 24, 24);
		frmOurmdb.getContentPane().add(labelIcon);
		
		/*Panels Inýt*/
		
		
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
				//TODO: arama iþlemleri
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
		lblRight.setBounds(102, 0, 8, 24);
		frmOurmdb.getContentPane().add(lblRight);
		
		textFieldSearch = new JTextField();
		textFieldSearch.setVisible(false);
		textFieldSearch.setBounds(110, 0, 342, 25);
		frmOurmdb.getContentPane().add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		//SearchField End
		
		final JPanel panelTop = new JPanel();
		panelTop.setBackground(new Color(255, 255, 255, 0));
		panelTop.setBounds(0, 25, 550, 45);
		frmOurmdb.getContentPane().add(panelTop);
		panelTop.setLayout(null);
	
		final JPanel panelHome = new JPanel();
		panelHome.setBackground(UIManager.getColor("Button.shadow"));
		panelHome.setBounds(0, 75, 550, 675);
		frmOurmdb.getContentPane().add(panelHome);
		panelHome.setLayout(null);
		
		final JPanel panelMovies = new JPanel();
		panelMovies.setVisible(false);
		panelMovies.setBackground(UIManager.getColor("windowBorder"));
		panelMovies.setBounds(0, 75, 550, 675);
		frmOurmdb.getContentPane().add(panelMovies);
		panelMovies.setLayout(null);
		
		final JPanel panelRegister = new JPanel();
		panelRegister.setBackground(Color.WHITE);
		panelRegister.setVisible(false);
		panelRegister.setBounds(0, 75, 550, 675);
		frmOurmdb.getContentPane().add(panelRegister);
		panelRegister.setLayout(null);
		
	
		final JPanel panelCelebs = new JPanel();
		panelCelebs.setVisible(false);
		panelCelebs.setBackground(new Color(30, 144, 255));
		panelCelebs.setBounds(0, 75, 550, 675);
		panelCelebs.setLayout(null);
		frmOurmdb.getContentPane().add(panelCelebs);
		
		final JPanel panelTop10 = new JPanel();
		panelTop10.setVisible(false);
		panelTop10.setBackground(UIManager.getColor("windowBorder"));
		panelTop10.setBounds(0, 75, 550, 675);
		frmOurmdb.getContentPane().add(panelTop10);
		panelTop10.setLayout(null);
		
		final JPanel panelUser = new JPanel();
		panelUser.setBounds(0, 75, 550, 675);
		panelUser.setVisible(false);
		panelUser.setBackground(new Color(106, 90, 205, 50));
		panelUser.setLayout(null);
		frmOurmdb.getContentPane().add(panelUser);
		
		final JPanel panelUserScroll = new JPanel();
		panelUserScroll.setBounds(0, 75, 550, 675);
		
		JScrollPane scrollPaneUser = new JScrollPane();
		panelUser.add(scrollPaneUser);
		scrollPaneUser.setBounds(0, 0, 550, 675);	
		
		scrollPaneUser.add(panelUserScroll);
		scrollPaneUser.setViewportView(panelUserScroll);
		panelUserScroll.setLayout(new WrapLayout(FlowLayout.CENTER, 0, 1));
		
		final JPanel panelUnLogin = new JPanel();
		panelUnLogin.setBackground(new Color(255, 255, 255, 0));
		panelUnLogin.setBounds(309, 0, 240, 45);
		panelTop.add(panelUnLogin);
		panelUnLogin.setLayout(null);
		
		textFieldId = new JTextField("ID");
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
		lblUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				/*UserPage Init*/
				
				
				panelHome.setVisible(false);
				panelMovies.setVisible(false);
				panelCelebs.setVisible(false);
				panelTop10.setVisible(false);
				panelUser.setVisible(true);
			}
		});
		lblUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setForeground(new Color(0, 0, 0));
		lblUser.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 13));
		lblUser.setBounds(30, 25, 116, 19);
		panelLogined.add(lblUser);
		
		/*EndOf Panel Inýt*/
		
		final JLabel lblGoBackD = new JLabel("");
		final JLabel lblBack = new JLabel("");
		lblBack.setVisible(false);
		lblBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panelEachOne.removeAll();
				//TODO:panelComment Yerine scroll ekleyip düzelt

				lblBack.setVisible(false);
				lblGoBackD.setVisible(true);
				panelComment.removeAll();
				panelTop.setVisible(true);
				panelEachOne.setVisible(false);
				panelComment.setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblBack.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\GoBackA.png"));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblBack.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\GoBack.png"));
			}
		});
		
		
		lblGoBackD.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\GoBackDA.png"));
		lblGoBackD.setBounds(480, 0, 24, 24);
		frmOurmdb.getContentPane().add(lblGoBackD);
		lblBack.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\GoBack.png"));
		lblBack.setBounds(480, 0, 24, 24);
		frmOurmdb.getContentPane().add(lblBack);
		
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
		
		final JPanel panelWatchList = new JPanel();
		panelWatchList.setBounds(0, 75, 550, 675);
		frmOurmdb.getContentPane().add(panelWatchList);
		panelWatchList.setLayout(null);
		
		final JPanel WatchScroll = new JPanel();

		JScrollPane scrollPaneWatch = new JScrollPane();
		scrollPaneWatch.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
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
		
		labelDrag.setBounds(0, 0, 550, 15);
		frmOurmdb.getContentPane().add(labelDrag);
		
		/*-------------------------------Buttons-------------------------------*/
		
		JButton btnHome = new JButton("");
		btnHome.setBackground(UIManager.getColor("CheckBox.light"));
		btnHome.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\home.png"));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panelHome.setVisible(true);
				panelMovies.setVisible(false);
				panelCelebs.setVisible(false);
				panelTop10.setVisible(false);
				panelUser.setVisible(false);
				panelRegister.setVisible(false);
				panelEachOne.setVisible(false);
				panelComment.setVisible(false);
				panelWatchList.setVisible(false);
			}
		});
		btnHome.setBounds(10, 8, 46, 26);
		panelTop.add(btnHome);
		
		JButton btnMovies = new JButton("");
		btnMovies.setBackground(UIManager.getColor("CheckBox.light"));
		btnMovies.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\movies.png"));
		btnMovies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//panelEachOne.setPreferredSize(new Dimension(550,1108));
				//tempEachMovie = new EachMovie(1, panelEachOne);
				//new UserPageClass(1, panelEachOne);
				//new EachCeleb(1, panelEachOne);
				//new FullCastClass(1, panelEachOne);
				new EachMovie(1, panelEachOne);
				
				lblGoBackD.setVisible(false);
				lblBack.setVisible(true);
				panelTop.setVisible(false);
				panelHome.setVisible(false);
				panelCelebs.setVisible(false);
				panelTop10.setVisible(false);
				panelUser.setVisible(false);
				panelRegister.setVisible(false);
				panelEachOne.setVisible(false);
				panelComment.setVisible(false);
				panelWatchList.setVisible(false);
				panelEachOne.setVisible(true);
				/*
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
				tabbedPane.setBackground(UIManager.getColor("windowBorder"));
				tabbedPane.setBounds(0, 0, 550, 675);
				tabbedPane.addTab("In Theaters", scrollPaneInThe);
				tabbedPane.addTab("Coming Soon", scrollPaneComing);
				panelMovies.add(tabbedPane);
				//EndOf-Movies Init
				
				MovieTabComponents temp = new MovieTabComponents(123, panelInTheaters);
				temp = new MovieTabComponents(123, panelInTheaters);
				temp = new MovieTabComponents(333, panelInTheaters);
				
				temp = new MovieTabComponents(123, panelComingSoon);
				temp = new MovieTabComponents(333, panelComingSoon);
				
				panelHome.setVisible(false);
				panelCelebs.setVisible(false);
				panelTop10.setVisible(false);
				panelUser.setVisible(false);
				panelRegister.setVisible(false);
				panelMovies.setVisible(true);
				panelEachOne.setVisible(false);
				panelComment.setVisible(false);
				panelWatchList.setVisible(false);
				*/
			}
		});
		btnMovies.setBounds(57, 8, 54, 26);
		panelTop.add(btnMovies);
		
		JButton btnCelebs = new JButton("");
		btnCelebs.setBackground(UIManager.getColor("CheckBox.light"));
		btnCelebs.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\celebs.png"));
		btnCelebs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*Celebs Inýt*/
				JScrollPane scrollPaneC = new JScrollPane();
				scrollPaneC.setBounds(0, 0, 550, 675);
				panelCelebs.add(scrollPaneC);
				
				JPanel panelCelebsScroll = new JPanel();
				panelCelebsScroll.setBackground(UIManager.getColor("Button.shadow"));
				panelCelebsScroll.setLayout(new WrapLayout(FlowLayout.CENTER, 10, 5));
				panelCelebsScroll.setBounds(0, 0, 10, 10);
				scrollPaneC.add(panelCelebsScroll);
				scrollPaneC.setViewportView(panelCelebsScroll);
				
				
				JLabel lblSortBy = new JLabel("Sort by: ");
				panelCelebsScroll.add(lblSortBy);
				
				JLabel lblAz = new JLabel("A-Z,");
				panelCelebsScroll.add(lblAz);
				
				JLabel lblHeight = new JLabel("Height,");
				panelCelebsScroll.add(lblHeight);
				
				JLabel lblBirthDate = new JLabel("Birth Date");
				panelCelebsScroll.add(lblBirthDate);
				
				JLabel lblLine = new JLabel("");
				lblLine.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\line.png"));
				panelCelebsScroll.add(lblLine);
				
				JLabel lblTotalNames = new JLabel("Total Names:");
				panelCelebsScroll.add(lblTotalNames);
				
				JLabel lblNamescount = new JLabel("NamesCount");
				panelCelebsScroll.add(lblNamescount);
				/*EndOF Celebs Inýt*/
				
				CelebsComponent.Id = 0;
				
				CelebsComponent tempC = new CelebsComponent("Jhonny Deep", "Johnny Depp is perhaps one of the most versatile "
						+ "actors of his day and age in Hollywood. He was born John Christopher Depp II in Owensboro, Kentucky, "
						+ "on June 9, 1963, to Betty Sue (Wells), who worked as a waitress, and John Christopher Depp, a civil engineer. ", 
						panelCelebsScroll);
				tempC = new CelebsComponent("Jhonny Deep", "Johnny Depp is perhaps one of the most versatile "
						+ "actors of his day and age in Hollywood. He was born John Christopher Depp II in Owensboro, Kentucky, "
						+ "on June 9, 1963, to Betty Sue (Wells), who worked as a waitress, and John Christopher Depp, a civil engineer. ", 
						panelCelebsScroll);
				tempC = new CelebsComponent("Jhonny Deep", "Johnny Depp is perhaps one of the most versatile "
						+ "actors of his day and age in Hollywood. He was born John Christopher Depp II in Owensboro, Kentucky, "
						+ "on June 9, 1963, to Betty Sue (Wells), who worked as a waitress, and John Christopher Depp, a civil engineer. ", 
						panelCelebsScroll);
				tempC = new CelebsComponent("Jhonny Deep", "Johnny Depp is perhaps one of the most versatile "
						+ "actors of his day and age in Hollywood. He was born John Christopher Depp II in Owensboro, Kentucky, "
						+ "on June 9, 1963, to Betty Sue (Wells), who worked as a waitress, and John Christopher Depp, a civil engineer. ", 
						panelCelebsScroll);
				tempC = new CelebsComponent("Jhonny Deep", "Johnny Depp is perhaps one of the most versatile "
						+ "actors of his day and age in Hollywood. He was born John Christopher Depp II in Owensboro, Kentucky, "
						+ "on June 9, 1963, to Betty Sue (Wells), who worked as a waitress, and John Christopher Depp, a civil engineer. ", 
						panelCelebsScroll);
				tempC = new CelebsComponent("Jhonny Deep", "Johnny Depp is perhaps one of the most versatile "
						+ "actors of his day and age in Hollywood. He was born John Christopher Depp II in Owensboro, Kentucky, "
						+ "on June 9, 1963, to Betty Sue (Wells), who worked as a waitress, and John Christopher Depp, a civil engineer. ", 
						panelCelebsScroll);
				tempC = new CelebsComponent("Jhonny Deep", "Johnny Depp is perhaps one of the most versatile "
						+ "actors of his day and age in Hollywood. He was born John Christopher Depp II in Owensboro, Kentucky, "
						+ "on June 9, 1963, to Betty Sue (Wells), who worked as a waitress, and John Christopher Depp, a civil engineer. ", 
						panelCelebsScroll);
				tempC = new CelebsComponent("Jhonny Deep", "Johnny Depp is perhaps one of the most versatile "
						+ "actors of his day and age in Hollywood. He was born John Christopher Depp II in Owensboro, Kentucky, "
						+ "on June 9, 1963, to Betty Sue (Wells), who worked as a waitress, and John Christopher Depp, a civil engineer. ", 
						panelCelebsScroll);
				tempC = new CelebsComponent("Jhonny Deep", "Johnny Depp is perhaps one of the most versatile "
						+ "actors of his day and age in Hollywood. He was born John Christopher Depp II in Owensboro, Kentucky, "
						+ "on June 9, 1963, to Betty Sue (Wells), who worked as a waitress, and John Christopher Depp, a civil engineer. ", 
						panelCelebsScroll);
				tempC = new CelebsComponent("Jhonny Deep", "Johnny Depp is perhaps one of the most versatile "
						+ "actors of his day and age in Hollywood. He was born John Christopher Depp II in Owensboro, Kentucky, "
						+ "on June 9, 1963, to Betty Sue (Wells), who worked as a waitress, and John Christopher Depp, a civil engineer. ", 
						panelCelebsScroll);
				tempC = new CelebsComponent("Jhonny Deep", "Johnny Depp is perhaps one of the most versatile "
						+ "actors of his day and age in Hollywood. He was born John Christopher Depp II in Owensboro, Kentucky, "
						+ "on June 9, 1963, to Betty Sue (Wells), who worked as a waitress, and John Christopher Depp, a civil engineer. ", 
						panelCelebsScroll);
				
				panelHome.setVisible(false);
				panelMovies.setVisible(false);
				panelCelebs.setVisible(true);
				panelTop10.setVisible(false);
				panelUser.setVisible(false);
				panelRegister.setVisible(false);
				panelEachOne.setVisible(false);
				panelComment.setVisible(false);
				panelWatchList.setVisible(false);
			}
		});
		btnCelebs.setBounds(112, 8, 52, 26);
		panelTop.add(btnCelebs);
		
		JButton btnTop50 = new JButton("");
		btnTop50.setBackground(UIManager.getColor("CheckBox.light"));
		btnTop50.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\Top50.png"));
		btnTop50.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Top10Component.Id = 0;
				/*Top10 Inýt*/
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(0, 0, 550, 675);
				panelTop10.add(scrollPane);
				
				JPanel panelTop10Scroll = new JPanel();
				panelTop10Scroll.setBackground(UIManager.getColor("Button.shadow"));
				panelTop10Scroll.setLayout(new WrapLayout(FlowLayout.CENTER, 10, 10));
				panelTop10Scroll.setBounds(0, 0, 10, 10);
				
				scrollPane.add(panelTop10Scroll);
				scrollPane.setViewportView(panelTop10Scroll);
				/*EndOf Top10 Inýt*/
				
				Top10Component temp = new Top10Component(1, "YüzüklerinEdendisi", 8.5, panelTop10Scroll);
				temp = new Top10Component(3, "Inception", 4.5, panelTop10Scroll);
				temp = new Top10Component(3, "ASD", 4.5, panelTop10Scroll);
				temp = new Top10Component(3, "DEF", 4.5, panelTop10Scroll);
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
				
				panelHome.setVisible(false);
				panelMovies.setVisible(false);
				panelCelebs.setVisible(false);
				panelTop10.setVisible(true);
				panelUser.setVisible(false);
				panelRegister.setVisible(false);
				panelEachOne.setVisible(false);
				panelComment.setVisible(false);
				panelWatchList.setVisible(false);
			}
		});
		btnTop50.setBounds(165, 8, 50, 26);
		panelTop.add(btnTop50);
		
		//btnWatchList
		btnWatchList.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\watchlist.png"));
		btnWatchList.setEnabled(false);
		btnWatchList.setVisible(true);
		btnWatchList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				final JPanel WatchScrollContent = new JPanel();
				WatchScroll.add(WatchScrollContent);
				WatchScrollContent.setLayout(new WrapLayout(FlowLayout.CENTER, 5, 2));
				WatchScrollContent.setMinimumSize(new Dimension(530,0));
				
				new WatchlistComponent(12, WatchScrollContent);
				new WatchlistComponent(12, WatchScrollContent);
				new WatchlistComponent(12, WatchScrollContent);
				new WatchlistComponent(12, WatchScrollContent);
				
				
				//TODO::diðer butonlarda bu paneli invis yap
				panelHome.setVisible(false);
				panelMovies.setVisible(false);
				panelCelebs.setVisible(false);
				panelTop10.setVisible(false);
				panelUser.setVisible(false);
				panelRegister.setVisible(false);
				panelWatchList.setVisible(true);
				panelEachOne.setVisible(false);
				panelComment.setVisible(false);
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
				if("aa".equals(textFieldId.getText()) && "123".equals(textFieldPw.getText())){
					//JOptionPane.showMessageDialog(null, "Welcome " + textFieldId.getText() + "!");
					panelTop.setVisible(false);
					panelUnLogin.setVisible(false);
					panelLogined.setVisible(true);
					btnWatchList.setEnabled(true);
					panelTop.setVisible(true);
					
					lblUser.setText(textFieldId.getText());
					textFieldId.setText("");
					textFieldPw.setText("");
					
					isLogined = true;
					//TODO: userId setle
					//loggedUserId = from sql db
				}
				else{
					//TODO: kullanýcý adý tabloda varsa ayrý yoksa ayrý iþlem yapýlabilir belki
					textFieldPw.setText("");
					JOptionPane.showMessageDialog(null, "Username or Password wrong!");
				}
			}
		});
		
		JButton btnRegister = new JButton("");
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				/*Initilize Panel*/
				
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
						//TODO: Veri tabanýyla veya alanlarla ilgili sorun yoksa kaydet
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
				panelComment.setVisible(false);
				panelWatchList.setVisible(false);
			}
		});
		btnRegister.setBounds(165, 10, 64, 26);
		panelUnLogin.add(btnRegister);
		btnRegister.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\register.png"));
		/*----------------------------EndOf-Buttons----------------------------*/
		
		/*BackgroundPanel*/
		JPanel panelBackground = new JPanel();
		panelBackground.setBackground(UIManager.getColor("windowBorder"));
		/*Background image*/
		/*JPanel panelBackground = new JPanel(){
			public void paintComponent(Graphics g){
				ImageIcon icon = new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\back.jpg");
				Image i = icon.getImage();
				
				g.drawImage(i, 0, 0, this.getSize().width, this.getSize().height, this);
			}
		};*/
		panelBackground.setBounds(0, 0, 550, 750);
		frmOurmdb.getContentPane().add(panelBackground);
		/*EndOf-BackgroundPanel*/
	}
}
