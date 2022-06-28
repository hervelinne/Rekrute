package entities;

public class Formation {
	private static int idformation = 1; 
	private String formation; 
	private String offre;
	static void Increment()
	{
		idformation++;
	}
	public Formation(String formation, String offre) {
		Increment();
		this.formation = formation;
		this.offre = offre;
	}
	public String getFormation() {
		return formation;
	}
	public void setFormation(String formation) {
		this.formation = formation;
	}
	public String getOffre() {
		return offre;
	}
	public void setOffre(String offre) {
		this.offre = offre;
	}
	public static int getIdformation() {
		return idformation;
	}
	@Override
	public String toString() {
		return "Formation [idformation = "+ idformation + "formation = " + formation + ", offre = " + offre + "]";
	} 
	public void affiche() {
		System.out.println("idformation = "+ idformation + "formation = " + formation + ", offre = " + offre); 
	}
}
