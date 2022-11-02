package Login;

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

import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import Account.Account;

public class Login {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	public static int ano;
	public static String name;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Login() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(240, 248, 255));
		frame.setBounds(100, 100, 494, 365);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 10, 53, 17);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Login to your Account");
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 26));
		lblNewLabel_1.setBounds(89, 43, 285, 54);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Username: ");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(23, 138, 97, 21);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password: ");
		lblNewLabel_3.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(23, 190, 80, 28);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(113, 142, 165, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(113, 198, 165, 19);
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 153));
		btnNewButton.setFont(new Font("Serif", Font.BOLD, 20));
		btnNewButton.setBounds(354, 275, 91, 31);
		btnNewButton.setBorder(new LineBorder(new Color(0,153,255),2,true));
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setForeground(new Color(255, 0, 0));
		lblNewLabel_4.setBounds(288, 145, 157, 13);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setForeground(new Color(255, 0, 0));
		lblNewLabel_5.setBounds(288, 201, 157, 13);
		frame.getContentPane().add(lblNewLabel_5);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) 
			{
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_accounts","root","pword");
					String uname=textField.getText();
					String password=new String(passwordField.getPassword());
					if (uname.isBlank()) lblNewLabel_4.setText("Cannot be empty");
					if (password.isBlank()) lblNewLabel_5.setText("Cannot be empty");
					if (!uname.isBlank())
					{
						String sql="select pass_word,a_no,name from accounts where username='"+uname+"'";
						PreparedStatement p = con.prepareStatement(sql);
						ResultSet r=p.executeQuery();
						if(!r.next())
						{
							lblNewLabel_4.setText("Username does not exist");
							if(!password.isBlank())  lblNewLabel_5.setText("Incorrect password");
						}
						else 
						{
							lblNewLabel_4.setText("");
							String pword=r.getString("pass_word");
							if(!password.isBlank()) {
							if(!pword.equals(password)) lblNewLabel_5.setText("Incorrect password");
							else { 
								ano=r.getInt("a_no");
								name=r.getString("name");
								lblNewLabel_5.setText("");
								frame.dispose();
								Account.main(null);
							}
							}
						}
						}
					con.close();
					}catch(Exception e)
					{
						e.printStackTrace();
					}
			}
		});
					
	}
}
