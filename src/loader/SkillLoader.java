package loader;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import entities.Skill;

public class SkillLoader {
	public void insert(Skill s, Connection con){
        try{
            
            String sql ="INSERT INTO Skills (skill,Offre) VALUES ('" + s.getSkill() + "','"+ s.getOffre() +"')" ;
            System.out.println(sql);
            Statement smt = con.createStatement();
            int rs = smt.executeUpdate(sql);
            
        }  
        catch(Exception e){
         System.out.println(e.getMessage());
         System.out.println("no insert skills ");
        }  
        
    }
	public ResultSet select(Connection con){
	       try {
				String sql = "select * from Skills";
				Statement smt = con.createStatement();
				ResultSet rs = smt.executeQuery(sql);
				while(rs.next())
				{
					System.out.println("Skill : " + rs.getString("skill")+"\nOffre = "+rs.getString("Offre")+"\n"); 
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
	     SkillLoader o = new SkillLoader();
	     o.select(con);
	     System.out.println("Done *UwU*"); 
         
 }
}
