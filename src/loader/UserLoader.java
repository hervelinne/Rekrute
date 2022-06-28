package loader;

import java.sql.Connection;
import java.sql.Statement;
import entities.User;

public class UserLoader {
	 public void insert(User u, Connection con){
	        try{
	            
	            String sql ="INSERT INTO users (user,passwd) VALUES ('" + u.getName() + "','"+ u.getMdp() +"')" ;
	            System.out.println(sql);
	            Statement smt = con.createStatement();
	            int rs = smt.executeUpdate(sql);
	     }  catch(Exception e){
	         System.out.println(e.getMessage());
	         System.out.println("no in formation insert ");
	     }   
	
	 }

}
