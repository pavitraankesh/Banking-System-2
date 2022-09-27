package HomePage;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.LineBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JSeparator;

import SignUp.SignUp;
import Login.Login;

public class HomePage {

	private JFrame frame;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage window = new HomePage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public HomePage() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(240, 248, 255));
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("MONEY BANK");
		lblNewLabel_1.setForeground(new Color(0, 0, 102));
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblNewLabel_1.setBounds(43, 118, 214, 48);
		frame.getContentPane().add(lblNewLabel_1);
		
		ImageIcon i = new ImageIcon("C:\\Users\\Pavitra\\eclipse-workspace\\Banking System\\src\\HomePage\\home.png");
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(417, 74, 273, 298);
		lblNewLabel_2.setIcon(i);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnNewButton.setBackground(new Color(0, 0, 153));
		btnNewButton.setBounds(53, 294, 97, 35);
		btnNewButton.setBorder(new LineBorder(new Color(0,153,255),2,true));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				SignUp.main(null);
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.setBackground(new Color(0, 0, 153));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnNewButton_1.setBounds(196, 294, 97, 35);
		btnNewButton_1.setBorder(new LineBorder(new Color(0,153,255),2,true));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				Login.main(null);
			}
		});
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("A fast and efficient way to work with your money.  ");
		lblNewLabel.setFont(new Font("SansSerif", Font.ITALIC, 14));
		lblNewLabel.setBounds(53, 184, 354, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Secure way to deposit, withdraw and transfer money.");
		lblNewLabel_3.setFont(new Font("SansSerif", Font.ITALIC, 14));
		lblNewLabel_3.setBounds(53, 207, 354, 13);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Manage and track all accounts and transactions.");
		lblNewLabel_4.setFont(new Font("SansSerif", Font.ITALIC, 14));
		lblNewLabel_4.setBounds(53, 230, 354, 13);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("HOME");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(10, 10, 45, 13);
		frame.getContentPane().add(lblNewLabel_5);
			
		frame.setBounds(100, 100, 739, 485);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
