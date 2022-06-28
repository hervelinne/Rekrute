package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Window;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;

import mL.Classification;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class Home {

	JFrame frame2;
	protected Object frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frame2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame2 = new JFrame();
		frame2.setBounds(100, 100, 600, 600);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Which company suits you : ");
		lblNewLabel.setBounds(138, 20, 293, 34);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		frame2.getContentPane().add(lblNewLabel);
		
		// array of string containing cities
        String poste[] = { "IT Onsite Team Leader - Casablanca","Ingénieur sécurité - Rabat","Auditeur Système d\'Information Senior- (H/F) - Casablanca",
        		"Auditeur Système d’Information Confirmé (H/F) - Casablanca","Développeur orienté objet -TEC - - Casablanca","Développeur VBA - Rabat",
        		"Développeur VBA - Fès","Approvisionneur Junior - Rabat','Vérification & Test engineer - Rabat","Spécialiste Network - Rabat",
        		"Pilote Test et déploiement anglophone - Fès","Développeur PHP Full Stack Senior - Rabat","Pilote Test et déploiement anglophone - Rabat",
        		"Développeur PHP Full Stack Senior - Fès","Ingénieur Développement Senior C# / .NET / MVC5 - Marrakech","Ingénieur Réseau et Sécurité - Casablanca",
        		"Chef de projet PL/SQL -MON- - Casablanca","Ingénieur TMA (java/SQL) - Casablanca","Développeur Full stack confirmé -MON- - Casablanca",
        		"Développeur .NET Senior (H/F) - Casablanca","Business Analyst (H/F) - Rabat","Chef de projet AMOA (H/F) - Casablanca","Consultants expérimentés SIRH - Technopolis - Salé",
        		"Developpeur Reactjs - Rabat(Technopolis)/Casablanca (Casanearshore)","Developpeur Node JS - Rabat","Ingénieur Développement Senior Full Stack Java/ J2EE - Casablanca",
        		"Ingénieur TMA - Java/Perl - Casablanca","Consultant Technico-Fonctionnel - Casablanca","Data Scientist - Casablanca","Analyste Programmeur .Net - Casablanca","Développeur Angular, .Net Core, ASP.Net - Casablanca",
        		"Responsable support monétique -MON- - Casablanca","Concepteur Développeur Symfony (H/F) - Rabat","Expert Technique PHP Natif (H/F) - Rabat",
        		"Ingénieur Concepteur Développeur PHP NATIF (H/F) - Rabat","Concepteur Développeur Magento (H/F) - Rabat","Ingénieur Concepteur Développeur Drupal - Rabat",
        		"Expert Technique Drupal - Rabat","Développer Big Data SCALA/JAVA (H/F) - Casablanca","Spécialiste Recrutement (H/F) - Fès","Senior Developer Android/IOS (H/F) - Fès",
        		"INGENIEURS SENIORS CASA ET RABAT (RESEAUX, SYSTEME, SECURITE, COMMUNICATIONS UNIFIEES) - Casa et Rabat","Expert Apache - Rabat","Ingénieur de Production - Casablanca",
        		"Ingénieur Support (SQL/JAVA) - Casablanca","ingénieur support (PHP/ SQL) - Casablanca","Testeur Informatique Anglophone - Salé Technopolis","Ingénieur Support BI (H/F) - Casablanca",
        		"Consultant HR Access - Casablanca","Accounts Managers Intégration IT (Casa et Rabat) - Casa et Raba","Consultant SAP FICO - Freelance - Casablanca",
        		"Ingénieur Développeur Dot Net (H/F) - Casablanca","Consultant OTC - SAP.HANA.SCM.SD - Freelance - Casablanca","Lead SAP ( PP / QM/S4HANA ) - casablanca",
        		"Data Scientist (H/F) - Casablanca","Technicien Service Desk (H/F) - Rabat","Ingénieur Développeur Java/JEE - Casablanca","Expert DBA - Technopolis , Salé",
        		"Expert Technique Front End (H/F) - Casablanca","Ingénieur Concepteur Développeur JAVASCRIPT/ VUE.JS (H/F) - Raba","Concepteur Développeur NodeJs(H/F) - Rabat",
        		"Ingénieur Concepteur Développeur JavaScript/Angular (H/F) - Rabat","Ingénieur Concepteur Développeur JAVASCRIPT/REACTJS - Rabat","Expert Technique Front End (H/F) - Rabat",
        		"Administrateur Système H/F - Casablanca","Architecte Microservice - Casablanca","Team Leader JAVA JEE - Casablanca","Ingénieur Projet JAVA JEE - Casablanca",
        		"Architecte DEVOPS - Casablanca","Scrum Master Senior - Casablanca","Business Analyst / Power BI - CASABLANCA","IT Business Analyst / JAVA - CASABLANCA",
        		"Ingénieur Etudes et Développement .NET senior - Casablanca","Analyste SI - Casablanca","Chargé(e) de Facturation Client (H/F) [Contrat CDD 3 mois] - Casablanca",
        		"Chargé(e) de Facturation Client et administration des ventes (H/F) - Casablanca","Ingénieur Etude et Développement Java Senior (H/F) - Casablanca",
        		"Ingénieurs Etude et Développement JAVA EE Senior - Casablanca","Ingénieur développeur JAVA / Angular -MON- - Casablanca",
        		"Développeur full stack - Technopolis","Chargé(e) de Gestion des Déplacements Professionnels - Sala Al Jadida"};
        String region[] = { "Casablanca et région - Maroc", "Rabat et région - Maroc", "Fès et région - Maroc",
        					"Marrakech et région - Maroc", "Tout le Maroc - Maroc", "Béni Mellal et région - Maroc",
        					"Kénitra et région - Maroc", "Oujda et région - Maroc", "Casablanca et région - France"};
        String entreprise[] = { "Sitel Group", "Sofrecom Services Maroc", "Deloitte Nearshore", "Altados", "ALTEN Maroc",
								"TeamDEV", "EnerGetic Link", "Neosys", "TNC The Next Clic", "DXC Technology Maroc",
								"Involys", "SQLI Maroc", "ARIA Tech", "Cnexia", "Intelcom","AXA Rabat (Axa Services)",
								"Welink", "Oceane Consulting", "INTM Mediterranée", "Omnishore","Groupe Adaming",
								"Umanis", "Atos", "Perenity Software", "AXA Group Operations Maroc","LCI Education",
								"CGI Technologies et Solutions Maroc", "Leyton", "Webhelp Maroc", "OBS","Excel Management Conseil",
								"Intelcia ITS", "Adria Business & Technology", "Preci", "BMCI Groupe BNP Paribas","Econocom Maroc",
								"HPS Maroc", "Manpower Agences", "O&D Services", "Disty technologies","Eumatech"};
        String tyeContrat[] = { "CDI Poste avec Management", "CDI", "Freelance Poste avec Management", "CDD",
        						"Freelance", "Autre", "Stage" };
        String nivEtude[] = {   "Bac +4 - Ecole d'ingénieur", "Bac +5 et plus", "Bac +5 et plus - Ecole d'ingénieur",
        						"Bac +2", "Bac +5 et plus - Master - Ecole d'ingénieur", "Bac +4", "Bac +4 - Master", 
        						"Bac +5 et plus - Ecole de commerce - Formation spécialisée","Bac +5 et plus - Master - Formation spécialisée",
        						"Bac +3 - Ecole d'ingénieur", "Bac +5 et plus - Master - Ecole de commerce","Bac +5 et plus - Master",
        						"Bac +2 - Ecole d'ingénieur - Université", "Bac +3 - Master - Ecole d'ingénieur","Bac +3 - Université",
        						"Bac +3 - Université - Formation spécialisée", "Bac +5 et plus - Ecole de commerce","Bac +5 et plus - Ecole d'ingénieur - Université",
        						"Bac +3", "Bac +2 - BTS / DUT","Bac +4 - Ecole de commerce - Ecole d'ingénieur", "Bac +4 - Autre", "Bac +3 - Master",
        						"Bac +5 et plus - Formation continue", "Bac +3 - Formation spécialisée", "Bac +4 - Formation spécialisée"};
        String anneExperience[] = { "De 3 à 5 ans", "De 1 à 3 ans", "Débutant", "Moins de 1 an - De 1 à 3 ans",
        							"De 3 à 5 ans - De 5 à 10 ans","De 5 à 10 ans","De 5 à 10 ans - De 10 à 20 ans",
        							"De 1 à 3 ans - De 3 à 5 ans", "De 10 à 20 ans", "Moins de 1 an","Débutant - Moins de 1 an"};
        frame2.getContentPane().setLayout(null);
        
        // create checkbox
        JComboBox c1 = new JComboBox(poste);
        c1.setBounds(250, 88, 250, 40);
        JComboBox c2 = new JComboBox(region);
        c2.setBounds(250, 140, 250, 40);
        //JComboBox c3 = new JComboBox(entreprise);
        //c3.setBounds(51, 145, 193, 27);
        JComboBox c4 = new JComboBox(tyeContrat);
        c4.setBounds(250, 192, 250, 40);
        JComboBox c5 = new JComboBox(nivEtude);
        c5.setBounds(250, 248, 250, 40);
        JComboBox c6 = new JComboBox(anneExperience);
        c6.setBounds(250, 311, 250, 40);
        
        
        
        frame2.getContentPane().add(c1);
        frame2.getContentPane().add(c2);
        //frame2.getContentPane().add(c3);
        frame2.getContentPane().add(c4);
        frame2.getContentPane().add(c5);
        frame2.getContentPane().add(c6);
        
        JLabel lblNewLabel_1 = new JLabel("Select the job : ");
        lblNewLabel_1.setBounds(25, 99, 150, 16);
        frame2.getContentPane().add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Select Region : ");
        lblNewLabel_2.setBounds(25, 148, 150, 16);
        frame2.getContentPane().add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("Select Type of Contract : ");
        lblNewLabel_3.setBounds(25, 203, 183, 16);
        frame2.getContentPane().add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("Select level of study :");
        lblNewLabel_4.setBounds(25, 259, 150, 16);
        frame2.getContentPane().add(lblNewLabel_4);
        
        JLabel lblNewLabel_5 = new JLabel(" Select Years of experience : ");
        lblNewLabel_5.setBounds(25, 322, 183, 16);
        frame2.getContentPane().add(lblNewLabel_5);
        
        JLabel lblResult = new JLabel("--Result :--");
        lblResult.setFont(new Font("Lucida Grande", Font.BOLD, 20));
        lblResult.setBounds(213, 408, 129, 34);
        frame2.getContentPane().add(lblResult);
        
        JLabel lblNewLabel_6 = new JLabel("?");
        lblNewLabel_6.setFont(new Font("Monospaced", Font.BOLD, 20));
        lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_6.setBounds(84, 450, 393, 95);
        frame2.getContentPane().add(lblNewLabel_6);
        
        JButton btnNewButton = new JButton("Choose");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		lblNewLabel_6.setText(String.valueOf(c1.getSelectedIndex()));
        		Classification c = new Classification(); 
        		lblNewLabel_6.setText(c.Prediction(c1.getSelectedIndex(), c2.getSelectedIndex(), c4.getSelectedIndex(), c5.getSelectedIndex(), c6.getSelectedIndex())); 
        	}
        	
        });
        btnNewButton.setBounds(443, 363, 117, 29);
        frame2.getContentPane().add(btnNewButton);
        
        JLabel lblNewLabel_7 = new JLabel("< Company offers ");
        lblNewLabel_7.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		JLabel lblNewLabel_2 = new JLabel("< Company offers");
        		CompanyOffers window = new CompanyOffers();
				window.frame.setVisible(true);
        		frame2.setVisible(false); 
        		
        	}
        });
        lblNewLabel_7.setBounds(29, 529, 129, 16);
        frame2.getContentPane().add(lblNewLabel_7);
 
       
		   
			
        
			
		 
	}
}
