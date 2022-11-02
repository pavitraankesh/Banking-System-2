package SignUp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class SignUp {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_3;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp window = new SignUp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public SignUp() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(240, 248, 255));
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SIGN UP");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 10, 71, 17);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Create an Account");
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 26));
		lblNewLabel_1.setBounds(180, 57, 234, 28);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name:");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(118, 134, 51, 17);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("City:");
		lblNewLabel_3.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(125, 176, 44, 17);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Phone no.:");
		lblNewLabel_4.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(85, 215, 86, 17);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Username:");
		lblNewLabel_5.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(85, 255, 86, 21);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Password:");
		lblNewLabel_6.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(85, 300, 76, 17);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Reconfirm Password:");
		lblNewLabel_7.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(10, 343, 151, 17);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Initial amount:");
		lblNewLabel_8.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel_8.setBounds(71, 383, 98, 21);
		frame.getContentPane().add(lblNewLabel_8);
		
		textField = new JTextField();
		textField.setBounds(179, 136, 206, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(181, 217, 204, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(181, 259, 204, 19);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(179, 177, 206, 21);
		comboBox.addItem("Bengaluru");
		comboBox.addItem("Chennai");
		comboBox.addItem("Mumbai");
		comboBox.addItem("Trivandrum");
		comboBox.addItem("Delhi");
		comboBox.addItem("Hyderabad");
		comboBox.setSelectedItem(null);
		frame.getContentPane().add(comboBox);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(179, 302, 206, 19);
		frame.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(179, 345, 206, 19);
		frame.getContentPane().add(passwordField_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(179, 383, 206, 19);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setForeground(new Color(255, 0, 0));
		lblNewLabel_10.setBounds(395, 220, 218, 13);
		frame.getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setForeground(new Color(255, 0, 0));
		lblNewLabel_11.setBounds(395, 262, 206, 13);
		frame.getContentPane().add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setForeground(new Color(255, 0, 0));
		lblNewLabel_12.setBounds(395, 305, 218, 13);
		frame.getContentPane().add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setForeground(new Color(255, 0, 0));
		lblNewLabel_13.setBounds(395, 348, 218, 13);
		frame.getContentPane().add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setForeground(new Color(255, 0, 0));
		lblNewLabel_14.setBounds(395, 390, 218, 13);
		frame.getContentPane().add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("");
		lblNewLabel_15.setForeground(new Color(255, 0, 0));
		lblNewLabel_15.setBounds(395, 139, 218, 13);
		frame.getContentPane().add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("");
		lblNewLabel_16.setForeground(new Color(255, 0, 0));
		lblNewLabel_16.setBounds(395, 181, 218, 13);
		frame.getContentPane().add(lblNewLabel_16);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 153));
		btnNewButton.setFont(new Font("Serif", Font.BOLD, 20));
		btnNewButton.setBounds(487, 463, 108, 35);
		btnNewButton.setBorder(new LineBorder(new Color(0,153,255),2,true));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_accounts","root","pword");
				String name=textField.getText();
				String city=(String)comboBox.getSelectedItem();
				String phoneno=textField_1.getText();
				String uname=textField_2.getText();
				String password1=new String(passwordField.getPassword());
				String password2=new String(passwordField_1.getPassword());
				String amount=textField_3.getText();
				long pno; int amt;
				if (name.isBlank()) lblNewLabel_15.setText("Cannot be empty");
				else lblNewLabel_15.setText("");
				if (city==null) lblNewLabel_16.setText("Cannot be empty");
				else lblNewLabel_16.setText("");
				if (phoneno.isBlank()) lblNewLabel_10.setText("Cannot be empty");
				else {
					try {
						pno=Long.parseLong(phoneno);
						if(phoneno.length()!=10) 
							lblNewLabel_10.setText("Invalid phone number");
						else
							lblNewLabel_10.setText("");
					} catch(NumberFormatException e)
					{
						lblNewLabel_10.setText("Invalid phone number");
					}
				}
				if (uname.isBlank()) lblNewLabel_11.setText("Cannot be empty");
				else {
					String sql="select * from accounts where username='"+uname+"'";
					PreparedStatement p = con.prepareStatement(sql);
					ResultSet r=p.executeQuery();
					if(r.next()) lblNewLabel_11.setText("Username exits");
					else lblNewLabel_11.setText("");
				}
				if (password1.isBlank()) lblNewLabel_12.setText("Cannot be empty");
				else lblNewLabel_12.setText("");
				if (password2.isBlank()) lblNewLabel_13.setText("Cannot be empty");
				else {
					if(!password1.equals(password2))
						lblNewLabel_13.setText("Passwords do not match");
					else
					lblNewLabel_13.setText("");
				}
				if (amount.isBlank()) lblNewLabel_14.setText("Cannot be empty");
				else {
					try {
					amt=Integer.parseInt(amount);
					if(amt<10000)
						lblNewLabel_14.setText("Minimum amount: Rs.10000");
					else
					lblNewLabel_14.setText("");
				} catch(NumberFormatException e)
					{	lblNewLabel_14.setText("Invalid amount");}
				}
				if(lblNewLabel_10.getText()==""&&lblNewLabel_11.getText()==""&&lblNewLabel_12.getText()==""&&lblNewLabel_13.getText()==""&&lblNewLabel_14.getText()==""&&lblNewLabel_15.getText()==""&&lblNewLabel_16.getText()=="")
				{
					String sql1="select count(*) from accounts;";
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery(sql1);
					rs.next();
					int ano=rs.getInt(1)+1;
					String sql2="insert into accounts values('"+ano+"','"+name+"','"+city+"','"+Long.parseLong(phoneno)+"','"+uname+"','"+password1+"','"+Integer.parseInt(amount)+"')";
					st.executeUpdate(sql2);
					JOptionPane.showMessageDialog(null,"Account Created", "Sign Up", JOptionPane.PLAIN_MESSAGE);
					frame.dispose();
					
				}
			}catch(Exception e)
				{
				e.printStackTrace();
			}
		}});
		frame.getContentPane().add(btnNewButton);
		
		frame.setBackground(new Color(240, 248, 255));
		frame.setBounds(100, 100, 637, 557);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
}
