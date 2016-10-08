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

public class InterfaceClass {

	private JFrame frmDbtestform;
	private JTable table;
	private JTextField textFieldFN;
	private JTextField textFieldLN;
	private JTextField textFieldA;
	private JTextField textFieldPK;
	
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
			Properties properties = new Properties();
			properties.setProperty("user", "root");
			properties.setProperty("password", "81035241");
			properties.setProperty("useSSL", "false");
			properties.setProperty("autoReconnect", "true");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DbTest", properties);
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
				person = new Person(result.getString("fname"), result.getString("lname"), result.getInt("age"), result.getInt("PK"));
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
		
		Object[] row = new Object[4];
		for(int i = 0; i < list.size(); i++){
			row[0] = list.get(i).getfName();
			row[1] = list.get(i).getlName();
			row[2] = list.get(i).getAge();
			row[3] = list.get(i).getPK();
			
			model.addRow(row);
		}
	}
	//Execute SQL query
	public void executeSqlQuery(String query, String message){
		Connection con = getConnection();
		Statement statement;
		try {
			statement = (Statement) con.createStatement();
			if(statement.executeUpdate(query) == 1){
				//Refresh table
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				DisplayPersonsInJTable();
				
				JOptionPane.showMessageDialog(null, "Data" + message + " Succes!");
			}else{
				JOptionPane.showMessageDialog(null, "Data Not " + message);
			}

		} catch (Exception e) {
			e.printStackTrace();
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
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//Fill text field with selected row
				int i = table.getSelectedRow();
				TableModel model = table.getModel();
				textFieldFN.setText(model.getValueAt(i, 0).toString());
				textFieldLN.setText(model.getValueAt(i, 1).toString());
				textFieldA.setText(model.getValueAt(i, 2).toString());
				textFieldPK.setText(model.getValueAt(i, 3).toString());
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"FirstName", "LastName", "Age", "PK"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, true, true
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
		
		textFieldFN = new JTextField();
		textFieldFN.setBounds(114, 32, 152, 23);
		panel.add(textFieldFN);
		textFieldFN.setColumns(10);
		
		textFieldLN = new JTextField();
		textFieldLN.setColumns(10);
		textFieldLN.setBounds(114, 65, 152, 23);
		panel.add(textFieldLN);
		
		textFieldA = new JTextField();
		textFieldA.setColumns(10);
		textFieldA.setBounds(114, 98, 152, 23);
		panel.add(textFieldA);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String query = "INSERT INTO `information`(`fname`, `lname`, `age`) VALUES ('"+textFieldFN.getText()+"','"+textFieldLN.getText()+"','"+textFieldA.getText()+"')";
				executeSqlQuery(query, " Inserted");
			}
		});
		btnInsert.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		btnInsert.setBounds(10, 160, 104, 40);
		panel.add(btnInsert);
		
		JLabel lblFname = new JLabel("fName");
		lblFname.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblFname.setBounds(400, 11, 104, 22);
		panel.add(lblFname);
		
		JLabel lblLname = new JLabel("lName");
		lblLname.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblLname.setBounds(493, 11, 104, 22);
		panel.add(lblLname);
		
		JLabel lblAge_1 = new JLabel("Age");
		lblAge_1.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblAge_1.setBounds(587, 11, 51, 22);
		panel.add(lblAge_1);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = "UPDATE `information` SET `fname`='"+textFieldFN.getText()+"',`lname`='"+textFieldLN.getText()+"',`age`='"+textFieldA.getText()+" WHERE `PK` = " + textFieldPK.getText();
				executeSqlQuery(query, " Updated");
			}
		});
		btnUpdate.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		btnUpdate.setBounds(146, 160, 104, 40);
		panel.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = "DELETE FROM `information` "+" WHERE `PK` = " + textFieldPK.getText();
				executeSqlQuery(query, " Deleted");
			}
		});
		btnDelete.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		btnDelete.setBounds(276, 160, 104, 40);
		panel.add(btnDelete);
		
		textFieldPK = new JTextField();
		textFieldPK.setVisible(false);
		textFieldPK.setColumns(10);
		textFieldPK.setBounds(114, 239, 152, 23);
		panel.add(textFieldPK);
		
		JLabel lblPk = new JLabel("PK");
		lblPk.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblPk.setBounds(682, 11, 51, 22);
		panel.add(lblPk);
	}
}
