package Account;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Login.Login;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JButton;

public class Balance extends JPanel
{
	private JTextField textField;
	public Balance() {	
		setBackground(new Color(240, 248, 255));
		setLayout(null);
		JLabel lblNewLabel = new JLabel("ACCOUNT BALANCE");	
		lblNewLabel.setForeground(new Color(0, 0, 153));
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
		lblNewLabel.setBounds(186, 10, 254, 26);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Account Number: "+Login.ano);
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 67, 171, 26);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(10, 103, 276, 26);
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 18));
		add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("View Balance");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 153));
		btnNewButton.setFont(new Font("Serif", Font.BOLD, 16));
		btnNewButton.setBounds(468, 197, 105, 37);
		btnNewButton.setBorder(new LineBorder(new Color(0,153,255),2,true));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
		int amt1=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_accounts","root","pword");
			String sql1="select balance from accounts where a_no='"+Login.ano+"'";
			PreparedStatement p = con.prepareStatement(sql1);
			ResultSet rs = p.executeQuery();
			if(rs.next())
			{
				 amt1= rs.getInt("balance");
				 lblNewLabel_2.setText("Account Balance: Rs. "+amt1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
			}
		});
		add(btnNewButton);
}
}