package entities;

import java.util.Objects;

public class Offre {
	private static int id = 1; 
	private String Poste; 
	private String region; 
	private String Entreprise; 
	private String typeContrat; 
	private String nivEtude; 
	private String anneeExperience;
	
	static void Increment()
	{
		id++;
	}
	
	public Offre( String poste, String ville, String Entreprise, String typeContrat, String nivEtude,String anneeExperience) 
	{
		Increment();
		Poste = poste;
		this.region = ville;
		this.Entreprise = Entreprise;
		this.typeContrat = typeContrat;
		this.nivEtude = nivEtude;
		this.anneeExperience = anneeExperience;
	}

	public int getId() {
		return id;
	}

	public String getPoste() {
		return Poste;
	}

	public void setPoste(String poste) {
		Poste = poste;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String ville) {
		this.region = ville;
	}

	public String getEntreprise() {
		return Entreprise;
	}

	public void setEntreprise(String Entreprise) {
		this.Entreprise = Entreprise;
	}

	public String getTypeContrat() {
		return typeContrat;
	}

	public void setTypeContrat(String typeContrat) {
		this.typeContrat = typeContrat;
	}

	public String getNivEtude() {
		return nivEtude;
	}

	public void setNivEtude(String nivEtude) {
		this.nivEtude = nivEtude;
	}

	public String getAnneeExperience() {
		return anneeExperience;
	}

	public void setAnneeExperience(String anneeExperience) {
		this.anneeExperience = anneeExperience;
	}

	@Override
	public String toString() {
		return "Offre [id = " + id + ", Poste = " + Poste + ", region = " + region + ", Entreprise = " + Entreprise
				+ ", typeContrat = " + typeContrat + ", nivEtude = " + nivEtude + ", anneeExperience = " + anneeExperience
				+ "]";
	} 
	public void affiche() {
		System.out.println("id = " + id + ", Poste = " + Poste + ", region = " + region + ", Entreprise = " + Entreprise
				+ ", typeContrat = " + typeContrat + ", nivEtude = " + nivEtude + ", anneeExperience = " + anneeExperience);
	}

	@Override
	public int hashCode() {
		return Objects.hash(Poste, anneeExperience, nivEtude, Entreprise, region, typeContrat);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Offre other = (Offre) obj;
		return Objects.equals(Poste, other.Poste) && Objects.equals(anneeExperience, other.anneeExperience)
				&& Objects.equals(nivEtude, other.nivEtude) && Objects.equals(Entreprise, other.Entreprise)
				&& Objects.equals(region, other.region) && Objects.equals(typeContrat, other.typeContrat);
	}
	
}
