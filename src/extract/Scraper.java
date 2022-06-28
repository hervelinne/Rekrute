package extract;

import java.sql.Connection;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import entities.Formation;
//import entities.Formation;
import entities.Offre;
import entities.Skill;
import loader.FormationLoader;
//import entities.Skill;
//import loader.FormationLoader;
import loader.Loader;
import loader.OffreLoader;
//import loader.SkillLoader;
import loader.SkillLoader;




public class Scraper {
	public void Scrap() {
		try {
			Loader load = new Loader(); 
			Connection con = load.connexion(); 
				// Create a List where to grp all the href   
				ArrayList<String> hrefs = new ArrayList<String>();
				// i = nb of the page
				for(int i = 1; i <3;i++)
				{
	                String url = "https://www.rekrute.com/offres.html?s=2&p="+i+"&o=1&sectorId%5B0%5D=24";
	                // Access the URL 
	                Document doc = Jsoup.connect(url).get();
	                // test 
	                //System.out.println("done");
	                
	                // filling href list 
	                Elements list = doc.getElementsByClass("post-id"); 
	                for(Element j:list)
	                {
	                	Elements elt = j.getElementsByClass("section").select("h2");                        
	                    String href = elt.select("a[href]").attr("href");
	                    hrefs.add(href);
	                    //System.out.println(" link : " +href);
	                              
	                 }
	                     
	            }
				//give nbr of links 
				System.out.println("nombre d'offres  = " + hrefs.size());
				
				for(int i=0;i<hrefs.size();i++)
				{
	                String url = hrefs.get(i);
	                // Access link with doc
	                Document doc = Jsoup.connect("https://www.rekrute.com/"+url).get();
	                
	                System.out.println("Annonce "+i+" : \n");
	                // get poste :
	                String poste = doc.getElementsByTag("h1").text();
	                //fix pb with BD 
	                poste = poste.replace("'",""); 
	               /* if(poste.indexOf("'") >= 0){
	                                 String[] elmts = poste.split("'");
	                                 poste = elmts[0];
	                                 for(int m=1;m<elmts.length;m++){
	                                     poste +="''"+elmts[m];
	                                     //System.out.println(elmts[m]);
	                                 }
	                                }*/
	                poste = poste.split("-")[0];
	                System.out.println("poste = "+ poste); 
	                
	                Element ul = doc.getElementsByClass("featureInfo").first(); 
	                // get experience : 
	                String anneeExperience = ul.getElementsByTag("li").get(0).text();
	                anneeExperience = anneeExperience.replace("'",""); 
	                System.out.println("Annee d'experience = "+ anneeExperience);
	                
	                //get region :  
	                String region = ul.getElementsByTag("li").get(1).text();
	                region = region.replace(ul.getElementsByTag("li").get(1).getElementsByTag("b").text(),""); 
	                region = region.replace(" poste(s) sur ", ""); 
	                System.out.println("Region = "+ region); 
	                
	               
	                //get niveau d'etude : 
	                String nivEtude = ul.getElementsByTag("li").get(2).text();
	                System.out.println("Niveau D'étude = "+ nivEtude); 
	                nivEtude = nivEtude.replace("'",""); 
	               /* if(nivEtude.indexOf("'") >= 0){
	            	   
                        String[] elmts = nivEtude.split("'");
                        nivEtude = elmts[0];
                        for(int m=1;m<elmts.length;m++){
                            nivEtude +="''"+elmts[m];
                        }
                     }*/
	                
	                
	                //get TypeContrat : 
	                Element carte = doc.getElementsByTag("div").get(1).getElementsByClass("container anno").first().getElementsByClass("row").get(1);
	                String typeContrat = carte.getElementsByTag("ul").get(1).text();
	                System.out.println("Type de contrat : "+ typeContrat); 
	                
	                //get title : 
	                String Entreprise; 
	                if (doc.getElementsByClass("foruloffemp col-md-12 blc").first() != null) { 
	                	Entreprise = doc.getElementsByClass("foruloffemp col-md-12 blc").first().getElementsByTag("h4").text(); 
	                	Entreprise = Entreprise.replace("Les dernières offres d’emploi de « ", ""); 
		                Entreprise = Entreprise.replace(" »", "");
		                System.out.println("Nom de l'entreprise : "+ Entreprise); 
	                }
	                else {
	                	Entreprise = doc.title(); 
		                System.out.println("Nom de l'entreprise : "+ Entreprise); 
	                }
	                
	                
	                // Creation Offre 
	                Offre offre = new Offre(poste, region, Entreprise, typeContrat, nivEtude, anneeExperience); 
	                System.out.println("offre id  = "+offre.getId()); 
	             // --- Connect Offre to Base ---
	                OffreLoader oL = new OffreLoader(); 
       	         	oL.insert(offre, con);
	                
	                //get skills 
	                Elements skills = carte.getElementsByTag("div").get(0).getElementsByTag("p").first().getElementsByTag("span");
	                String skill = skills.text();
                    System.out.println("Skill "+i+" = "+skill); 
                    
                    
                    
                    
                    
	                /*for(int j=0;j<skills.size();j++){
	                    
	                    if(skill.indexOf("'") >= 0){
	                                 String[] elmts = skill.split("'");
	                                 skill = elmts[0];
	                                 for(int m=1;m<elmts.length;m++) skill +="''"+elmts[m];
	                    }  
	                    */// Creation skill 
	                   Skill s = new Skill(skill, offre.getPoste()); 
	                 // --- Connect Skill to Base ---
	                    SkillLoader sL = new SkillLoader(); 
	                    sL.insert(s, con); 
	                    
	                 
	                //get formation
	                Element profil = doc.getElementsByClass("col-md-12 blc").get(3); 
	                System.out.println("profil : "+profil.text() ); 
	                
	                //Divide the profile content to multiple formations 
	                if(profil.getElementsByTag("ul").first() != null){
	                    Elements comps = profil.getElementsByTag("ul").get(0).getElementsByTag("li");
                        
                        
	                    for(int j=0;j<comps.size();j++){ 
	                        String formation = comps.get(j).text();
	                        System.out.println("Formation "+j+" = "+formation); 
	                        //fixing pb with BD 
	                        if(formation.indexOf("'") >= 0){
	                                 String[] elmts = formation.split("'");
	                                 formation = elmts[0];
	                                 for(int m=1;m<elmts.length;m++) formation +="''"+elmts[m];
	                                } 
	                      // Creation Formation   
	                        
	                        Formation f = new Formation(formation, offre.getPoste()); 
	                      // --- Connect Formation to Base ---
	                        FormationLoader fL = new FormationLoader();
	                        fL.insert(f,con);

	                    }
	                }
	                if(profil.getElementsByTag("p") != null ){
	                    
	                    Elements comps = profil.getElementsByTag("p");
	                    for(int j=0;j<comps.size();j++){
	                         String formation = comps.get(j).text();
	                         System.out.println("Formation "+j+" = "+formation + "\n"); 
	                         //fixing pb with BD 
	                         if(formation.indexOf("'") >= 0){
	                                 String[] elmts = formation.split("'");
	                                 formation = elmts[0];
	                                 for(int m=1;m<elmts.length;m++) formation +="''"+elmts[m];
	                         } 
	                      // Creation formation  
	                         Formation f = new Formation(formation, offre.getPoste()); 
	                     // --- Connect Formation to Base ---
	                         FormationLoader fL = new FormationLoader();
		                     fL.insert(f, con);
	                    }
	                }
      
	                
				}
				System.out.println(" Finally !!!! YEY \\^w^/"); 
			
		}
		catch(Exception e) {
			e.printStackTrace(); 
		}
	}
	
	public static void main(String[] args) {
		Scraper scrap = new Scraper();
        scrap.Scrap();
		
	}

}
