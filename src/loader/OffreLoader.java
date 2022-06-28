package loader;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import entities.Offre;

public class OffreLoader {
		
		public void insert(Offre o, Connection con){
	        try{
	            
	            String sql ="INSERT INTO Offre (poste, region, entreprise, typeContrat, nivEtude, anneeExperience) VALUES ('"+ o.getPoste() + "','"+ o.getRegion() + "','" + o.getEntreprise()+"','"+o.getTypeContrat()+ "','"+o.getNivEtude()+"','"+o.getAnneeExperience() +"')" ;
	            System.out.println(sql);
	            Statement smt = con.createStatement();
	            int rs = smt.executeUpdate(sql);
	            System.out.println("offre inserted "); 
	            
		     }  catch(Exception e){
		         System.out.println(e.getMessage());
		         System.out.println("no in insert offre");
		     }      
	    }
		public void select(String e, Connection con){
		       try {
					String sql = "select * from Offre where entreprise ='"+e+"'";
					Statement smt = con.createStatement();
					ResultSet rs = smt.executeQuery(sql);
					while(rs.next())
					{
						System.out.println("Poste : " + rs.getString("poste")+"\nRegion = "+rs.getString("region")+"\nEntreprise = "+rs.getString("entreprise")+
								"\nType de contrat = "+rs.getString("typeContrat")+"\nNiveau d'etude = "+rs.getString("nivEtude")+"\nAnnées D'expériences = "+rs.getString("anneeExperience")+"\n"); 
					}
					
				}catch(Exception ex)
				{
					System.out.println(ex.getMessage());
					
				}
		 }
		public static void main(String[] args){
			Loader load = new Loader(); 
			Connection con = load.connexion(); 
	        OffreLoader o = new OffreLoader();
	        o.select("Intelcia ITS", con);
	        System.out.println("Done *UwU*"); 
                
	    }
}
