package loader;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import entities.Formation;

public class FormationLoader {

	 public void insert(Formation f, Connection con){
	        try{
	            
	            String sql ="INSERT INTO Formation (formation,Offre) VALUES ('" + f.getFormation() + "','"+ f.getOffre() +"')" ;
	            System.out.println(sql);
	            Statement smt = con.createStatement();
	            int rs = smt.executeUpdate(sql);
	            
	     }  catch(Exception e){
	         System.out.println(e.getMessage());
	         System.out.println("no in formation insert ");
	     }   
	
	 }
	 public ResultSet select(Connection con){
	       try {
				String sql = "select * from Formation";
				Statement smt = con.createStatement();
				ResultSet rs = smt.executeQuery(sql);
				while(rs.next())
				{
					System.out.println("Formation : " + rs.getString("formation")+"\nOffre = "+rs.getString("Offre")+"\n"); 
				}
				return rs;
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
				return null;
			}
	    }
	 public static void main(String[] args){
		Loader load = new Loader(); 
		Connection con = load.connexion(); 
        FormationLoader o = new FormationLoader();
        o.select(con);
        System.out.println("Done *UwU*"); 
        
                
                
    }
}
