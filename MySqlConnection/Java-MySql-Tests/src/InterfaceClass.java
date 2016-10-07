import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Statement;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class InterfaceClass {

	private JFrame frmDbtestform;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	//Create the application
	public InterfaceClass() {
		initialize();
		DisplayPersonsInJTable();
	}
	//Get connection with database
	public Connection getConnection(){
		Connection con;
		try{
			//Creating connection with variable which named "con" 	 DB address		user		pw
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DbTest", "root", "81035241");
			return con;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	//Get table to ArrayList
	public ArrayList<Person> getPersonList(){
		ArrayList<Person> personList = new ArrayList<Person>();
		
		Connection connection = getConnection();
		
		String query = "SELECT * FROM `information`";
		
		Statement statement;
		ResultSet result;
		try {
			statement = (Statement) connection.createStatement();
			result = statement.executeQuery(query);
			Person person;
			
			while(result.next()){
				person = new Person(result.getString("fname"), result.getString("lname"), result.getInt("age"));
				personList.add(person);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return personList;
	}
	
	//Display Persons in JTable
	public void DisplayPersonsInJTable(){
		ArrayList<Person> list = getPersonList();
		DefaultTableModel model =  (DefaultTableModel)table.getModel();
		
		Object[] row = new Object[3];
		for(int i = 0; i < list.size(); i++){
			row[0] = list.get(i).getfName();
			row[1] = list.get(i).getlName();
			row[2] = list.get(i).getAge();
			
			model.addRow(row);
		}
	}
	
	
	//Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceClass window = new InterfaceClass();
					window.frmDbtestform.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

    //Initialize the contents of the frame.
	private void initialize() {
		frmDbtestform = new JFrame();
		frmDbtestform.setTitle("DbTestForm");
		frmDbtestform.setBounds(100, 100, 800, 500);
		frmDbtestform.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDbtestform.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 784, 465);
		frmDbtestform.getContentPane().add(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"FirstName", "LastName", "Age"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.setBounds(400, 32, 374, 422);
		panel.add(table);
		
		JLabel lblFirstName = new JLabel("First Name :");
		lblFirstName.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblFirstName.setBounds(10, 32, 104, 22);
		panel.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name  :");
		lblLastName.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblLastName.setBounds(10, 65, 104, 22);
		panel.add(lblLastName);
		
		JLabel lblAge = new JLabel("Age         :");
		lblAge.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblAge.setBounds(10, 98, 104, 22);
		panel.add(lblAge);
		
		textField = new JTextField();
		textField.setBounds(114, 32, 152, 23);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(114, 65, 152, 23);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(114, 98, 152, 23);
		panel.add(textField_2);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		btnInsert.setBounds(10, 160, 104, 40);
		panel.add(btnInsert);
		
		JLabel lblFname = new JLabel("fName");
		lblFname.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblFname.setBounds(428, 11, 104, 22);
		panel.add(lblFname);
		
		JLabel lblLname = new JLabel("lName");
		lblLname.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblLname.setBounds(550, 11, 104, 22);
		panel.add(lblLname);
		
		JLabel lblAge_1 = new JLabel("Age");
		lblAge_1.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblAge_1.setBounds(702, 11, 51, 22);
		panel.add(lblAge_1);
	}
}
