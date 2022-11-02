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

public class Withdraw extends JPanel
{
	private JTextField textField;
	public Withdraw() {	
		setBackground(new Color(240, 248, 255));
		setLayout(null);
		JLabel lblNewLabel = new JLabel("WITHDRAW MONEY");	
		lblNewLabel.setForeground(new Color(0, 0, 153));
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
		lblNewLabel.setBounds(186, 10, 254, 26);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Account Number: "+Login.ano);
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 67, 171, 26);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Amount to be withdrawn: ");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(10, 114, 217, 26);
		add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(216, 115, 116, 32);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setBounds(346, 124, 217, 13);
		add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Withdraw");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 153));
		btnNewButton.setFont(new Font("Serif", Font.BOLD, 16));
		btnNewButton.setBounds(489, 197, 84, 37);
		btnNewButton.setBorder(new LineBorder(new Color(0,153,255),2,true));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try {
					String amt=textField.getText();
					int amt2=Integer.parseInt(amt);
					int amt1=0;
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_accounts","root","pword");
					String sql1="select balance from accounts where a_no='"+Login.ano+"'";
					PreparedStatement p = con.prepareStatement(sql1);
					ResultSet rs = p.executeQuery();
					if(rs.next())
					{
						 amt1= rs.getInt("balance");
					}
					if((amt1-amt2)<10000)
					{
						lblNewLabel_3.setText("Minimum balance must be Rs. 10,000");
					}
					else {
					String sql2="update accounts set balance=? where a_no='"+Login.ano+"'";
					PreparedStatement ps = con.prepareStatement(sql2);
					ps.setInt(1,amt1-amt2);
					if(ps.executeUpdate()==1)
					{
						lblNewLabel_3.setText("");
						JOptionPane.showMessageDialog(null,"Amount withdrawn", "Withdraw", JOptionPane.PLAIN_MESSAGE);
						textField.setText("");
					}
					}
				} catch(NumberFormatException e)
				{
					lblNewLabel_3.setText("Invalid amount");
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		add(btnNewButton);
	}
	}