package optimisation.modele.algorithme;

public interface Algorithme {
	
	public String getNom();

	public int getNbrIte();

	public int getBestObj();
	
	public int getRefresh();
	
	public void setRefresh(int refresh);
	
	public int getLimite();
	
	public void setLimite(int limite);
}
