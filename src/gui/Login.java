package gui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.SwingConstants;

import extract.Scraper;
import loader.Loader;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(51, 51, 51));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(210, 180, 140));
		panel.setBounds(61, 21, 321, 214);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("LOGIN ");
		lblNewLabel_1.setBackground(new Color(119, 136, 153));
		lblNewLabel_1.setBounds(126, 6, 66, 28);
		lblNewLabel_1.setForeground(new Color(248, 248, 255));
		lblNewLabel_1.setFont(new Font("Thonburi", Font.BOLD | Font.ITALIC, 20));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setBounds(35, 66, 87, 16);
		panel.add(lblNewLabel_2);
		

		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setBounds(35, 112, 61, 16);
		panel.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(151, 61, 130, 26);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(151, 107, 130, 26);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(6, 181, 186, 16);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(new Color(0, 0, 51));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(new Color(51, 51, 51));
		Image img = new ImageIcon(this.getClass().getResource("/ML4.jpg")).getImage(); 
		lblNewLabel.setIcon(new ImageIcon(img)); 
		lblNewLabel.setBounds(0, 0, 463, 350);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = " "; 
				try {
					Loader b=new Loader();
					Connection con = b.connexion();
					String sql ="SELECT * FROM `users` WHERE user ='"+textField.getText()+"'";
					Statement smt = con.createStatement();
					ResultSet rs = smt.executeQuery(sql);
					while(rs.next())
					{
						s=rs.getString("passwd");
						
					}
					if( textField_1.getText().equals(s))
					{
						lblNewLabel_2.setText("Connected ");
						CompanyOffers window = new CompanyOffers();
						window.frame.setVisible(true);
						frame.setVisible(false); 
						Scraper scrap = new Scraper(); 
						scrap.Scrap(); 
					}
					else {
						lblNewLabel_4.setText("User or Password Uknown");
					}
					
					}
					catch (Exception e1) {

						lblNewLabel_4.setText("Error !!");

						}
			}
		});
		btnNewButton.setBounds(183, 145, 117, 29);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("Create account >");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Register window = new Register();
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		lblNewLabel_5.setBounds(193, 181, 117, 16);
		panel.add(lblNewLabel_5);
		
	}
}
