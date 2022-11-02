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

public class Profile extends JPanel
{
	public Profile()
	{
		setBackground(new Color(240, 248, 255));
		setLayout(null);
		JLabel lblNewLabel = new JLabel("ACCOUNT DETAILS");	
		lblNewLabel.setForeground(new Color(0, 0, 153));
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
		lblNewLabel.setBounds(186, 10, 230, 26);
		add(lblNewLabel);
		
		String name="", uname="", pno="", city="";
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_accounts","root","pword");
			String sql="select name, city, phone_no, username from accounts where a_no='"+Login.ano+"'";
			PreparedStatement p = con.prepareStatement(sql);
			ResultSet r = p.executeQuery();
			if(r.next())
			{
				name=r.getString("name");
				uname=r.getString("username");
				pno=r.getString("phone_no");
				city=r.getString("city");
				
			}
			con.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		JLabel lblNewLabel_1 = new JLabel("Account Number: "+Login.ano);
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 67, 171, 26);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name: "+name);
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(10, 103, 308, 26);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Username: "+uname);
		lblNewLabel_3.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(10, 143, 308, 23);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Phone Number: "+pno);
		lblNewLabel_4.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(10, 176, 346, 27);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("City: "+city);
		lblNewLabel_5.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(10, 213, 289, 24);
		add(lblNewLabel_5);
	}
}
		