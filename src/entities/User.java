package entities;

public class User {
	private String name;
	private String mdp;
	
	public User(String name, String mdp) {
		this.name = name;
		this.mdp = mdp;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	@Override
	public String toString() {
		return "User [name = " + name + ", mdp = " + mdp + "]";
	} 
	public void affiche() {
		System.out.println("name = " + name + ", mdp = " + mdp); 
	}
}
