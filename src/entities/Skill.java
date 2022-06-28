package entities;

public class Skill {
	private static int idskill = 1;
	private String skill;
	private String offre; 
	static void Increment()
	{
		idskill++;
	}
	public Skill(String skill, String offre) {
		Increment();
		this.skill = skill;
		this.offre = offre;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public String getOffre() {
		return offre;
	}
	public void setOffre(String offre) {
		this.offre = offre;
	}
	public static int getIdskill() {
		return idskill;
	}
	@Override
	public String toString() {
		return "Skill [idskill = " + idskill+ "skill = " + skill + ", offre = " + offre + "]";
	}
	public void affiche() {
		System.out.println("idskill = " + idskill+ "skill = " + skill + ", offre = " + offre);
	}
}
