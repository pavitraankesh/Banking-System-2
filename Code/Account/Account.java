package Account;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Login.Login;
import javax.swing.JButton;
import java.time.LocalDate;

public class Account {

	private JFrame frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Account window = new Account();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Account() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(240, 248, 255));
		frame.setBounds(100, 100, 683, 436);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP,JTabbedPane.WRAP_TAB_LAYOUT);
		tabbedPane.setBounds(25, 80, 609, 307);
		frame.getContentPane().add(tabbedPane);
		
		tabbedPane.addTab("Profile", new Profile());
		tabbedPane.addTab("Deposit",new Deposit());
		tabbedPane.addTab("Withdraw", new Withdraw());
		tabbedPane.addTab("Transfer", new Transfer());
		tabbedPane.addTab("Check Balance", new Balance());
		
		JLabel lblNewLabel = new JLabel(" ");	
		lblNewLabel.setText("Hello "+Login.name);
		lblNewLabel.setForeground(new Color(0, 0, 153));
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
		lblNewLabel.setBounds(26, 33, 205, 26);
		frame.getContentPane().add(lblNewLabel);
		
		LocalDate date = LocalDate.now();
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setText("Date: "+date);
		lblNewLabel_1.setBounds(542, 20, 92, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(68, 57, 45, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.setFont(new Font("Serif", Font.BOLD, 16));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 153));
		btnNewButton.setBounds(542, 34, 92, 30);
		btnNewButton.setBorder(new LineBorder(new Color(0,153,255),2,true));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.dispose();
				JOptionPane.showMessageDialog(null, "Successfully logged out!","Logout", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		frame.getContentPane().add(btnNewButton);
	}
}
