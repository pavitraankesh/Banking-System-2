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
import javax.swing.JScrollPane;

public class Transfer extends JPanel
{
	private JTextField textField;
	public Transfer() {	
		setBackground(new Color(240, 248, 255));
		setLayout(null);
		JLabel lblNewLabel = new JLabel("TRANSFER MONEY");	
		lblNewLabel.setForeground(new Color(0, 0, 153));
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
		lblNewLabel.setBounds(186, 10, 254, 26);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Account Number: "+Login.ano);
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 67, 171, 26);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Account to be transferred: ");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(10, 114, 217, 26);
		add(lblNewLabel_2);
		
		JTextField tf1= new JTextField();
		tf1.setBounds(237, 158, 116, 32);
		add(tf1);
		tf1.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 2, 2);
		add(scrollPane);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setBounds(370, 127, 217, 13);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Amount to be transfered: ");
		lblNewLabel_5.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(10, 157, 217, 26);
		add(lblNewLabel_5);
		
		JTextField tf= new JTextField();
		tf.setBounds(238, 115, 116, 32);
		add(tf);
		tf.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setBounds(370, 169, 217, 13);
		add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Transfer");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 153));
		btnNewButton.setFont(new Font("Serif", Font.BOLD, 16));
		btnNewButton.setBounds(489, 197, 84, 37);
		btnNewButton.setBorder(new LineBorder(new Color(0,153,255),2,true));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_accounts","root","pword");
					
					String acc=tf.getText();
					int accno=Integer.parseInt(acc);
					int amt3=0;
					String sql="select balance from accounts where a_no='"+accno+"'";
					PreparedStatement p = con.prepareStatement(sql);
					ResultSet r = p.executeQuery();
					if(r.next())
					{
						amt3=r.getInt("balance");
						lblNewLabel_3.setText("");
					}
					else
					{
						lblNewLabel_3.setText("Invalid Account Number");
					}
					
					String amt=tf1.getText();
					int amt2=Integer.parseInt(amt);
					int amt1=0;
					
					String sql1="select balance from accounts where a_no='"+Login.ano+"'";
					PreparedStatement ps = con.prepareStatement(sql1);
					ResultSet rs = ps.executeQuery();
					if(rs.next())
					{
						 amt1= rs.getInt("balance");
					}
					if((amt1-amt2)<10000)
					{
						lblNewLabel_4.setText("Minimum balance must be Rs. 10,000");
					}
					else
					{
						lblNewLabel_4.setText("");
					}
					
					if(lblNewLabel_3.getText()==""&&lblNewLabel_4.getText()=="") 
					{
					String sql2="update accounts set balance=? where a_no=?";
					PreparedStatement ps1 = con.prepareStatement(sql2);
					ps1.setInt(1,amt1-amt2);
					ps1.setInt(2, Login.ano);
					if(ps1.executeUpdate()==1)
					{
						ps1.setInt(1,amt3+amt2);
						ps1.setInt(2, accno);
						if(ps1.executeUpdate()==1)
						{
							JOptionPane.showMessageDialog(null,"Amount transfered", "Transfer", JOptionPane.PLAIN_MESSAGE);
							tf.setText("");
							tf1.setText("");
						}
					}
					}
				} catch(NumberFormatException e)
				{
					lblNewLabel_4.setText("Invalid amount");
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		add(btnNewButton);
	}
	}