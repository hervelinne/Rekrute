package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import loader.Loader;
import loader.OffreLoader;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CompanyOffers {

	JFrame frame;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CompanyOffers window = new CompanyOffers();
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
	public CompanyOffers() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Get All the Offers of a Company");
		lblNewLabel.setFont(new Font("ITF Devanagari", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 6, 488, 67);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Select the Company's name : ");
		lblNewLabel_1.setBounds(16, 85, 213, 33);
		frame.getContentPane().add(lblNewLabel_1);
		
		String entreprise[] = { "Sitel Group", "Sofrecom Services Maroc", "Deloitte Nearshore", "Altados", "ALTEN Maroc",
				"TeamDEV", "EnerGetic Link", "Neosys", "TNC The Next Clic", "DXC Technology Maroc",
				"Involys", "SQLI Maroc", "ARIA Tech", "Cnexia", "Intelcom","AXA Rabat (Axa Services)",
				"Welink", "Oceane Consulting", "INTM Mediterranée", "Omnishore","Groupe Adaming",
				"Umanis", "Atos", "Perenity Software", "AXA Group Operations Maroc","LCI Education",
				"CGI Technologies et Solutions Maroc", "Leyton", "Webhelp Maroc", "OBS","Excel Management Conseil",
				"Intelcia ITS", "Adria Business & Technology", "Preci", "BMCI Groupe BNP Paribas","Econocom Maroc",
				"HPS Maroc", "Manpower Agences", "O&D Services", "Disty technologies","Eumatech"};
		JComboBox c = new JComboBox(entreprise);
        c.setBounds(241, 89, 193, 27);
        frame.getContentPane().add(c);
        
      
		
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Loader b=new Loader();
				Connection con = b.connexion();
				try {
					String sql = "select * from Offre where entreprise ='"+c.getSelectedItem()+"'";
					Statement smt = con.createStatement();
					ResultSet rs = smt.executeQuery(sql);
					
					  String columns[] = { "Poste", "Region", "Entreprise", "Type de Contrat","Niveau d'etude", "Années d'expériences" };
					  String data[][] = new String[100][6];
					  
					  	
				      
				      int i = 0, j=0;
				      while (rs.next()) {
				        String Poste = rs.getString("poste");
				        String Region = rs.getString("region");
				        String Entreprise = rs.getString("entreprise");
				        String Contrat = rs.getString("typeContrat");
				        String NivEtude = rs.getString("nivEtude");
				        String AnneeExperience = rs.getString("anneeExperience");
				        
				        data[i][0] = Poste + "";
				        data[i][1] = Region;
				        data[i][2] = Entreprise;
				        data[i][3] = Contrat;
				        data[i][4] = NivEtude;
				        data[i][5] = AnneeExperience;
				        i++;
				      }
				      table_1 = new JTable();
				      table_1.setFillsViewportHeight(true);
				      table_1.setColumnSelectionAllowed(true);
					  table_1.setCellSelectionEnabled(true);
					  table_1.setBounds(16, 452, 460, -294);
					  frame.getContentPane().add(table_1);
				      table_1 = new JTable(data, columns);
				      table_1.setShowGrid(true);
				      table_1.setShowVerticalLines(true); 
				      JScrollPane scroll = new JScrollPane(table_1);
				      scroll.setBounds(6, 191, 488, 250);
				      frame.getContentPane().add(scroll);
				      
					
					
					
				}catch(Exception ex)
				{
					System.out.println(ex.getMessage());
					
				}
				
				
			}
			
		});
		
		btnNewButton.setBounds(349, 123, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Prediction >");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Home window = new Home();
				window.frame2.setVisible(true);
				frame.setVisible(false); 
			}
		});
		lblNewLabel_2.setBounds(406, 450, 88, 16);
		frame.getContentPane().add(lblNewLabel_2);  
		
		
	}
}
