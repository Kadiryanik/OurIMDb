import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.sql.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;

import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	public JFrame frmLogin;
	private JTextField textField_Id;
	private JTextField textField_Pw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//Get connection with database
	public Connection getConnection(){
		Connection con;
		try{
			//Creating connection with variable which named "con" 	 DB address		user		pw
			Properties properties = new Properties();
			properties.setProperty("user", "root");
			properties.setProperty("password", "81035241");
			properties.setProperty("useSSL", "false");
			properties.setProperty("autoReconnect", "true");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ourimdb", properties);
			return con;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	//Get table to ArrayList
	public ArrayList<User> getUserList(){
		ArrayList<User> userList = new ArrayList<User>();
		
		Connection connection = getConnection();
			
		String query = "SELECT * FROM `users`";
		
		Statement statement;
		ResultSet result;
		try {
			statement = (Statement) connection.createStatement();
			result = statement.executeQuery(query);
			User user;
			
			while(result.next()){
				user = new User( result.getInt("PK"), result.getString("id"), result.getString("pw") );
				userList.add(user);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return userList;
	}	

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setResizable(false);
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 304, 161);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		textField_Id = new JTextField();
		textField_Id.setBounds(75, 11, 119, 20);
		frmLogin.getContentPane().add(textField_Id);
		textField_Id.setColumns(10);
		
		textField_Pw = new JTextField();
		textField_Pw.setColumns(10);
		textField_Pw.setBounds(75, 42, 119, 20);
		frmLogin.getContentPane().add(textField_Pw);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			int success = 0;
			public void actionPerformed(ActionEvent arg0) {
				String id = textField_Id.getText();
				String pw = textField_Pw.getText();
				ArrayList<User> list = getUserList();
				for(int i = 0; i < list.size(); i++){
					if(id.equals(list.get(i).getID())){
						if(pw.equals(list.get(i).getPW())){
							success = 1;
						}
					}
				}
				if(success == 1){
					JOptionPane.showMessageDialog(null, "Succeed");
					frmLogin.setVisible(false);
					InterfaceClass window = new InterfaceClass();
					window.frmDbtestform.setVisible(true);
				}
				else{
					JOptionPane.showMessageDialog(null, "Id veya Pw yanlýþ");
				}
				
				
				
			}
		});
		btnLogin.setBounds(85, 73, 97, 23);
		frmLogin.getContentPane().add(btnLogin);
	}
}
