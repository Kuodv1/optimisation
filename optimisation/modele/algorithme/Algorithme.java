package optimisation.modele.algorithme;

public interface Algorithme {
	
	public String getNom();

	public int getNbrIte();
	
	public int calculEnergie(char[][] t);
}
